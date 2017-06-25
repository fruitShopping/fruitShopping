package com.zcf.fruit.controller;


import com.zcf.fruit.common.config.Global;
import com.zcf.fruit.common.utils.CookieUtils;
import com.zcf.fruit.common.utils.StringUtils;
import com.zcf.fruit.util.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
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
    private Logger logger = org.slf4j.LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = {"","/"})
    public String home(HttpServletRequest request, HttpServletResponse response){
        String username = UserUtils.getPrincipal();

        // 登录成功后，验证码计算器清零
//        isValidateCodeLogin(principal.getLoginName(), false, true);

        // 如果已登录，再次访问主页，则退出原账号。
        if (Global.TRUE.equals(Global.getConfig("notAllowRefreshIndex"))){
            String logined = CookieUtils.getCookie(request, "LOGINED");
            if (StringUtils.isBlank(logined) || "false".equals(logined)){
                CookieUtils.setCookie(response, "LOGINED", "true");
            }else if (StringUtils.equals(logined, "true")){
                UserUtils.getSubject().logout();
                return "redirect:/login";
            }
        }

        return "redirect:/back/index";
    }

    /**
     * 管理登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        String username = UserUtils.getPrincipal();

//		// 默认页签模式
//		String tabmode = CookieUtils.getCookie(request, "tabmode");
//		if (tabmode == null){
//			CookieUtils.setCookie(response, "tabmode", "1");
//		}

        if (logger.isDebugEnabled()){
            //处理session
            DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
            DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
            Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
            logger.debug("login, active session size: {}", sessions.size());
        }

        // 如果已登录，再次访问主页，则退出原账号。
        if (Global.TRUE.equals(Global.getConfig("notAllowRefreshIndex"))){
            CookieUtils.setCookie(response, "LOGINED", "false");
        }

        // 如果已经登录，则跳转到管理首页
        if(username != null && username != ""){
            return "redirect:/back/index";
        }

        return "sys/login";
    }

    /**
     * 登录失败，真正登录的POST请求由Filter完成
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showLoginForm(HttpServletRequest request, Model model) {
        String username = UserUtils.getPrincipal();

        // 如果已经登录，则跳转到管理首页
        if(username != null && username != ""){
            return "redirect:/back/index";
        }

        username = WebUtils.getCleanParam(request, FormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
        boolean rememberMe = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
        String exceptionClassName = (String)request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        String error = null;
//        System.out.println(exceptionClassName);
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(LockedAccountException.class.getName().equals(exceptionClassName)){
            error = "用户已锁定，禁止登陆";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute(FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM, rememberMe);
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
        model.addAttribute("error", error);
        return "sys/login";
    }

}
