package com.fruit.service.sys;

import com.fruit.dao.sys.RelationShipDao;
import com.fruit.dao.sys.ResourceDao;
import com.fruit.dao.sys.RoleDao;
import com.fruit.entity.sys.Resource;
import com.fruit.entity.sys.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zyming 20170806
 */
@Service
@Transactional
public class ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private RelationShipDao relationShipDao;
    

    /**
     * 添加资源
     * @param resource
     */
    public void insert(Resource resource){
        resourceDao.insert(resource);
    }

    /**
     * 资源信息更新
     * @param resource
     */
    public void update(Resource resource){
        resourceDao.update(resource);
    }

}
