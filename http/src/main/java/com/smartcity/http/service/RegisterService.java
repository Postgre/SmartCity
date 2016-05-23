package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.BaseModel;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: RegisterService.java
 * @author: fengliang
 * @date: 2016-04-30 17:30
 */
public interface RegisterService {
    //获取验证码
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<Object> getNewCode(@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    //获取验证码
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<BaseModel> regist(@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);
}
