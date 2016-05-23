package com.smartcity.presenter;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: RegistPresenter.java
 * @author: fengliang
 * @date: 2016-05-20 15:34
 */
public interface RegistPresenter {

    void getNewCode(String phone);

    void regist(String usercode, String pwd, String comPwd, String captcha);
}
