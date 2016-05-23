package com.smartcity.model;

import com.smartcity.model.modelImpl.CoolModelImpl;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CoolModel.java
 * @author: fengliang
 * @date: 2016-05-04 16:30
 */
public interface CoolModel extends BaseModel {
    void addCool(String key, String url, String version, String data, CoolModelImpl.AddCoolCallBack callBack);

    void getAllCool(String key, String url, String version, String data, CoolModelImpl.GetAllCoolCallBack callBack);

    void getCoolDetail(String key, String url, String version, String data, CoolModelImpl.GetCoolDetailCallBack callBack);

    void getCoolByMe(String key, String url, String version, String data, CoolModelImpl.GetCoolByMeCallBack callBack);

    void editCool(String key, String url, String version, String data, CoolModelImpl.EditCoolCallBack callBack);

    void focusCool(String key, String url, String version, String data, CoolModelImpl.FocusCallBack callBack);

    void unFocusCool(String key, String url, String version, String data, CoolModelImpl.FocusCallBack callBack);
}
