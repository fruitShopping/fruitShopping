package com.fruit.controller.gateway;

import com.fruit.entity.dat.Menu;
import com.fruit.util.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * zyming 2017/8/6.
 */
@Controller
@RequestMapping("/back")
public class IndexController{
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    //@RequiresRoles("ADMIN")
    //@RequiresPermissions("account:create")
    @RequestMapping("/index")
    public String index(Model model){
        //获取菜单列表
        List<Menu> menuList = UserUtils.getMenuList();

        model.addAttribute("menuList",menuList);


        return "sys/index";
    }
}
