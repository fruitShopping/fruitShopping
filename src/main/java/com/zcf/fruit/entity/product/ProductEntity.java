package com.zcf.fruit.entity.product;

import java.util.Date;

/**
 * 产品
 * Created by zcf on 2017/6/27.
 */
public class ProductEntity {
    private int id;
    private int businessmenId;//商家ID
    private String businessName;//商家名称
    private String productName;//水果名称
    private float originalPrice;//原价(优惠价为0时 原价作为单价)
    private float discountedPrice;//优惠价
    private int inStock;//库存
    private int sold;  //已售
    private String title;//标题
    private String description;//描述
    private String detailImg;//产品详情图
    private String oldDetailImg;
    private String oldProductImg;
    private String productImg;//产品图
    private int isPromotion;//是否促销(0否 1是)
    private int isSeason;//是否时令(0否 1是)
    private Date createDate;//创建时间
    private int categoryId;//水果品种
    private String categoryName;//类别名称
    private int typeId;        //水果类别
    private String typeName;   //水果类别名称
    private int delFlag; //0有效，1删除
    private int isShelves;//是否上架(1是 0否)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusinessmenId() {
        return businessmenId;
    }

    public void setBusinessmenId(int businessmenId) {
        this.businessmenId = businessmenId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(float discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg;
    }

    public String getOldDetailImg() {
        return oldDetailImg;
    }

    public void setOldDetailImg(String oldDetailImg) {
        this.oldDetailImg = oldDetailImg;
    }

    public String getOldProductImg() {
        return oldProductImg;
    }

    public void setOldProductImg(String oldProductImg) {
        this.oldProductImg = oldProductImg;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(int isPromotion) {
        this.isPromotion = isPromotion;
    }

    public int getIsSeason() {
        return isSeason;
    }

    public void setIsSeason(int isSeason) {
        this.isSeason = isSeason;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public int getIsShelves() {
        return isShelves;
    }

    public void setIsShelves(int isShelves) {
        this.isShelves = isShelves;
    }
}
