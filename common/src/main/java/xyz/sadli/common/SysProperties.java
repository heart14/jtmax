package xyz.sadli.common;

import xyz.sadli.config.SysPropertyLoader;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 16:47.
 * Editored:
 */
public class SysProperties {

    public static final String BUCKET_PATH = SysPropertyLoader.getInstance().getSysProperty("bucket.path");
    public static final String BUCKET_URL = SysPropertyLoader.getInstance().getSysProperty("bucket.url");

    public static void main(String[] args) {
        System.out.println(BUCKET_PATH);
        System.out.println(BUCKET_URL);
    }

}
