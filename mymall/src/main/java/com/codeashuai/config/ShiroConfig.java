package com.codeashuai.config;

import com.codeashuai.realm.MyRealm;
import com.codeashuai.realm.PasswordHelper;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
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
        securityManager.setRememberMeManager(rememberMeManager());//把cookie管理器交给SecurityManager
        log.info("======SecurityManager注册完成=======");
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/admin/");  //没有权限就跳到这个页面
        shiroFilterFactoryBean.setSuccessUrl("/admin/index");   //跳到主页
//        shiroFilterFactoryBean.setUnauthorizedUrl("/admin/");
        Map<String,String> map = new LinkedHashMap<>();
        map.put("/admin/logout","logout");
        map.put("/admin","anon");
        map.put("/admin/","anon");
        map.put("/admin/login","anon");     //放行部分页面便于登录
        map.put("/admin/userchart","roles[1]");
//        map.put("/admin/userlist","roles[2]");
        //设置rememberMe权限能够进来的url
        map.put("/admin/index","user");
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
        log.info("========加密算法=========");
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher()); // 原来在这里
        return myRealm;
    }

    @Bean
    public SimpleCookie rememMeCookie() {
        // 初始化设置cookie的名称
        SimpleCookie simpleCookie = new SimpleCookie("mymall-shiro");
        simpleCookie.setMaxAge(3600*24);// 设置cookie的生效时间
        simpleCookie.setHttpOnly(true);
        return simpleCookie;
    }

    @Bean
    public CookieRememberMeManager rememberMeManager() {
        final String ENCRYPTION_KEY = "3AvVhmFLUs0KTA3Kprsdag==";
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememMeCookie());
        // remeberMe cookie 加密的密钥 各个项目不一样 默认AES算法 密钥长度（128 256 512）
        cookieRememberMeManager.setCipherKey(Base64.decode(ENCRYPTION_KEY));
        return cookieRememberMeManager;
    }

    @Bean
    public PasswordHelper passwordHelper() {
        return new PasswordHelper();
    }

}
