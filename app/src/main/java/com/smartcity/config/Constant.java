package com.smartcity.config;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: Constant.java
 * @author: fengliang
 * @date: 2016-04-30 16:43
 */
public class Constant {

    public static final String KEY = "Item";

    public static final int TYPE_IMG = 1;//炫 图片
    public static final int TYPE_VIDEO = 2;//炫 视频

    public static final String LOGINNAME = "loginname";

    public static final String SP_FILE_NAME = "SP_SMARTCITY";
    public static final String USER_NAME = "userName";
    public static final String CMD = "cmd";
    public static final String KEY_VERSION = "version";
    public static final String KEY_DATA = "data";
    public static final String VERSION_CODE = "1";
    public static final String VALUE_VERSION = "1";
    public static final String BASE_URL = "http://192.168.3.61:8080";
    public static final String USER_CODE = "usercode";
    public static final String PWD = "password";
    public static final String API_KEY = "apikey";
    public static final String ID = "id";
    public static final String LOCAL_FOLDER_NAME = "local_folder_name";//跳转到相册页的文件夹名称
    public static final String CITY = "city";
    public static final String CITY_CODE = "citycode";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String DISTRICT = "district";

    public static final String COOLID = "coolId";


    //手机号正则
    public static String MATCHES_PHONE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";


    public static class DbInfo {

        public static final String DATABASE_NAME = "smart_city";
        public static final int DATABASE_VERSION = 1;

        public static final String USER_TABLE_SQL = "CREATE TABLE userinfo(_id INTEGER PRIMARY KEY  ,id INTEGER ,usercode TEXT,username TEXT ,userpassword TEXT ,userpic TEXT,usersex TEXT,userbirth TEXT ,residence TEXT,signature TEXT,userversion TEXT,boolean,messagenotify INTEGER)";
        public static final String USER_TABLE_NAME = "userinfo";
    }


    public static class TableUserInfo {
        public static final String COLUMN_USER_CODE = "usercode";
        public static final String COLUMN_USER_NAME = "username";
        public static final String COLUMN_USER_PASSWORD = "userpassword";
        public static final String COLUMN_USER_PRICE = "userpic";
        public static final String COLUMN_USER_SEX = "usersex";
        public static final String COLUMN_USER_BIRTH = "userbirth";
        public static final String COLUMN_USER_VERSION = "userversion";
        public static final String COLUMN_USER_RESIDENCE = "residence";
        public static final String COLUMN_USER_SIGNATURE = "signature";

        public static final String COLUMN_USER_ID = "id";
        public static final String QUERY_USER_INFO = "SELECT * FROM " + DbInfo.USER_TABLE_NAME + " where " + TableUserInfo.COLUMN_USER_ID + " = ?";
        public static final String UPDATA_BY_ID = " id = ?";
        public static final String DELETE_BY_ID = " id = ?";
        public static final String COLUMN_USER_MESSAGE_NOTIFY = "messagenotify";
        public static final String QUERY_USER_MESSAGE_NOTIFY = "SELECT " + COLUMN_USER_MESSAGE_NOTIFY + " FROM " + DbInfo.USER_TABLE_NAME + " where " + TableUserInfo.COLUMN_USER_ID + " = ?";
    }

    public static class UserInfo {

        //修改信息字段 key
        public static final String UPDATA_KEY_IMG = "userpic";
        public static final String UPDATA_KEY_ADDRESS = "residence";
        public static final String UPDATA_KEY_NICK_NAME = "username";
        public static final String UPDATA_KEY_SIGN = "signature";
        public static final String UPDATA_KEY_SEX = "usersex";

        //修改字段类型
        public static final int UPDATA_IMG = 0x10;
        public static final int UPDATA_ADDRESS = 0x11;
        public static final int UPDATA_NICK_NAME = 0x12;
        public static final int UPDATA_SIGN = 0x13;
        public static final int UPDATA_SEX = 0x14;

    }

    public static final class LifeClassify {
        //健康养生
        public static final int HEALTHCARE = 1;

        //潮流鞋包
        public static final int FASHIONSHOE = 2;

        //时尚服饰
        public static final int FASHIONAPPAREA = 3;

        //箱包珠宝
        public static final int LUGGAGEJEWELRY = 4;

        //酒水饮料
        public static final int DRINKS = 5;

        //美容美体
        public static final int BEAUTY = 6;

        //活色生鲜
        public static final int FRESHLVING = 7;

        //家居家纺
        public static final int HOMETEXTILE = 8;

        //母婴玩具
        public static final int BABYTOYS = 9;

        //全部分类
        public static final int ALLCLASSIFY = 10;

    }
}
