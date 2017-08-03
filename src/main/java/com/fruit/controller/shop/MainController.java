package com.fruit.controller.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商城首页
 * Created by zcf on 2017/7/15.
 */
@RequestMapping("/main")
@Controller
public class MainController {

    @RequestMapping("")
    public String main(Model model){

        return "shopping/main";
    }
}
