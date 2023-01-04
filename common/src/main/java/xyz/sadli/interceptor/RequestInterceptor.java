package xyz.sadli.interceptor;

import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import xyz.sadli.common.Constants;
import xyz.sadli.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * About: 请求过滤器
 * Other:
 * Created: lwf14 on 2022/11/27 15:42.
 * Editored:
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果没有经过jwtFilter添加traceId，在这里进行设置traceId
        if (MDC.get(Constants.FIELD_MDC_TRACE_ID) == null) {
            MDC.put(Constants.FIELD_MDC_TRACE_ID, StringUtils.UuidLowerCase());
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //请求结束，清除traceId
        MDC.clear();
    }

}
