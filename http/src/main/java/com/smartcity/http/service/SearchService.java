package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.CircleBean;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by Administrator on 2016/5/11.
 */
public interface SearchService {
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CircleBean> getSearchData(@Header(Constant.API_KEY) String apikey,
                                   @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION)
                                   String version, @Field(Constant.KEY_DATA) String data);
}
