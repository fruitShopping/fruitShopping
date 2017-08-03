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
 * 角色JDBC层
 * Created by zjj-ideapad on 2015/3/26.
 */
@MyBatisDao
@Repository
public interface RoleDao extends BaseDao<Role> {

    public Role findOneByName(@Param("roleName") String roleName);

    public List<Map<String,Integer>> findUserRoleId(@Param("userId") Long userId);

    public Role findOne(@Param("id") int roleId);

    public List<Role> findListByUser(@Param("user") User user);

    public void insertRoleAndUser(@Param("userId") long userId,
                                  @Param("roleId") int roleId);

    public void deleteUserAndRole(@Param("userId") long userId);

    public void delRoleAndMenu(@Param("roleId") int roleId);

    public void addRoleAndMenu(@Param("menuId") int menuId,
                               @Param("roleId") int roleId);

    public void delOneRoleAndMenu(@Param("menuId") int menuId,
                                  @Param("roleId") int roleId);
}
