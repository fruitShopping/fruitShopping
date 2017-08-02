package com.zcf.fruit.entity.product;

/**
 * 产品销售
 * Created by zcf on 2017/6/29.
 */
public class ProductSalesEntity {
    private int id;
    private int salesMethod;//销售方式(0斤 1箱)
    private int poundsNum; //斤数(起售斤数和每箱斤数)
    private int productId;//商品ID
    private String productName;//产品名称
    private int isFreePost;//是否包邮(0是1否)
    private int freePostJin;//包邮斤数(超过几斤包邮)
    private float postMoney;//邮费
    private int fruitScore;  //赠送果币

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalesMethod() {
        return salesMethod;
    }

    public void setSalesMethod(int salesMethod) {
        this.salesMethod = salesMethod;
    }

    public int getPoundsNum() {
        return poundsNum;
    }

    public void setPoundsNum(int poundsNum) {
        this.poundsNum = poundsNum;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getIsFreePost() {
        return isFreePost;
    }

    public void setIsFreePost(int isFreePost) {
        this.isFreePost = isFreePost;
    }

    public int getFreePostJin() {
        return freePostJin;
    }

    public void setFreePostJin(int freePostJin) {
        this.freePostJin = freePostJin;
    }

    public float getPostMoney() {
        return postMoney;
    }

    public void setPostMoney(float postMoney) {
        this.postMoney = postMoney;
    }

    public int getFruitScore() {
        return fruitScore;
    }

    public void setFruitScore(int fruitScore) {
        this.fruitScore = fruitScore;
    }
}
