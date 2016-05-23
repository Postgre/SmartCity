package com.smartcity.model;


import com.smartcity.model.modelImpl.RegistModelImpl;

/**
 * Created by Yancy on 2016/5/3.
 */
public interface RegistModel extends BaseModel {

    /**
     * 获取验证码、
     *
     * @param phone    手机号
     * @param callback 结果返回回调
     */
    void getNewCode(String phone, RegistModelImpl.RegistNewCodeCallback callback);


    void regist(String usercode, String pwd, String captcha, RegistModelImpl.RegistCallBack callBack);
}
