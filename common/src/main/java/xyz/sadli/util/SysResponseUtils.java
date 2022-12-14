package xyz.sadli.util;

import org.slf4j.MDC;
import xyz.sadli.common.Constants;
import xyz.sadli.common.ErrCodeEnums;
import xyz.sadli.vo.SysResponse;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 17:17.
 * Editored:
 */
public class SysResponseUtils {

    public static SysResponse success() {
        return success(null);
    }

    public static SysResponse success(Object data) {
        return success(ErrCodeEnums.SUCCESS.getCode(), ErrCodeEnums.SUCCESS.getMsg(), data);
    }

    public static SysResponse success(int code, String msg, Object data) {
        return new SysResponse(Constants.STATE_SUCCESS, code, msg, data, MDC.get(Constants.FIELD_MDC_TRACE_ID));
    }

    public static SysResponse fail() {
        return fail(null);
    }

    public static SysResponse fail(Object data) {
        return fail(ErrCodeEnums.UNKNOWN_EXCEPTION.getCode(), ErrCodeEnums.UNKNOWN_EXCEPTION.getMsg(), data);
    }

    public static SysResponse fail(int code, String msg, Object data) {
        return new SysResponse(Constants.STATE_FAIL, code, msg, data, MDC.get(Constants.FIELD_MDC_TRACE_ID));
    }
}
