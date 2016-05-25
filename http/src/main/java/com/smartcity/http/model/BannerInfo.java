package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Yancy on 2016/5/23.
 *
 * 商铺 品牌列表
 */
public class BannerInfo extends BaseModel {


    /**
     * id : 1
     * brandName : 潘婷
     * brandEn : PANTING
     * brandMini : 潘婷
     * createTime : 2016-04-21 18:51:47
     * createUser : 10000
     * modifyTime : 2016-05-10 14:28:44
     * modifyUser : 10000
     * brandIntroduce : 介绍一
     * categoryList : []
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
        private String brandName;
        private String brandEn;
        private String brandMini;
        private String createTime;
        private int createUser;
        private String modifyTime;
        private int modifyUser;
        private String brandIntroduce;
        private List<?> categoryList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getBrandEn() {
            return brandEn;
        }

        public void setBrandEn(String brandEn) {
            this.brandEn = brandEn;
        }

        public String getBrandMini() {
            return brandMini;
        }

        public void setBrandMini(String brandMini) {
            this.brandMini = brandMini;
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

        public String getBrandIntroduce() {
            return brandIntroduce;
        }

        public void setBrandIntroduce(String brandIntroduce) {
            this.brandIntroduce = brandIntroduce;
        }

        public List<?> getCategoryList() {
            return categoryList;
        }

        public void setCategoryList(List<?> categoryList) {
            this.categoryList = categoryList;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", brandName='" + brandName + '\'' +
                    ", brandEn='" + brandEn + '\'' +
                    ", brandMini='" + brandMini + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", createUser=" + createUser +
                    ", modifyTime='" + modifyTime + '\'' +
                    ", modifyUser=" + modifyUser +
                    ", brandIntroduce='" + brandIntroduce + '\'' +
                    ", categoryList=" + categoryList +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "BannerInfo{" +
                "data=" + data +
                '}';
    }
}
