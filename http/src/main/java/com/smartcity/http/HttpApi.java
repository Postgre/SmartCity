package com.smartcity.http;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: HttpApi.java
 * @author: fengliang
 * @date: 2016-04-29 16:00
 */
public class HttpApi {
    private static final String TAG = HttpApi.class.getName();
    private final OkHttpClient okHttpClient;

    private static final int TIMEOUT_READ = 25;
    private static final int TIMEOUT_CONNECTION = 25;
    private static HttpApi instance;
    private Retrofit retrofit;

    private HttpApi() {
        okHttpClient = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor())
                .retryOnConnectionFailure(true)
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS).
                        build();
        retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
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
