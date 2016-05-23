package com.smartcity.model.modelImpl;

import android.util.Log;

import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.config.Url;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.model.CircleDetailInfoModel;
import com.smartcity.http.model.LabelBean;
import com.smartcity.http.service.CircleService;
import com.smartcity.model.CircleModel;
import com.smartcity.utils.GsonUtils;
import com.smartcity.utils.NetTool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Administrator on 2016/5/7.
 */
public class CircleModelImpl implements CircleModel {

    private final CircleService circleService;

    public CircleModelImpl() {
        circleService = HttpApi.getInstance().create(CircleService.class);
    }

    @Override
    public boolean isNetState() {
        return NetTool.isNetworkAvailable(MyApplication.getInstance());
    }

    /*-----------------------------查询全部圈子-------------------------------------------*/

    @Override
    public void getCircles(String apikey, String sStartpage, String sPagerows, String sPersonUserId, final CircleModelImpl.onLoadCircleListListener listener) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("sStartpage", sStartpage);
        parameter.put("sPagerows", sPagerows);
        parameter.put("sPersonUserId", sPersonUserId);
        Call<CircleBean> call = circleService.getAllCircles(apikey, Url.CIRCLEDETAIL, Constant.VALUE_VERSION, GsonUtils.objectToJson(parameter));
        call.enqueue(new Callback<CircleBean>() {
            @Override
            public void onResponse(Response<CircleBean> response, Retrofit retrofit) {
                CircleBean entity = response.body();
                if (entity.getCode() == Constant.STATUS_SUCCESS) {
                    if (null != entity) {
                        listener.onGetCirclesSuccess(entity.getData());
                    } else {
                        listener.onGetCirclesFailure(entity.getMsg());
                    }
                }

            }

            @Override
            public void onFailure(Throwable t) {
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
        circleService.getCircleDetail(key, Url.CIRCLEDETAIL, Constant.VALUE_VERSION, GsonUtils.objectToJson(pams)).enqueue(new Callback<CircleDetailInfoModel>() {
            @Override
            public void onResponse(Response<CircleDetailInfoModel> response, Retrofit retrofit) {
                if (null != response && null != response.body()) {
                    CircleDetailInfoModel info = response.body();
                    if (null != info) {
                        if (info.getCode() == Constant.STATUS_SUCCESS) {
                            callback.onSuccess(info);
                        } else {
                            callback.onError(info.getMsg() + "");
                        }
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Throwable t) {
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

        circleService.getLabels(apikey, Url.GETLABELS, Constant.VALUE_VERSION, GsonUtils.objectToJson(pam)).enqueue(new Callback<LabelBean>() {
            @Override
            public void onResponse(Response<LabelBean> response, Retrofit retrofit) {
                LabelBean labelBean = response.body();
                Log.d("CircleModelImpl", "labelBean:" + labelBean);

                if (null != labelBean) {
                    if (labelBean.getCode() == Constant.STATUS_SUCCESS) {
                        listener.onSuccess(labelBean.getData());
                    } else {
                        listener.onError(labelBean.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
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

        circleService.getCircleListByLabel(apikey, Url.GETCIRCLELISTBYLABEL, Constant.VALUE_VERSION, GsonUtils.objectToJson(pam)).enqueue(new Callback<CircleBean>() {
            @Override
            public void onResponse(Response<CircleBean> response, Retrofit retrofit) {

                Log.d("getCirclesByLabel", "response.body():" + response.body().getCode());
                CircleBean circleBean = response.body();
                if (null != circleBean) {
                    if (circleBean.getCode() == Constant.STATUS_SUCCESS) {
                        listener.onLoadCirclesListSuccess(circleBean.getData());
                    } else {
                        listener.onLoadCirclesListError(circleBean.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onLoadCirclesListError(t.getMessage());
            }
        });
    }

    public interface onLoadCirclesByLabel {
        void onLoadCirclesListSuccess(List<CircleBean.CirDataEntity> result);

        void onLoadCirclesListError(String msg);
    }

    /*--------------------------我的圈子------------------------------------------------*/

    @Override
    public void getMyCircle(String apikey, String personUserId, String sStartpage, String sPagerows, final onLoadMyCircle listener) {
        Map<String, Object> pam = new HashMap<>();
        pam.put("personUserId", personUserId);
        pam.put("sStartpage", sStartpage);
        pam.put("sPagerows", sPagerows);

        circleService.getMyCircle(apikey, Url.MYCIRCLE, Constant.VALUE_VERSION, GsonUtils.objectToJson(pam)).enqueue(new Callback<CircleBean>() {
            @Override
            public void onResponse(Response<CircleBean> response, Retrofit retrofit) {

//                Log.e("getMyCircle", "response.body():" + response.body().getCode());
                CircleBean circleBean = response.body();
                if (null != circleBean) {
                    if (circleBean.getCode() == Constant.STATUS_SUCCESS) {
                        listener.onLoadMyCirclesSuccess(circleBean.getData());
                    } else {
                        listener.onLoadMyCirclesError(circleBean.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onLoadMyCirclesError(t.getMessage());
            }
        });
    }

    public interface onLoadMyCircle {
        void onLoadMyCirclesSuccess(List<CircleBean.CirDataEntity> result);

        void onLoadMyCirclesError(String msg);
    }

//     /*--------------------------圈子小组------------------------------------------------*/
//
//    @Override
//    public void getMyGroup(String apikey, String detailPid, String sStartpage, String sPagerows, final onLoadMyGroup listener) {
//        Map<String, Object> pam = new HashMap<>();
//        pam.put("detailPid", detailPid);
//        pam.put("sStartpage", sStartpage);
//        pam.put("sPagerows", sPagerows);
//
//        circleService.getCircleGroup(apikey, Url.MYGROUP, Constant.VALUE_VERSION, GsonUtils.objectToJson(pam)).enqueue(new Callback<CircleBean>() {
//            @Override
//            public void onResponse(Response<CircleBean> response, Retrofit retrofit) {
//
//                Log.e("getMyCircle", "response.body():" + response.body().getCode());
//                CircleBean circleBean = response.body();
//                if (null != circleBean) {
//                    if (circleBean.getCode() == Constant.STATUS_SUCCESS) {
//                        listener.onLoadMyGroupSuccess(circleBean.getData());
//
//                    } else {
//                        listener.onLoadMyGroupError(circleBean.getMsg());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                listener.onLoadMyGroupError(t.getMessage());
//            }
//        });
//    }
//    public interface onLoadMyGroup {
//        void onLoadMyGroupSuccess(List<CircleBean.CirDataEntity> result);
//
//        void onLoadMyGroupError(String msg);
//    }
}
