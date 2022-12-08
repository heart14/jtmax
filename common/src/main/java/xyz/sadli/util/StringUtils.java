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

    /**
     * 将/banner/list格式的route转化为BannerList格式的name
     *
     * @param route
     * @return
     */
    public static String parseRoutePathToName(String route) {
        if (route == null || route.trim().isEmpty()) {
            return "";
        }
        String[] split = route.split("/");
        String result = "";

        if (split.length > 0) {
            for (String s : split) {
                if (s.trim().length() > 0) {
                    String upperCase = s.substring(0, 1).toUpperCase();
                    String name = upperCase + s.substring(1);
                    result += name;
                }
            }

        }
        return result;


    }
}
