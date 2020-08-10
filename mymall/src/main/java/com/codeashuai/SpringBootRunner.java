package com.codeashuai;

import com.codeashuai.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/22 17:49
 */
@EnableAsync
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableConfigurationProperties(RsaKeyProperties.class)
public class SpringBootRunner {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(SpringBootRunner.class);
    }
}
