package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Yancy on 2016/5/19.
 */
public class HopShopAndBanner extends BaseModel{


    /**
     * id : 5
     * companyId : 10000
     * shopName : 商城滚动店铺1
     * shopShortName : slide1
     * shopDesc : e33
     * shopStatus : 0
     * logoUrl : http://oss-cn-hangzhou.aliyuncs.com/tsnrhapp/store/shop/19ba81ef3d7e49e496f75992c9eaf515.jpg
     * bgImage : http://oss-cn-hangzhou.aliyuncs.com/tsnrhapp/store/shop/2955cf23ca3c4e088bc512b3489ca30d.jpg
     * provinceId : 420000
     * cityId : 420100
     * areaId : 420106
     * address : 武珞路230号
     * longitude : 114.32
     * latitude : 30.53
     * name : 23
     * email : liuxihope@63.com
     * mobile : 13202029621
     * phone : 13202029621
     * phoneService : 027-88556835
     * openTimeStart : 08:00:00
     * openTimeEnd : 20:30:00
     * createTime : 2016-05-10 16:28:06
     * modifyTime : 2016-05-13 17:13:22
     * createUser : 10000
     * modifyUser : 10000
     * shopOwnerId : null
     * score : 0
     * scoreDesc : null
     * scoreService : null
     * scoreDelivery : null
     * memberDiscount : null
     * monthSellCnt : null
     * distance : null
     * labelImageUrl : http://oss-cn-hangzhou.aliyuncs.com/tsnrhapp/store/shopLabel/c573bc0ca2824dd9a9d5782449b74318.jpg
     * labelDescription : null
     * goodsList : []
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
        private int companyId;
        private String shopName;
        private String shopShortName;
        private String shopDesc;
        private int shopStatus;
        private String logoUrl;
        private String bgImage;
        private String provinceId;
        private String cityId;
        private String areaId;
        private String address;
        private double longitude;
        private double latitude;
        private String name;
        private String email;
        private String mobile;
        private String phone;
        private String phoneService;
        private String openTimeStart;
        private String openTimeEnd;
        private String createTime;
        private String modifyTime;
        private int createUser;
        private int modifyUser;
        private String shopOwnerId;
        private double score;
        private String scoreDesc;
        private String scoreService;
        private String scoreDelivery;
        private String memberDiscount;
        private String monthSellCnt;
        private String distance;
        private String labelImageUrl;
        private String labelDescription;//店铺描述
        private List<?> goodsList;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", companyId=" + companyId +
                    ", shopName='" + shopName + '\'' +
                    ", shopShortName='" + shopShortName + '\'' +
                    ", shopDesc='" + shopDesc + '\'' +
                    ", shopStatus=" + shopStatus +
                    ", logoUrl='" + logoUrl + '\'' +
                    ", bgImage='" + bgImage + '\'' +
                    ", provinceId='" + provinceId + '\'' +
                    ", cityId='" + cityId + '\'' +
                    ", areaId='" + areaId + '\'' +
                    ", address='" + address + '\'' +
                    ", longitude=" + longitude +
                    ", latitude=" + latitude +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", phone='" + phone + '\'' +
                    ", phoneService='" + phoneService + '\'' +
                    ", openTimeStart='" + openTimeStart + '\'' +
                    ", openTimeEnd='" + openTimeEnd + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", modifyTime='" + modifyTime + '\'' +
                    ", createUser=" + createUser +
                    ", modifyUser=" + modifyUser +
                    ", shopOwnerId=" + shopOwnerId +
                    ", score=" + score +
                    ", scoreDesc=" + scoreDesc +
                    ", scoreService=" + scoreService +
                    ", scoreDelivery=" + scoreDelivery +
                    ", memberDiscount=" + memberDiscount +
                    ", monthSellCnt=" + monthSellCnt +
                    ", distance=" + distance +
                    ", labelImageUrl='" + labelImageUrl + '\'' +
                    ", labelDescription='" + labelDescription + '\'' +
                    ", goodsList=" + goodsList +
                    '}';
        }


        public void setId(int id) {
            this.id = id;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public void setShopShortName(String shopShortName) {
            this.shopShortName = shopShortName;
        }

        public void setShopDesc(String shopDesc) {
            this.shopDesc = shopDesc;
        }

        public void setShopStatus(int shopStatus) {
            this.shopStatus = shopStatus;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public void setBgImage(String bgImage) {
            this.bgImage = bgImage;
        }

        public void setProvinceId(String provinceId) {
            this.provinceId = provinceId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setPhoneService(String phoneService) {
            this.phoneService = phoneService;
        }

        public void setOpenTimeStart(String openTimeStart) {
            this.openTimeStart = openTimeStart;
        }

        public void setOpenTimeEnd(String openTimeEnd) {
            this.openTimeEnd = openTimeEnd;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public void setCreateUser(int createUser) {
            this.createUser = createUser;
        }

        public void setModifyUser(int modifyUser) {
            this.modifyUser = modifyUser;
        }

        public void setShopOwnerId(String shopOwnerId) {
            this.shopOwnerId = shopOwnerId;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public void setScoreDesc(String scoreDesc) {
            this.scoreDesc = scoreDesc;
        }

        public void setScoreService(String scoreService) {
            this.scoreService = scoreService;
        }

        public void setScoreDelivery(String scoreDelivery) {
            this.scoreDelivery = scoreDelivery;
        }

        public void setMemberDiscount(String memberDiscount) {
            this.memberDiscount = memberDiscount;
        }

        public void setMonthSellCnt(String monthSellCnt) {
            this.monthSellCnt = monthSellCnt;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public void setLabelImageUrl(String labelImageUrl) {
            this.labelImageUrl = labelImageUrl;
        }

        public void setLabelDescription(String labelDescription) {
            this.labelDescription = labelDescription;
        }

        public void setGoodsList(List<?> goodsList) {
            this.goodsList = goodsList;
        }

        public int getId() {
            return id;
        }

        public int getCompanyId() {
            return companyId;
        }

        public String getShopName() {
            return shopName;
        }

        public String getShopShortName() {
            return shopShortName;
        }

        public String getShopDesc() {
            return shopDesc;
        }

        public int getShopStatus() {
            return shopStatus;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public String getBgImage() {
            return bgImage;
        }

        public String getProvinceId() {
            return provinceId;
        }

        public String getCityId() {
            return cityId;
        }

        public String getAreaId() {
            return areaId;
        }

        public String getAddress() {
            return address;
        }

        public double getLongitude() {
            return longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getMobile() {
            return mobile;
        }

        public String getPhone() {
            return phone;
        }

        public String getPhoneService() {
            return phoneService;
        }

        public String getOpenTimeStart() {
            return openTimeStart;
        }

        public String getOpenTimeEnd() {
            return openTimeEnd;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public int getCreateUser() {
            return createUser;
        }

        public int getModifyUser() {
            return modifyUser;
        }

        public String getShopOwnerId() {
            return shopOwnerId;
        }

        public double getScore() {
            return score;
        }

        public String getScoreDesc() {
            return scoreDesc;
        }

        public String getScoreService() {
            return scoreService;
        }

        public String getScoreDelivery() {
            return scoreDelivery;
        }

        public String getMemberDiscount() {
            return memberDiscount;
        }

        public String getMonthSellCnt() {
            return monthSellCnt;
        }

        public String getDistance() {
            return distance;
        }

        public String getLabelImageUrl() {
            return labelImageUrl;
        }

        public String getLabelDescription() {
            return labelDescription;
        }

        public List<?> getGoodsList() {
            return goodsList;
        }
    }

    @Override
    public String toString() {
        return "HopShopAndBanner{" +
                "data=" + data +
                '}';
    }
}
