package com.smartcity.presenterImpl;

import android.text.TextUtils;

import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.dao.ChinaCityDao;
import com.smartcity.dao.impl.ChinaCityDaoImpl;
import com.smartcity.http.model.BannerInfo;
import com.smartcity.http.model.ShopParameterInfo;
import com.smartcity.model.ShopListModel;
import com.smartcity.model.modelImpl.ShopListModelImpl;
import com.smartcity.presenter.BasePresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.SharedPreferencesUtil;

/**
 * Created by Yancy on 2016/5/23.
 */
public class ShopListPresenter implements BasePresenter, ShopListModelImpl.BannerListListener<BannerInfo>,ShopListModelImpl.ShopListListener {

    private final ChinaCityDao chinaCityDao;
    private ShopListModel shopListModel;
    private final String apikey;
    private final String id;

    public ShopListPresenter() {
        shopListModel = new ShopListModelImpl();
        chinaCityDao = new ChinaCityDaoImpl();
        apikey = MyApplication.getApikey();
        id = MyApplication.getId();
    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void stop() {

    }


    public void getShopListByClassifyId(int categoryId,String cityName,String areaName,String brandId,String monthSellCntSort) {
        if(TextUtils.isEmpty(cityName))
        {
            return;
        }
        if(TextUtils.isEmpty(areaName))
        {
            return;
        }
        String cityId = chinaCityDao.cityId(cityName);
        String areaId = chinaCityDao.areaId(areaName)[0];

        SharedPreferencesUtil spUtils = MyApplication.getSpUtils();
        ShopParameterInfo shopParInfo = new ShopParameterInfo();
        shopParInfo.setCategoryId(categoryId);
        shopParInfo.setAreaId(areaId);
        shopParInfo.setCityId(cityId);
        shopParInfo.setBrandId(brandId);

        shopParInfo.setLatitude(spUtils.getString(Constant.LATITUDE,"30"));
        shopParInfo.setLongitude(spUtils.getString(Constant.LONGITUDE,"120"));
        shopParInfo.setMonthSellCntSort(monthSellCntSort);
        shopListModel.getShopList(apikey,shopParInfo,this);
    }

    public void getShopListBannerInfo() {
        shopListModel.getBannerList(apikey, this);
    }

    @Override
    public void loadBannerInfoListSuccess(BannerInfo bannerInfo) {
              LogTool.e("bannerInfo", bannerInfo.toString());

    }

    @Override
    public void loadBannerInfoListError(String msg) {
        LogTool.e("test", TextUtils.isEmpty(msg)?"get banner info error":msg);
    }

    @Override
    public void loadShopListSuccess(Object o) {
        LogTool.e("test2", o.toString());
    }

    @Override
    public void loadShopListError(String msg) {
        LogTool.e("test", TextUtils.isEmpty(msg)?"get shoplist info error":msg);
    }
}
