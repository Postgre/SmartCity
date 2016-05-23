package com.smartcity.view;

import com.smartcity.http.model.UserInfo;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: ILoginView.java
 * @author: fengliang
 * @date: 2016-04-30 12:52
 */
public interface ILoginView {
    void showProgress();

    void hideProgress();

    void showHintMsg(String msg);

    void showLoginInfo(UserInfo userInfo);

    void showFailMsg(String msg);

    String getUserName();

    String getPassword();

    void setResult();

    void finishActivity();

    void loginToYunxin(String loginName, String password);
}
