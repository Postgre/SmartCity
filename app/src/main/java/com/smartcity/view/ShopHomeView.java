package com.smartcity.view;

import com.smartcity.http.model.CouponModel;
import com.smartcity.http.model.LifeGoodsModel;
import com.smartcity.http.model.LifeShopModel;

/**
 * Created by Ynacy on 2016/5/20.
 */
public interface ShopHomeView  extends BaseViews{

    //店铺背景
    void setShopBgUrl(String url);

    //优惠券列表
    void setCouponList(CouponModel couponList);

    //设置商品列表
    void setGoodsList(LifeGoodsModel goodsList);

    //店铺是否收藏
    void idCollection(boolean isCoolection);

    void startLogin();

    void  goShopDesActivity(LifeShopModel lifeShopModel);
}
