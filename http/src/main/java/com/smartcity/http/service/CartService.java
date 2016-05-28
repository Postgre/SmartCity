package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.BaseModel;
import com.smartcity.http.model.CartInfo;
import com.smartcity.http.model.ScShopCartVo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface CartService {
    //购物车列表
    String ALL_PRODUCT = "shop/shopCartList";

    //添加商品
    String ADD_GOOD = "shop/addShopCart";


    //更新购物车
    String UPDATE_GOOD ="shop/updateShopCart";

    //删除商品  根据商铺id删除  商铺下所有的商品
    String DELETE_GOODS ="shop/delShopCartGoodsByShopId";

    //删除商品 用户id删除某一个商品
    String DELETE_GOOD_BY_USER_ID ="shop/delShopCartGoodsByUidAndGid";


    /**
     * 地址列表
     */
    @POST(Constant.REST)
    @FormUrlEncoded
    Call<CartInfo> getAllProduct(@Field(Constant.KEY_VERSION) String version, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_DATA) String data, @Header(Constant.API_KEY) String apikey);

    /**
     *添加到购物车
     */
    @POST(Constant.REST)
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded;charset=utf-8")
    Call<BaseModel> addGoodsToCart(@Field(Constant.KEY_VERSION) String version, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_DATA) String data,
                                   @Header(Constant.API_KEY) String apikey);

    /**
     *删除店铺下的所有商品
     */
    @POST(Constant.REST)
    @FormUrlEncoded
    Call<BaseModel> delteGoods(@Field(Constant.KEY_VERSION) String version, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_DATA) String data,
                                   @Header(Constant.API_KEY) String apikey);

    /**
     *删除购物车某一个商品
     */
    @POST(Constant.REST)
    @FormUrlEncoded
    Call<BaseModel> deleteGoodByUserId(@Field(Constant.KEY_VERSION) String version, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_DATA) String data,
                                   @Header(Constant.API_KEY) String apikey);

    /**
     *更新购物车
     */
    @POST(Constant.REST)
    @FormUrlEncoded
    Call<BaseModel> UpDateCartNum(@Field(Constant.KEY_VERSION) String version, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_DATA) String data,
                                       @Header(Constant.API_KEY) String apikey);
}
