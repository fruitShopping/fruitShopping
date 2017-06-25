package com.zcf.fruit.controller.sys;

import com.zcf.fruit.common.utils.Servlets;
import com.zcf.fruit.entity.IfPage;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.user.Role;
import com.zcf.fruit.entity.user.User;
import com.zcf.fruit.service.sys.RoleService;
import com.zcf.fruit.service.sys.UserService;
import com.zcf.fruit.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * 用户管理ACTION
 * Created by zjj-ideapad on 2015/3/29.
 */
@Controller
@RequestMapping("/back/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 用户列表查询
     * @param username 用户名
     * @param mobile 手机号码
     * @param currentPage 页码
     */
    @RequestMapping("/userList")
    public String userList(Model model,
                            @RequestParam(value = "username",required = false, defaultValue = "") String username,
                           @RequestParam(value = "mobile",required = false, defaultValue = "") String mobile,
                            @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage){
        logger.info("UserController userList check user information");
        //分页
        Page page = new Page();
        page.setCurrentPage(currentPage);

        IfPage<User> ifPageUsersList = userService.getUsersList(page, username,mobile);
        model.addAttribute("username",username);
        model.addAttribute("mobile",mobile);
        model.addAttribute("userList",ifPageUsersList);
        model.addAttribute("url","/back/menu/menuList?");
        return "users/userList";
    }

    /**
     * 用户新增页面跳转
     * @return 返回值
     */
    @RequestMapping("/add")
    public String add(Model model){
        //查询角色数据
        List<Role> roleList = roleService.findAllList();
        model.addAttribute("roleList",roleList);
        return "users/add";
    }

    /**
     * 用户信息修改和保存
     * @param user 用户信息对象
     * @return 返回值
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(User user){
        long userId = user.getId() != null ? user.getId() : 0;
        String isShow = user.getIsShow();
       if(isShow.equals("0")){
           user.setLocked(false);
       }else{
           user.setLocked(true);
       }
        if(userId == 0){
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "用户新增");
            logger.info("UserController insert : insert userInfo");
            userService.save(user);
        }else{
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "用户信息更新");
            logger.info("UserController update : update userInfo");
            userService.doEditUser(user);
        }
        return "redirect:/back/users/userList";
    }

    /**
     * 用户信息删除
     * @param ids 用户ID字符串
     * @return 返回值
     */
    @RequestMapping("/userDel")
    public @ResponseBody Boolean userDel(@RequestParam("ids") String ids){
        boolean flag = false;
        flag = userService.userDel(ids);
        return flag;
    }

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 返回值
     */
    @RequestMapping("/checkUsername")
    public @ResponseBody Boolean checkUsername(@RequestParam("username") String username){
        boolean flag = false;
        User user = userService.findUserByUsername(username);
        if(user == null){
            flag = true;
        }
        return flag;
    }

    /**
     * 用户信息更新页面跳转
     * @param model
     * @param userId
     * @return
     */
    @RequestMapping(value="/editUser/{userId}",method = RequestMethod.GET)
    public String editUser(Model model,
                           @PathVariable("userId") Long userId){
        User user = userService.editUser(userId);
        //查询角色数据
        List<Role> roleList = roleService.findAllList();
        model.addAttribute("roleList",roleList);
        model.addAttribute("user",user);
        return "users/edit";
    }

    @Inject
    private UserService userService;
    @Inject
    private RoleService roleService;
}
