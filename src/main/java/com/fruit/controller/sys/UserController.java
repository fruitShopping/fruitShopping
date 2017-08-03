package com.fruit.controller.sys;

import com.fruit.common.utils.Servlets;
import com.fruit.entity.IfPage;
import com.fruit.entity.Page;
import com.fruit.entity.sys.Role;
import com.fruit.entity.sys.User;
import com.fruit.service.sys.DictService;
import com.fruit.service.sys.RoleService;
import com.fruit.service.sys.UserService;
import com.fruit.util.LogUtils;
import com.fruit.util.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理ACTION
 * Created by zjj-ideapad on 2015/3/29.
 */
@Controller
@RequestMapping("/back/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 用户列表查询
     * @param username 用户名
     * @param mobile 手机号码
     * @param pageNo 页码
     */
    @RequestMapping("/userList")
    public String userList(Model model,
                            @RequestParam(value = "username",required = false, defaultValue = "") String username,
                           @RequestParam(value = "mobile",required = false, defaultValue = "") String mobile,
                            @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo){
        logger.info("UserController userList check sys information");
        //分页
        Page page = new Page();
        page.setCurrentPage(pageNo);

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
     * @return 返回值
     */
    @RequestMapping("/checkUsername")
    public @ResponseBody Map<String,Object> checkUsername(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map=new HashMap<String,Object>();
        String username = request.getParameter("param");
        User user = userService.findUserByUsername(username);
        if(user == null){
            map.put("status", "y");
            map.put("info", "用户名可以使用！");
        }else{
            map.put("status", "n");
            map.put("info","用户名已经存在！" );
        }
        return map;
    }

    /**
     * 根据用户名查询用户信息
     * @return 返回值
     */
    @RequestMapping("/checkUsernameBus")
    public @ResponseBody Map<String,Object> checkUsernameBus(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map=new HashMap<String,Object>();
        String username = request.getParameter("param");
        User loginUser = UserUtils.getUser();
        User user = userService.findUserBus(username,loginUser.getUsername());
        if(user == null){
            map.put("status", "y");
            map.put("info", "用户名可以使用！");
        }else{
            map.put("status", "n");
            map.put("info","用户名已经存在！" );
        }
        return map;
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
}
