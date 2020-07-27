package com.codeashuai.config;

import com.codeashuai.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 20:59
 */

/**
 * 实现 WebMvcConfigure 接口的方式可以用在非前后端分离的项目中，因为需要读取一些图片、
 * css、js文件等等
 */
@Configuration
public class MyInterceptorConfig2 implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/static/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin/index").setViewName("admin/index");
    }
}
