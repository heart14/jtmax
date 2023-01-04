package xyz.sadli.common;

import xyz.sadli.config.SysPropertyLoader;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 16:47.
 * Editored:
 */
public class SysProperties {

    private static final SysPropertyLoader propertyLoader;

    static {
        propertyLoader = SysPropertyLoader.getInstance();
    }

    public static final String BUCKET_PATH = propertyLoader.getSysProperty("bucket.path");
    public static final String BUCKET_URL = propertyLoader.getSysProperty("bucket.url");
    public static final String JWT_SECRET = propertyLoader.getSysProperty("jwt.secret");
    public static final Long JWT_TTL = Long.valueOf(propertyLoader.getSysProperty("jwt.ttl"));
    public static final Long REDIS_ACCESS_TOKEN_TTL = Long.valueOf(propertyLoader.getSysProperty("redis.access_token.ttl"));
    public static final Long REDIS_REFRESH_TOKEN_TTL = Long.valueOf(propertyLoader.getSysProperty("redis.refresh_token.ttl"));


    public static void main(String[] args) {
        System.out.println(BUCKET_PATH);
        System.out.println(BUCKET_URL);
        System.out.println(JWT_SECRET);
        System.out.println(JWT_TTL);
    }

}
