package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.CircleBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;


/**
 * Created by Administrator on 2016/5/11.
 */
public interface SearchService {
    String GETCIRCLELIST = "getCircleByCircleName";

    @FormUrlEncoded
    @POST(GETCIRCLELIST)
    Call<CircleBean> getSearchData(@Header(Constant.API_KEY) String apikey, @Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);
}
