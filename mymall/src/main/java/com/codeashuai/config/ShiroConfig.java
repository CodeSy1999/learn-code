package com.codeashuai.config;

import com.codeashuai.realm.MyRealm;
import com.codeashuai.realm.PasswordHelper;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/27 14:00
 */
@Configuration
public class ShiroConfig {

    private static final Logger log = LoggerFactory.getLogger(ShiroConfig.class);

    /*@Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        log.info("======myRealm注册完成=======");
        return myRealm;
    }*/

    @Bean
    public SecurityManager securityManager(){
        DefaultSecurityManager securityManager = new DefaultWebSecurityManager(myRealm());
        log.info("======SecurityManager注册完成=======");
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/admin/");
        shiroFilterFactoryBean.setSuccessUrl("/admin/index");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/admin/");
        Map<String,String> map = new LinkedHashMap<>();
        map.put("/admin/logout","logout");
        map.put("/admin","anon");
        map.put("/admin/","anon");
        map.put("/admin/login","anon");
        map.put("/admin/userchart","roles[1]");
//        map.put("/admin/userlist","roles[2]");
        map.put("/admin/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        log.info("======shiroFilterFactoryBean注册完成=======");
        return shiroFilterFactoryBean;
    }


    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(PasswordHelper.ALGORITHM_NAME); // 散列算法
        hashedCredentialsMatcher.setHashIterations(PasswordHelper.HASH_ITERATIONS); // 散列次数
        return hashedCredentialsMatcher;
    }

    @Bean
    public MyRealm myRealm() {
        MyRealm myRealm = new MyRealm();
        log.info("======myRealm注册完成=======");
        System.out.println("========加密算法=========");
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher()); // 原来在这里
        return myRealm;
    }

    @Bean
    public PasswordHelper passwordHelper() {
        return new PasswordHelper();
    }

}
