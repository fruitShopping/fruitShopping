package com.zcf.fruit.controller.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商家信息ACTION
 * Created by zcf on 2017/6/25.
 */
@RequestMapping("/back/business")
@Controller
public class BusinessController {
    Logger logger = LoggerFactory.getLogger(BusinessController.class);

    @RequestMapping("/businessInfo")
    public String view(){

        return "business/businessInfo";
    }
}
