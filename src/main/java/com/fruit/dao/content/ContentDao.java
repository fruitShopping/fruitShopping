package com.fruit.dao.content;

import com.fruit.common.annotation.MyBatisDao;
import com.fruit.common.base.BaseDao;
import com.fruit.entity.content.ContentImgEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商城内容
 * Created by zcf on 2017/6/25.
 */
@MyBatisDao
@Repository
public interface ContentDao extends BaseDao<ContentImgEntity> {

    /**
     * 商家信息图片查询
     * @param contentId 商家ID
     * @return 返回值
     */
    public List<ContentImgEntity> getBusImg(@Param("contentId") int contentId);
}
