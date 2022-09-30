package xyz.sadli.shiro.domain;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * About: 自定义JwtToken类，用于shiro认证授权
 * Other: 由于使用jwt来进行认证授权，而不是shiro的使用username,password来创建一个UsernamePasswordToken来认证授权，所以这里自定义一个Token类
 * Created: wfli on 2022/9/29 16:54.
 * Editored:
 */
public class JwtToken implements AuthenticationToken {

    private String jwt;

    public JwtToken() {
    }

    public JwtToken(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public Object getPrincipal() {
        return jwt;
    }

    @Override
    public Object getCredentials() {
        return jwt;
    }

}
