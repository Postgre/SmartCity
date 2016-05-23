package com.smartcity.http.model;

import java.util.List;

/**
 * Created by Yancy on 2016/5/14.
 */
public class AddressList extends BaseModel {


    /**
     * id : 2
     * customerId : 1
     * name : 张三3
     * phone : 13202029621
     * zipcode : 430000
     * provinceId : 1
     * cityId : 2
     * areaId : 3
     * address : 武珞路220号
     * isDefault : 1
     * createTime : 2016-04-09 09:30:07
     * modifyTime : null
     */

    private List<LifeAddressModel> data;

    public List<LifeAddressModel> getData() {
        return data;
    }

    public void setData(List<LifeAddressModel> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AddressList{" +
                "data=" + data +
                '}';
    }

    public static class LifeAddressModel extends BaseModel {
        private int id;
        private int customerId;
        private String name;
        private String phone;
        private String zipcode;
        private String provinceId;
        private String cityId;
        private String areaId;
        private String address;
        private int isDefault;
        private String createTime;
        private Object modifyTime;

        public int getId() {
            return id;
        }

        public int getCustomerId() {
            return customerId;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public String getZipcode() {
            return zipcode;
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

        public int getIsDefault() {
            return isDefault;
        }

        public String getCreateTime() {
            return createTime;
        }

        public Object getModifyTime() {
            return modifyTime;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
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

        public void setIsDefault(int isDefault) {
            this.isDefault = isDefault;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setModifyTime(Object modifyTime) {
            this.modifyTime = modifyTime;
        }

        @Override
        public String toString() {
            return "LifeAddressModel{" +
                    "id=" + id +
                    ", customerId=" + customerId +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    ", zipcode='" + zipcode + '\'' +
                    ", provinceId='" + provinceId + '\'' +
                    ", cityId='" + cityId + '\'' +
                    ", areaId='" + areaId + '\'' +
                    ", address='" + address + '\'' +
                    ", isDefault=" + isDefault +
                    ", createTime='" + createTime + '\'' +
                    ", modifyTime=" + modifyTime +
                    '}';
        }
    }
}
