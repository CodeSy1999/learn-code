package com.codeashuai.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 16:53
 */
@Configuration
public class DruidMonitorConfiguration {

    @Value("${spring.datasource.druid.monitor.allow}")
    private String allow;
    //    @Value("${spring.datasource.druid.monitor.deny}")
//    private String deny;
    @Value("${spring.datasource.druid.monitor.loginUsername}")
    private String loginUsername;
    @Value("${spring.datasource.druid.monitor.loginPassword}")
    private String loginPassword;
    @Value("${spring.datasource.druid.monitor.resetEnable")
    private String resetEnable;

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        servletRegistrationBean.addInitParameter("allow", this.allow);
//        servletRegistrationBean.addInitParameter("deny", this.deny);
        servletRegistrationBean.addInitParameter("loginUsername", this.loginUsername);
        servletRegistrationBean.addInitParameter("loginPassword", this.loginPassword);
        servletRegistrationBean.addInitParameter("resetEnable", this.resetEnable);
//        servletRegistrationBean.addInitParameter("enabled","true");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
