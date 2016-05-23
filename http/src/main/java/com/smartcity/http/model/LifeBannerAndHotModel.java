package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Yancy on 2016/5/20.
 */
public class LifeBannerAndHotModel extends BaseModel{


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4
         * categoryName : 美发造型
         * categoryNameEn : hair
         * categoryLogo :
         * categoryDepath : 0
         * categoryStatus : 0
         * categoryType : 0
         * isHomeShow : 1
         * sequence : 1
         * createTime : 2016-04-15 14:20:21
         * createUser : 10000
         * modifyTime : 2016-05-19 10:13:25
         * modifyUser : 10000
         * scSysBackUser : {"id":10000,"usercode":"superAdmin","username":null,"scSysPositionList":null,"isManage":0}
         * pid : 0
         * state : closed
         * children : null
         * merchantId : null
         */

        private List<CategoryListBean> categoryList;
        /**
         * id : 5
         * merchantId : 1036
         * shopName : 商城滚动店铺1
         * shopShortName : slide1
         * shopDesc : e33
         * shopStatus : 0
         * byDoor : null
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
         * score : 0
         * scoreDesc : null
         * scoreService : null
         * scoreDelivery : null
         * memberDiscount : null
         * monthSellCnt : null
         * distance : null
         * labelImageUrl : http://oss-cn-hangzhou.aliyuncs.com/tsnrhapp/store/shopLabel/c573bc0ca2824dd9a9d5782449b74318.jpg
         * labelDescription : null
         * topCategoryName : null
         * goodsList : null
         */

        private List<SlideShopListBean> slideShopList;
        /**
         * id : 1
         * merchantId : 1036
         * shopName : 店铺1
         * shopShortName : TEST1
         * shopDesc : DDD,dddffasdsaf,
         * shopStatus : 0
         * byDoor : 1
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
         * modifyTime : 2016-05-20 15:39:55
         * createUser : 10000
         * modifyUser : 10000
         * score : 0.72
         * scoreDesc : 0.72
         * scoreService : 0.72
         * scoreDelivery : 0.72
         * memberDiscount : null
         * monthSellCnt : null
         * distance : null
         * labelImageUrl : http://oss-cn-hangzhou.aliyuncs.com/tsnrhapp/store/shopLabel/bdfe9fa25a5a48a0a1d3575b3cbf951e.jpg
         * labelDescription : 3333
         * topCategoryName : null
         * goodsList : null
         */

        private List<HotShopListBean> hotShopList;

        public List<CategoryListBean> getCategoryList() {
            return categoryList;
        }

        public void setCategoryList(List<CategoryListBean> categoryList) {
            this.categoryList = categoryList;
        }

        public List<SlideShopListBean> getSlideShopList() {
            return slideShopList;
        }

        public void setSlideShopList(List<SlideShopListBean> slideShopList) {
            this.slideShopList = slideShopList;
        }

        public List<HotShopListBean> getHotShopList() {
            return hotShopList;
        }

        public void setHotShopList(List<HotShopListBean> hotShopList) {
            this.hotShopList = hotShopList;
        }

        public static class CategoryListBean {
            private int id;
            private String categoryName;
            private String categoryNameEn;
            private String categoryLogo;
            private int categoryDepath;
            private int categoryStatus;
            private int categoryType;
            private int isHomeShow;
            private int sequence;
            private String createTime;
            private int createUser;
            private String modifyTime;
            private int modifyUser;
            /**
             * id : 10000
             * usercode : superAdmin
             * username : null
             * scSysPositionList : null
             * isManage : 0
             */

            private ScSysBackUserBean scSysBackUser;
            private int pid;
            private String state;
            private Object children;
            private Object merchantId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public String getCategoryNameEn() {
                return categoryNameEn;
            }

            public void setCategoryNameEn(String categoryNameEn) {
                this.categoryNameEn = categoryNameEn;
            }

            public String getCategoryLogo() {
                return categoryLogo;
            }

            public void setCategoryLogo(String categoryLogo) {
                this.categoryLogo = categoryLogo;
            }

            public int getCategoryDepath() {
                return categoryDepath;
            }

            public void setCategoryDepath(int categoryDepath) {
                this.categoryDepath = categoryDepath;
            }

            public int getCategoryStatus() {
                return categoryStatus;
            }

            public void setCategoryStatus(int categoryStatus) {
                this.categoryStatus = categoryStatus;
            }

            public int getCategoryType() {
                return categoryType;
            }

            public void setCategoryType(int categoryType) {
                this.categoryType = categoryType;
            }

            public int getIsHomeShow() {
                return isHomeShow;
            }

            public void setIsHomeShow(int isHomeShow) {
                this.isHomeShow = isHomeShow;
            }

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
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

            public int getModifyUser() {
                return modifyUser;
            }

            public void setModifyUser(int modifyUser) {
                this.modifyUser = modifyUser;
            }

            public ScSysBackUserBean getScSysBackUser() {
                return scSysBackUser;
            }

            public void setScSysBackUser(ScSysBackUserBean scSysBackUser) {
                this.scSysBackUser = scSysBackUser;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public Object getChildren() {
                return children;
            }

            public void setChildren(Object children) {
                this.children = children;
            }

            public Object getMerchantId() {
                return merchantId;
            }

            public void setMerchantId(Object merchantId) {
                this.merchantId = merchantId;
            }

            public static class ScSysBackUserBean {
                private int id;
                private String usercode;
                private Object username;
                private Object scSysPositionList;
                private int isManage;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getUsercode() {
                    return usercode;
                }

                public void setUsercode(String usercode) {
                    this.usercode = usercode;
                }

                public Object getUsername() {
                    return username;
                }

                public void setUsername(Object username) {
                    this.username = username;
                }

                public Object getScSysPositionList() {
                    return scSysPositionList;
                }

                public void setScSysPositionList(Object scSysPositionList) {
                    this.scSysPositionList = scSysPositionList;
                }

                public int getIsManage() {
                    return isManage;
                }

                public void setIsManage(int isManage) {
                    this.isManage = isManage;
                }
            }
        }

        public static class SlideShopListBean {
            private int id;
            private int merchantId;
            private String shopName;
            private String shopShortName;
            private String shopDesc;
            private int shopStatus;
            private Object byDoor;
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
            private int score;
            private Object scoreDesc;
            private Object scoreService;
            private Object scoreDelivery;
            private Object memberDiscount;
            private Object monthSellCnt;
            private Object distance;
            private String labelImageUrl;
            private Object labelDescription;
            private Object topCategoryName;
            private Object goodsList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMerchantId() {
                return merchantId;
            }

            public void setMerchantId(int merchantId) {
                this.merchantId = merchantId;
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

            public Object getByDoor() {
                return byDoor;
            }

            public void setByDoor(Object byDoor) {
                this.byDoor = byDoor;
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

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public Object getScoreDesc() {
                return scoreDesc;
            }

            public void setScoreDesc(Object scoreDesc) {
                this.scoreDesc = scoreDesc;
            }

            public Object getScoreService() {
                return scoreService;
            }

            public void setScoreService(Object scoreService) {
                this.scoreService = scoreService;
            }

            public Object getScoreDelivery() {
                return scoreDelivery;
            }

            public void setScoreDelivery(Object scoreDelivery) {
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

            public String getLabelImageUrl() {
                return labelImageUrl;
            }

            public void setLabelImageUrl(String labelImageUrl) {
                this.labelImageUrl = labelImageUrl;
            }

            public Object getLabelDescription() {
                return labelDescription;
            }

            public void setLabelDescription(Object labelDescription) {
                this.labelDescription = labelDescription;
            }

            public Object getTopCategoryName() {
                return topCategoryName;
            }

            public void setTopCategoryName(Object topCategoryName) {
                this.topCategoryName = topCategoryName;
            }

            public Object getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(Object goodsList) {
                this.goodsList = goodsList;
            }
        }

        public static class HotShopListBean {
            private int id;
            private int merchantId;
            private String shopName;
            private String shopShortName;
            private String shopDesc;
            private int shopStatus;
            private int byDoor;
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
            private double score;
            private double scoreDesc;
            private double scoreService;
            private double scoreDelivery;
            private Object memberDiscount;
            private Object monthSellCnt;
            private Object distance;
            private String labelImageUrl;
            private String labelDescription;
            private Object topCategoryName;
            private Object goodsList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMerchantId() {
                return merchantId;
            }

            public void setMerchantId(int merchantId) {
                this.merchantId = merchantId;
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

            public int getByDoor() {
                return byDoor;
            }

            public void setByDoor(int byDoor) {
                this.byDoor = byDoor;
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

            public String getLabelImageUrl() {
                return labelImageUrl;
            }

            public void setLabelImageUrl(String labelImageUrl) {
                this.labelImageUrl = labelImageUrl;
            }

            public String getLabelDescription() {
                return labelDescription;
            }

            public void setLabelDescription(String labelDescription) {
                this.labelDescription = labelDescription;
            }

            public Object getTopCategoryName() {
                return topCategoryName;
            }

            public void setTopCategoryName(Object topCategoryName) {
                this.topCategoryName = topCategoryName;
            }

            public Object getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(Object goodsList) {
                this.goodsList = goodsList;
            }
        }
    }
}
