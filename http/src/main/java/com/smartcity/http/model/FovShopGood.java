package com.smartcity.http.model;

/**
 * Created by Administrator on 2016/5/20.
 */
public class FovShopGood {

    private String customerId;//会员ID
    private String favId;//收藏的ID
    private String favName;//收藏名称
    private String favUrl;//收藏对应的访问路径
    private String picUrl;//收藏对应的展示图
    private String desc;//收藏描述
    private String type;//收藏类别：1商品 2店铺
    private double price;//如果是商品的话，填写价格，否则填空

    public FovShopGood() {
    }

    public FovShopGood(String customerId, String favId, String favName, String favUrl, String picUrl, String desc, String type, double price) {
        this.customerId = customerId;
        this.favId = favId;
        this.favName = favName;
        this.favUrl = favUrl;
        this.picUrl = picUrl;
        this.desc = desc;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "FovShopGood{" +
                "customerId='" + customerId + '\'' +
                ", favId='" + favId + '\'' +
                ", favName='" + favName + '\'' +
                ", favUrl='" + favUrl + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFavId() {
        return favId;
    }

    public String getFavName() {
        return favName;
    }

    public String getFavUrl() {
        return favUrl;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setFavId(String favId) {
        this.favId = favId;
    }

    public void setFavName(String favName) {
        this.favName = favName;
    }

    public void setFavUrl(String favUrl) {
        this.favUrl = favUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
