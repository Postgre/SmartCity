package com.smartcity.model;

import com.smartcity.model.modelImpl.CircleModelImpl;

/**
 * Created by Administrator on 2016/5/7.
 */
public interface CircleModel extends BaseModel {

    void getCircles(String apikey, String sStartpage, String sPagerows, String sPersonUserId, CircleModelImpl.OnLoadCircleListListener listener);

    /*
     圈子详情
     */
    void getDetail(String key, int detailId, CircleModelImpl.CircleDetailCallback callback);

    /*获取热门标签*/
    void getHotLabels(String apikey, String sStartpage, String sPagerows, CircleModelImpl.OnLoadHotLabelsListener listener);

    /*根据标签名称获取对应圈子列表数据*/
    void getCirclesByLabelContent(String apikey, String detailMarkName, String sStartpage, String sPagerows, CircleModelImpl.OnLoadCirclesByLabel listener);

    /*我的圈子*/
    void getMyCircle(String apikey, String personUserId, String sStartpage, String sPagerows, CircleModelImpl.OnLoadMyCircle listener);

    /*查询圈子小组*/
    void getGroupsListByPid(String apikey, String detailPid, String sStartpage, String sPagerows, CircleModelImpl.OnGetGroupsForCircleListener listener);

    /*查询圈子的所有活动列表*/
    void getActivityList(String apikey, String detailCircleId, String sStartpage,String sPagerows, CircleModelImpl.OnGetActivitiesListener listener );
}
