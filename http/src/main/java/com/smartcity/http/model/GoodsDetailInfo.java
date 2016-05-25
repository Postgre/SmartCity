package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Yancy on 2016/5/23.
 */
public class GoodsDetailInfo  extends BaseModel{


    /**
     * id : 1
     * brandId : 1
     * brandName : null
     * shopId : 1
     * units : 支
     * goodsName : SK2-优选1
     * price : 100
     * marketPrice : 120
     * deliveryMoney : null
     * deliveryCalcType : null
     * deliveryWeight : null
     * discount : null
     * discountCondition : null
     * byDoor : 0
     * onShelfTime : 2016-04-06 09:37:23
     * offShelfTime : 2016-11-06 09:37:26
     * startTime : 2016-04-06 09:37:30
     * endTime : 2016-12-06 09:37:32
     * stockBalance : 85
     * status : 1
     * descTitle : 324
     * pictureUrl : http://img14.360buyimg.com/n1/jfs/t2470/30/755323007/84160/debf1d71/562898c4N3e135baf.jpg
     * createTime : 2016-04-06 09:38:13
     * createUser : 10000
     * modifyTime : 2016-04-30 17:20:46
     * modifyUser : null
     * descStock : 234234
     * descContent : 2444333
     * sortNo : 1
     * imageList : [{"id":1,"goodsId":1,"fileName":"文件1","status":0,"bigFilePath":"http://img14.360buyimg.com/n1/jfs/t2005/20/769707088/75444/a3dba356/562898c5Nd1c6de66.jpg","smallFilePath":"http://img14.360buyimg.com/n1/jfs/t2005/20/769707088/75444/a3dba356/562898c5Nd1c6de66.jpg","upfileName":"1111","createUser":10000,"createTime":"2016-04-06 14:49:58"},{"id":2,"goodsId":1,"fileName":"文件2","status":0,"bigFilePath":"http://img14.360buyimg.com/n1/jfs/t1987/20/800891369/68942/2042fda9/562898c5N63676aba.jpg","smallFilePath":"http://img14.360buyimg.com/n1/jfs/t1987/20/800891369/68942/2042fda9/562898c5N63676aba.jpg","upfileName":"2222","createUser":10000,"createTime":"2016-04-06 14:49:58"}]
     * likeCount : 1
     * payCount : null
     * favCount : 1
     * isMyFav : null
     * stockList : []
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private int brandId;
        private Object brandName;
        private int shopId;
        private String units;
        private String goodsName;
        private int price;
        private int marketPrice;
        private Object deliveryMoney;
        private Object deliveryCalcType;
        private Object deliveryWeight;
        private Object discount;
        private Object discountCondition;
        private int byDoor;
        private String onShelfTime;
        private String offShelfTime;
        private String startTime;
        private String endTime;
        private int stockBalance;
        private int status;
        private String descTitle;
        private String pictureUrl;
        private String createTime;
        private int createUser;
        private String modifyTime;
        private Object modifyUser;
        private String descStock;
        private String descContent;
        private int sortNo;
        private int likeCount;
        private Object payCount;
        private int favCount;
        private Object isMyFav;
        /**
         * id : 1
         * goodsId : 1
         * fileName : 文件1
         * status : 0
         * bigFilePath : http://img14.360buyimg.com/n1/jfs/t2005/20/769707088/75444/a3dba356/562898c5Nd1c6de66.jpg
         * smallFilePath : http://img14.360buyimg.com/n1/jfs/t2005/20/769707088/75444/a3dba356/562898c5Nd1c6de66.jpg
         * upfileName : 1111
         * createUser : 10000
         * createTime : 2016-04-06 14:49:58
         */

        private List<ImageListBean> imageList;
        private List<?> stockList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }

        public Object getBrandName() {
            return brandName;
        }

        public void setBrandName(Object brandName) {
            this.brandName = brandName;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getUnits() {
            return units;
        }

        public void setUnits(String units) {
            this.units = units;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(int marketPrice) {
            this.marketPrice = marketPrice;
        }

        public Object getDeliveryMoney() {
            return deliveryMoney;
        }

        public void setDeliveryMoney(Object deliveryMoney) {
            this.deliveryMoney = deliveryMoney;
        }

        public Object getDeliveryCalcType() {
            return deliveryCalcType;
        }

        public void setDeliveryCalcType(Object deliveryCalcType) {
            this.deliveryCalcType = deliveryCalcType;
        }

        public Object getDeliveryWeight() {
            return deliveryWeight;
        }

        public void setDeliveryWeight(Object deliveryWeight) {
            this.deliveryWeight = deliveryWeight;
        }

        public Object getDiscount() {
            return discount;
        }

        public void setDiscount(Object discount) {
            this.discount = discount;
        }

        public Object getDiscountCondition() {
            return discountCondition;
        }

        public void setDiscountCondition(Object discountCondition) {
            this.discountCondition = discountCondition;
        }

        public int getByDoor() {
            return byDoor;
        }

        public void setByDoor(int byDoor) {
            this.byDoor = byDoor;
        }

        public String getOnShelfTime() {
            return onShelfTime;
        }

        public void setOnShelfTime(String onShelfTime) {
            this.onShelfTime = onShelfTime;
        }

        public String getOffShelfTime() {
            return offShelfTime;
        }

        public void setOffShelfTime(String offShelfTime) {
            this.offShelfTime = offShelfTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getStockBalance() {
            return stockBalance;
        }

        public void setStockBalance(int stockBalance) {
            this.stockBalance = stockBalance;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getDescTitle() {
            return descTitle;
        }

        public void setDescTitle(String descTitle) {
            this.descTitle = descTitle;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getCreateUser() {
            return createUser;
        }

        public void setCreateUser(int createUser) {
            this.createUser = createUser;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public Object getModifyUser() {
            return modifyUser;
        }

        public void setModifyUser(Object modifyUser) {
            this.modifyUser = modifyUser;
        }

        public String getDescStock() {
            return descStock;
        }

        public void setDescStock(String descStock) {
            this.descStock = descStock;
        }

        public String getDescContent() {
            return descContent;
        }

        public void setDescContent(String descContent) {
            this.descContent = descContent;
        }

        public int getSortNo() {
            return sortNo;
        }

        public void setSortNo(int sortNo) {
            this.sortNo = sortNo;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public Object getPayCount() {
            return payCount;
        }

        public void setPayCount(Object payCount) {
            this.payCount = payCount;
        }

        public int getFavCount() {
            return favCount;
        }

        public void setFavCount(int favCount) {
            this.favCount = favCount;
        }

        public Object getIsMyFav() {
            return isMyFav;
        }

        public void setIsMyFav(Object isMyFav) {
            this.isMyFav = isMyFav;
        }

        public List<ImageListBean> getImageList() {
            return imageList;
        }

        public void setImageList(List<ImageListBean> imageList) {
            this.imageList = imageList;
        }

        public List<?> getStockList() {
            return stockList;
        }

        public void setStockList(List<?> stockList) {
            this.stockList = stockList;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", brandId=" + brandId +
                    ", brandName=" + brandName +
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
                    ", onShelfTime='" + onShelfTime + '\'' +
                    ", offShelfTime='" + offShelfTime + '\'' +
                    ", startTime='" + startTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", stockBalance=" + stockBalance +
                    ", status=" + status +
                    ", descTitle='" + descTitle + '\'' +
                    ", pictureUrl='" + pictureUrl + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", createUser=" + createUser +
                    ", modifyTime='" + modifyTime + '\'' +
                    ", modifyUser=" + modifyUser +
                    ", descStock='" + descStock + '\'' +
                    ", descContent='" + descContent + '\'' +
                    ", sortNo=" + sortNo +
                    ", likeCount=" + likeCount +
                    ", payCount=" + payCount +
                    ", favCount=" + favCount +
                    ", isMyFav=" + isMyFav +
                    ", imageList=" + imageList +
                    ", stockList=" + stockList +
                    '}';
        }

        public static class ImageListBean {
            private int id;
            private int goodsId;
            private String fileName;
            private int status;
            private String bigFilePath;
            private String smallFilePath;
            private String upfileName;
            private int createUser;
            private String createTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(int goodsId) {
                this.goodsId = goodsId;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getBigFilePath() {
                return bigFilePath;
            }

            public void setBigFilePath(String bigFilePath) {
                this.bigFilePath = bigFilePath;
            }

            public String getSmallFilePath() {
                return smallFilePath;
            }

            public void setSmallFilePath(String smallFilePath) {
                this.smallFilePath = smallFilePath;
            }

            public String getUpfileName() {
                return upfileName;
            }

            public void setUpfileName(String upfileName) {
                this.upfileName = upfileName;
            }

            public int getCreateUser() {
                return createUser;
            }

            public void setCreateUser(int createUser) {
                this.createUser = createUser;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            @Override
            public String toString() {
                return "ImageListBean{" +
                        "id=" + id +
                        ", goodsId=" + goodsId +
                        ", fileName='" + fileName + '\'' +
                        ", status=" + status +
                        ", bigFilePath='" + bigFilePath + '\'' +
                        ", smallFilePath='" + smallFilePath + '\'' +
                        ", upfileName='" + upfileName + '\'' +
                        ", createUser=" + createUser +
                        ", createTime='" + createTime + '\'' +
                        '}';
            }
        }


    }

    @Override
    public String toString() {
        return "GoodsDetailInfo{" +
                "data=" + data +
                '}';
    }
}
