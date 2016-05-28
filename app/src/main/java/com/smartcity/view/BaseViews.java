package com.smartcity.view;

/**
 * Created by Yancy on 2016/4/18.
 */
public interface BaseViews {

    void showLoading(String msg);

    void hideLoading();

    void showEmpty();

    void hideEmpty();

    void showToast(String msg);

    void showToast(int msg);

}
