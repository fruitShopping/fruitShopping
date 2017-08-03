package com.fruit.dao.product;

import com.fruit.common.annotation.MyBatisDao;
import com.fruit.common.base.BaseDao;
import com.fruit.entity.Page;
import com.fruit.entity.product.ProductSalesEntity;
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
