package com.zcf.fruit.service.authuser;

import com.zcf.fruit.dao.mysqlDao.user.UserDao;
import com.zcf.fruit.entity.user.User;
import com.zcf.fruit.service.sys.RoleService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 用户服务类
 * Created by zjj-ideapad on 2015/3/26.
 */
@Service
public class AuthUserService {
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

    public String findByRoleIds(String username) {
        return userDao.findByRoleIds(username);
    }

    public Set<String> findPermissions(String username) {
        String RoleIds =findByRoleIds(username);
        if(RoleIds.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        String[] idsStr = RoleIds.split(",");
        List<Integer> idsList = new ArrayList<Integer>();
        for(int i=0 ; i<idsStr.length;i++){
            idsList.add(Integer.parseInt(idsStr[i]));
        }
        return authorityService.findPermissions(idsList);
    }

    @Inject
    private UserDao userDao;
    @Inject
    private RoleService roleService;

    @Inject
    private AuthorityService authorityService;
}
