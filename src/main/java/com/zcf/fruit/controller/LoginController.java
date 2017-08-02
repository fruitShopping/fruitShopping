package com.zcf.fruit.controller;


import com.zcf.fruit.common.config.Global;
import com.zcf.fruit.common.utils.CookieUtils;
import com.zcf.fruit.common.utils.StringUtils;
import com.zcf.fruit.util.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 */
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping(value = {"","/"})
    public String home(HttpServletRequest request, HttpServletResponse response){
//        String username = UserUtils.getPrincipal();

        // 登录成功后，验证码计算器清零
//        isValidateCodeLogin(principal.getLoginName(), false, true);

        // 如果已登录，再次访问主页，则退出原账号。
//        if (Global.TRUE.equals(Global.getConfig("notAllowRefreshIndex"))){
//            String logined = CookieUtils.getCookie(request, "LOGINED");
//            if (StringUtils.isBlank(logined) || "false".equals(logined)){
//                CookieUtils.setCookie(response, "LOGINED", "true");
//            }else if (StringUtils.equals(logined, "true")){
//                UserUtils.getSubject().logout();
//                return "redirect:/login";
//            }
//        }
        return "redirect:/back/index";
//        return "redirect:/main";
    }

    /**
     * 管理登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "sys/login";
    }
    /**
     * 登录失败，真正登录的POST请求由Filter完成
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showLoginForm(HttpServletRequest request, Model model) {
        String usernames = UserUtils.getPrincipal();
        logger.debug("UserUtils.getPrincipal => " + usernames);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        logger.debug("username => " + username);
        logger.debug("password => " + password);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        String error = null;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            error = "用户名/密码错误";
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            logger.error("密码不匹配(生产环境中应该写:用户名和密码的组合不正确)");
            error = "用户名/密码错误";
        } catch (LockedAccountException e){
            e.printStackTrace();
            logger.error(e.getMessage());
            error = "用户已锁定，禁止登陆";
        }
        // 如果已经登录，则跳转到管理首页
        if(username != null && username != ""){
            return "redirect:/back/index";
        }

//        username = WebUtils.getCleanParam(request, FormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
        boolean rememberMe = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
//        String exceptionClassName = (String)request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
////        String error = null;
////        System.out.println(exceptionClassName);
//        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
//            error = "用户名/密码错误";
//        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
//            error = "用户名/密码错误";
//        } else if(LockedAccountException.class.getName().equals(exceptionClassName)){
//            error = "用户已锁定，禁止登陆";
//        } else if(exceptionClassName != null) {
//            error = "其他错误：" + exceptionClassName;
//        }
        model.addAttribute(FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM, rememberMe);
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
        model.addAttribute("error", error);
        return "sys/login";
    }
    @RequestMapping(value = "/unAuthorization")
    public String unAuthorization(){
        return "unAuthorization";
    }

}
