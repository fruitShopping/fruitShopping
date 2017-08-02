package com.zcf.fruit.dao.mysqlDao.product;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.common.base.BaseDao;
import com.zcf.fruit.entity.product.CategoryEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品品种
 * Created by zcf on 2017/6/28.
 */
@MyBatisDao
@Repository
public interface CategoryDao extends BaseDao<CategoryEntity> {

    public List<CategoryEntity> findCateByCode(@Param("typeId") int typeId);
}
