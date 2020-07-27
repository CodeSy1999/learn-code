package com.codeashuai.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 21:08
 */

/**
 * 用于标记不需要拦截的方法
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnInterception {

}
