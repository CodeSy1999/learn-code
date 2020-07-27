package com.codeashuai.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 19:59
 */
/*@Component
public class MyRequestListener implements ServletRequestListener {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        log.info("reqeust的sessionID：{}",request.getRequestedSessionId());
        log.info("request的url为：{}",request.getRequestURL());

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("request...结束");
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        log.info("request的url为：{}",request.getRequestURL());
    }
}*/
