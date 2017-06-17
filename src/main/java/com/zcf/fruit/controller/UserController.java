package com.zcf.fruit.controller;

import com.zcf.fruit.entity.IfPage;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.user.User;
import com.zcf.fruit.service.sys.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by zjj-ideapad on 2015/3/29.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/userList")
    public String userList(Model model,
                            @RequestParam(value = "username",required = false, defaultValue = "") String username,
                            @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage){

        //分页
        Page page = new Page();
        page.setCurrentPage(currentPage);

        IfPage<User> ifPageUsersList = userService.getUsersList(page, username);
        model.addAttribute("username",username);
        model.addAttribute("dateRecord",ifPageUsersList);
        model.addAttribute("url","/users/userList");
        return "users/userList";
    }

    @RequestMapping(value="/doLocked",method = RequestMethod.POST)
    public @ResponseBody Boolean doLocked(@RequestParam("userId") Long userId,
                                          @RequestParam("num") int num){
        boolean flag = false;
        flag = userService.doLocked(userId,num);
        return flag;
    }

    @RequestMapping("/userDel")
    public @ResponseBody Boolean userDel(Model model,
                                         @RequestParam("userId") Long userId){
        boolean flag = false;
        flag = userService.userDel(userId);
        return flag;
    }

    @RequestMapping(value="/editUser/{userId}",method = RequestMethod.GET)
    public String editUser(Model model,
                           @PathVariable("userId") Long userId){
        User user = userService.editUser(userId);
        model.addAttribute("user",user);
        model.addAttribute("userId",userId);
        model.addAttribute("backupPassword",user.getPassword());
        return "users/editUser";
    }

    @RequestMapping(value="/editUser",method = RequestMethod.POST)
    public String doEditUser(Model model,User user,
                             @RequestParam("backupPassword") String backupPassword,
                             @RequestParam("userId") Long userId){
        boolean flag = userService.doEditUser(user,backupPassword,userId);
        if(flag == true){
            return "redirect:/users/userList";
        }else{
            model.addAttribute("user",user);
            return "users/editUser";
        }


    }

    @Inject
    private UserService userService;
}
