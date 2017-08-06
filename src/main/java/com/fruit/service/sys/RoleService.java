package com.fruit.service.sys;

import com.fruit.dao.sys.RelationShipDao;
import com.fruit.dao.sys.RoleDao;
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
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RelationShipDao relationShipDao;


    public Role findById(Integer roleId){
        return roleDao.findById(roleId);
    }
    public List<Role> queryAll(){
        return roleDao.queryAll();
    }
    //根据用户Id查询角色
    public Set<String> findRoleNameByUserId(Integer userId) {
        List<Map<String,String>> roles = roleDao.findRoleNameByUserId(userId);
        Set<String> roleNames = new HashSet<String>();
        for(Map<String,String> item : roles) {

            if(item != null) {
                roleNames.add(item.get("name"));
            }
        }
        return roleNames;
    }
    //根据用户Id查询角色
    public List<Role> findRolesByUserId(Integer userId) {
        return roleDao.findRolesByUserId(userId);
    }
    public void deleteByIds(String ids){
        roleDao.deleteByIds(ids);
    }
    /**
     * 添加角色
     * @param role
     */
    public void insert(Role role){
        roleDao.insert(role);
    }

    /**
     * 角色信息更新
     * @param role
     */
    public void update(Role role){
        roleDao.update(role);
    }

}
