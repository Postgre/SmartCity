package com.smartcity.model.modelImpl;

import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.CoolDetailInfo;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.http.service.CoolService;
import com.smartcity.model.CoolModel;
import com.smartcity.utils.GsonUtils;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.NetTool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
    public void addCool(String coolVideoTypeId, String coolCoverPic, String coolFileAddress, String coolDecrip, String coolUserId, String coolMarkId, String coolAreaNo, String coolJwd, String coolRename, final AddCoolCallBack callBack) {
        Map<String, String> maps = new HashMap<>();
        maps.put("coolVideoTypeId", coolVideoTypeId);
        maps.put("coolCoverPic", coolCoverPic);
        maps.put("coolFileAddress", coolFileAddress);
        maps.put("coolDecrip", coolDecrip);
        maps.put("coolUserId", coolUserId);
        maps.put("coolMarkId", coolMarkId);
        maps.put("coolAreaNo", coolAreaNo);
        maps.put("coolJwd", coolJwd);
        maps.put("coolRename", coolRename);
        Call<CoolInfo> addCoolCall = coolService.addCool(Constant.API_KEY, CoolService.ADD_COOL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        addCoolCall.enqueue(new Callback<CoolInfo>() {

            @Override
            public void onResponse(Call<CoolInfo> call, Response<CoolInfo> response) {
                CoolInfo coolInfo = response.body();
                if (null != coolInfo) {
                    if (coolInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                        callBack.onAddCoolSuccess(coolInfo);
                    } else {
                        callBack.onAddCoolFailure(coolInfo.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<CoolInfo> call, Throwable t) {
                callBack.onAddCoolFailure(t.getMessage());
            }

        });
    }

    @Override
    public void getAllCool(String coolMarkId, String coolAreaNo, String coolUserId, String sStartpage, String sPagerows, final GetAllCoolCallBack callBack) {
        Map<String, String> maps = new HashMap<>();
        maps.put("coolMarkId", coolMarkId);
        maps.put("coolAreaNo", coolAreaNo);
        maps.put("coolUserId", coolUserId);
        maps.put("sStartpage", sStartpage);
        maps.put("sPagerows", sPagerows);
        Call<CoolInfo> getAllCoolCall = coolService.getAllCool(Constant.API_KEY, CoolService.GET_ALL_COOL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        getAllCoolCall.enqueue(new Callback<CoolInfo>() {

            @Override
            public void onResponse(Call<CoolInfo> call, Response<CoolInfo> response) {
                CoolInfo coolInfo = response.body();
                LogTool.d(TAG, "coolInfo:" + coolInfo);
                if (null != coolInfo) {
                    LogTool.d(TAG, "coolInfo.getCode():" + coolInfo.getCode());
                    if (coolInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                        callBack.onGetAllCoolSuccess(coolInfo.getData());
                    } else {
                        callBack.onGetAllCoolFailure(coolInfo.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<CoolInfo> call, Throwable t) {
                callBack.onGetAllCoolFailure(t.getMessage());
            }

        });
    }

    @Override
    public void getCoolDetail(String coolId, String iCurrUserId, final GetCoolDetailCallBack callBack) {
        Map<String, String> maps = new HashMap<>();
        maps.put("coolId", coolId);
        maps.put("iCurrUserId", iCurrUserId);
        Call<CoolDetailInfo> getCoolDetailCall = coolService.getCoolDetail(Constant.API_KEY, CoolService.GET_COOL_DETAIL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        getCoolDetailCall.enqueue(new Callback<CoolDetailInfo>() {

            @Override
            public void onResponse(Call<CoolDetailInfo> call, Response<CoolDetailInfo> response) {
                CoolDetailInfo detailInfo = response.body();
                if (null != detailInfo) {
                    if (detailInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                        callBack.onGetCoolDetailSuccess(detailInfo);
                    } else {
                        callBack.onGetCoolDetailFailure(detailInfo.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<CoolDetailInfo> call, Throwable t) {
                callBack.onGetCoolDetailFailure(t.getMessage());
            }
        });
    }

    @Override
    public void getCoolByMe(String coolUserId, String coolVideoTypeId, String sStartpage, String sPagerows, final GetCoolByMeCallBack callBack) {
        Map<String, String> maps = new HashMap<>();
        maps.put("coolUserId", coolUserId);
        maps.put("coolVideoTypeId", coolVideoTypeId);
        maps.put("sStartpage", sStartpage);
        maps.put("sPagerows", sPagerows);
        Call<CoolInfo> getCoolByMeCall = coolService.getCoolByMe(Constant.API_KEY, CoolService.GET_COOL_BY_ME, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        getCoolByMeCall.enqueue(new Callback<CoolInfo>() {

            @Override
            public void onResponse(Call<CoolInfo> call, Response<CoolInfo> response) {
                CoolInfo coolInfo = response.body();
                if (null != coolInfo) {
                    if (coolInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {

                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<CoolInfo> call, Throwable t) {
                callBack.onGetCoolByMeFailure(t.getMessage());
            }
        });
    }

    @Override
    public void editCool(String coolId, String coolVideoTypeId, String coolCoverPic, String coolFileAddress, String coolDecrip, String coolUserId, String coolMarkId, String coolAreaNo, String coolPlayTimes, String coolJwd, String coolRename, final EditCoolCallBack callBack) {
        Map<String, String> maps = new HashMap<>();
        maps.put("coolId", coolId);
        maps.put("coolVideoTypeId", coolVideoTypeId);
        maps.put("coolCoverPic", coolCoverPic);
        maps.put("coolFileAddress", coolFileAddress);
        maps.put("coolDecrip", coolDecrip);
        maps.put("coolUserId", coolUserId);
        maps.put("coolMarkId", coolMarkId);
        maps.put("coolAreaNo", coolAreaNo);
        maps.put("coolPlayTimes", coolPlayTimes);
        maps.put("coolJwd", coolJwd);
        maps.put("coolRename", coolRename);
        Call<CoolInfo> editCoolCall = coolService.editCool(Constant.API_KEY, CoolService.EDIT_COOL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        editCoolCall.enqueue(new Callback<CoolInfo>() {

            @Override
            public void onResponse(Call<CoolInfo> call, Response<CoolInfo> response) {
                CoolInfo coolInfo = response.body();
                if (null != coolInfo) {
                    if (coolInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {

                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Call<CoolInfo> call, Throwable t) {
                callBack.onEditCoolFailure(t.getMessage());
            }
        });
    }


    @Override
    public void focusCool(String userAttentionIng, String userAttentionEd, FocusCallBack callBack) {
        Map<String, String> maps = new HashMap<>();
        maps.put("userAttentionIng", userAttentionIng);
        maps.put("userAttentionEd", userAttentionEd);
        Call<String> focusCoolCall = coolService.focusCool(Constant.API_KEY, CoolService.FOCUS_COOL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        focusCoolCall.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String str = response.body();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    @Override
    public void unFocusCool(String userAttentionId, String userAttentionStatus, FocusCallBack callBack) {
        Map<String, String> maps = new HashMap<>();
        maps.put("userAttentionId", userAttentionId);
        maps.put("userAttentionStatus", userAttentionStatus);
        Call<String> unFocusCoolCall = coolService.unFocusCool(Constant.API_KEY, CoolService.UNFOCUS_COOL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        unFocusCoolCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String str = response.body();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

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
