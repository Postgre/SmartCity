package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.ServiceRecommendBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by chenyuan on 2016/5/24.
 */
public interface CallService {

    String SERVICE_FENNEI = "service/getRecommend";

    //呼叫服务主页面的分类
    @FormUrlEncoded
    @GET(SERVICE_FENNEI)
    Call<ServiceRecommendBean> getServiceRecommend(@Header(Constant.API_KEY) String apikey, @Field(Constant.KEY_VERSION)
    String version);

}
