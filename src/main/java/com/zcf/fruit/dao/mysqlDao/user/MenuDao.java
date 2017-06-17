package com.zcf.fruit.dao.mysqlDao.user;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.entity.Page;
import com.zcf.fruit.entity.user.Menu;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 菜单JDBC类
 * Created by zcf on 2016/9/28.
 */
@MyBatisDao
@Repository
public interface MenuDao {

    public List<Menu> findList(Page page);

    @Select("SELECT * FROM sys_menu WHERE parent_id = 0")
    public List<Menu> findParentMenu();

    @Insert("INSERT INTO sys_menu (menu_name,level,menu_class,request_url,parent_id) " +
            "VALUES (#{menu_name},#{level},#{menu_class},#{request_url},#{parent_id})")
    public void insertMenu(Menu MenuEntity);

    @Select("SELECT * FROM sys_menu WHERE id = #{menuId}")
    public Menu selectById(@Param("menuId") int menuId);

    @Update("UPDATE sys_menu SET menu_name=#{menu_name},menu_class=#{menu_class},request_url=#{request_url}," +
            "parent_id=#{parent_id} WHERE id = #{id}")
    public void updateById(Menu menuEntity);

    @Delete("DELETE FROM sys_menu WHERE id=#{menuId}")
    public void deleteById(@Param("menuId") int menuId);

    public int getMenuTotal();

    @Select("SELECT m.id,m.menu_name AS name,m.parent_id AS pId," +
            " CASE (SELECT count(*) from sys_role_menu WHERE role_id = #{roleId} AND menu_id = m.id)" +
            " WHEN 1 THEN 'true' else 'false' end AS checked FROM sys_menu m")
    public List<Map<Object,Object>> menuTree(@Param("roleId") int roleId);

    @Update("DELETE FROM sys_role_menu WHERE role_id = #{roleId} AND menu_id = #{menuId}")
    public void deleteRoleMenu(@Param("roleId") int roleId,
                               @Param("menuId") int menuId);

    @Insert("INSERT INTO sys_role_menu (role_id,menu_id) VALUES (#{roleId},#{menuId})")
    public void insertRoleMenu(@Param("roleId") int roleId,
                               @Param("menuId") int menuId);

    @Update("DELETE FROM sys_role_menu WHERE role_id = #{roleId}")
    public void delByRoleId(@Param("roleId") int roleId);

//    @Select("SELECT m.* FROM sys_menu m" +
//            " LEFT JOIN sys_role_menu rm ON m.id=rm.menu_id" +
//            " LEFT JOIN sys_role r ON r.id = rm.role_id" +
//            " LEFT JOIN sys_user_role ur ON ur.role_id = r.id" +
//            " LEFT JOIN sys_user u ON u.id = ur.user_id" +
//            " WHERE u.username = #{username} order by id ASC")
    public List<Menu> findAllList(@Param("username") String username);
}
