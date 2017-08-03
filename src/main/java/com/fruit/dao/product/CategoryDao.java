package com.fruit.dao.product;

import com.fruit.common.annotation.MyBatisDao;
import com.fruit.common.base.BaseDao;
import com.fruit.entity.product.CategoryEntity;
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
