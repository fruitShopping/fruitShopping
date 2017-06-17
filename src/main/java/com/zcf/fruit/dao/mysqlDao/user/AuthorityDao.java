package com.zcf.fruit.dao.mysqlDao.user;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.entity.user.Authority;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zjj-ideapad on 2015/1/7.
 */
@MyBatisDao
@Repository
public interface AuthorityDao {

    public Authority findOne(@Param("authorityId") int authorityId);
}
