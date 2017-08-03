package com.fruit.controller.gateway;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping(value = {"","/"})
    public String home(HttpServletRequest request, HttpServletResponse response){
        return "redirect:/back/index";
    }

    /**
     * 管理登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "sys/login";
    }
    /**
     * 管理登录
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:sys/login";
    }
    /**
     * 登录失败，真正登录的POST请求由Filter完成
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doFormLogin(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        logger.debug("username => " + username);
        logger.debug("password => " + password);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        String error = null;
        boolean b=true;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            b=false;
            e.printStackTrace();
            error = "用户名/密码错误";
            logger.error(error);
        } catch (IncorrectCredentialsException e){
            b=false;
            e.printStackTrace();
            error = "用户名/密码错误";
            logger.error(error);
        } catch (LockedAccountException e){
            b=false;
            e.printStackTrace();
            error = "用户已锁定，禁止登陆";
            logger.error(error);
        } catch (Exception e){
            b=false;
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        // 如果已经登录，则跳转到管理首页
        if(b){return "redirect:/back/index";}

        //username = WebUtils.getCleanParam(request, FormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
        //boolean rememberMe = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
        //logger.error(username+">>>>>>>>>>"+rememberMe);
        //model.addAttribute(FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM, rememberMe);
        //model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
        model.addAttribute("error", error);
        return "sys/login";
    }
    @RequestMapping(value = "/unAuthorization")
    public String unAuthorization(){
        return "unAuthorization";
    }

}
