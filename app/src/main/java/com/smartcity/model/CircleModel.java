package com.smartcity.model;

import com.smartcity.model.modelImpl.CircleModelImpl;

/**
 * Created by Administrator on 2016/5/7.
 */
public interface CircleModel extends BaseModel {

    void getCircles(String apikey, String sStartpage, String sPagerows, String sPersonUserId, CircleModelImpl.onLoadCircleListListener listener);

    /*
     圈子详情
     */
    void getDetail(String key, int detailId, CircleModelImpl.CircleDetailCallback callback);

    /*获取热门标签*/
    void getHotLabels(String apikey, String sStartpage, String sPagerows, CircleModelImpl.onLoadHotLabelsListener listener);

    /*根据标签名称获取对应圈子列表数据*/
    void getCirclesByLabelContent(String apikey, String detailMarkName, String sStartpage, String sPagerows, CircleModelImpl.onLoadCirclesByLabel listener);

    /*我的圈子*/
    void getMyCircle(String apikey, String personUserId, String sStartpage, String sPagerows, CircleModelImpl.onLoadMyCircle listener);

//    /*我的圈子*/
//    void getMyGroup(String apikey, String detailPid,String sStartpage,String sPagerows,CircleModelImpl.onLoadMyCircle listener);
}
