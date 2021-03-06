package com.smartcity.http.service;

import com.smartcity.http.Constant;
import com.smartcity.http.model.ActivityModel;
import com.smartcity.http.model.ApplyCircleInfo;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.model.CircleByLabel;
import com.smartcity.http.model.CircleDetailInfoModel;
import com.smartcity.http.model.CircleGroupInfo;
import com.smartcity.http.model.CircleGroup_bean;
import com.smartcity.http.model.CircleNotice;
import com.smartcity.http.model.CircleVideo;
import com.smartcity.http.model.Circle_PeopleBean;
import com.smartcity.http.model.LabelBean;
import com.smartcity.http.model.Model;
import com.smartcity.http.model.NewCircleListInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Created by Administrator on 2016/5/6.
 */
public interface CircleService {

    //所有圈子
    String ALLCIRCLE = "circle/getCircleList" ;
    //加入圈子
    String JOINCIRCLE = "circle/applyJoinCircle" ;
    //我的圈子
    String MYCIRCLE = "circle/getCircleListByUserID" ;
    //圈子小组
    String MYGROUP = "circle/getCcByEn" ;
    //圈子活动
    String CIRCLEACTIVITY = "circle/getActivityListByCircleID" ;
    //圈子通知
    String CIRCLENOTICE = "circle/getInformList" ;
    //圈子视频
    String CIRCLEVIDEO = "circle/getVideoList" ;
    //圈子相册
    String CIRCLEPHOTO = "circle/getAlbList" ;
    //圈子成员
    String CIRCLEPEOPLE = "circle/getAllmembers" ;
    //退出圈子
    String EDITCIRCLE = "circle/delPerson" ;
    //根据圈子id查询圈子详情
    String CIRCLEDETAIL = "circle/getCircleByID" ;
    //根据标签查询圈子列表
    String GETCIRCLELISTBYLABEL = "circle/getCcByEn" ;

    //根据标签
    String GETLABELS = "circle/getML" ;

    //申请加入圈子
    String APPLYJIONCIRCLE = "circle/applyJoinCircle" ;

    //加入圈子
    String JIONCIRCLE = "circle/addPerson" ;

    //查询圈子下面的组
    String GETCIRLCELISTBYPID = "circle/getCirlceListByPid" ;


    // 圈子活动
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<NewCircleListInfo> getMyCircleList(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    // 圈子通知
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CircleNotice> getCircleNotice(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    // 圈子视频
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CircleVideo> getCircleVideo(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //加入圈子
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<Model> getCircle_join(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //我的圈子
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CircleBean> getMyCircle(@Header(Constant.API_KEY) String apikey,  @Field(Constant.CMD) String cmd,@Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //圈子小组
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CircleGroup_bean> getCircleGroup(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //圈子成员
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<Circle_PeopleBean> getCircle_People(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //退出圈子
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<Model> getExit(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd,@Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    //根据圈子id获取活动列表
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<ActivityModel> getActivityListById(@Header(Constant.API_KEY) String apikey,
                                            @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION)
                                            String version, @Field(Constant.KEY_DATA) String data);

    //根据圈子id查询圈子详情
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CircleDetailInfoModel> getCircleDetail(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION)
    String version, @Field(Constant.KEY_DATA) String data);

    /*查询全部圈子*/
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CircleBean> getAllCircles(@Header(Constant.API_KEY) String apikey,@Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    /*查询全部标签*/
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<LabelBean> getLabels(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    /*-----------------------根据标签查对应圈子列表----------------------*/
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded;charset=utf-8")
    @POST(Constant.REST)
    Call<CircleByLabel> getCircleListByLabel(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

    /*申请加入圈子*/
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<ApplyCircleInfo> applyJoinCircle(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);


    /*查询圈子下面的小组*/
    @FormUrlEncoded
    @POST(Constant.REST)
    Call<CircleGroupInfo> getGroupsForCircle(@Header(Constant.API_KEY) String apikey, @Field(Constant.CMD) String cmd, @Field(Constant.KEY_VERSION) String version, @Field(Constant.KEY_DATA) String data);

}
