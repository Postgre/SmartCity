package com.smartcity.model;

import com.smartcity.http.model.FovShopGood;
import com.smartcity.model.modelImpl.ShopHomeModelImpl;

/**
 * Created by Administrator on 2016/5/20.
 */
public interface ShopHomeModel{

    /**
     * 店铺首页信息
     */
    void getShopInfo(String apikey, String shopId, ShopHomeModelImpl.LoadShopInfoListener listener);

    /**
     * 优惠券列表
     */
    void getCouPonList(String apikey, String shopid, ShopHomeModelImpl.LoadCouPonListListener listener);

    /**
     * 商品列表
     *
     * @param type 综合  最新  价格 高 低
     */
    void getGoodsList(String apikey, String shopId, int pageNo, int pageSize, int type, ShopHomeModelImpl.LoadShopGoodsListener listener);


    void addFovShopOrGood(String apikey, FovShopGood fovShopGood, ShopHomeModelImpl.AddFovShopOrGoodListener listener);
}
