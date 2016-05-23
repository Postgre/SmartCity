package com.smartcity.utils;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CovertUtils.java
 * @author: fengliang
 * @date: 2016-05-12 16:42
 */
public class CovertUtils {
    private static final String TAG = "CovertUtils";

    public static List<String> getListByResource(Context context, int resId) {
        List<String> list = new ArrayList<>();
        String[] array = context.getResources().getStringArray(resId);
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
}
