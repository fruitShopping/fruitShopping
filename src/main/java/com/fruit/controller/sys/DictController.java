package com.fruit.controller.sys;

import com.google.common.collect.Lists;
import com.fruit.common.utils.Servlets;
import com.fruit.entity.IfPage;
import com.fruit.entity.Page;
import com.fruit.entity.sys.DictEntity;
import com.fruit.entity.sys.Menu;
import com.fruit.entity.sys.User;
import com.fruit.service.sys.DictService;
import com.fruit.util.LogUtils;
import com.fruit.util.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * 字典
 * Created by zcf on 2017/6/27.
 */
@Controller
@RequestMapping("/back/dict")
public class DictController {
    Logger logger = LoggerFactory.getLogger(DictController.class);
    @Autowired
    private DictService dictService;

    @RequestMapping("list")
    public String dictList(Model model,
                           @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo){
        logger.info("DictController dictList check list information");
        //分页
        Page page = new Page();
        page.setCurrentPage(pageNo);

        IfPage<DictEntity> ifPageDictList = dictService.getDictList(page);
        model.addAttribute("dictList",ifPageDictList);
        model.addAttribute("url","/back/dict/list?");
        return "dict/list";
    }

    @RequestMapping("/add")
    public String add(Model model,DictEntity dict){
        model.addAttribute("dict",dict);
        return "dict/add";
    }

    @RequestMapping("/update")
    public String update(Model model,@RequestParam("dictId") int dictId){
        DictEntity dict = dictService.findById(dictId);
        model.addAttribute("dict",dict);
        return "dict/add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Model model,DictEntity dict){
        try {
            dictService.save(dict);
            return "redirect:/back/dict/list";
        }catch (Exception e){
            model.addAttribute("dict",dict);
            logger.info("DictController updateOrAdd Exception: "+e.getMessage());
            e.printStackTrace();
            return "dict/add";
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public @ResponseBody
    boolean delete(@RequestParam("ids") String ids){
        logger.info("DictController delete dict information！");
        boolean flag = false;
        try {
            dictService.delete(ids);
            flag = true;
            logger.info("DictController delete dict information success！");
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "字典信息删除成功");
        }catch (Exception e){
            e.printStackTrace();
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "字典信息删除失败");
            logger.error("DictController delete dict information Exception:"+e.getMessage());
        }
        return flag;
    }


}
