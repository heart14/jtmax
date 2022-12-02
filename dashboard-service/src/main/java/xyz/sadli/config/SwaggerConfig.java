package xyz.sadli.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * About:
 * Other:
 * Created: lwf14 on 2022/9/27 22:32.
 * Editored:
 */
@Configuration
public class SwaggerConfig {

    //swagger接口文档地址
    //http://localhost:28080/dashboard/swagger-ui/index.html

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("xyz.sadli.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("JTMAX Dashboard Api Documentation")
                .description("JTMAX Dashboard Api Description")
                .contact(new Contact("sadli", "sadli.xyz", "lwf14@qq.com"))
                .version("v1.0")
                .build();
    }
}
