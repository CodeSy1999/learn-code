package com.codeashuai.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 19:39
 */
/*@Component
public class MyHttpSessionListener implements HttpSessionListener {

    public static Integer count = 0;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("有人上线了");
        count++;
        se.getSession().getServletContext().setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("有人下线了");
        count--;
        se.getSession().getServletContext().setAttribute("count",count);
    }
}*/
