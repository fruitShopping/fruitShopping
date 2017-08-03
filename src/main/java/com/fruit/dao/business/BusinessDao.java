package com.fruit.dao.business;

import com.fruit.common.annotation.MyBatisDao;
import com.fruit.common.base.BaseDao;
import com.fruit.entity.business.BusinessEntity;
import org.springframework.stereotype.Repository;

/**
 * 商家信息
 * Created by zcf on 2017/6/25.
 */
@MyBatisDao
@Repository
public interface BusinessDao extends BaseDao<BusinessEntity> {

}
