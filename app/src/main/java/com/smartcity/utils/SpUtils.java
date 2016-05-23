package com.smartcity.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/4/5.
 */
public  class SpUtils {

    private static final String KEY_USER_ACCOUNT = "account";//网易云信account
    private static final String KEY_USER_TOKEN = "token";//登录成功后服务端返回的token
    private static final String ISLOGINYX = "isloginyx";

    public static void saveUserAccount(String account) {
        saveString(KEY_USER_ACCOUNT, account);
    }

    public static String getUserAccount() {
        return getString(KEY_USER_ACCOUNT);
    }

    public static void saveUserToken(String token) {
        saveString(KEY_USER_TOKEN, token);
    }

    public  static  void saveIsLoginYx(Boolean bool){
        saveBoolen(ISLOGINYX,bool);
    }

    public static Boolean getIsloginyx() {
        return getBol(ISLOGINYX);
    }

    public static String getUserToken() {
        return getString(KEY_USER_TOKEN);
    }

    private static void saveString(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.commit();
    }
    private static void saveBoolen(String key, Boolean value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    private static String getString(String key) {
        return getSharedPreferences().getString(key, null);
    }
    private static Boolean getBol(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }

    static SharedPreferences getSharedPreferences() {
        return DemoCache.getContext().getSharedPreferences("Demo", Context.MODE_PRIVATE);
    }

}
