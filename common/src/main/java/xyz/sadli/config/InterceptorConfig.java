package xyz.sadli.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.sadli.interceptor.RequestInterceptor;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/11/27 15:47.
 * Editored:
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义过滤器
        registry.addInterceptor(new RequestInterceptor());
    }

    @Override
    //重写父类提供的跨域请求处理的接口
    public void addCorsMappings(CorsRegistry registry) {
        //添加映射路径
        registry.addMapping("/**")
                //放行哪些原始域
                .allowedOrigins("*")
                //是否发送Cookie信息
                .allowCredentials(true)
                //放行哪些原始域(请求方式)
                .allowedMethods("OPTIONS","GET", "POST", "PUT", "DELETE", "HEAD", "FETCH")
                //放行哪些原始域(头部信息)
                .allowedHeaders("*")
                //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                .exposedHeaders("Authorization");

        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}
