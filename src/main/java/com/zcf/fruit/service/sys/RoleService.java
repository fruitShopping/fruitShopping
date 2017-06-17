package com.zcf.fruit.service.sys;

import com.zcf.fruit.dao.mysqlDao.user.RoleDao;
import com.zcf.fruit.entity.user.Role;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zjj-ideapad on 2015/3/26.
 */
@Service
public class RoleService {
    public Role findOne(String roleName) {
        return roleDao.findOneByName(roleName);
    }

    public Role findOne(int roleId) {
        return roleDao.findOne(roleId);
    }

    public Set<String> findRoles(Long userId) {
        int roleId = roleDao.findUserRoleId(userId);
        Set<String> roles = new HashSet<String>();
//        for(int roleId : roleIds) {
        Role role = findOne(roleId);
        if(role != null) {
            roles.add(role.getRole_name());
        }
//        }
        return roles;
    }

    @Inject
    private RoleDao roleDao;
}
