package com.zcf.fruit.dao.mysqlDao.user;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.common.base.BaseDao;
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
public interface MenuDao extends BaseDao<Menu> {

    public List<Menu> findList(Page page);

    public Menu get(@Param("id") int id);

    public int getMenuTotal();

    public int updateParentIds(Menu menu);

    public List<Menu> findByParentIdsLike(Menu menu);

    @Select("SELECT m.id,m.menu_name AS name,m.parent_id AS pId," +
            " CASE (SELECT count(*) from sys_role_menu WHERE role_id = #{roleId} AND menu_id = m.id)" +
            " WHEN 1 THEN 'true' else 'false' end AS checked FROM sys_menu m")
    public List<Map<Object,Object>> menuTree(@Param("roleId") int roleId);

    public List<Menu> findAllList(@Param("username") String username);
}
