package com.codeashuai.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 20:07
 */
public class MyEvent extends ApplicationEvent {

    private String message;

    public MyEvent(Object source,String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
