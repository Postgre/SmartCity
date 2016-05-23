package com.smartcity.config;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: Url.java
 * @author: fengliang
 * @date: 2016-04-30 16:44
 */
public class Url {
    //登录
    public static final String LOGIN = "user/login";
    //获取验证码
    public static final String REQ_CODE = "user/reqCode";
    //注册
    public static final String REGISTER = "user/reg";
    //发布炫
    public static final String ADD_COOL = "circle/addCool";
    //查询炫
    public static final String GET_ALL_COOL = "circle/getAllCool";
    //炫详情
    public static final String GET_COOL_DETAIL = "circle/getCBID";
    //我炫的
    public static final String GET_COOL_BY_ME = "circle/getCBUID";
    //编辑炫
    public static final String EDIT_COOL = "circle/uptCool";
    //查询所有圈子
    public static final String GETCIRCLELIST = "circle/getCircleList";
    //我要炫 关注
    public static final String FOCUS_COOL = "circle/addUA";
    //我要炫 取消关注
    public static final String UNFOCUS_COOL = "circle/uptUA";

    /*----------------------------------圈子--------------------------------*/
    //所有圈子
    public static final String ALLCIRCLE = "circle/getCircleList";
    //加入圈子
    public static final String JOINCIRCLE = "circle/applyJoinCircle";
    //我的圈子
    public static final String MYCIRCLE = "circle/getCircleListByUserID";
    //圈子小组
    public static final String MYGROUP = "circle/getCcByEn";
    //圈子活动
    public static final String CIRCLEACTIVITY = "circle/getActivityListByCircleID";
    //圈子通知
    public static final String CIRCLENOTICE = "circle/getInformList";
    //圈子视频
    public static final String CIRCLEVIDEO= "circle/getVideoList";
    //圈子相册
    public static final String CIRCLEPHOTO= "circle/getAlbList";
    //圈子成员
    public static final String CIRCLEPEOPLE = "circle/getAllmembers";
    //退出圈子
    public static final String EDITCIRCLE = "circle/delPerson";
    //根据圈子id查询圈子详情
    public static final String CIRCLEDETAIL = "circle/getCircleByID";

    //根据标签
    public static final String GETLABELS = "circle/getML";

    //根据标签查询圈子列表
    public static final String GETCIRCLELISTBYLABEL = "circle/getCcByEn";


    //获取收货地址列表
    public static final String ALL_LIST_ADDRESS = "shop/recvAddrList";
    //修改或添加  地址列表
    public static final String UPDATE_ADD_ADDRESS = "shop/recvAddrAddOrUpdate";
}
