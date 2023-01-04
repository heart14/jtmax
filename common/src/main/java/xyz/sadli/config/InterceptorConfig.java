package xyz.sadli.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.sadli.interceptor.RequestInterceptor;

/**
 * About: MDC设置traceId的过滤器已弃用，所以这里不需要再注册过滤器了
 * Other:
 * Created: lwf14 on 2022/11/27 15:47.
 * Editored:
 */
@Deprecated
//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义过滤器
//        registry.addInterceptor(new RequestInterceptor());
    }
}
