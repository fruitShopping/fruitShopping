package com.zcf.fruit.dao.mysqlDao.business;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.common.base.BaseDao;
import com.zcf.fruit.entity.business.BusinessEntity;
import org.springframework.stereotype.Repository;

/**
 * 商家信息
 * Created by zcf on 2017/6/25.
 */
@MyBatisDao
@Repository
public interface BusinessDao extends BaseDao<BusinessEntity> {

}
