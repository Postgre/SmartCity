package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.AddressList;
import com.smartcity.http.model.BaseModel;
import com.squareup.okhttp.internal.Version;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by Yancy on 2016/5/16.
 */
public interface AddressService  {

    String ALL_LIST_CMD ="shop/recvAddrList";
    /**
     * 地址列表
     * */
    @POST("/zxcity_restful/ws/rest")
    @FormUrlEncoded
    Call<AddressList>  getAllList(@Field(Constant.CMD) String cmd,@Field(Constant.KEY_VERSION)String version,@Field(Constant.KEY_DATA)String data,@Header(Constant.API_KEY)String apikey);

    @POST("/zxcity_restful/ws/rest")
    @FormUrlEncoded
    Call<AddressList.LifeAddressModel>  updateOrAddAddress(@Field(Constant.CMD) String cmd,@Field(Constant.KEY_VERSION)String version,@Field(Constant.KEY_DATA)String data,@Header(Constant.API_KEY)String apikey);

    @POST("/zxcity_restful/ws/rest")
    @FormUrlEncoded
    Call<AddressList.LifeAddressModel>  deleteAddAddressById(@Field(Constant.CMD) String cmd,@Field(Constant.KEY_VERSION)String version,@Field(Constant.KEY_DATA)String data,@Header(Constant.API_KEY)String apikey);
}
