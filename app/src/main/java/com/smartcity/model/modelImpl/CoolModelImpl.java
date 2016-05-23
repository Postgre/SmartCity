package com.smartcity.model.modelImpl;

import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.CoolDetailInfo;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.http.service.CoolService;
import com.smartcity.model.CoolModel;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.NetTool;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CoolModelImpl.java
 * @author: fengliang
 * @date: 2016-05-04 16:31
 */
public class CoolModelImpl implements CoolModel {
    private static final String TAG = CoolModelImpl.class.getName();
    private CoolService coolService;

    public CoolModelImpl() {
        coolService = HttpApi.getInstance().create(CoolService.class);
    }

    @Override
    public boolean isNetState() {
        return NetTool.isNetworkAvailable(MyApplication.getInstance());
    }

    @Override
    public void addCool(String key, String url, String version, String data, final AddCoolCallBack callBack) {
        LogTool.d(TAG, "data:" + data);
        Call<CoolInfo> addCoolCall = coolService.addCool(key, url, version, data);
        addCoolCall.enqueue(new Callback<CoolInfo>() {
            @Override
            public void onResponse(Response<CoolInfo> response, Retrofit retrofit) {
                CoolInfo coolInfo = response.body();
                if (null != coolInfo) {
                    if (coolInfo.getCode() == Constant.STATUS_SUCCESS) {
                        callBack.onAddCoolSuccess(coolInfo);
                    } else {
                        callBack.onAddCoolFailure(coolInfo.getMsg());
                    }
                }

            }

            @Override
            public void onFailure(Throwable t) {
                callBack.onAddCoolFailure(t.getMessage());
            }
        });
    }

    @Override
    public void getAllCool(String key, String url, String version, String data, final GetAllCoolCallBack callBack) {
        LogTool.d(TAG, "data:" + data);
        Call<CoolInfo> getAllCoolCall = coolService.getAllCool(key, url, version, data);
        getAllCoolCall.enqueue(new Callback<CoolInfo>() {
            @Override
            public void onResponse(Response<CoolInfo> response, Retrofit retrofit) {
                CoolInfo coolInfo = response.body();
                LogTool.d(TAG, "coolInfo:" + coolInfo);
                if (null != coolInfo) {
                    LogTool.d(TAG, "coolInfo.getCode():" + coolInfo.getCode());
                    if (coolInfo.getCode() == Constant.STATUS_SUCCESS) {
                        callBack.onGetAllCoolSuccess(coolInfo.getData());
                    } else {
                        callBack.onGetAllCoolFailure(coolInfo.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.onGetAllCoolFailure(t.getMessage());
            }
        });
    }

    @Override
    public void getCoolDetail(String key, String url, String version, String data, final GetCoolDetailCallBack callBack) {
        LogTool.d(TAG, "data:" + data);
        Call<CoolDetailInfo> getCoolDetailCall = coolService.getCoolDetail(key, url, version, data);
        getCoolDetailCall.enqueue(new Callback<CoolDetailInfo>() {
            @Override
            public void onResponse(Response<CoolDetailInfo> response, Retrofit retrofit) {
                CoolDetailInfo detailInfo = response.body();
                if (null != detailInfo) {
                    if (detailInfo.getCode() == Constant.STATUS_SUCCESS) {
                        callBack.onGetCoolDetailSuccess(detailInfo);
                    } else {
                        callBack.onGetCoolDetailFailure(detailInfo.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.onGetCoolDetailFailure(t.getMessage());
            }
        });
    }

    @Override
    public void getCoolByMe(String key, String url, String version, String data, final GetCoolByMeCallBack callBack) {
        LogTool.d(TAG, "data:" + data);
        Call<CoolInfo> getCoolByMeCall = coolService.getCoolByMe(key, url, version, data);
        getCoolByMeCall.enqueue(new Callback<CoolInfo>() {
            @Override
            public void onResponse(Response<CoolInfo> response, Retrofit retrofit) {
                CoolInfo coolInfo = response.body();
                if (null != coolInfo) {
                    if (coolInfo.getCode() == Constant.STATUS_SUCCESS) {

                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.onGetCoolByMeFailure(t.getMessage());
            }
        });
    }

    @Override
    public void editCool(String key, String url, String version, String data, final EditCoolCallBack callBack) {
        LogTool.d(TAG, "data:" + data);
        Call<CoolInfo> editCoolCall = coolService.editCool(key, url, version, data);
        editCoolCall.enqueue(new Callback<CoolInfo>() {
            @Override
            public void onResponse(Response<CoolInfo> response, Retrofit retrofit) {
                CoolInfo coolInfo = response.body();
                if (null != coolInfo) {
                    if (coolInfo.getCode() == Constant.STATUS_SUCCESS) {

                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                callBack.onEditCoolFailure(t.getMessage());
            }
        });
    }


    @Override
    public void focusCool(String key, String url, String version, String data, FocusCallBack callBack) {
        Call<String> focusCoolCall = coolService.focusCool(key, url, version, data);
        focusCoolCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                String str = response.body();

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public void unFocusCool(String key, String url, String version, String data, FocusCallBack callBack) {
        LogTool.d(TAG, "data:" + data);
        Call<String> unFocusCoolCall = coolService.unFocusCool(key, url, version, data);
        unFocusCoolCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                String str = response.body();

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    public interface AddCoolCallBack {
        void onAddCoolSuccess(CoolInfo coolInfo);

        void onAddCoolFailure(String msg);
    }

    public interface GetAllCoolCallBack {
        void onGetAllCoolSuccess(List<CoolInfo.CoolListInfo> list);

        void onGetAllCoolFailure(String msg);
    }

    public interface GetCoolDetailCallBack {
        void onGetCoolDetailSuccess(CoolDetailInfo coolDetailInfo);

        void onGetCoolDetailFailure(String msg);
    }

    public interface GetCoolByMeCallBack {
        void onGetCoolByMeSuccess(List<CoolInfo> list);

        void onGetCoolByMeFailure(String msg);
    }

    public interface EditCoolCallBack {
        void onEditCoolSuccess(String msg);

        void onEditCoolFailure(String msg);
    }

    public interface FocusCallBack {
        void onFocusSuccess(String msg);

        void onFocusFailure(String msg);
    }
}
