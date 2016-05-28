package com.smartcity.model.modelImpl;

import android.util.Log;

import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.ApplyCircleInfo;
import com.smartcity.http.service.CircleService;
import com.smartcity.model.CircleConfigModel;
import com.smartcity.utils.GsonUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/5/24.
 */
public class CircleConfigModelImpl extends BaseModelImpl implements CircleConfigModel {

    private final CircleService circleService;

    public CircleConfigModelImpl() {

        circleService = HttpApi.getInstance().create(CircleService.class);
    }

    @Override
    public boolean isNetState() {
        return super.isNetState();
    }

    /*---------------------申请加入圈子----------------------------------------*/

    @Override
    public void applyJoinCircle(String apikey, String applyCircleId, String applyUserId,  final OnApplyJoinCircleListener listener) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("applyCircleId", applyCircleId);
        parameter.put("applyUserId", applyUserId);

        Log.d("CircleConfigModelImpl", GsonUtils.objectToJson(parameter));

        circleService.applyJoinCircle(apikey, circleService.APPLYJIONCIRCLE, Constant.VALUE_VERSION, GsonUtils.objectToJson(parameter)).enqueue(new Callback<ApplyCircleInfo>() {
            @Override
            public void onResponse(Call<ApplyCircleInfo> call, Response<ApplyCircleInfo> response) {
                ApplyCircleInfo applyCircleInfo = response.body();
                if (null != applyCircleInfo) {
                    Log.d("CircleConfigModelImpl", applyCircleInfo.toString());

                    if (applyCircleInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                        listener.applyJoinCircleSuccess(applyCircleInfo.getMsg());
                    } else {
                        listener.applyCircleFailure(applyCircleInfo.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<ApplyCircleInfo> call, Throwable t) {
                listener.applyCircleFailure(t.getMessage());
            }
        });
    }

    /*----------------------------加入圈子----------------------------------*/
    @Override
    public void joinCircle(String apikey, String personCircleId, String personUserId, final OnApplyJoinCircleListener listener) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("personCircleId", personCircleId);
        parameter.put("personUserId", personUserId);
        parameter.put("personJob", "2");

        Log.d("CircleConfigModelImpl", GsonUtils.objectToJson(parameter));

        circleService.applyJoinCircle(apikey, circleService.JIONCIRCLE, Constant.VALUE_VERSION, GsonUtils.objectToJson(parameter)).enqueue(new Callback<ApplyCircleInfo>() {
            @Override
            public void onResponse(Call<ApplyCircleInfo> call, Response<ApplyCircleInfo> response) {
                ApplyCircleInfo applyCircleInfo = response.body();
                if (null != applyCircleInfo) {
                    Log.d("CircleConfigModelImpl", applyCircleInfo.toString());

                    if (applyCircleInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                        listener.applyJoinCircleSuccess(applyCircleInfo.getMsg());
                    } else {
                        listener.applyCircleFailure(applyCircleInfo.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<ApplyCircleInfo> call, Throwable t) {
                listener.applyCircleFailure(t.getMessage());
            }
        });
    }

    public interface OnApplyJoinCircleListener {
        void applyJoinCircleSuccess(String msg);

        void applyCircleFailure(String msg);
    }
}
