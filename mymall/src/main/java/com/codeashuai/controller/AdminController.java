package com.codeashuai.controller;


import com.codeashuai.exception.MyException;
import com.codeashuai.exception.MyExceptionEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/25 11:03
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping({"","/"})
    public String admin(HttpSession session){
        //判断是否已经登录过了
        Object isLogin = session.getAttribute("isLogin");
        log.info("==========登陆前isLogin:{}=========",isLogin);
        if(isLogin!=null && (boolean)isLogin==true){
            return "redirect:/admin/index";
        }
        return "login";
    }

    /*@PostMapping("/login")
    public String login(String adminName,String adminPwd,String rememberMe,RedirectAttributes attributes){
        //获得用户名和密码
        log.info("尝试登录:{},{},{}",adminName,adminPwd,rememberMe);
        UsernamePasswordToken token = new UsernamePasswordToken(adminName,adminPwd);
        Subject subject = SecurityUtils.getSubject();
        if(rememberMe!=null && "on".equals(rememberMe)){
            token.setRememberMe(true);
        }
        try{
            subject.login(token);
        }catch (Exception e){
            log.info("登录异常：{}",e.getMessage());
//            return "redirect:/admin/index";
            attributes.addFlashAttribute("login_msg","名字或密码有误~");
            return "redirect:/admin";
        }
        //登录成功
        subject.getSession().setAttribute("isLogin",true);
        log.info("登录成功isLogin:{}",subject.getSession().getAttribute("isLogin"));
        return "redirect:/admin/index";
    }*/

    @Secured("1")
    @GetMapping("/userchart")
    public String userchart(){
        return "admin/user-chart";
    }

    @GetMapping("/userlist")
    public String userlist(){
        return "admin/user-list";
    }

    @GetMapping("/salelist")
    public String salelist(){
        return "admin/sale-list";
    }

    @GetMapping("/phonelist")
    public String phonelist(){
        return "admin/phone-list";
    }

    @GetMapping("/orderlist")
    public String orderlist(){
        return "admin/order-list";
    }

    @GetMapping("/orderrefund")
    public String orderrefund(){
        return "admin/order-refund";
    }

    @GetMapping("/orderchart")
    public String orderchart(){
        return "admin/order-chart";
    }

    @GetMapping("/promotionlist")
    public String promotionlist(){
        return "admin/promotion-list";
    }

    @GetMapping("/promotionopen")
    public String promotionopen(){
        return "admin/promotion-open";
    }

    @GetMapping("/loguser")
    public String loguser(){
        return "admin/log-user";
    }

    @GetMapping("/logadmin")
    public String logadmin(){
        return "admin/log-admin";
    }

    @GetMapping("/adminlist")
    public String adminlist(){
        return "admin/admin-list";
    }

    @GetMapping("/authoritymanager")
    public String authoritymanager(){
        return "admin/authority-manager";
    }

    @GetMapping("/adminmessage")
    public String adminmessage(){
        return "admin/admin-message";
    }

    /*@GetMapping("/logout")
    public String adminlogout(HttpSession session){
        log.info("==========注销==============");
        return "redirect:/admin";
    }*/

    @GetMapping("/test")
    public String test(){
        throw new MyException(MyExceptionEnum.AUTHORITY_Exception);
    }

    @GetMapping("/test1")
    public String test1(){
        throw new RuntimeException("运行异常");
    }
}
