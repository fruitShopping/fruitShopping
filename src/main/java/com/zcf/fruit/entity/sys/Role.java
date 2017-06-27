package com.zcf.fruit.entity.sys;

import com.zcf.fruit.common.base.BaseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjj-ideapad on 2015/3/26.
 */
public class Role extends BaseEntity implements Serializable{
    private static final long serialVersionUID = -8409287519824777806L;
    private int id;
    private String roleName;
    private String description;
//    private String authorityIdsStr;
    private List<Integer> authority_ids;

    public Role() {
    }

    public Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getAuthority_ids() {
        if(authority_ids == null) {
            authority_ids = new ArrayList<Integer>();
        }

        return authority_ids;
    }

    public void setAuthority_ids(List<Integer> authority_ids) {
        this.authority_ids = authority_ids;
    }

    public String getAuthorityIdsStr() {
        if(CollectionUtils.isEmpty(authority_ids)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(int authorityId : authority_ids) {
            s.append(authorityId);
            s.append(",");
        }
        return s.toString();
    }

    public void setAuthorityIdsStr(String authorityIdsStr) {
        if(StringUtils.isEmpty(authorityIdsStr)) {
            return;
        }
        String[] authorityIdsStrs = authorityIdsStr.split(",");
        for(String authorityIdStr : authorityIdsStrs) {
            if(StringUtils.isEmpty(authorityIdStr)) {
                continue;
            }
            getAuthority_ids().add(Integer.valueOf(authorityIdStr));
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Role role = (Role) o;
//
//        if (id != null ? !id.equals(role.id) : role.id != null) return false;
//
//        return true;
//    }

//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", authorityIds=" + authority_ids +
                '}';
    }
}
