package com.fruit.dao.sys;

import com.fruit.common.annotation.MyBatisDao;
import com.fruit.entity.sys.Authority;
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
