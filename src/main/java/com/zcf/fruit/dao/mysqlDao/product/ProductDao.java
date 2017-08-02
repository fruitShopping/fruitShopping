package com.zcf.fruit.dao.mysqlDao.product;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.common.base.BaseDao;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.product.ProductEntity;
import com.zcf.fruit.entity.sys.User;
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
