package com.zcf.fruit.dao.mysqlDao.sys;

import com.zcf.fruit.common.annotation.MyBatisDao;
import com.zcf.fruit.common.base.BaseDao;
import com.zcf.fruit.entity.sys.DictEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典
 * Created by zcf on 2017/6/27.
 */
@MyBatisDao
@Repository
public interface DictDao extends BaseDao<DictEntity> {

    public DictEntity findById(@Param("dictId") int dictId);

    public List<DictEntity> findByCode(@Param("code") String code);
}
