package com.smartcity.dao;

import com.smartcity.http.model.CityModel;
import com.smartcity.http.model.DistrictModel;
import com.smartcity.http.model.ProvinceModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yancy on 2016/5/17.
 */
public interface ChinaCityDao {
    //所有省
    ArrayList<ProvinceModel> getProvinceList();

    //所有市
    ArrayList<CityModel> getCityList();

    //所有区
    ArrayList<DistrictModel>getAreaList();

    //根据省id查询市
    ArrayList<CityModel> findCityListByProvinceId(String provinceId);
    //根据市id查询所有区

    ArrayList<DistrictModel> findDistrictListByCityId(String cityId);

    /**
     * 根据省名称查出id
     * */
    String provinceId(String province);

    /**
     * 根据城市名称查出id
     * */
    String cityId(String cityId);

    /**
     * 根据区名称查出id 和  邮编
     * */
    String[] areaId(String areaId);


    /**
     *根据省id查询名称
     * */
    String provinceName(String provinceId);
    /**
     *根据市id查询名称
     * */
    String cityName(String cityId);

    /**
     *根据区id查询名称
     * */
    String areaName(String areaId);

}
