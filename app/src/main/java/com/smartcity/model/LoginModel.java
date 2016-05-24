package com.smartcity.model;

import com.smartcity.model.modelImpl.LoginModelImpl;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: LoginModel.java
 * @author: fengliang
 * @date: 2016-04-30 11:19
 */
public interface LoginModel extends BaseModel {
    void login(String userName, String pwd, LoginModelImpl.LoginCallBack callBack);
}
