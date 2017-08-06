package com.fruit.dao.menu;

import com.fruit.common.annotation.MyBatisDao;
import com.fruit.common.base.BaseDao;
import com.fruit.entity.Page;
import com.fruit.entity.dat.Menu;
import org.apache.ibatis.annotations.*;
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

    public List<Map<Object,Object>> getMenuTree(@Param("roleId") int roleId);

    public List<Menu> findAllList(@Param("username") String username);
}
