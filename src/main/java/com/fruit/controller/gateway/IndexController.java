package com.fruit.controller.gateway;

import com.fruit.entity.sys.Menu;
import com.fruit.util.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by zcf on 2017/6/12.
 */
@Controller
@RequestMapping("/back")
public class IndexController{

//    @RequiresRoles("ADMIN")
    @RequestMapping("/index")
    public String index(Model model){
        //获取菜单列表
        List<Menu> menuList = UserUtils.getMenuList();

        model.addAttribute("menuList",menuList);

        return "sys/index";
    }
}