package com.zcf.fruit.service.sys;

import com.zcf.fruit.dao.mysqlDao.sys.RoleDao;
import com.zcf.fruit.entity.sys.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zjj-ideapad on 2015/3/26.
 */
@Service
@Transactional
public class RoleService {
    public Role findOneByName(String roleName) {
        return roleDao.findOneByName(roleName);
    }

    public Role findOne(int roleId) {
        return roleDao.findOne(roleId);
    }

    public Set<String> findRoles(Long userId) {
        List<Map<String,Integer>> roleIds = roleDao.findUserRoleId(userId);
        Set<String> roles = new HashSet<String>();
        for(Map roleIdMap : roleIds) {
            Role role = findOne((Integer) roleIdMap.get("role_id"));
            if(role != null) {
                roles.add(role.getRoleName());
            }
        }
        return roles;
    }

    /**
     * 查询角色列表
     * @return
     */
    public List<Role> findAllList(){
        return roleDao.findAllList();
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

    /**
     * 删除角色
     * @param roleIds
     */
    public void delete(String roleIds){
        String[] roleIdArr = roleIds.split(",");
        for(String roleId : roleIdArr){
            //角色删除
            roleDao.delete(Integer.parseInt(roleId));
            //删除角色所属权限
            roleDao.delRoleAndMenu(Integer.parseInt(roleId));
        }
    }

    /**
     * 更新角色权限
     * @param roleId 角色ID
     * @param selectIds  已有的权限
     * @param changeIds 变化的权限
     */
    public void roleAndMenu(int roleId,String selectIds ,String changeIds){
        String[] changeArr = changeIds.split(",");
        for (int i=0;i<changeArr.length;i++){
            String menuId = changeArr[i];
            int index = selectIds.indexOf(menuId);
            if(index == -1){
                //权限不存在，新增权限
                roleDao.addRoleAndMenu(Integer.parseInt(menuId),roleId);
            }else{
                //权限存在，删除
                roleDao.delOneRoleAndMenu(Integer.parseInt(menuId),roleId);
            }
        }
    }

    @Inject
    private RoleDao roleDao;
}
