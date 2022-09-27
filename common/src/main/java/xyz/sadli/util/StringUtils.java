package xyz.sadli.util;

import java.util.UUID;

/**
 * About:
 * Other:
 * Created: wfli on 2022/9/27 17:24.
 * Editored:
 */
public class StringUtils extends org.springframework.util.StringUtils {

    public static String UuidUpperCase() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String UuidLowerCase() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
