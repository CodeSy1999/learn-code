package com.codeashuai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/22 17:49
 */
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringBootRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRunner.class);
    }
}
