package com.fruit.service.sys;

import com.fruit.dao.sys.UserDao;
import com.fruit.entity.sys.User;
import com.fruit.shiro.ShiroRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.*;

/**
 * 权限服务类
 */
@Service
@Transactional
public class PermsService {
    private static final Logger logger = LoggerFactory.getLogger(PermsService.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleService roleService;

    //根据用户名查询用户
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }
    //根据用户名查询用户角色
    public Set<String> findRoleNames(String username) {
        User user =userDao.findUserByName(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findRoleNameByUserId(user.getId());
    }
    //根据用户名查询用户权限
    public Set<String> findPermissions(String username) {
        User user =userDao.findUserByName(username);
        logger.debug(username+"user:"+user.toString());

        if(user == null) {
            return Collections.EMPTY_SET;
        }
        //根据用户id查用户的资源权限列表
        List<Map<String,String>> permissions =userDao.findPermsByUserId(user.getId());
        logger.debug("permissions.size():"+permissions.size());

        if(permissions.size() == 0) {
            return Collections.EMPTY_SET;
        }
        Set<String> permissionList = new HashSet<>();
        for(Map<String,String> item : permissions){
            String perm = item.get("permission");
            String url = item.get("url");
            permissionList.add(perm);
            permissionList.add(url);
        }
        return permissionList;
    }
}
