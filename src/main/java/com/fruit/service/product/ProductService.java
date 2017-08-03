package com.fruit.service.product;

import com.fruit.common.file.FileUpload;
import com.fruit.common.utils.Servlets;
import com.fruit.dao.product.ProductDao;
import com.fruit.entity.IfPage;
import com.fruit.entity.Page;
import com.fruit.entity.product.ProductEntity;
import com.fruit.entity.sys.User;
import com.fruit.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 产品服务类
 * Created by zcf on 2017/6/27.
 */
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * 产品分页查询
     * @param page 分页
     * @param isPromotion 用户名
     * @param isSeason 手机号码
     * @return 返回值
     */
    public IfPage<ProductEntity> getProductList(Page page, User user,int delFlag, int isPromotion,int isSeason){
        IfPage<ProductEntity> proListIfPage = new IfPage<ProductEntity>();
        proListIfPage.setPageNum(page.getCurrentPage());
        if(page.getCurrentPage() == 1){
            page.setBegin(0);
        }
        //判断是否是管理员
        boolean isAdmin = user.isAdmin(user.getId());
        List<ProductEntity> productList = productDao.getProductList(page,user,delFlag,isPromotion,isSeason,isAdmin);
        proListIfPage.setDates(productList);

        //数据总数
        int total = productDao.productListTotal(user,delFlag,isPromotion,isSeason,isAdmin);
        int totalPage = total/page.getSize();
        totalPage += total%page.getSize() > 0 ? 1:0;
        proListIfPage.setPageTotal(totalPage);
        return  proListIfPage;

    }

    public ProductEntity findById(int productId){
        return productDao.findById(productId);
    }
    public void save(ProductEntity product,HttpServletRequest request){
        //更新产品信息
        int productId = product.getId();
        if(productId == 0){
            //新增
            productDao.insert(product);
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "商品信息新增");
        }else{
            //更新
            //删除旧图片
            String productImgs = product.getOldProductImg();
            String[] productImgArr = productImgs.split(",");
//            if(!productImgs.equals(product.getProductImg())){
                for(String imgPath : productImgArr){
                    // 文件删除
                    FileUpload.fileDelete(request,imgPath);
                }
//            }

            String detailImgs = product.getOldDetailImg();
            String[] detailImgArr = detailImgs.split(",");
//            if(!detailImgs.equals(product.getDetailImg())){
                for(String imgPath2 : detailImgArr){
                    // 文件删除
                    FileUpload.fileDelete(request,imgPath2);
                }
//            }

            productDao.update(product);
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "商品信息更新");
        }
    }

    public void delete(String productIds){
        String idss= productIds.substring(0,productIds.length()-1);
        String[] idsArr = idss.split(",");
        for(String id : idsArr){
            productDao.delete(Integer.parseInt(id));
        }
    }

    public List<ProductEntity> findAllProduct(User user){
        //判断是否是管理员
        boolean isAdmin = user.isAdmin(user.getId());
        return productDao.findAllProduct(user,isAdmin);
    }

}
