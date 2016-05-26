package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.AddressList;
import com.smartcity.http.model.BaseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Created by Yancy on 2016/5/16.
 */
public interface AddressService {

    //获取收货地址列表
    String ALL_LIST_ADDRESS = "shop/recvAddrList";
    //修改或添加  地址列表
    String UPDATE_ADD_ADDRESS = "shop/recvAddrAddOrUpdate";

    //删除  地址列表
    String DELETE_ADDRESS = "shop/recvAddrDel";
    /**
     * 地址列表
     */
    @POST(Constant.REST)
    @FormUrlEncoded
    Call<AddressList> getAllList(@Field(Constant.KEY_VERSION) String version,@Field(Constant.CMD)String cmd, @Field(Constant.KEY_DATA) String data, @Header(Constant.API_KEY) String apikey);

    @POST(Constant.REST)
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded;charset=utf-8")
    Call<BaseModel> updateOrAddAddress(@Field(Constant.KEY_VERSION) String version,@Field(Constant.CMD)String cmd, @Field(Constant.KEY_DATA) String data, @Header(Constant.API_KEY) String apikey);

    @POST(Constant.REST)
    @FormUrlEncoded
    Call<BaseModel> deleteAddAddressById(@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data, @Header(Constant.API_KEY) String apikey);
}
