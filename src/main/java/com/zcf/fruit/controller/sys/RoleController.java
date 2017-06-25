package com.zcf.fruit.controller.sys;

import com.zcf.fruit.common.utils.Servlets;
import com.zcf.fruit.entity.user.Role;
import com.zcf.fruit.service.sys.RoleService;
import com.zcf.fruit.util.LogUtils;
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

/**
 * 角色ACTION
 * Created by zcf on 2017/6/22.
 */
@Controller
@RequestMapping("/back/role")
public class RoleController {
    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Inject
    private RoleService roleService;

    /**
     * 角色列表
     * @param model
     * @return 跳转页面
     */
    @RequestMapping("list")
    public String roleList(Model model){
        logger.info("RoleController roleList check role information");
        List<Role> roleList = roleService.findAllList();
        model.addAttribute("roleList",roleList);
        return "role/list";
    }

    @RequestMapping("/add")
    public String add(){

        return "role/add";
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Role role){
        int roleId = role.getId();
        if(roleId == 0){
            //新增
            logger.info("RoleController insert role information！");
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "角色新增");
            roleService.insert(role);
        }else{
           //更新
            logger.info("RoleController update role information！");
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "角色信息更新");
            roleService.update(role);
        }
        return "redirect:/back/role/list";
    }

    @RequestMapping("/edit")
    public String edit(Model model,@RequestParam("id") int id){
        Role role = roleService.findOne(id);
        model.addAttribute("role",role);
        return "role/edit";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public @ResponseBody
    boolean delete(@RequestParam("ids") String ids){
        logger.info("RoleController delete role information！");
        boolean flag = false;
        try {
            roleService.delete(ids);
            flag = true;
            logger.info("RoleController delete role information success！");
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "角色删除成功");
        }catch (Exception e){
            e.printStackTrace();
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "角色删除失败");
            logger.error("RoleController delete role information Exception:"+e.getMessage());
        }
        return flag;
    }

    @RequestMapping(value = "/roleAndMenu",method = RequestMethod.POST)
    public @ResponseBody boolean roleMenu(@RequestParam("roleId") int roleId,
                                          @RequestParam(value = "selectIds",required = false,defaultValue = "0") String selectIds,
                                          @RequestParam(value = "changeIds",required = false,defaultValue = "-1") String changeIds){
        logger.info("RoleController roleMenu role authority");
        // 记录登录日志
        LogUtils.saveLog(Servlets.getRequest(), "角色赋权");
        boolean flag = false;
        try{
            roleService.roleAndMenu(roleId,selectIds,changeIds);
            flag = true;
            logger.info("RoleController roleMenu role authority success");
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "角色赋权成功");
        }catch (Exception e){
            logger.error("RoleController roleMenu role authority fail Exception:"+e.getMessage());
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "角色赋权失败");
        }

        return flag;
    }
}
