package xyz.sadli.shiro.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import xyz.sadli.common.Constants;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.shiro.domain.JwtToken;
import xyz.sadli.util.StringUtils;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.SysResponse;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * About: JwtFilter
 * Other: 拦截所有请求，判断是否携带有效JwtToken
 * Created: wfli on 2022/9/29 16:21.
 * Editored:
 */
public class JwtFilter extends AccessControlFilter {

    public static final Logger log = LoggerFactory.getLogger(JwtFilter.class);

    /**
     * 约定http请求头中token字段名为Authorization
     */
    public static final String FIELD_TOKEN = "Authorization";

    /**
     * 当
     *
     * @param servletRequest
     * @param servletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        String uuid = StringUtils.UuidLowerCase();
        MDC.put(Constants.FIELD_MDC_TRACE_ID, uuid);
        log.warn("isAccessAllowed check!");
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {

        //从请求头中获取authorization
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authorization = request.getHeader(FIELD_TOKEN);

        JwtToken jwtToken = new JwtToken(authorization);

        try {
            //获取shiro subject，委托shiro realm 进行认证
            getSubject(servletRequest, servletResponse).login(jwtToken);
        } catch (AuthenticationException e) {
            //抛出异常说明认证失败
            //e.printStackTrace();
            onLoginFail(servletResponse);
            return false;
        }
        return true;
    }

    /**
     * 认证失败时返回方法
     *
     * @param response
     * @throws IOException
     */
    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        SysResponse sysResponse = SysResponseUtils.fail(ErrCodeEnums.AUTHENTICATION_EXCEPTION.getCode(), ErrCodeEnums.AUTHENTICATION_EXCEPTION.getMsg(), null);
        httpServletResponse.getWriter().write(JSON.toJSONString(sysResponse, SerializerFeature.WriteMapNullValue));
    }
}