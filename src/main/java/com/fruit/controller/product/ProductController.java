package com.fruit.controller.product;

import com.fruit.common.file.FileUpload;
import com.fruit.common.utils.Servlets;
import com.fruit.entity.IfPage;
import com.fruit.entity.Page;
import com.fruit.entity.business.BusinessEntity;
import com.fruit.entity.product.ProductEntity;
import com.fruit.entity.dat.DictEntity;
import com.fruit.entity.sys.User;
import com.fruit.service.business.BusinessService;
import com.fruit.service.product.ProductService;
import com.fruit.service.dat.DictService;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品管理
 * Created by zcf on 2017/6/27.
 */
@Controller
@RequestMapping("/back/product")
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;
    @Autowired
    private DictService dictService;
    @Autowired
    private BusinessService businessService;

    @RequestMapping("/list")
    public String productList(Model model,
                              @RequestParam(value = "delFlag", required = false, defaultValue = "0") int delFlag,
                              @RequestParam(value = "isPromotion", required = false, defaultValue = "2") int isPromotion,
                              @RequestParam(value = "isSeason", required = false, defaultValue = "2") int isSeason,
                              @RequestParam(value = "pageNo", required = false, defaultValue = "1") int pageNo){
        logger.info("ProductController productList check list information");
        //分页
        Page page = new Page();
        page.setCurrentPage(pageNo);

        User user = UserUtils.getUser();

        IfPage<ProductEntity> ifPageProList = productService.getProductList(page,user,delFlag,isPromotion,isSeason);
        model.addAttribute("productList",ifPageProList);
        model.addAttribute("url","/back/product/list?");
        return "product/list";
    }

    @RequestMapping("/add")
    public String add(Model model){
        //查询水果类别
        List<DictEntity> dictList = dictService.findByCode("category");
        model.addAttribute("dictList",dictList);
        return "product/add";
    }

    @RequestMapping("/edit")
    private String edit(Model model,@RequestParam("productId") int productId){
        //查询产品
        ProductEntity product = productService.findById(productId);
        String productImg = product.getProductImg();
        String detailImg = product.getDetailImg();
        List<String> productImgList = new ArrayList<>();
        List<String> detailImgList = new ArrayList<>();
        if(productImg != null && productImg.length()>0){
            String[] productImgArr = productImg.split(",");
            for(String imgStr : productImgArr){
                productImgList.add(imgStr);
            }
        }
        if(detailImg != null && detailImg.length()>0){
            String[] detailImgArr = detailImg.split(",");
            for(String imgStr : detailImgArr){
                detailImgList.add(imgStr);
            }
        }
        //查询水果类别
        List<DictEntity> dictList = dictService.findByCode("category");
        model.addAttribute("dictList",dictList);
        model.addAttribute("product",product);
        model.addAttribute("productImgList",productImgList);
        model.addAttribute("detailImgList",detailImgList);
        return "product/edit";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(HttpServletRequest request, ProductEntity product){
        logger.info("ProductController save product information updateOrInsert!");
        try {
            User user = UserUtils.getUser();
            // 文件上传
            String[] pathStr = FileUpload.productUpload(request,"static/content/images/"+user.getId()+"/");
            BusinessEntity business = businessService.getInfo(user.getId());
            product.setBusinessmenId(business.getId());
            //处理产品详情图片路径
            String oldDetailUrls = product.getOldDetailImg();
            String detailUrls = product.getDetailImg();
            if(detailUrls != null && !detailUrls.equals("")){
                String[] detailUrlArr = detailUrls.split(",");
                String delDetailUrls = "";
                for(String imgPath : detailUrlArr){
                    if(oldDetailUrls.indexOf(imgPath) != -1){
                        //包含
                    }else{
                        //不包含
                        delDetailUrls = delDetailUrls + imgPath + ",";
                    }
                }
                if(delDetailUrls.equals("")){
                    product.setOldDetailImg("");
                }else{
                    delDetailUrls = delDetailUrls.substring(0,delDetailUrls.length()-1);
                    product.setOldDetailImg(delDetailUrls);
                }
            }

            //处理产品图片路径
            String oldProductUrls = product.getOldProductImg();
            String productUrls = product.getProductImg();
            if(productUrls != null && !productUrls.equals("")){
                String[] productUrlArr = productUrls.split(",");
                String delProductUrls = "";
                for(String productImgUrl : productUrlArr){
                    if(oldProductUrls.indexOf(productImgUrl) != -1){
                        //包含
                    }else{
                        //不包含
                        delProductUrls = delProductUrls + productImgUrl + ",";
                    }
                }
                if(delProductUrls == null || delProductUrls.equals("")){
                    product.setOldProductImg("");
                }else{
                    delProductUrls = delProductUrls.substring(0,delProductUrls.length()-1);
                    product.setOldProductImg(delProductUrls);
                }
            }

            if(pathStr[0].equals("")){
                product.setProductImg(productUrls);
            }else{
                if(productUrls == null || productUrls.equals("")){
                    productUrls = pathStr[0];
                }else{
                    productUrls = productUrls + "," + pathStr[0];
                }

                product.setProductImg(productUrls);
            }
            if(pathStr[1].equals("")){
//                detailUrls = detailUrls.substring(0,detailUrls.length()-1);
                product.setDetailImg(detailUrls);
            }else{
                if(detailUrls == null || detailUrls.equals("")){
                    detailUrls = pathStr[1];
                }else{
                    detailUrls = detailUrls + "," + pathStr[1];
                }
                product.setDetailImg(detailUrls);
            }

            productService.save(product,request);
            logger.info("ProductController save product information edit success!");

            return "redirect:/back/product/list";
        }catch (IOException e){
            e.printStackTrace();
            logger.info("ProductController save product information edit fail!");
            logger.error("ProductController save product information Exception:"+e.getMessage());
            return "redirect:/back/product/add";
        }

    }


    @RequestMapping("/view")
    public String view(Model model,@RequestParam("productId") int productId){
        //查询产品
        ProductEntity product = productService.findById(productId);
        String productImg = product.getProductImg();
        String detailImg = product.getDetailImg();
        List<String> productImgList = new ArrayList<>();
        List<String> detailImgList = new ArrayList<>();
        if(productImg.length()>0){
            String[] productImgArr = productImg.split(",");
            for(String imgStr : productImgArr){
                productImgList.add(imgStr);
            }
        }
        if(detailImg.length()>0){
            String[] detailImgArr = detailImg.split(",");
            for(String imgStr : detailImgArr){
                detailImgList.add(imgStr);
            }
        }
        //查询水果类别
        List<DictEntity> dictList = dictService.findByCode("category");
        model.addAttribute("dictList",dictList);
        model.addAttribute("product",product);
        model.addAttribute("productImgList",productImgList);
        model.addAttribute("detailImgList",detailImgList);
        return "product/view";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public @ResponseBody
    boolean delete(@RequestParam("ids") String ids){
        logger.info("ProductController delete product information！");
        boolean flag = false;
        try {
            productService.delete(ids);
            flag = true;
            logger.info("ProductController delete product information success！");
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "商品信息删除成功");
        }catch (Exception e){
            e.printStackTrace();
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "商品信息删除失败");
            logger.error("ProductController delete product information Exception:"+e.getMessage());
        }
        return flag;
    }

}
