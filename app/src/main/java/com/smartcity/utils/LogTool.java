package com.smartcity.utils;

import android.util.Log;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: LogTool.java
 * @author: fengliang
 * @date: 2016-04-30 17:16
 */
public class LogTool {
    private static final String TAG = "LogTool";

    public LogTool() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isDebug = true;//是否需要打印BUG，可以在application的onCreate函数里面初始化

    public static void i(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
        }
    }

    public static void v(String msg) {
        if (isDebug) {
            Log.v(TAG, msg);
        }
    }

    //下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }
}
