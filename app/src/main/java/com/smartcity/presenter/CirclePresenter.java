package com.smartcity.presenter;

/**
 * Created by Administrator on 2016/5/13.
 */
public interface CirclePresenter {

    void loadCircleDetail(String detailId);

    void getDetail(String apikey,int detailId);
    void getLabels(String apikey, String sStartpage, String sPagerows);

    void getCircles(String apikey,String sStartpage,String sPagerows,String sPersonUserId);
    void getCircleListByLabel(String apikey, String detailMarkName, String sStartpage, String sPagerows);
//    void getCircleListByLabel(String apikey, String sStartpage, String sPagerows);

    void getMyCircle(String apikey,String personUserId,String sPagerows,String sPersonUserId);
//    void getMyGroup(String apikey,String detailPid,String sPagerows,String sPersonUserId);
}
