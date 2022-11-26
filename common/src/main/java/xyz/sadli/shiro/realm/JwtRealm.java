package xyz.sadli.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import xyz.sadli.dao.JtPermissionMapper;
import xyz.sadli.dao.JtRoleMapper;
import xyz.sadli.entity.JtPermission;
import xyz.sadli.entity.JtRole;
import xyz.sadli.shiro.domain.JwtToken;
import xyz.sadli.util.JwtUtils;

import java.util.List;

import static xyz.sadli.common.Constants.ACCESS_TOKEN_PREFIX;
import static xyz.sadli.common.Constants.REDIS_KEY_SEPARATOR;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/29 17:19.
 * Editored:
 */
@Component
public class JwtRealm extends AuthorizingRealm {

    public static final Logger log = LoggerFactory.getLogger(JwtRealm.class);

    @Autowired
    private JtRoleMapper roleMapper;

    @Autowired
    private JtPermissionMapper permissionMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean supports(AuthenticationToken token) {
        //验证token类型，是否是自定义Token
        return token instanceof JwtToken;
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("JwtRealm.doGetAuthorizationInfo() execute");
        String jwtToken = (String) principalCollection.getPrimaryPrincipal();
        String uid = (String) JwtUtils.parseJwtToken(jwtToken).get("uid");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<JtRole> jtRoles = roleMapper.selectRolesByUid(uid);
        if (jtRoles != null && jtRoles.size() > 0) {
            for (JtRole jtRole : jtRoles) {
                authorizationInfo.addRole(jtRole.getRoleKey());

                List<JtPermission> jtPermissions = permissionMapper.selectPermByRoleId(jtRole.getRoleId());
                if (jtPermissions != null && jtPermissions.size() > 0) {
                    for (JtPermission jtPermission : jtPermissions) {
                        authorizationInfo.addStringPermission(jtPermission.getPermKey());
                    }
                }
            }
        }
        return authorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("JwtRealm.doGetAuthenticationInfo() execute");
        JwtToken jwtToken = (JwtToken) authenticationToken;
        if (jwtToken.getPrincipal() == null) {
//            throw new SysException(ErrCodeEnums.AUTHENTICATION_EXCEPTION.getCode(), ErrCodeEnums.AUTHENTICATION_EXCEPTION.getMsg());
            throw new AuthenticationException("jwtToken does not exist");
        }
        //验证jwtToken有效性
        String jwt = (String) jwtToken.getPrincipal();
        boolean verify = JwtUtils.verify(String.valueOf(jwt));
        if (!verify) {
//            throw new SysException(ErrCodeEnums.AUTHENTICATION_EXCEPTION.getCode(), ErrCodeEnums.AUTHENTICATION_EXCEPTION.getMsg());
            throw new AuthenticationException("jwtToken already expired");
        }
        /**
         * TODO jwtToken的刷新与过期
         *
         * 当用户注销登录时，需要使jwtToken过期
         * 当用户jwtToken过期时，需要使用refresh_token来刷新jwtToken
         *
         * 方案：
         * 使用redis，在登录接口生成jwtToken时，对token进行存储，expire时间和jwtToken ttl相同，对refresh_token进行存储，expire时间比jwtToken更久
         * access_token存储规则  key = accesstoken:[uid] ,value = [token value]
         * refresh_token存储规则 key = refreshtoken:[token value] ,value = [uid]
         * 这样，在认证时，可以从jwtToken中解析出uid，然后去redis查询access_token
         * 在注销登录时，也可以这样去移除
         * 在刷新token时，根据传来的refresh_token，可以查询到uid，根据uid可以生成新的jwtToken，同时，刷新token时要验证存在token，可避免注销登录后，再使用refresh_token来获取token
         *
         * 当用户每次在这个方法里验证JwtToken的有效性时，除了使用jwtUtils.verify()之外，还要查询redis，确认键值存在，才算成功，否则认证失败
         */
        String redisToken = redisTemplate.opsForValue().get(ACCESS_TOKEN_PREFIX + REDIS_KEY_SEPARATOR + JwtUtils.parseJwtToken(jwt).get("uid"));
        if (redisToken == null) {
            throw new AuthenticationException("user already logout: uid=" + JwtUtils.parseJwtToken(jwt).get("uid"));
        }
        log.info("find in redis: uid = {}, token = {}", JwtUtils.parseJwtToken(jwt).get("uid"), redisToken);
        return new SimpleAuthenticationInfo(jwt, jwt, getName());
    }
}
