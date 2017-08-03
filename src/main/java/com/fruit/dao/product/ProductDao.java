package com.fruit.dao.product;

import com.fruit.common.annotation.MyBatisDao;
import com.fruit.common.base.BaseDao;
import com.fruit.entity.Page;
import com.fruit.entity.product.ProductEntity;
import com.fruit.entity.sys.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zcf on 2017/6/27.
 */
@MyBatisDao
@Repository
public interface ProductDao extends BaseDao<ProductEntity> {

    public List<ProductEntity> getProductList(@Param("page") Page page,
                                              @Param("user") User user,
                                              @Param("delFlag") int delFlag,
                                              @Param("isPromotion") int isPromotion,
                                              @Param("isSeason") int isSeason,
                                              @Param("isAdmin") boolean isAdmin);

    public int productListTotal(@Param("user") User user,
                                @Param("delFlag") int delFlag,
                                @Param("isPromotion") int isPromotion,
                                @Param("isSeason") int isSeason,
                                @Param("isAdmin") boolean isAdmin);

    public List<ProductEntity> findAllProduct(@Param("user") User user,
                                              @Param("isAdmin") boolean isAdmin);
}
