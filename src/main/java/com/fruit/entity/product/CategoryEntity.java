package com.fruit.entity.product;

import java.util.Date;

/**
 * 产品品种
 * Created by zcf on 2017/6/28.
 */
public class CategoryEntity {
    private int id;
    private int typeId;//字典关联ID
    private String categoryName;//品种名称
    private int isShelves;//是否上架(0是 1否)
    private Date createTime;//添加时间
    private String breedName;//产品类别

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getIsShelves() {
        return isShelves;
    }

    public void setIsShelves(int isShelves) {
        this.isShelves = isShelves;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }
}
