package com.smartcity.http.model;

/**
 * Created by Administrator on 2016/5/20.
 */
public class LifeShopModel extends BaseModel {

    /**
     * id : 1
     * companyId : 10000
     * shopName : 测试1
     * shopShortName : TEST1
     * shopDesc : DDD,dddffasdsaf,
     * shopStatus : 0
     * logoUrl : http://oss-cn-hangzhou.aliyuncs.com/tsnrhapp/store/shop/24863c2f4bae43a4a9c14db737b3b79e.png
     * bgImage : http://oss-cn-hangzhou.aliyuncs.com/tsnrhapp/store/shop/583b91599e974488822538d95db09c99.jpg
     * provinceId : 420000
     * cityId : 420100
     * areaId : 420106
     * address : 42343242432AA
     * longitude : 114.35895
     * latitude : 30.56216
     * name : 测试名称
     * email : 3333333@qq.com
     * mobile : 15927517292
     * phone : 13202029621
     * phoneService : 027-67865867
     * openTimeStart : 08:30:00
     * openTimeEnd : 20:45:00
     * createTime : 2016-04-05 16:15:16
     * modifyTime : 2016-05-17 20:17:03
     * createUser : 10000
     * modifyUser : 10000
     * shopOwnerId : 1
     * score : 0.72
     * scoreDesc : 0.72
     * scoreService : 0.72
     * scoreDelivery : 0.72
     * memberDiscount : null
     * monthSellCnt : null
     * distance : null
     * labelImageUrl : null
     * labelDescription : null
     * goodsList : null
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
        private int shopOwnerId;
        private double score;
        private double scoreDesc;
        private double scoreService;
        private double scoreDelivery;
        private Object memberDiscount;
        private Object monthSellCnt;
        private Object distance;
        private Object labelImageUrl;
        private Object labelDescription;
        private Object goodsList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopShortName() {
            return shopShortName;
        }

        public void setShopShortName(String shopShortName) {
            this.shopShortName = shopShortName;
        }

        public String getShopDesc() {
            return shopDesc;
        }

        public void setShopDesc(String shopDesc) {
            this.shopDesc = shopDesc;
        }

        public int getShopStatus() {
            return shopStatus;
        }

        public void setShopStatus(int shopStatus) {
            this.shopStatus = shopStatus;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public String getBgImage() {
            return bgImage;
        }

        public void setBgImage(String bgImage) {
            this.bgImage = bgImage;
        }

        public String getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(String provinceId) {
            this.provinceId = provinceId;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhoneService() {
            return phoneService;
        }

        public void setPhoneService(String phoneService) {
            this.phoneService = phoneService;
        }

        public String getOpenTimeStart() {
            return openTimeStart;
        }

        public void setOpenTimeStart(String openTimeStart) {
            this.openTimeStart = openTimeStart;
        }

        public String getOpenTimeEnd() {
            return openTimeEnd;
        }

        public void setOpenTimeEnd(String openTimeEnd) {
            this.openTimeEnd = openTimeEnd;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public int getCreateUser() {
            return createUser;
        }

        public void setCreateUser(int createUser) {
            this.createUser = createUser;
        }

        public int getModifyUser() {
            return modifyUser;
        }

        public void setModifyUser(int modifyUser) {
            this.modifyUser = modifyUser;
        }

        public int getShopOwnerId() {
            return shopOwnerId;
        }

        public void setShopOwnerId(int shopOwnerId) {
            this.shopOwnerId = shopOwnerId;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public double getScoreDesc() {
            return scoreDesc;
        }

        public void setScoreDesc(double scoreDesc) {
            this.scoreDesc = scoreDesc;
        }

        public double getScoreService() {
            return scoreService;
        }

        public void setScoreService(double scoreService) {
            this.scoreService = scoreService;
        }

        public double getScoreDelivery() {
            return scoreDelivery;
        }

        public void setScoreDelivery(double scoreDelivery) {
            this.scoreDelivery = scoreDelivery;
        }

        public Object getMemberDiscount() {
            return memberDiscount;
        }

        public void setMemberDiscount(Object memberDiscount) {
            this.memberDiscount = memberDiscount;
        }

        public Object getMonthSellCnt() {
            return monthSellCnt;
        }

        public void setMonthSellCnt(Object monthSellCnt) {
            this.monthSellCnt = monthSellCnt;
        }

        public Object getDistance() {
            return distance;
        }

        public void setDistance(Object distance) {
            this.distance = distance;
        }

        public Object getLabelImageUrl() {
            return labelImageUrl;
        }

        public void setLabelImageUrl(Object labelImageUrl) {
            this.labelImageUrl = labelImageUrl;
        }

        public Object getLabelDescription() {
            return labelDescription;
        }

        public void setLabelDescription(Object labelDescription) {
            this.labelDescription = labelDescription;
        }

        public Object getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(Object goodsList) {
            this.goodsList = goodsList;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "goodsList=" + goodsList +
                    ", labelDescription=" + labelDescription +
                    ", labelImageUrl=" + labelImageUrl +
                    ", distance=" + distance +
                    ", monthSellCnt=" + monthSellCnt +
                    ", memberDiscount=" + memberDiscount +
                    ", scoreDelivery=" + scoreDelivery +
                    ", scoreService=" + scoreService +
                    ", scoreDesc=" + scoreDesc +
                    ", score=" + score +
                    ", shopOwnerId=" + shopOwnerId +
                    ", modifyUser=" + modifyUser +
                    ", createUser=" + createUser +
                    ", modifyTime='" + modifyTime + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", openTimeEnd='" + openTimeEnd + '\'' +
                    ", openTimeStart='" + openTimeStart + '\'' +
                    ", phoneService='" + phoneService + '\'' +
                    ", phone='" + phone + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", address='" + address + '\'' +
                    ", areaId='" + areaId + '\'' +
                    ", cityId='" + cityId + '\'' +
                    ", provinceId='" + provinceId + '\'' +
                    ", bgImage='" + bgImage + '\'' +
                    ", logoUrl='" + logoUrl + '\'' +
                    ", shopStatus=" + shopStatus +
                    ", shopDesc='" + shopDesc + '\'' +
                    ", shopShortName='" + shopShortName + '\'' +
                    ", shopName='" + shopName + '\'' +
                    ", companyId=" + companyId +
                    ", id=" + id +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LifeShopModel{" +
                "data=" + data +
                '}';
    }
}
