package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.CartInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface CartService {
    //购物城列表
    String ALL_PRODUCT = "shop/shopCartList";

    /**
     * 地址列表
     */
    @POST(ALL_PRODUCT)
    @FormUrlEncoded
    Call<CartInfo> getAllProduct(@Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data, @Header(Constant.API_KEY) String apikey);
}
