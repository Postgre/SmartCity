package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.AddCoolInfo;
import com.smartcity.http.model.CoolDetailInfo;
import com.smartcity.http.model.CoolInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;


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
    String ADD_COOL = "circle/addCool";
    //查询炫
    String GET_ALL_COOL = "circle/getAllCool";
    //炫详情
    String GET_COOL_DETAIL = "circle/getCBID";
    //我炫的
    String GET_COOL_BY_ME = "circle/getCBUID";
    //编辑炫
    String EDIT_COOL = "circle/uptCool";
    //我要炫 关注
    String FOCUS_COOL = "circle/addUA";
    //我要炫 取消关注
    String UNFOCUS_COOL = "circle/uptUA";

    //发布炫
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<AddCoolInfo> addCool(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

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
