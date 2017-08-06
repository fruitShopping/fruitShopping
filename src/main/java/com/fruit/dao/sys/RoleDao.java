package com.fruit.dao.sys;

import com.fruit.common.annotation.MyBatisDao;
import com.fruit.common.base.BaseDao;
import com.fruit.entity.sys.Role;
import com.fruit.entity.sys.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 角色DAO层
 * Created by zyming 20170806
 */
@MyBatisDao
@Repository
public interface RoleDao extends BaseDao<Role> {
    public List<Role> queryAll();
    public List<Map<String,String>> findRoleNameByUserId(@Param("userId") Integer userId);
    public List<Role> findRolesByUserId(@Param("userId") Integer userId);
    public void deleteByIds(@Param("ids") String ids);

}
