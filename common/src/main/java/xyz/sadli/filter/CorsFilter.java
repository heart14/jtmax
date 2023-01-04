package xyz.sadli.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import xyz.sadli.common.Constants;
import xyz.sadli.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * About:
 * Other:
 * Created: wfli on 2023/1/4 17:08.
 * Editored:
 */
@Component
public class CorsFilter implements Filter {

    public static final Logger log = LoggerFactory.getLogger(CorsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CorsFilter init");
        //如果没有添加traceId，在这里进行设置traceId
        if (MDC.get(Constants.FIELD_MDC_TRACE_ID) == null) {
            MDC.put(Constants.FIELD_MDC_TRACE_ID, StringUtils.UuidLowerCase());
        }
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("CorsFilter doFilter, request METHOD = {}, request URL = {}",request.getMethod(), request.getRequestURL());
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE,OPTIONS,FETCH,HEAD");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, Authorization");
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("CorsFilter destroy");
        Filter.super.destroy();
    }
}
