package xyz.sadli.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.sadli.common.Constants;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.SysResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 17:06.
 * Editored:
 */
@RestControllerAdvice
public class SysExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(SysExceptionHandler.class);

    @ExceptionHandler({UnauthorizedException.class})
    public void unauthorizedException(UnauthorizedException e, HttpServletResponse httpServletResponse) throws IOException {
        //Shiro鉴权异常
        log.error("Shiro鉴权异常 :{}", e.getMessage(), e);
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        SysResponse sysResponse = SysResponseUtils.fail(ErrCodeEnums.AUTHORIZATION_EXCEPTION.getCode(), ErrCodeEnums.AUTHORIZATION_EXCEPTION.getMsg(), null);
        httpServletResponse.getWriter().write(JSON.toJSONString(sysResponse, SerializerFeature.WriteMapNullValue));
    }

    @ExceptionHandler({SysException.class})
    public SysResponse sysExceptionHandler(SysException e) {
        //手动抛出自定异常
        log.error("手动抛出异常 :{}", e.getMessage(), e);
        return SysResponseUtils.fail(e.getCode(), e.getMessage(),null);
    }

    @ExceptionHandler({Exception.class})
    public SysResponse exceptionHandler(Exception e) {
        //系统捕获异常 可能是Assert抛出的异常
        log.error("系统捕获异常 :{}", e.getMessage(), e);
        // 判断捕获到的异常信息是否属于自定义异常枚举类
        ErrCodeEnums errCodeEnums = ErrCodeEnums.fromMsgString(e.getMessage());
        if (errCodeEnums != null) {
            return SysResponseUtils.fail(errCodeEnums.getCode(), errCodeEnums.getMsg(), null);
        }
        return SysResponseUtils.fail(ErrCodeEnums.SYSTEM_EXCEPTION.getCode(), ErrCodeEnums.SYSTEM_EXCEPTION.getMsg(), null);
    }
}
