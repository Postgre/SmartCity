package com.smartcity.model;

import com.smartcity.http.model.HopShopAndBanner;
import com.smartcity.model.modelImpl.LifeIndexModelImpl;

/**
 * Created by Yancy on 2016/5/19.
 */
public interface LifeIndexModel extends BaseModel {


    /**
     * 获取分类
     */
    void getListClassify(String apikey, LifeIndexModelImpl.OnGetClassifyShopListener listener);


    /**
     * 获取热门店铺/获取轮播图
     *
     * @param apikey token
     * @param type   轮播图  或者热门店铺
     */
    void getHotShopOrBanner(String apikey, int type, LifeIndexModelImpl.OnGetHotShopOrBannerListener<HopShopAndBanner> listener);

    /**
     * 获取附近店铺
     */

    void getNearShop(String apikey, String categoryId, String cityId, String areaId, String brandId, String longitude, String latitude, String monthSellCntSort, LifeIndexModelImpl.OnGetNearShopListener listener);

    /**
     * 获取首页banner hot calssify
     * */
    void getBannerAndClassify(String apikey,LifeIndexModelImpl.OnGetBannerAndHotListener listener);
}
