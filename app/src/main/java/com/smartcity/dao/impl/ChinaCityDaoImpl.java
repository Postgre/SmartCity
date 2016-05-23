package com.smartcity.dao.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.smartcity.application.MyApplication;
import com.smartcity.dao.ChinaCityDao;
import com.smartcity.http.model.CityModel;
import com.smartcity.http.model.DistrictModel;
import com.smartcity.http.model.ProvinceModel;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.UIUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yancy on 2016/5/17.
 */
public class ChinaCityDaoImpl implements ChinaCityDao {

    private File file = null;

    public ChinaCityDaoImpl() {

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            file = new File(Environment.getExternalStorageDirectory(), MyApplication.PROVINCE_CITY_NAME);
        } else {
            file = new File(UIUtils.getContext().getFilesDir(), MyApplication.PROVINCE_CITY_NAME);
        }


    }

    @Override
    public ArrayList<ProvinceModel> getProvinceList() {

        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        ArrayList<ProvinceModel> citys = null;
        try {
            sqLiteDatabase = getChinaCityDb();
            cursor = sqLiteDatabase.rawQuery("select * from " + ChinaCityInfo.provinceName, null);
            citys = new ArrayList<>();
            while (cursor.moveToNext()) {
                String provinceName =  cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumProvinceName));
                String provinceId=  cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumProvinceSortId));
                citys.add(new ProvinceModel(provinceName,findCityListByProvinceId(provinceId)));
            }
        } finally {
            if (null != cursor) {
                cursor.close();
            }
            if (null != sqLiteDatabase) {
                sqLiteDatabase.close();
            }
        }
        return citys;
    }

    @Override
    public ArrayList<CityModel> getCityList() {
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        ArrayList<CityModel> citys = null;
        try {
            sqLiteDatabase = SQLiteDatabase.openDatabase(file.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
            cursor = sqLiteDatabase.rawQuery("select * from " + ChinaCityInfo.cityName, null);
            citys = new ArrayList<>();
            while (cursor.moveToNext()) {
                String cityName = cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumCityName));
                String citySortId = cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumCitySortId));
                citys.add(new CityModel(cityName,citySortId,null));
            }

        } finally {
            closeCourse(cursor);
            closeSqlDb(sqLiteDatabase);

        }
        return citys;
    }

    @Override
    public ArrayList<DistrictModel> getAreaList() {

        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(file.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + ChinaCityInfo.areaName, null);
        ArrayList<DistrictModel> districtModels = new ArrayList<>();
        while (cursor.moveToNext()) {
            districtModels.add(new DistrictModel(cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumAreaName)), cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumAreaId))));
        }
        cursor.close();
        sqLiteDatabase.close();
        return districtModels;
    }

    @Override
    public ArrayList<CityModel> findCityListByProvinceId(String provinceId) {
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        ArrayList<CityModel> cityModelList = null;
        try {
            sqLiteDatabase = getChinaCityDb();
            cursor = sqLiteDatabase.rawQuery("select * from " + ChinaCityInfo.cityName + " where " + ChinaCityInfo.colnumCityProId + " = ?", new String[]{provinceId});
            cityModelList = new ArrayList<>();
            while (cursor.moveToNext()) {
                String cityName = cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumCityName));
                String citySoryId = cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumCitySortId));
                cityModelList.add(new CityModel(cityName,citySoryId,findDistrictListByCityId(citySoryId)));
            }
        } finally {
            closeCourse(cursor);
            closeSqlDb(sqLiteDatabase);
        }
        return cityModelList;

    }

    @Override
    public ArrayList<DistrictModel> findDistrictListByCityId(String cityId) {
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        ArrayList<DistrictModel> districtModels = null;
        try {
            sqLiteDatabase = getChinaCityDb();
            cursor = sqLiteDatabase.rawQuery("select * from " + ChinaCityInfo.areaName + " where " + ChinaCityInfo.colnumCityID + " = ?", new String[]{cityId});
            districtModels = new ArrayList<>();
            while (cursor.moveToNext()) {
                districtModels.add(new DistrictModel(cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumAreaName)), cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumAreaId))));
            }
        } finally {
            closeCourse(cursor);
            closeSqlDb(sqLiteDatabase);
        }
        return districtModels;

    }

    @Override
    public String provinceId(String province) {
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        String result = "";
        try {
            sqLiteDatabase = getChinaCityDb();
            cursor = sqLiteDatabase.rawQuery("select "+ChinaCityInfo.colnumProvinceSortId+" from " + ChinaCityInfo.provinceName + " where " + ChinaCityInfo.colnumProvinceName + " = ?", new String[]{province});
          if(cursor.moveToNext())
          {
              result = cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumProvinceSortId));
          }
        } finally {
            closeCourse(cursor);
            closeSqlDb(sqLiteDatabase);
        }
        return result;
    }

    @Override
    public String cityId(String cityId) {
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        String result = "";
        try {
            sqLiteDatabase = getChinaCityDb();
            cursor = sqLiteDatabase.rawQuery("select "+ChinaCityInfo.colnumCitySortId+" from " + ChinaCityInfo.cityName + " where " + ChinaCityInfo.colnumCityName + " = ?", new String[]{cityId});
            if(cursor.moveToNext())
            {
                result = cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumCitySortId));
            }
        } finally {
            closeCourse(cursor);
            closeSqlDb(sqLiteDatabase);
        }
        return result;
    }

    @Override
    public String[] areaId(String areaId) {
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;
        String[] result = new String[2];
        try {
            sqLiteDatabase = getChinaCityDb();
            cursor = sqLiteDatabase.rawQuery("select "+ChinaCityInfo.colnumAreaId+" from " + ChinaCityInfo.areaName + " where " + ChinaCityInfo.colnumAreaName + " = ?", new String[]{areaId});
            if(cursor.moveToNext())
            {
                result[0] = cursor.getString(cursor.getColumnIndex(ChinaCityInfo.colnumAreaId));
            }
        } finally {
            closeCourse(cursor);
            closeSqlDb(sqLiteDatabase);
        }
        return result;
    }

    public interface ChinaCityInfo {
        String provinceName = "T_Province";
        String cityName = "T_City";
        String areaName = "T_Zone";
        String colnumAreaId = "ZoneID";
        String colnumAreaName = "ZoneName";

        String colnumCityID = "CityID";
        String colnumCityName = "CityName";
        String colnumCitySortId="CitySort";
        String colnumCityProId="ProID";


        String colnumProvinceName = "ProName";
        String colnumProvinceSortId="ProSort";
    }

    private SQLiteDatabase getChinaCityDb() {
        return SQLiteDatabase.openDatabase(file.getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
    }

    private void closeSqlDb(SQLiteDatabase sqLiteDatabase) {
        if (null != sqLiteDatabase) {
            sqLiteDatabase.close();
        }
    }

    private void closeCourse(Cursor cursor) {
        if (null != cursor) {
            cursor.close();
        }
    }
}
