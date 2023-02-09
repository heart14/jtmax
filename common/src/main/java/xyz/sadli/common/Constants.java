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
     * 系统通用状态值常量，0-无效 1-有效
     */
    public static final int STATUS_VALID = 1;
    public static final int STATUS_INVALID = 0;

    /**
     * 用户状态值常量，0-正常,1-黑名单,2-退群,3-注销账号
     */
    public static final int USER_STATUS_NORMAL = 0;
    public static final int USER_STATUS_FORBIDDEN = 1;
    public static final int USER_STATUS_LEAVE_GROUP = 2;
    public static final int USER_STATUS_DELETE = 3;

    /**
     * 活动状态值常量，0-新建，待发布，1-发布中，2-已完成，3-已取消
     */
    public static final int ACTIVITY_STATUS_CREATE = 0;
    public static final int ACTIVITY_STATUS_PUBLISH = 1;
    public static final int ACTIVITY_STATUS_FINISH = 2;
    public static final int ACTIVITY_STATUS_CANCEL = 3;


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
    public static final String ACCESS_TOKEN_PREFIX = "jtmax:accesstoken";

    public static final String REFRESH_TOKEN_PREFIX = "jtmax:refreshtoken";

    public static final String REDIS_KEY_SEPARATOR = ":";

    /**
     * access_token过期时间 10分钟(与配置文件中配置的JWT token过期时间保持一致)
     */
    public static final long REDIS_ACCESS_TOKEN_TTL = SysProperties.REDIS_ACCESS_TOKEN_TTL;
    /**
     * refresh_token过期时间 30分钟
     */
    public static final long REDIS_REFRESH_TOKEN_TTL = SysProperties.REDIS_REFRESH_TOKEN_TTL;

    /**
     * redis缓存的默认过期时间10分钟，单位毫秒
     */
    public static final long REDIS_CACHE_ENTRY_TTL = 10 * 60 * 1000;

    /**
     * 路径、地址中的'/'分隔符
     */
    public static final String URL_SEPARATOR = "/";
}
