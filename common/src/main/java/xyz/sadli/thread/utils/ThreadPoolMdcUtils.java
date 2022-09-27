package xyz.sadli.thread.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import xyz.sadli.common.Constants;
import xyz.sadli.util.StringUtils;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/9/27 22:20.
 * Editored:
 */
public class ThreadPoolMdcUtils {

    public static final Logger log = LoggerFactory.getLogger(ThreadPoolMdcUtils.class);

    public static void setTraceIdIfAbsent() {
        if (MDC.get(Constants.FIELD_MDC_TRACE_ID) == null) {
            MDC.put(Constants.FIELD_MDC_TRACE_ID, StringUtils.UuidLowerCase());
        }
    }

    public static <T> Callable<T> wrap(final Callable<T> callable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }

            setTraceIdIfAbsent();

            try {
                return callable.call();
            } finally {
                MDC.clear();
            }
        };
    }

    public static Runnable wrap(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }

            setTraceIdIfAbsent();

            try {
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}
