package com.zcf.fruit.service.product;

import com.zcf.fruit.common.utils.Servlets;
import com.zcf.fruit.dao.mysqlDao.product.ProductSalesDao;
import com.zcf.fruit.entity.IfPage;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.business.BusinessEntity;
import com.zcf.fruit.entity.product.ProductEntity;
import com.zcf.fruit.entity.product.ProductSalesEntity;
import com.zcf.fruit.entity.sys.User;
import com.zcf.fruit.service.business.BusinessService;
import com.zcf.fruit.util.LogUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * 商品销售模式
 * Created by zcf on 2017/7/1.
 */
@Service
public class ProductSalesService {
    public IfPage<ProductSalesEntity> getProSalesList(Page page, User user, int productId){
        IfPage<ProductSalesEntity> proSalesIfPage = new IfPage<ProductSalesEntity>();
        proSalesIfPage.setPageNum(page.getCurrentPage());
        if(page.getCurrentPage() == 1){
            page.setBegin(0);
        }
        //判断是否是管理员
        boolean isAdmin = user.isAdmin(user.getId());
        long userId = user.getId();
        List<ProductSalesEntity> productList = productSalesDao.findList(page, userId,productId,isAdmin);
        proSalesIfPage.setDates(productList);

        //数据总数
        int total = productSalesDao.listTotal(userId,productId,isAdmin);
        int totalPage = total/page.getSize();
        totalPage += total%page.getSize() > 0 ? 1:0;
        proSalesIfPage.setPageTotal(totalPage);
        return  proSalesIfPage;

    }

    public void save(ProductSalesEntity productSales){
        int id = productSales.getId();
        if(id == 0){
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "产品销售信息新增");
            productSalesDao.insert(productSales);
        }else{
            // 记录登录日志
            LogUtils.saveLog(Servlets.getRequest(), "产品销售信息更新");
            productSalesDao.update(productSales);
        }
    }

    public void delete(String proSalesIds){
        String[] proSalesIdArr = proSalesIds.split(",");
        for(String proSalesId : proSalesIdArr){
            //字典信息删除
            productSalesDao.delete(Integer.parseInt(proSalesId));
        }
    }

    /**
     * 根据产品销售数据ID查询
     * @param proSalesId
     * @return
     */
    public ProductSalesEntity findById(int proSalesId){
        return productSalesDao.findById(proSalesId);
    }

    /**
     * 根据产品ID查询产品销售信息
     * @param proId 产品ID
     * @return 返回值
     */
    public ProductSalesEntity findByProId(int proId){
        return productSalesDao.findByProId(proId);
    }

    @Inject
    private ProductSalesDao productSalesDao;
}
