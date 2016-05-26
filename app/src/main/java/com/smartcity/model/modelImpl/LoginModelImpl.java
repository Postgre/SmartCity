package com.smartcity.model.modelImpl;

import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.UserInfo;
import com.smartcity.http.service.LoginService;
import com.smartcity.model.LoginModel;
import com.smartcity.utils.GsonUtils;
import com.smartcity.utils.LogTool;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: LoginModelImpl.java
 * @author: fengliang
 * @date: 2016-04-30 11:21
 */
public class LoginModelImpl extends BaseModelImpl implements LoginModel {
    private static final String TAG = LoginModelImpl.class.getName();

    @Override
    public boolean isNetState() {
        return super.isNetState();
    }

    @Override
    public void login(String userName, String pwd, final LoginCallBack callback) {
        LoginService loginService = HttpApi.getInstance().create(LoginService.class);
        Map<String, Object> params = new HashMap<>();
        params.put("usercode", userName);
        params.put("password", pwd);
        LogTool.d(TAG, "params:" + GsonUtils.objectToJson(params));
        Call<UserInfo> loginCall = loginService.login(LoginService.LOGIN, Constant.VALUE_VERSION, GsonUtils.objectToJson(params));
        loginCall.enqueue(new Callback<UserInfo>() {

            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                UserInfo userInfo = response.body();
                if (null != userInfo) {
                    if (userInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                        callback.onSuccess(userInfo);
                    } else {
                        callback.onFailure(userInfo.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public interface LoginCallBack {
        void onSuccess(UserInfo userInfo);

        void onFailure(String msg);
    }

}
