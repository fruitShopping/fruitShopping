package com.zcf.fruit.controller.sys;

import com.zcf.fruit.entity.IfPage;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.user.Menu;
import com.zcf.fruit.service.sys.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by zcf on 2017/6/16.
 */
@Controller
@RequestMapping("/back/menu")
public class MenuController {

    @Inject
    private MenuService menuService;

    @RequestMapping("/menuList")
    public String menuList(Model model,
                           @RequestParam(value = "pageNo",required = false, defaultValue = "1" ) int pageNo){
        //分页
        Page page = new Page();
        page.setCurrentPage(pageNo);

        IfPage<Menu>  menuList = menuService.findList(page);
        model.addAttribute("menuList",menuList);
        model.addAttribute("url","/back/menu/menuList?");
        return "menu/list";
    }

    @RequestMapping("/add")
    public String add(){

        return "menu/add";
    }
}
