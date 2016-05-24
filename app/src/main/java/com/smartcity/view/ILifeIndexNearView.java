package com.smartcity.view;

import com.smartcity.http.model.HopShopAndBanner;

/**
 * Created by Administrator on 2016/5/19.
 */
public interface ILifeIndexNearView extends BaseViews {
    void setNearShop(HopShopAndBanner banner);

    void setHasLoadDataOnce(boolean hasLoadDataOnce);
}
