package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.UserInfo;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * 登录服务
 *
 * @version V2.0
 * @FileName: LoginService.java
 * @author: fengliang
 * @date: 2016-04-29 16:41
 */
public interface LoginService {

    @FormUrlEncoded
    @POST(Constant.REST)
    Call<UserInfo> login(@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

}
