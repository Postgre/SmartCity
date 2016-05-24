package com.smartcity.http.service;

import com.smartcity.http.Constant;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: UploadService.java
 * @author: fengliang
 * @date: 2016-05-23 15:47
 */
public interface UploadService {
    @Multipart
    @POST(Constant.REST)
    void upload(@Header(Constant.API_KEY) String apikey,
                @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @PartMap Map<String, RequestBody> params);
}
