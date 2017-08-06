package com.fruit.dao.sys;

import com.fruit.common.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * Created by you on 17-8-6.
 * 关系维护dao,维护用户角色关系，角色资源关系，用户资源关系
 * 只负责增删改关系
 */
@MyBatisDao
@Repository
public interface RelationShipDao {
}
