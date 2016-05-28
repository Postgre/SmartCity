package com.smartcity.http.model;

import java.util.Date;
/**
 *商品 详情
 *
 * */
public class ScShopGoodsInfo extends BaseModel {



    private static final long serialVersionUID = 1273711703219740078L;

    private int id;

    private int brandId;

    private String brandName;//品 牌名称

    private int shopId;

    private String units;

    private String goodsName;

    private Double price;

    private Double marketPrice;

    private Double deliveryMoney;//单品快递费用
    private int deliveryCalcType;// 快递费计算方式(0一口价,不计数量，1-按件计，2-按重量计)
    private Double deliveryWeight;// 单品重量

    private Short discount;

    private Short discountCondition;

    private Byte byDoor;

    private Date onShelfTime;

    private Date offShelfTime;

    private Date startTime;

    private Date endTime;

    private int stockBalance;

    private Short status;

    private String descTitle;

    private String pictureUrl;

    private Date createTime;

    private int createUser;

    private Date modifyTime;

    private int modifyUser;

    private String descStock;

    private String descContent;

    private int sortNo;//商品综合排序

    private int likeCount;//点赞数量
    private int payCount;//付款数量

    private int favCount;//收藏数量

    private int isMyFav;//是否已收藏 1表示已收藏

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public int getBrandId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getShopId() {
        return shopId;
    }

    public String getUnits() {
        return units;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public Double getPrice() {
        return price;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public Double getDeliveryMoney() {
        return deliveryMoney;
    }

    public int getDeliveryCalcType() {
        return deliveryCalcType;
    }

    public Double getDeliveryWeight() {
        return deliveryWeight;
    }

    public Short getDiscount() {
        return discount;
    }

    public Short getDiscountCondition() {
        return discountCondition;
    }

    public Byte getByDoor() {
        return byDoor;
    }

    public Date getOnShelfTime() {
        return onShelfTime;
    }

    public Date getOffShelfTime() {
        return offShelfTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getStockBalance() {
        return stockBalance;
    }

    public Short getStatus() {
        return status;
    }

    public String getDescTitle() {
        return descTitle;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public int getCreateUser() {
        return createUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public int getModifyUser() {
        return modifyUser;
    }

    public String getDescStock() {
        return descStock;
    }

    public String getDescContent() {
        return descContent;
    }

    public int getSortNo() {
        return sortNo;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public int getPayCount() {
        return payCount;
    }

    public int getFavCount() {
        return favCount;
    }

    public int getIsMyFav() {
        return isMyFav;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public void setDeliveryMoney(Double deliveryMoney) {
        this.deliveryMoney = deliveryMoney;
    }

    public void setDeliveryCalcType(int deliveryCalcType) {
        this.deliveryCalcType = deliveryCalcType;
    }

    public void setDeliveryWeight(Double deliveryWeight) {
        this.deliveryWeight = deliveryWeight;
    }

    public void setDiscount(Short discount) {
        this.discount = discount;
    }

    public void setDiscountCondition(Short discountCondition) {
        this.discountCondition = discountCondition;
    }

    public void setByDoor(Byte byDoor) {
        this.byDoor = byDoor;
    }

    public void setOnShelfTime(Date onShelfTime) {
        this.onShelfTime = onShelfTime;
    }

    public void setOffShelfTime(Date offShelfTime) {
        this.offShelfTime = offShelfTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setStockBalance(int stockBalance) {
        this.stockBalance = stockBalance;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public void setDescTitle(String descTitle) {
        this.descTitle = descTitle;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUser(int createUser) {
        this.createUser = createUser;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setModifyUser(int modifyUser) {
        this.modifyUser = modifyUser;
    }

    public void setDescStock(String descStock) {
        this.descStock = descStock;
    }

    public void setDescContent(String descContent) {
        this.descContent = descContent;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public void setPayCount(int payCount) {
        this.payCount = payCount;
    }

    public void setFavCount(int favCount) {
        this.favCount = favCount;
    }

    public void setIsMyFav(int isMyFav) {
        this.isMyFav = isMyFav;
    }

    @Override
    public String toString() {
        return "ScShopGoodsInfo{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", shopId=" + shopId +
                ", units='" + units + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", marketPrice=" + marketPrice +
                ", deliveryMoney=" + deliveryMoney +
                ", deliveryCalcType=" + deliveryCalcType +
                ", deliveryWeight=" + deliveryWeight +
                ", discount=" + discount +
                ", discountCondition=" + discountCondition +
                ", byDoor=" + byDoor +
                ", onShelfTime=" + onShelfTime +
                ", offShelfTime=" + offShelfTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", stockBalance=" + stockBalance +
                ", status=" + status +
                ", descTitle='" + descTitle + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", createTime=" + createTime +
                ", createUser=" + createUser +
                ", modifyTime=" + modifyTime +
                ", modifyUser=" + modifyUser +
                ", descStock='" + descStock + '\'' +
                ", descContent='" + descContent + '\'' +
                ", sortNo=" + sortNo +
                ", likeCount=" + likeCount +
                ", payCount=" + payCount +
                ", favCount=" + favCount +
                ", isMyFav=" + isMyFav +
                '}';
    }


}