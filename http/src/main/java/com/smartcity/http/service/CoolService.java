package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.CoolDetailInfo;
import com.smartcity.http.model.CoolInfo;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CoolService.java
 * @author: fengliang
 * @date: 2016-05-12 10:32
 */
public interface CoolService {
    //发布炫
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CoolInfo> addCool(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    //查询炫
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CoolInfo> getAllCool(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    //我炫的
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CoolInfo> getCoolByMe(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    //炫详情
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CoolDetailInfo> getCoolDetail(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    //编辑炫
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CoolInfo> editCool(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    //关注炫
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<String> focusCool(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    //取消关注炫
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<String> unFocusCool(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);
}
