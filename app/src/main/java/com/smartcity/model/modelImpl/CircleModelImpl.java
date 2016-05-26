package com.smartcity.model.modelImpl;

import android.util.Log;

import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.model.CircleByLabel;
import com.smartcity.http.model.CircleDetailInfoModel;
import com.smartcity.http.model.LabelBean;
import com.smartcity.http.service.CircleService;
import com.smartcity.model.CircleModel;
import com.smartcity.utils.GsonUtils;
import com.smartcity.utils.LogTool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2016/5/7.
 */
public class CircleModelImpl extends BaseModelImpl implements CircleModel {
    private static final String TAG = CircleModelImpl.class.getName();

    private final CircleService circleService;

    public CircleModelImpl() {
        circleService = HttpApi.getInstance().create(CircleService.class);
    }

    @Override
    public boolean isNetState() {
        return super.isNetState();
    }

   /*-----------------------------查询全部圈子-------------------------------------------*/

    @Override
    public void getCircles(String apikey, String sStartpage, String sPagerows, String sPersonUserId, final CircleModelImpl.onLoadCircleListListener listener) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("sStartpage", sStartpage);
        parameter.put("sPagerows", sPagerows);
        parameter.put("sPersonUserId", sPersonUserId);
        Call<CircleBean> call = circleService.getAllCircles(apikey, Constant.VALUE_VERSION, GsonUtils.objectToJson(parameter));
        call.enqueue(new Callback<CircleBean>() {

            @Override
            public void onResponse(Call<CircleBean> call, Response<CircleBean> response) {
                CircleBean entity = response.body();
                if (entity.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                    if (null != entity) {
                        listener.onGetCirclesSuccess(entity.getData());
                    } else {
                        listener.onGetCirclesFailure(entity.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<CircleBean> call, Throwable t) {
                listener.onGetCirclesFailure(t.getMessage());
            }
        });
    }

    public interface onLoadCircleListListener {
        void onGetCirclesSuccess(List<CircleBean.CirDataEntity> list);

        void onGetCirclesFailure(String msg);
    }


    /*----------------------查询圈子详细信息----------------------------------------------*/
    @Override
    public void getDetail(String key, int detailId, final CircleDetailCallback callback) {
        Map<String, Object> pams = new HashMap<>();
        pams.put("detailId", detailId);
        circleService.getCircleDetail(key, Constant.VALUE_VERSION, GsonUtils.objectToJson(pams)).enqueue(new Callback<CircleDetailInfoModel>() {

            @Override
            public void onResponse(Call<CircleDetailInfoModel> call, Response<CircleDetailInfoModel> response) {
                if (null != response && null != response.body()) {
                    CircleDetailInfoModel info = response.body();
                    if (null != info) {
                        if (info.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                            callback.onSuccess(info);
                        } else {
                            callback.onError(info.getMsg() + "");
                        }
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<CircleDetailInfoModel> call, Throwable t) {
                if (null != callback) {
                    callback.onError(t.getMessage());
                }
            }
        });
    }

    public interface CircleDetailCallback<T> {
        void onSuccess(CircleDetailInfoModel result);

        void onError(String msg);
    }

    /*--------------------------------获取标签列表----------------------------------------*/
    @Override
    public void getHotLabels(String apikey, String sStartpage, String sPagerows, final onLoadHotLabelsListener listener) {
        Map<String, Object> pam = new HashMap<>();
        pam.put("sStartpage", sStartpage);
        pam.put("sPagerows", sPagerows);
        circleService.getLabels(apikey, circleService.GETLABELS,Constant.VALUE_VERSION, GsonUtils.objectToJson(pam)).enqueue(new Callback<LabelBean>() {
            @Override
            public void onResponse(Call<LabelBean> call, Response<LabelBean> response) {
                LabelBean labelBean = response.body();
                if (null != labelBean) {
                    Log.d("CircleModelImpl", "labelBean:" + labelBean);
                    if (labelBean.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                        listener.onSuccess(labelBean.getData());
                    } else {
                        listener.onError(labelBean.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<LabelBean> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public interface onLoadHotLabelsListener {
        void onSuccess(List<LabelBean.DataEntity> result);

        void onError(String msg);
    }

    /*--------------------------根据标签查询对应圈子列表数据------------------------------------------------*/

    @Override
    public void getCirclesByLabelContent(String apikey, String detailMarkName, String sStartpage, String sPagerows, final onLoadCirclesByLabel listener) {
        Map<String, Object> pam = new HashMap<>();
        pam.put("detailMarkName", detailMarkName);
        pam.put("sStartpage", sStartpage);
        pam.put("sPagerows", sPagerows);

        Log.d("CircleModelImpl", "CircleByLabel:pam" + pam.toString());
        circleService.getCircleListByLabel(apikey, circleService.GETCIRCLELISTBYLABEL,Constant.VALUE_VERSION, GsonUtils.objectToJson(pam)).enqueue(new Callback<CircleByLabel>() {

            @Override
            public void onResponse(Call<CircleByLabel> call, Response<CircleByLabel> response) {
                CircleByLabel circleBean = response.body();
                if (null != circleBean) {
                    Log.e("CircleModelImpl", "CircleByLabel:" + circleBean.toString());
                    if (circleBean.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                        listener.onLoadCirclesListSuccess(circleBean.getData());
                    } else {
                        listener.onLoadCirclesListError(circleBean.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<CircleByLabel> call, Throwable t) {
                listener.onLoadCirclesListError(t.getMessage());
            }
        });
    }

    public interface onLoadCirclesByLabel {
        void onLoadCirclesListSuccess(List<CircleByLabel.DataEntity> result);

        void onLoadCirclesListError(String msg);
    }

    /*--------------------------我的圈子------------------------------------------------*/

    @Override
    public void getMyCircle(String apikey, String personUserId, String sStartpage, String sPagerows, final onLoadMyCircle listener) {
        Map<String, Object> pam = new HashMap<>();
        pam.put("personUserId", personUserId);
        pam.put("sStartpage", sStartpage);
        pam.put("sPagerows", sPagerows);
        LogTool.d(TAG, "params:" + GsonUtils.objectToJson(pam));
        circleService.getMyCircle(apikey, Constant.VALUE_VERSION, GsonUtils.objectToJson(pam)).enqueue(new Callback<CircleBean>() {

            @Override
            public void onResponse(Call<CircleBean> call, Response<CircleBean> response) {
                //                Log.e("getMyCircle", "response.body():" + response.body().getCode());
                CircleBean circleBean = response.body();
                if (null != circleBean) {
                    if (circleBean.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                        listener.onLoadMyCirclesSuccess(circleBean.getData());
                    } else {
                        listener.onLoadMyCirclesError(circleBean.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<CircleBean> call, Throwable t) {
                listener.onLoadMyCirclesError(t.getMessage());
            }
        });
    }

    public interface onLoadMyCircle {
        void onLoadMyCirclesSuccess(List<CircleBean.CirDataEntity> result);

        void onLoadMyCirclesError(String msg);
    }

     /*--------------------------圈子小组------------------------------------------------*/

    @Override
    public void getMyGroup(String apikey, String detailPid, String sStartpage, String sPagerows, onLoadMyCircle listener) {
        Map<String, Object> pam = new HashMap<>();
        pam.put("detailPid", detailPid);
        pam.put("sStartpage", sStartpage);
        pam.put("sPagerows", sPagerows);


    }

    public interface onLoadMyGroup {
        void onLoadMyGroupSuccess(List<CircleBean> result);

        void onLoadMyGroupError(String msg);
    }
}
