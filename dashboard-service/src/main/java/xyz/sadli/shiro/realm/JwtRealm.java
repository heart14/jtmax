package xyz.sadli.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.exception.SysException;
import xyz.sadli.shiro.domain.JwtToken;
import xyz.sadli.util.JwtUtils;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/29 17:19.
 * Editored:
 */
public class JwtRealm extends AuthorizingRealm {

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
        return null;
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
        JwtToken jwtToken = (JwtToken) authenticationToken;
        if (jwtToken.getPrincipal() == null) {
            throw new SysException(ErrCodeEnums.AUTHENTICATION_EXCEPTION.getCode(), ErrCodeEnums.AUTHENTICATION_EXCEPTION.getMsg());
        }
        //验证jwtToken有效性
        String jwt = (String) jwtToken.getPrincipal();
        boolean verify = JwtUtils.verify(String.valueOf(jwt));
        if (!verify) {
            throw new SysException(ErrCodeEnums.AUTHENTICATION_EXCEPTION.getCode(), ErrCodeEnums.AUTHENTICATION_EXCEPTION.getMsg());
        }
        return new SimpleAuthenticationInfo(jwt, jwt, getName());
    }
}
