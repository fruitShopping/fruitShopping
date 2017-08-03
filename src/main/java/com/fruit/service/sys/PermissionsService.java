package com.fruit.service.sys;

import com.fruit.dao.sys.UserDao;
import com.fruit.entity.sys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

/**
 * 用户服务类
 */
@Service
public class PermissionsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public Set<String> findRoles(String username) {
        User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findRoles(user.getId());
    }

    public List<Map<String,String>> findByRoleIds(String username) {
        return userDao.findByRoleIds(username);
    }

    public Set<String> findPermissions(String username) {
        List<Map<String,String>> roleIds =userDao.findByRoleIds(username);
        if(roleIds.size() == 0) {
            return Collections.EMPTY_SET;
        }
        List<Integer> idsList = new ArrayList<Integer>();
        for(Map item : roleIds){
            String roleIdStr = item.get("role_id").toString();
            String[] arr = roleIdStr.split(",");
            for(String a : arr){
                if(!idsList.contains(Integer.parseInt(a))){
                    idsList.add(Integer.parseInt(a));
                }
            }
        }
        return authorityService.findPermissions(idsList);
    }
}
