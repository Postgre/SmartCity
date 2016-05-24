package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.UserInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 登录服务
 *
 * @version V2.0
 * @FileName: LoginService.java
 * @author: fengliang
 * @date: 2016-04-29 16:41
 */
public interface LoginService {
    //登录
    String LOGIN = "user/login";

    @FormUrlEncoded
    @POST(Constant.REST)
    Call<UserInfo> login(@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

}
