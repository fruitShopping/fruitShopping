package com.fruit.entity.sys;

import java.io.Serializable;

/**
 * Created by zyming 2017/08/03
 * t_sys_role_resource
 */
public class RoleResource implements Serializable {

    private static final long serialVersionUID = -9183507878857561147L;
    private Integer id;
    private Integer roleId;
    private Integer resourceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "RoleResource{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", resourceId=" + resourceId +
                '}';
    }
}
