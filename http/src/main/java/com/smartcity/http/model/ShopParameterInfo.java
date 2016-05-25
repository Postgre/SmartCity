package com.smartcity.http.model;

/**
 * Created by Yancy on 2016/5/23.
 * 分类查找店铺 参数对象
 *
 */


public class ShopParameterInfo {
    private int categoryId;//分类ID
    private String cityId;//城市ID
    private String areaId;//区域ID，可选
    private String brandId;//品 牌ID，可选

    private String longitude;//手机所在的经度，必填
    private String latitude;//手机所在的纬度，必填

    private String monthSellCntSort;// 月销量排序规则，0-降序；1-升序。为null时，默认按距离排序。


    public ShopParameterInfo() {
    }

    public ShopParameterInfo(int categoryId, String cityId, String areaId, String brandId, String longitude, String latitude, String monthSellCntSort) {
        this.categoryId = categoryId;
        this.cityId = cityId;
        this.areaId = areaId;
        this.brandId = brandId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.monthSellCntSort = monthSellCntSort;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCityId() {
        return cityId;
    }

    public String getAreaId() {
        return areaId;
    }

    public String getBrandId() {
        return brandId;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getMonthSellCntSort() {
        return monthSellCntSort;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setMonthSellCntSort(String monthSellCntSort) {
        this.monthSellCntSort = monthSellCntSort;
    }


}
