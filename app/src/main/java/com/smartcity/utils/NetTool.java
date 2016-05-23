package com.smartcity.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: NetTool.java
 * @author: fengliang
 * @date: 2016-05-20 16:32
 */
public class NetTool {
    private static final String TAG = "NetTool";


    /**
     * 判断数据网络/WIFI是否连接
     *
     * @param mContext
     * @return
     */
    public static boolean isNetworkAvailable(Context mContext) {
        boolean netStatus = false;
        try {
            ConnectivityManager connectManager = (ConnectivityManager) mContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectManager
                    .getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()
                        && activeNetworkInfo.isConnected()) {
                    netStatus = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return netStatus;
    }


}
