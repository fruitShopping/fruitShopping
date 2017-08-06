package com.fruit.controller.product;

import com.fruit.common.utils.Servlets;
import com.fruit.entity.IfPage;
import com.fruit.entity.Page;
import com.fruit.entity.product.ProductEntity;
import com.fruit.entity.product.ProductSalesEntity;
import com.fruit.entity.sys.User;
import com.fruit.service.product.ProductSalesService;
import com.fruit.service.product.ProductService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品销售模式
 * Created by zcf on 2017/7/1.
 */
@RequestMapping("/back/productSales")
@Controller
public class ProductSalesController {
    private Logger logger = LoggerFactory.getLogger(ProductSalesController.class);
    @Autowired
    private ProductSalesService productSalesService;
    @Autowired
    private ProductService productService;
    @RequestMapping("/list")
    public String productList(Model model,
                              @RequestParam(value = "productId", required = false, defaultValue = "0") int productId,
                              @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo){
        logger.info("ProductSalesController productSalesList check list information");
        //分页
        Page page = new Page();
        page.setCurrentPage(pageNo);

        User user = UserUtils.getUser();

        IfPage<ProductSalesEntity> ifPageProList = productSalesService.getProSalesList(page,user,productId);
        //查询本商家产品
        List<ProductEntity> proList = productService.findAllProduct(user);
        model.addAttribute("productList",proList);
        model.addAttribute("productSalesList",ifPageProList);
        model.addAttribute("productId",productId);
        model.addAttribute("url","/back/productSales/list?");
        return "productSales/list";
    }

    @RequestMapping("/add")
    public String add(Model model){
        User user = UserUtils.getUser();
        //查询本商家产品
        List<ProductEntity> proList = productService.findAllProduct(user);
        model.addAttribute("productList",proList);
        return "productSales/add";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Model model,ProductSalesEntity productSales){
        try {
            productSalesService.save(productSales);
            return "redirect:/back/productSales/list";
        }catch (Exception e){
            model.addAttribute("productSales",productSales);
            logger.info("ProductSalesController updateOrAdd Exception: "+e.getMessage());
            e.printStackTrace();
            return "productSales/add";
        }
    }

    @RequestMapping("/edit")
    public String edit(Model model,@RequestParam("proSalesId") int proSalesId){
        ProductSalesEntity productSales = productSalesService.findById(proSalesId);
        User user = UserUtils.getUser();
        //查询本商家产品
        List<ProductEntity> proList = productService.findAllProduct(user);
        model.addAttribute("productList",proList);
        model.addAttribute("productSales",productSales);

        return "productSales/edit";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public @ResponseBody
    boolean delete(@RequestParam("ids") String ids){
        logger.info("ProductSalesController delete productSales information！");
        boolean flag = false;
        try {
            productSalesService.delete(ids);
            flag = true;
            logger.info("ProductSalesController delete productSales information success！");
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "产品销售信息删除成功");
        }catch (Exception e){
            e.printStackTrace();
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "产品销售信息删除失败");
            logger.error("ProductSalesController delete productSales information Exception:"+e.getMessage());
        }
        return flag;
    }

    /**
     * 根据产品ID查询产品信息
     * @return 返回值
     */
    @RequestMapping("/checkProSales")
    public @ResponseBody
    Map<String,Object> checkUsername(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map=new HashMap<String,Object>();
        String productId = request.getParameter("param");
        ProductSalesEntity productSales = productSalesService.findByProId(Integer.parseInt(productId));
        if(productSales == null){
            map.put("status", "y");
            map.put("info", "此产品无销售信息！");
        }else{
            map.put("status", "n");
            map.put("info","此产品已有销售信息！" );
        }
        return map;
    }
}
