package com.smartcity.model.modelImpl;

import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.AddCoolInfo;
import com.smartcity.http.model.CommentInfo;
import com.smartcity.http.model.CoolDetailInfo;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.http.model.FocusInfo;
import com.smartcity.http.service.CoolService;
import com.smartcity.model.CoolModel;
import com.smartcity.utils.GsonUtils;
import com.smartcity.utils.LogTool;

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
public class CoolModelImpl extends BaseModelImpl implements CoolModel {
    private static final String TAG = CoolModelImpl.class.getName();
    private CoolService coolService;
    private String apiKey;

    public CoolModelImpl() {
        coolService = HttpApi.getInstance().create(CoolService.class);
        apiKey = MyApplication.getApikey();
    }

    @Override
    public boolean isNetState() {
        return super.isNetState();
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
        maps.put("coolCoverWidth", "150");
        maps.put("coolCoverHeight", "200");
        Call<AddCoolInfo> addCoolCall = coolService.addCool(apiKey, CoolService.ADD_COOL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        addCoolCall.enqueue(new Callback<AddCoolInfo>() {

            @Override
            public void onResponse(Call<AddCoolInfo> call, Response<AddCoolInfo> response) {
                if (response.isSuccessful()) {
                    AddCoolInfo addCoolInfo = response.body();
                    LogTool.d(TAG, "addCoolInfo=" + addCoolInfo);
                    if (null != addCoolInfo) {
                        if (addCoolInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                            callBack.onAddCoolSuccess(addCoolInfo.getMsg());
                        } else {
                            callBack.onAddCoolFailure(addCoolInfo.getMsg());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<AddCoolInfo> call, Throwable t) {
                callBack.onAddCoolFailure(t.getMessage());
            }

        });
    }

    @Override
    public void getAllCool(String coolMarkId, String coolAreaNo, String coolUserId, String coolVideoTypeId, int sStartpage, int sPagerows, final GetAllCoolCallBack callBack) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("coolMarkId", coolMarkId);
        maps.put("coolAreaNo", coolAreaNo);
        maps.put("coolUserId", coolUserId);
        maps.put("coolVideoTypeId", coolVideoTypeId);
        maps.put("sStartpage", sStartpage);
        maps.put("sPagerows", sPagerows);
        Call<CoolInfo> getAllCoolCall = coolService.getAllCool(apiKey, CoolService.GET_ALL_COOL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        getAllCoolCall.enqueue(new Callback<CoolInfo>() {

            @Override
            public void onResponse(Call<CoolInfo> call, Response<CoolInfo> response) {
                if (response.isSuccessful()) {
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
        Call<CoolDetailInfo> getCoolDetailCall = coolService.getCoolDetail(apiKey, CoolService.GET_COOL_DETAIL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        getCoolDetailCall.enqueue(new Callback<CoolDetailInfo>() {

            @Override
            public void onResponse(Call<CoolDetailInfo> call, Response<CoolDetailInfo> response) {
                if (response.isSuccessful()) {
                    CoolDetailInfo detailInfo = response.body();
                    if (null != detailInfo) {
                        if (detailInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {
                            callBack.onGetCoolDetailSuccess(detailInfo.getData());
                        } else {
                            callBack.onGetCoolDetailFailure(detailInfo.getMsg());
                        }
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
        Call<CoolInfo> getCoolByMeCall = coolService.getCoolByMe(apiKey, CoolService.GET_COOL_BY_ME, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        getCoolByMeCall.enqueue(new Callback<CoolInfo>() {

            @Override
            public void onResponse(Call<CoolInfo> call, Response<CoolInfo> response) {
                if (response.isSuccessful()) {
                    CoolInfo coolInfo = response.body();
                    if (null != coolInfo) {
                        if (coolInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {

                        } else {

                        }
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
        Call<CoolInfo> editCoolCall = coolService.editCool(apiKey, CoolService.EDIT_COOL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        editCoolCall.enqueue(new Callback<CoolInfo>() {

            @Override
            public void onResponse(Call<CoolInfo> call, Response<CoolInfo> response) {
                if (response.isSuccessful()) {
                    CoolInfo coolInfo = response.body();
                    if (null != coolInfo) {
                        if (coolInfo.getCode() == ResCode.STATUS_SUCCESS_CODE) {

                        } else {

                        }
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
    public void focusCool(String userAttentionIng, String userAttentionEd, final FocusCallBack callBack) {
        Map<String, String> maps = new HashMap<>();
        maps.put("userAttentionIng", userAttentionIng);
        maps.put("userAttentionEd", userAttentionEd);
        Call<FocusInfo> focusCoolCall = coolService.focusCool(apiKey, CoolService.FOCUS_COOL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        focusCoolCall.enqueue(new Callback<FocusInfo>() {

            @Override
            public void onResponse(Call<FocusInfo> call, Response<FocusInfo> response) {
                if (response.isSuccessful()) {
                    callBack.onFocusSuccess(response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<FocusInfo> call, Throwable t) {
                callBack.onFocusSuccess(t.getMessage());
            }
        });
    }

    @Override
    public void unFocusCool(String userAttentionId, String userAttentionStatus, final FocusCallBack callBack) {
        Map<String, String> maps = new HashMap<>();
        maps.put("userAttentionId", userAttentionId);
        maps.put("userAttentionStatus", userAttentionStatus);
        Call<FocusInfo> unFocusCoolCall = coolService.unFocusCool(apiKey, CoolService.UNFOCUS_COOL, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        unFocusCoolCall.enqueue(new Callback<FocusInfo>() {
            @Override
            public void onResponse(Call<FocusInfo> call, Response<FocusInfo> response) {
                if (response.isSuccessful()) {
                    callBack.onFocusSuccess(response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<FocusInfo> call, Throwable t) {
                callBack.onFocusSuccess(t.getMessage());
            }
        });
    }


    @Override
    public void addComment(String sType, String sCoolId, String sUserId, String sUserCode, String sCommentTitle, String sCommentContent, String sIsLike, final CommentCallBack callback) {
        Map<String, String> maps = new HashMap<>();
        maps.put("sType", sType);
        maps.put("sCoolId", sCoolId);
        maps.put("sUserId", sUserId);
        maps.put("sUserCode", sUserCode);
        maps.put("sCommentTitle", sCommentTitle);
        maps.put("sCommentContent", sCommentContent);
        maps.put("sIsLike", sIsLike);
        Call<CommentInfo> addCommentCall = coolService.addComment(apiKey, CoolService.ADD_COMMENT, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        addCommentCall.enqueue(new Callback<CommentInfo>() {
            @Override
            public void onResponse(Call<CommentInfo> call, Response<CommentInfo> response) {
                if (response.isSuccessful()) {
                    CommentInfo commentInfo = response.body();
                    if (null != commentInfo) {
                        callback.onCommentSuccess("评论成功");
                    }
                }
            }

            @Override
            public void onFailure(Call<CommentInfo> call, Throwable t) {
                callback.onCommentFailure(t.getMessage());
            }
        });
    }

    @Override
    public void updateComment(String sIsLike, String sLikeCount, final CommentCallBack callback) {
        Map<String, String> maps = new HashMap<>();
        maps.put("sIsLike", sIsLike);
        maps.put("sLikeCount", sLikeCount);
        Call<CommentInfo> unFocusCoolCall = coolService.updateComment(apiKey, CoolService.UPDATE_COMMENT, Constant.VALUE_VERSION, GsonUtils.objectToJson(maps));
        unFocusCoolCall.enqueue(new Callback<CommentInfo>() {
            @Override
            public void onResponse(Call<CommentInfo> call, Response<CommentInfo> response) {
                if (response.isSuccessful()) {
                    CommentInfo commentInfo = response.body();
                    if (null != commentInfo) {
                        callback.onCommentSuccess("点赞成功");
                    }
                }
            }

            @Override
            public void onFailure(Call<CommentInfo> call, Throwable t) {
                callback.onCommentFailure(t.getMessage());
            }
        });
    }

    public interface AddCoolCallBack {
        void onAddCoolSuccess(String msg);

        void onAddCoolFailure(String msg);
    }

    public interface GetAllCoolCallBack {
        void onGetAllCoolSuccess(List<CoolInfo.CoolListInfo> list);

        void onGetAllCoolFailure(String msg);
    }

    public interface GetCoolDetailCallBack {
        void onGetCoolDetailSuccess(CoolDetailInfo.CoolDetailItemInfo coolDetailItemInfo);

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

    public interface CommentCallBack {
        void onCommentSuccess(String msg);

        void onCommentFailure(String msg);
    }
}
