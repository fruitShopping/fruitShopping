package com.zcf.fruit.service.authuser;

import com.zcf.fruit.dao.mysqlDao.sys.UserDao;
import com.zcf.fruit.entity.sys.User;
import com.zcf.fruit.service.sys.RoleService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

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

    public List<Map<String,String>> findByRoleIds(String username) {
        return userDao.findByRoleIds(username);
    }

    public Set<String> findPermissions(String username) {
        List<Map<String,String>> roleIds =findByRoleIds(username);
        if(roleIds.size() == 0) {
            return Collections.EMPTY_SET;
        }
        //Arrays.asList(arr).contains(targetValue)
        List<Integer> idsList = new ArrayList<Integer>();
        for(Map roleIdMap : roleIds){
            String roleIdStr = roleIdMap.get("authority_ids").toString();
            String[] arr = roleIdStr.split(",");
            for(String a : arr){
                if(!idsList.contains(Integer.parseInt(a))){
                    idsList.add(Integer.parseInt(a));
                }
            }
        }
//        List<Integer> idsList = new ArrayList<Integer>();
//        for(int i=0 ; i<idsStr.length;i++){
//            idsList.add(Integer.parseInt(idsStr[i]));
//        }
        return authorityService.findPermissions(idsList);
    }

    @Inject
    private UserDao userDao;
    @Inject
    private RoleService roleService;

    @Inject
    private AuthorityService authorityService;
}
