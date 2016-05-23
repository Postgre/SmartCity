package com.smartcity.model.modelImpl;

import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.UserInfo;
import com.smartcity.http.service.LoginService;
import com.smartcity.model.LoginModel;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.NetTool;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: LoginModelImpl.java
 * @author: fengliang
 * @date: 2016-04-30 11:21
 */
public class LoginModelImpl implements LoginModel {
    private static final String TAG = LoginModelImpl.class.getName();

    @Override
    public boolean isNetState() {
        return NetTool.isNetworkAvailable(MyApplication.getInstance());
    }

    @Override
    public void login(String url, String version, String data, final LoginCallBack callback) {
        LoginService loginService = HttpApi.getInstance().create(LoginService.class);
        LogTool.d(TAG, "data:" + data);
        Call<UserInfo> loginCall = loginService.login(url, version, data);
        loginCall.enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Response<UserInfo> response, Retrofit retrofit) {
                UserInfo userInfo = response.body();
                if (null != userInfo) {
                    if (userInfo.getCode() == Constant.STATUS_SUCCESS) {
                        callback.onSuccess(userInfo);
                    } else {
                        callback.onFailure(userInfo.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public interface LoginCallBack {
        void onSuccess(UserInfo userInfo);

        void onFailure(String msg);
    }

}
