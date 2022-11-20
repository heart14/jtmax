package xyz.sadli.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/11/20 11:53.
 * Editored:
 */
public class DateUtils {

    public static Date currentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime atZone = now.atZone(zone);
        return Date.from(atZone.toInstant());
    }
}
