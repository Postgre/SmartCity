package com.smartcity.http;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: LoggingInterceptor.java
 * @author: fengliang
 * @date: 2016-05-24 10:35
 */
public class LoggingInterceptor implements Interceptor {
    private static final String TAG = LoggingInterceptor.class.getName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        Log.i(TAG, String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        Log.i(TAG, String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        return response;
    }
}
