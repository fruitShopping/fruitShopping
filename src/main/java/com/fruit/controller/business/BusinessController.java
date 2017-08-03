package com.fruit.controller.business;

import com.fruit.common.file.FileUpload;
import com.fruit.entity.business.BusinessEntity;
import com.fruit.entity.content.ContentImgEntity;
import com.fruit.entity.sys.User;
import com.fruit.service.business.BusinessService;
import com.fruit.util.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商家信息ACTION
 * Created by zcf on 2017/6/25.
 */
@RequestMapping("/back/business")
@Controller
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    Logger logger = LoggerFactory.getLogger(BusinessController.class);

    @RequestMapping("/businessInfo")
    public String view(Model model){
        User user = UserUtils.getUser();
        BusinessEntity business = businessService.getInfo(user.getId());
        model.addAttribute("business",business);
        return "business/businessInfo";
    }

    @RequestMapping("/edit")
    public String edit(Model model){
        User user = UserUtils.getUser();
        BusinessEntity business = businessService.getInfo(user.getId());
        model.addAttribute("business",business);
        return "business/edit";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(HttpServletRequest request,BusinessEntity business){
        logger.info("BusinessController save business information edit!");
        try {
            User user = UserUtils.getUser();
            // 文件上传
            String pathStr = FileUpload.springUpload(request,"static/content/images/"+user.getId()+"/");
            String[] path = pathStr.split(",");
            List<ContentImgEntity> imgList = new ArrayList<ContentImgEntity>();
            int num = 0;
            for(String str : path){
                ContentImgEntity contentImg = new ContentImgEntity();
                contentImg.setImgPath(str);
                contentImg.setType(num);
                imgList.add(contentImg);
                num++;
            }
            business.setImgList(imgList);
            businessService.save(business);
            logger.info("BusinessController save business information edit success!");

            return "redirect:/back/business/businessInfo";
        }catch (IOException e){
            e.printStackTrace();
            logger.info("BusinessController save business information edit fail!");
            logger.error("BusinessController save business information Exception:"+e.getMessage());
            return "redirect:/back/business/edit";
        }

    }

}
