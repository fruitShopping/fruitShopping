package com.fruit.entity.sys;

import com.fruit.common.base.BaseEntity;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zcf on 2016/9/28.
 */
public class Menu extends BaseEntity implements Serializable{
    private static final long serialVersionUID = -4009326068598796239L;
    private int id;
    private Menu parent;	// 父级菜单
    private String name;//菜单名称
    private int sort;      //菜单级别
    private String href; //请求路径
    private String icon;//菜单图标
    private String isShow;//是否在菜单中显示 0展示 1不展示
    private int parentId;     //父节点ID
    private String parentIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @JsonIgnore
    public static String getRootId(){
        return "1";
    }

    @JsonIgnore
    public static void sortList(List<Menu> list, List<Menu> sourcelist, int parentId, boolean cascade){
        for (int i=0; i<sourcelist.size(); i++){
            Menu e = sourcelist.get(i);
            if (e.getParent()!=null && e.getParent().getId()!=0
                    && e.getParent().getId() == parentId){
                list.add(e);
                if (cascade){
                    // 判断是否还有子节点, 有则继续获取子节点
                    for (int j=0; j<sourcelist.size(); j++){
                        Menu child = sourcelist.get(j);
                        if (child.getParent()!=null && child.getParent().getId()!=0
                                && child.getParent().getId()==e.getId()){
                            sortList(list, sourcelist, e.getId(), true);
                            break;
                        }
                    }
                }
            }
        }
    }
}
