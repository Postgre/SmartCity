package com.smartcity.model;

import com.smartcity.http.model.ShopParameterInfo;
import com.smartcity.model.modelImpl.ShopListModelImpl;

/**
 * Created by Yancy on 2016/5/23.
 */
public interface ShopListModel extends BaseModel {

    void getShopList(String apiKey, ShopParameterInfo shopParameterInfo, ShopListModelImpl.ShopListListener listener);


    void getBannerList(String apiKey, ShopListModelImpl.BannerListListener listener);
}
