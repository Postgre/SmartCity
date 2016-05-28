package com.smartcity.model;

import com.smartcity.http.model.CartInfo;
import com.smartcity.http.model.ScShopCartVo;
import com.smartcity.model.modelImpl.CartModelImpl;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface CartModel extends BaseModel {
    /**
     * 获取购物车所有的商品
     * @param customerId  用户id
     *@param apiKey token
     *@param listener  结果回调
     * */
    void getProductList(String customerId, String apiKey, CartModelImpl.OnProductListListener<CartInfo> listener);

    /**
     * 添加商品到购物车
     * @param apiKey token
     * @param listener 结果回调
     * @param customerId  用户id
     * @param goodsId  商品id
     * @param goodsName 商品名称
     *  @param shopId 店铺id
     * */
    void  addGoodTotCart(String customerId,int goodsId,String goodsName,int shopId,String apiKey,CartModelImpl.OnAddGoodResultListener listener);

    /**
     * 删除购物车  店铺下的商品
     * @param shopId 商铺id
     * @param listener 结果 =回调
     * @param apiKey token
     * */
    void deleteGoodsByShopId(String shopId,String apiKey,CartModelImpl.OnDeleteGoodsListener listener);
    /**
     * 删除购物车  店铺下的某一个商品
     * @param goodsId 商铺id
     * @param listener 结果 =回调
     * @param apiKey token
     * @param customerId 用户id
     * */
    void  deleteGoodByShopIdAndUserId(int goodsId,int customerId,String apiKey,CartModelImpl.OnDeleteGoodListener listener);

    /**
     * 删除购物车  店铺下的某一个商品
     * @param goodsId 商铺id
     * @param listener 结果 =回调
     * @param apikey token
     * @param customerId 用户id

     * @param number 数量
     *@param stockId  规格id
     * */
    void updateCartNum(int customerId,int goodsId,int number,int stockId,String apikey ,CartModelImpl.OnUpdateResultListener listener);
}
