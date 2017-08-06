package com.fruit.controller.product;

import com.fruit.common.utils.Servlets;
import com.fruit.entity.IfPage;
import com.fruit.entity.Page;
import com.fruit.entity.product.CategoryEntity;
import com.fruit.entity.dat.DictEntity;
import com.fruit.service.product.CategoryService;
import com.fruit.service.dat.DictService;
import com.fruit.util.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 产品品种
 * Created by zcf on 2017/6/28.
 */
@Controller
@RequestMapping("/back/category")
public class CategoryController {
    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DictService dictService;

    @RequestMapping("/list")
    public String categoryList(Model model,
                           @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo){
        logger.info("CategoryController categoryList check list information");
        //分页
        Page page = new Page();
        page.setCurrentPage(pageNo);

        IfPage<CategoryEntity> ifPageCateList = categoryService.getCategoryList(page);
        model.addAttribute("cateList",ifPageCateList);
        model.addAttribute("url","/back/category/list?");
        return "category/list";
    }

    @RequestMapping("/add")
    public String add(Model model,CategoryEntity category){
        //查询产品类别
        List<DictEntity> dictList = dictService.findByCode("category");
        model.addAttribute("category",category);
        model.addAttribute("dictList",dictList);
        return "category/add";
    }

    @RequestMapping("/update")
    public String update(Model model,@RequestParam("categoryId") int categoryId){
        CategoryEntity category = categoryService.findById(categoryId);
        //查询产品类别
        List<DictEntity> dictList = dictService.findByCode("category");
        model.addAttribute("category",category);
        model.addAttribute("dictList",dictList);
        return "category/add";
    }

    @RequestMapping(value = "/findCateByCode",method = RequestMethod.POST)
    @ResponseBody
    public List<CategoryEntity> findCateByCode(@RequestParam("typeId") int typeId){
        try {
            return categoryService.findCateByCode(typeId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Model model,CategoryEntity category){
        try {
            categoryService.save(category);
            return "redirect:/back/category/list";
        }catch (Exception e){
            model.addAttribute("dict",category);
            logger.info("CategoryController updateOrAdd category information Exception: "+e.getMessage());
            e.printStackTrace();
            return "category/add";
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public @ResponseBody
    boolean delete(@RequestParam("ids") String ids){
        logger.info("CategoryController delete category information！");
        boolean flag = false;
        try {
            categoryService.delete(ids);
            flag = true;
            logger.info("CategoryController delete category information success！");
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "产品类别信息删除成功");
        }catch (Exception e){
            e.printStackTrace();
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "产品类别信息删除失败");
            logger.error("CategoryController delete category information Exception:"+e.getMessage());
        }
        return flag;
    }
}
