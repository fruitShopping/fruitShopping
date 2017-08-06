package com.fruit.controller.gateway;

import com.fruit.entity.sys.User;
import com.fruit.service.sys.RegisterService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

/**
 * zyming 2017/8/6.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @RequestMapping("")
    public String register(Model model){

        return "register";
    }

    @RequestMapping(value="register",method = RequestMethod.POST)
    public String addUser(Model model,User user){
        //如果使用user password token进行登陆，则需要先保存password，因为后面会对密码进行加密
        String password = user.getPassword();
        try {
            registerService.createUser(user);
            //注册成功之后，直接登陆
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), password);
            subject.login(usernamePasswordToken);
            return "redirect:/sms/";
        }catch(Exception e){
            model.addAttribute("error", "error");

            //将密码设置为未加密之前的字符串
            user.setPassword(password);
            model.addAttribute("sys", user);
//            model.addAttribute("agent", agent);
            return "register";
        }
    }

    @RequestMapping("/checkUsername")
    public @ResponseBody Boolean checkUsername(Model model,@RequestParam("username") String username){
        boolean flag = false;
        flag = registerService.checkUsername(username);
        return flag;
    }
}
