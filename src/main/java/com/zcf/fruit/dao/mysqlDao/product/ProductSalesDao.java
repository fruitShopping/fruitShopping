package com.zcf.fruit.dao.mysqlDao.product;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.common.base.BaseDao;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.product.ProductSalesEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品销售
 * Created by zcf on 2017/7/1.
 */
@MyBatisDao
@Repository
public interface ProductSalesDao extends BaseDao<ProductSalesEntity> {

    public List<ProductSalesEntity> findList(@Param("page")Page page,
                                             @Param("userId") long userId,
                                             @Param("productId") int productId,
                                             @Param("isAdmin") boolean isAdmin);

    public int listTotal(@Param("userId") long userId,
                         @Param("productId") int productId,
                         @Param("isAdmin") boolean isAdmin);

    public ProductSalesEntity findByProId(@Param("productId") int productId);
}
