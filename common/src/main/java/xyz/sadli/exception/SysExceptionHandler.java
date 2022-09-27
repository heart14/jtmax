package xyz.sadli.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.sadli.common.Constants;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.util.SysResponseUtils;
import xyz.sadli.vo.SysResponse;

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

    @ExceptionHandler({SysException.class})
    public SysResponse sysExceptionHandler(SysException e) {
        //手动抛出自定异常
        log.error("手动抛出异常 :{}", e.getMessage(), e);
        //异常时返回日志traceId
        Map<String, String> map = new HashMap<>();
        map.put(Constants.FIELD_MDC_TRACE_ID, MDC.get(Constants.FIELD_MDC_TRACE_ID));
        return SysResponseUtils.fail(e.getCode(), e.getMessage(), map);
    }

    @ExceptionHandler({Exception.class})
    public SysResponse exceptionHandler(Exception e) {
        //系统捕获异常 可能是Assert抛出的异常
        log.error("系统捕获异常 :{}", e.getMessage(), e);
        //异常时返回日志traceId
        Map<String, String> map = new HashMap<>();
        map.put(Constants.FIELD_MDC_TRACE_ID, MDC.get(Constants.FIELD_MDC_TRACE_ID));
        // 判断捕获到的异常信息是否属于自定义异常枚举类
        ErrCodeEnums errCodeEnums = ErrCodeEnums.fromMsgString(e.getMessage());
        if (errCodeEnums != null) {
            return SysResponseUtils.fail(errCodeEnums.getCode(), errCodeEnums.getMsg(), map);
        }
        return SysResponseUtils.fail(ErrCodeEnums.SYSTEM_EXCEPTION.getCode(), ErrCodeEnums.SYSTEM_EXCEPTION.getMsg(), map);
    }
}
