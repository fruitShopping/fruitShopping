package com.zcf.fruit.dao.mysqlDao.sys;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.common.base.BaseDao;
import com.zcf.fruit.entity.sys.Role;
import com.zcf.fruit.entity.sys.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色JDBC层
 * Created by zjj-ideapad on 2015/3/26.
 */
@MyBatisDao
@Repository
public interface RoleDao extends BaseDao<Role> {

    public Role findOneByName(@Param("roleName") String roleName);

    public int findUserRoleId(@Param("userId") Long userId);

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
