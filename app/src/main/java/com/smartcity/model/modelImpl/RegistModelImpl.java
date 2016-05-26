package com.smartcity.model.modelImpl;

import com.smartcity.config.Constant;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.BaseModel;
import com.smartcity.http.service.RegisterService;
import com.smartcity.model.RegistModel;
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
 * @FileName: RegistModelImpl.java
 * @author: fengliang
 * @date: 2016-05-20 15:21
 */
public class RegistModelImpl extends BaseModelImpl implements RegistModel {
    private static final String TAG = "RegistModelImpl";
    private final RegisterService service;

    public RegistModelImpl() {
        service = HttpApi.getInstance().create(RegisterService.class);
    }

    @Override
    public boolean isNetState() {
        return super.isNetState();
    }

    @Override
    public void getNewCode(String phone, final RegistNewCodeCallback callback) {
        Map<String, Object> params = new HashMap<>();
        params.put("usercode", phone);
        LogTool.d(TAG, "data:" + GsonUtils.objectToJson(params));
        service.getNewCode(RegisterService.REQ_CODE, Constant.VERSION_CODE, GsonUtils.objectToJson(params)).enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (null != response && null != response.body()) {
                    if (null != callback) {
                        callback.success(response.body().toString());
                    }
                } else {
                    if (null != callback) {
                        callback.errorEmpty();
                    }
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                if (null != callback) {
                    callback.success(t.getMessage());
                }
            }
        });
    }

    @Override
    public void regist(String usercode, String pwd, String captcha, final RegistCallBack callBack) {
        Map<String, Object> params = new HashMap<>();
        params.put("usercode", usercode);
        params.put("captcha", captcha);
        params.put("password", pwd);
        service.register(RegisterService.REGISTER, Constant.VERSION_CODE, GsonUtils.objectToJson(params)).enqueue(new Callback<BaseModel>() {

            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                if (null != response && null != response.body()) {
                    if (null != callBack) {
                        callBack.registSuccess(response.body());
                    }
                } else {
                    if (null != callBack) {
                        callBack.registError(null);
                    }

                }
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                if (null != callBack) {
                    callBack.registError(t.getMessage());
                }
            }
        });
    }

    public interface RegistNewCodeCallback {
        void success(String code);

        void error(String msg);

        void errorEmpty();
    }

    public interface RegistCallBack<T> {
        void registSuccess(T result);

        void registError(String msg);
    }
}
