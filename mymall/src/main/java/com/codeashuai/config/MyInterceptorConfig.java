package com.codeashuai.config;

import com.codeashuai.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 20:51
 */

/**
 * 该实现适用于前后端分离项目，因为WebMvcConfigurationSupport会拦截静态资源，
 * 另一个WebMvcConfigure则不会拦截静态资源
 *
 */

/*@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }


*//**
     * 不用拦截静态资源，默认WebMvcConfigurationSupport会拦截
     * @param registry*//*


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations
                ("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}*/
