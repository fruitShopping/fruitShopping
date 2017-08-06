package com.fruit.dao.sys;

import com.fruit.common.annotation.MyBatisDao;
import com.fruit.common.base.BaseDao;
import com.fruit.entity.sys.Resource;
import com.fruit.entity.sys.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by zyming 20170806
 */
@MyBatisDao
@Repository
public interface ResourceDao extends BaseDao<Resource> {
    public Role findResourceById(@Param("id") Integer resourceId);
    public List<Map<String,String>> findRolesByUserId(@Param("userId") Integer userId);
}
