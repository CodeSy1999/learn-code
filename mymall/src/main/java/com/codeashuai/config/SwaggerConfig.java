package com.codeashuai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 0:55
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        // 指定构建api文档的详细信息的方法：apiInfo()
        .apiInfo(apiInfo())
        .select()
        // 指定要生成api接口的包路径，这里把controller作为包路径，生成controlle
        .apis(RequestHandlerSelectors.basePackage("com.codeashuai.controller"))
        .paths(PathSelectors.any()).build();
    }
      /**
      * 构建api文档的详细信息
      * @return
      */
        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
            // 设置页面标题
            .title("RestFulApi")
            // 设置接口描述
            .description("codeashuai...mymall")
            // 设置联系方式
            .contact("codeashuai!!!")
             // 设置版本
            .version("1.0")
            // 构建
            .build();
    }

}
