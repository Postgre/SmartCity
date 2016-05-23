package com.smartcity.view;

/**
 * Created by Yancy on 2016/5/3.
 */
public interface IRegistViews extends BaseViews {

    //获取手机号
    String getPhone();

    //获取密码
    String getPwd();

    //获取确认密码
    String getComPwd();

    //获取验证码
    String getPhoneCode();

    //文本提示
    void setTvHint(String msg);

    //设置是否可点击
    void setTvClickable(boolean isClick);

    //显示提示
    void showMessage(String msg);

}
