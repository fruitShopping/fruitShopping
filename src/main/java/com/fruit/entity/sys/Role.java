package com.fruit.entity.sys;

import com.fruit.common.base.BaseEntity;
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
    private String name;
    private String nameZh;

    public int getId() {
        return id;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
    public String getNameZh() {
        return nameZh;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameZh=" + nameZh +
                '}';
    }
}
