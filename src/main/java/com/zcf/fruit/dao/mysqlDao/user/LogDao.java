/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.zcf.fruit.dao.mysqlDao.user;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.common.base.BaseDao;
import com.zcf.fruit.entity.user.Log;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * 日志DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
@Repository
public interface LogDao extends BaseDao<Log> {

}
