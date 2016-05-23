package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Administrator on 2016/5/20.
 */
public class LifeGoodsModel extends BaseModel {

    /**
     * id : 13
     * brandId : 1
     * brandName : 潘婷
     * shopId : 1
     * units : null
     * goodsName : SK2-优选13
     * price : 100
     * marketPrice : 120
     * byDoor : 1
     * stockBalance : 100
     * status : null
     * descTitle : 324
     * pictureUrl : http://img14.360buyimg.com/n1/jfs/t2470/30/755323007/84160/debf1d71/562898c4N3e135baf.jpg
     * createTime : null
     * descStock : null
     * descContent : null
     * sortNo : 9
     * likeCount : 0
     * payCount : null
     * favCount : 0
     * isMyFav : null
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private int brandId;
        private String brandName;
        private int shopId;
        private Object units;
        private String goodsName;
        private int price;
        private int marketPrice;
        private int byDoor;
        private int stockBalance;
        private Object status;
        private String descTitle;
        private String pictureUrl;
        private String createTime;
        private Object descStock;
        private String descContent;
        private int sortNo;
        private int likeCount;
        private double payCount;
        private int favCount;
        private int isMyFav;

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

        public Object getUnits() {
            return units;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public int getPrice() {
            return price;
        }

        public int getMarketPrice() {
            return marketPrice;
        }

        public int getByDoor() {
            return byDoor;
        }

        public int getStockBalance() {
            return stockBalance;
        }

        public Object getStatus() {
            return status;
        }

        public String getDescTitle() {
            return descTitle;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public String getCreateTime() {
            return createTime;
        }

        public Object getDescStock() {
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

        public double getPayCount() {
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

        public void setUnits(Object units) {
            this.units = units;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setMarketPrice(int marketPrice) {
            this.marketPrice = marketPrice;
        }

        public void setByDoor(int byDoor) {
            this.byDoor = byDoor;
        }

        public void setStockBalance(int stockBalance) {
            this.stockBalance = stockBalance;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public void setDescTitle(String descTitle) {
            this.descTitle = descTitle;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setDescStock(Object descStock) {
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

        public void setPayCount(double payCount) {
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
            return "DataBean{" +
                    "id=" + id +
                    ", brandId=" + brandId +
                    ", brandName='" + brandName + '\'' +
                    ", shopId=" + shopId +
                    ", units=" + units +
                    ", goodsName='" + goodsName + '\'' +
                    ", price=" + price +
                    ", marketPrice=" + marketPrice +
                    ", byDoor=" + byDoor +
                    ", stockBalance=" + stockBalance +
                    ", status=" + status +
                    ", descTitle='" + descTitle + '\'' +
                    ", pictureUrl='" + pictureUrl + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", descStock=" + descStock +
                    ", descContent=" + descContent +
                    ", sortNo=" + sortNo +
                    ", likeCount=" + likeCount +
                    ", payCount=" + payCount +
                    ", favCount=" + favCount +
                    ", isMyFav=" + isMyFav +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LifeGoodsModel{" +
                "data=" + data +
                '}';
    }
}
