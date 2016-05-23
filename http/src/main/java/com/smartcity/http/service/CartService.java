package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.CartInfo;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface CartService {

    /**
     * 购物城列表
     * */
    String ALL_PRODUCT ="shop/shopCartList";
    /**
     * 地址列表
     * */
    @POST("/zxcity_restful/ws/rest")
    @FormUrlEncoded
    Call<CartInfo> getAllProduct(@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION)String version, @Field(Constant.KEY_DATA)String data, @Header(Constant.API_KEY)String apikey);
}
