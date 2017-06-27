package com.zcf.fruit.entity.business;

import com.zcf.fruit.entity.content.ContentImgEntity;
import com.zcf.fruit.entity.sys.User;

import java.util.List;

/**
 * 商家信息
 * Created by zcf on 2017/6/25.
 */
public class BusinessEntity{
    private int id;
    private User user;
    private int type; //商户类型(0个人 1企业)
    private String address;//商家地址
    private int isCheck;
    private String merchantName;//商户名称
    private List<ContentImgEntity> imgList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public List<ContentImgEntity> getImgList() {
        return imgList;
    }

    public void setImgList(List<ContentImgEntity> imgList) {
        this.imgList = imgList;
    }
}
