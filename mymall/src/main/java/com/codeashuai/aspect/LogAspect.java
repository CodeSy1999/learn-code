package com.codeashuai.aspect;

import com.codeashuai.entity.ALog;
import com.codeashuai.entity.Admin;
import com.codeashuai.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 15:05
 */
@Aspect
@Component
public class LogAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LogService logService;

    @Pointcut("execution(* com.codeashuai.controller..*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logBefore(JoinPoint jp){
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取请求url
        String url = request.getRequestURL().toString();
        if(url.endsWith("admin")){
            return;
        }
        log.info("进入logBefore方法前");
        Admin admin;
        Integer aLogAdminId;
        String aLogAdminName;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.warn("{}",authentication.getPrincipal());
        if(authentication!=null && authentication.getPrincipal()!=null){
            admin = (Admin) authentication.getPrincipal();
            aLogAdminId = admin.getAdminId();
            aLogAdminName = admin.getAdminName();
        }
        //这里拦截用户判断用户是否存在
        else if(false){
            return;
        }else{
            return;
        }
        // 获取签名
        Signature signature = jp.getSignature();
        // 获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        // 获取即将执行的方法名
        String funcName = signature.getName();
        log.info("即将执行方法为: {}，属于{}包", funcName, declaringTypeName);
        // 也可以用来记录一些信息，比如获取请求的url和ip

        // 获取请求ip
        String ip = request.getRemoteAddr();
        log.info("用户请求的url为：{}，ip地址为：{}", url,ip);
        ALog aLog = new ALog(null,admin,aLogAdminName,url,new Date(),true,ip);
        logService.saveALog(aLog);
    }

    /**
     * 在上面定义的切面方法返回后执行该方法，可以捕获返回对象或者对返回对象进行增强
     * @param joinPoint joinPoint
     * @param result result
     */
    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        String classMethod = signature.getName();
        log.info("方法{}执行完毕，返回参数为：{}", classMethod, result);
        // 实际项目中可以根据业务做具体的返回值增强
//        log.info("对返回参数进行业务上的增强：{}", result + "增强版");
    }
}
