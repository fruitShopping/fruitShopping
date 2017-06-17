package com.zcf.fruit.entity.user;

import com.zcf.fruit.common.base.BaseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjj-ideapad on 2015/3/26.
 */
public class Role extends BaseEntity{
    private static final long serialVersionUID = -8409287519824777806L;
    private Long id;
    private String role_name;
    private String description;
//    private String authority_ids;
    private List<Integer> authority_ids;

    public Role() {
    }

    public Role(String role_name, String description) {
        this.role_name = role_name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", description='" + description + '\'' +
                ", authorityIds=" + authority_ids +
                '}';
    }
}
