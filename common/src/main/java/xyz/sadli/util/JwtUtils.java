package xyz.sadli.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import xyz.sadli.common.SysProperties;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * About: Jwt工具类
 * Other:
 * Created: wfli on 2022/9/29 15:00.
 * Editored:
 */
public class JwtUtils {

    //创建默认的秘钥和算法，供无参的构造方法使用
    private static final String defaultbase64EncodedSecretKey = "sadli.xyz";
    private static final SignatureAlgorithm defaultsignatureAlgorithm = SignatureAlgorithm.HS256;

    private final String base64EncodedSecretKey;
    private final SignatureAlgorithm signatureAlgorithm;

    public JwtUtils() {
        this(defaultbase64EncodedSecretKey, defaultsignatureAlgorithm);
    }

    public JwtUtils(String secretKey, SignatureAlgorithm signatureAlgorithm) {
        this.base64EncodedSecretKey = Base64.encodeBase64String(secretKey.getBytes());
        this.signatureAlgorithm = signatureAlgorithm;
    }

    /*
     *这里就是产生jwt字符串的地方
     * jwt字符串包括三个部分
     *  1. header
     *      -当前字符串的类型，一般都是“JWT”
     *      -哪种算法加密，“HS256”或者其他的加密算法
     *      所以一般都是固定的，没有什么变化
     *  2. payload
     *      一般有四个最常见的标准字段（下面有）
     *      iat：签发时间，也就是这个jwt什么时候生成的
     *      jti：JWT的唯一标识
     *      iss：签发人，一般都是username或者userId
     *      exp：过期时间
     *
     * */
    public String encode(String iss, long ttlMillis, Map<String, Object> claims) {
        //iss签发人，ttlMillis生存时间，claims是指还想要在jwt中存储的一些非隐私信息
        if (claims == null) {
            claims = new HashMap<>();
        }
        long nowMillis = System.currentTimeMillis();

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(StringUtils.UuidLowerCase())//2. 这个是JWT的唯一标识，一般设置成唯一的，这个方法可以生成唯一标识
                .setIssuedAt(new Date(nowMillis))//1. 这个地方就是以毫秒为单位，换算当前系统时间生成的iat
                .setSubject(iss)//3. 签发人，也就是JWT是给谁的（逻辑上一般都是username或者userId）
                .signWith(signatureAlgorithm, base64EncodedSecretKey);//这个地方是生成jwt使用的算法和秘钥
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);//4. 过期时间，这个也是使用毫秒生成的，使用当前时间+前面传入的持续时间生成
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    //相当于encode的反向，传入jwtToken生成对应的username和password等字段。Claim就是一个map
    //也就是拿到荷载部分所有的键值对
    public Claims decode(String jwtToken) {
        // 得到 DefaultJwtParser
        return Jwts.parser()
                // 设置签名的秘钥
                .setSigningKey(base64EncodedSecretKey)
                // 设置需要解析的 jwt
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    //判断jwtToken是否合法
    public boolean isVerify(String jwtToken) {
        //这个是官方的校验规则，这里只写了一个校验算法，可以自己加
        Algorithm algorithm = null;
        switch (signatureAlgorithm) {
            case HS256:
                algorithm = Algorithm.HMAC256(Base64.decodeBase64(base64EncodedSecretKey));
                break;
            default:
                throw new RuntimeException("不支持的算法");
        }
        JWTVerifier verifier = JWT.require(algorithm).build();
        verifier.verify(jwtToken);  // 校验不通过会抛出异常
        //判断合法的标准：1. 头部和荷载部分没有篡改过。2. 没有过期
        return true;
    }

    //创建静态实例，使可以作为普通工具类调用
    public static final JwtUtils jwtUtils;

    //初始化静态实例
    static {
        if (SysProperties.JWT_SECRET != null) {
            jwtUtils = new JwtUtils(SysProperties.JWT_SECRET, SignatureAlgorithm.HS256);
        } else {
            jwtUtils = new JwtUtils();
        }
    }

    /**
     * 生成jwtToken
     *
     * @param iss    签发对象，本项目取uid
     * @param claims 其它参数
     * @return
     */
    public static String createJwtToken(String iss, Map<String, Object> claims) {
        return jwtUtils.encode(iss, SysProperties.JWT_TTL, claims);
    }

    /**
     * 解析jwtToken
     *
     * @param jwtToken jwtToken
     * @return
     */
    public static Map<String, Object> parseJwtToken(String jwtToken) {
        Claims claims = jwtUtils.decode(jwtToken);
        //对claims进行处理，转化成map
        Map<String, Object> payload = new HashMap<>();
        claims.forEach((key, value) -> {
            //由于签发对象iss本项目取uid，故在这里进行一下转化处理
            if ("sub".equals(key)) {
                payload.put("uid", value);
            } else {
                payload.put(key, value);
            }
        });
        return payload;
    }

    /**
     * 校验jwtToken
     *
     * @param jwtToken
     * @return
     */
    public static boolean verify(String jwtToken) {
        try {
            return jwtUtils.isVerify(jwtToken);
        } catch (Exception e) {
            if (e instanceof TokenExpiredException) {
                return false;
            }
            return false;
        }
    }

}
