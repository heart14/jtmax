package xyz.sadli.common;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 17:11.
 * Editored:
 */
public enum ErrCodeEnums {
    /**
     * 成功，ErrorCode :9999
     */
    SUCCESS(9999, "请求成功"),

    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION(9000, "系统异常"),

    /**
     * 系统异常
     */
    UNKNOWN_EXCEPTION(9001, "未知异常"),

    /**
     * 登陆失败
     */
    LOGIN_EXCEPTION(9002, "登陆失败"),

    /**
     * 认证异常
     */
    AUTHENTICATION_EXCEPTION(9003, "认证异常"),

    /**
     * 授权异常
     */
    AUTHORIZATION_EXCEPTION(9004, "授权异常"),

    /**
     * 参数异常
     */
    PARAMS_EXCEPTION(9005, "参数异常"),

    /**
     * 结果集异常
     */
    RESULT_EXCEPTION(9006, "查询异常"),

    /**
     * 字符集异常
     */
    CHARSET_EXCEPTION(9007, "字符集异常"),

    /**
     * 网络请求异常
     */
    HTTP_EXCEPTION(9008, "网络请求异常"),

    /**
     * 不支持的媒体类型
     */
    UNSUPPORT_MEDIA_TYPE(9009, "不支持的媒体类型");

    private Integer code;

    private String msg;

    ErrCodeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据msg值获取ErrCodeEnums
     *
     * @param msg
     * @return
     */
    public static ErrCodeEnums fromMsgString(String msg) {
        for (ErrCodeEnums errCodeEnums : ErrCodeEnums.values()) {
            if (errCodeEnums.getMsg().equals(msg)) {
                return errCodeEnums;
            }
        }
        return null;
    }

    /**
     * 根据code值获取ErrCodeEnums
     *
     * @param code
     * @return
     */
    public static ErrCodeEnums fromCode(int code) {
        for (ErrCodeEnums errCodeEnums : ErrCodeEnums.values()) {
            if (errCodeEnums.getCode() == code) {
                return errCodeEnums;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
