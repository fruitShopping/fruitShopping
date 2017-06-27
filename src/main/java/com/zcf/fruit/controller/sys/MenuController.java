package com.zcf.fruit.controller.sys;

import com.google.common.collect.Lists;
import com.zcf.fruit.common.utils.CacheUtils;
import com.zcf.fruit.common.utils.Servlets;
import com.zcf.fruit.entity.IfPage;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.sys.Menu;
import com.zcf.fruit.entity.sys.User;
import com.zcf.fruit.service.sys.MenuService;
import com.zcf.fruit.util.LogUtils;
import com.zcf.fruit.util.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by zcf on 2017/6/16.
 */
@Controller
@RequestMapping("/back/menu")
public class MenuController {
    Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Inject
    private MenuService menuService;

    @RequestMapping("/menuList")
    public String menuList(Model model,
                           @RequestParam(value = "pageNo",required = false, defaultValue = "1" ) int pageNo){
        // 记录登录日志
        LogUtils.saveLog(Servlets.getRequest(), "菜单列表");
        //分页
        Page page = new Page();
        page.setCurrentPage(pageNo);

        IfPage<Menu>  menuList = menuService.findList(page);
        model.addAttribute("menuList",menuList);
        model.addAttribute("url","/back/menu/menuList?");
        return "menu/list";
    }

    @RequestMapping("/add")
    public String add(Model model){
        User user  = UserUtils.getUser();
        List<Menu> menuList = menuService.findAllList(user.getUsername());
        model.addAttribute("menuList",menuList);
        return "menu/add";
    }

    @RequestMapping("/edit")
    public String edit(Model model,
                       @RequestParam("id") int id){
        User user  = UserUtils.getUser();
        List<Menu> menuList = menuService.findAllList(user.getUsername());
        Menu menu = menuService.selectById(id);
        model.addAttribute("menuList",menuList);
        model.addAttribute("menu",menu);
        return "menu/edit";
    }

    @RequestMapping("/save")
    public String save(Menu menu){
        int menuId = menu.getId();
        menu.setParent(menuService.selectById(menu.getParentId()));
        User user  = UserUtils.getUser();
        // 获取排序号，最末节点排序号+30
        if (menuId == 0){
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "菜单新增");
            logger.info("MenuController update : insert menu");
            List<Menu> list = Lists.newArrayList();
            List<Menu> sourcelist = menuService.findAllList(user.getUsername());
            Menu.sortList(list, sourcelist, menu.getParentId(), false);
            if (list.size() > 0){
                menu.setSort(list.get(list.size()-1).getSort() + 30);
            }
        }else{
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "菜单信息更新");
            logger.info("MenuController update : update menu");
        }
        menuService.save(menu);

        return "redirect:/back/menu/menuList";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public @ResponseBody boolean delete(@RequestParam("ids") String ids){
        boolean flag = false;
        try {
            menuService.delete(ids);
            flag = true;
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "菜单删除");
            // 清除用户菜单缓存
            UserUtils.removeCache(UserUtils.CACHE_MENU_LIST);

            // 清除日志相关缓存
            CacheUtils.remove(LogUtils.CACHE_MENU_NAME_PATH_MAP);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("MenuController delete Exception:"+e.getMessage());
        }
        return flag;
    }

    @RequestMapping("/menuTree")
    @ResponseBody
    public List<Map<Object,Object>> menuTree(@RequestParam("roleId") int roleId){
        List<Map<Object,Object>> menuTree =  menuService.getMenuTree(roleId);

        return menuTree;
    }
}
