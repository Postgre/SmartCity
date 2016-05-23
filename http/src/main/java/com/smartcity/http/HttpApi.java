package com.smartcity.http;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: HttpApi.java
 * @author: fengliang
 * @date: 2016-04-29 16:00
 */
public class HttpApi {
    private static final String TAG = "HttpApi";

    private static HttpApi instance;
    private Retrofit retrofit;

    private HttpApi() {
        retrofit = new Retrofit.Builder().baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static HttpApi getInstance() {
        if (instance == null) {
            synchronized (HttpApi.class) {
                if (instance == null) {
                    instance = new HttpApi();
                }
            }
        }
        return instance;
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
