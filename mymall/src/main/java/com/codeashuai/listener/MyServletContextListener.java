package com.codeashuai.listener;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 16:13
 */

/*@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //获取ServletContext上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        //获取容器中的属性
        FirstService firstService = applicationContext.getBean(FirstService.class);
        User user = firstService.getUser();
        //获取ServletContext域对象
        ServletContext servletContext = applicationContext.getBean(ServletContext.class);
        log.info("user:{}",user);
        servletContext.setAttribute("user",user);

    }
}*/
