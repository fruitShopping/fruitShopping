package com.fruit.entity.sys;

import java.io.Serializable;

/**
 * Created by zyming 2017/08/03
 * t_sys_resource
 */
public class Resource implements Serializable {

    private static final long serialVersionUID = 0L;
    private Integer id;
    private String name;
    private String permission;
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permission='" + permission + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
