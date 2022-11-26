package xyz.sadli.common;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 16:46.
 * Editored:
 */
public class Constants {

    /**
     * 系统响应返回值state取值
     */
    public static final String STATE_SUCCESS = "SUCCESS";
    public static final String STATE_FAIL = "FAIL";

    /**
     * 状态值常量
     */
    public static final int STATUS_VALID = 1;
    public static final int STATUS_INVALID = 0;

    /**
     * slf4j日志框架MDC常量字段名
     */
    public static final String FIELD_MDC_TRACE_ID = "traceId";

    /**
     * 约定http请求头中token字段名为Authorization
     */
    public static final String FIELD_JWT_TOKEN = "Authorization";

    /**
     * Redis常量
     */
    public static final String ACCESS_TOKEN_PREFIX = "accesstoken";

    public static final String REFRESH_TOKEN_PREFIX = "refreshtoken";

    public static final String REDIS_KEY_SEPARATOR = ":";

    /**
     * access_token过期时间 10分钟(与配置文件中配置的JWT token过期时间保持一致)
     */
    public static final long REDIS_ACCESS_TOKEN_TTL = 10 * 60 * 1000;
    /**
     * refresh_token过期时间 30分钟
     */
    public static final long REDIS_REFRESH_TOKEN_TTL = 30 * 60 * 1000;
}
