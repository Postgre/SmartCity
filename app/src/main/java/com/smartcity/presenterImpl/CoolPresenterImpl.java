package com.smartcity.presenterImpl;

import com.google.gson.Gson;
import com.smartcity.config.Constant;
import com.smartcity.config.Url;
import com.smartcity.http.model.CoolDetailInfo;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.model.CoolModel;
import com.smartcity.model.modelImpl.CoolModelImpl;
import com.smartcity.presenter.CoolPresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.view.ICoolView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CoolPresenterImpl.java
 * @author: fengliang
 * @date: 2016-05-04 16:46
 */
public class CoolPresenterImpl implements CoolPresenter, CoolModelImpl.AddCoolCallBack, CoolModelImpl.GetAllCoolCallBack, CoolModelImpl.GetCoolDetailCallBack, CoolModelImpl.GetCoolByMeCallBack, CoolModelImpl.EditCoolCallBack, CoolModelImpl.FocusCallBack {
    private static final String TAG = "CoolPresenterImpl";
    private ICoolView coolView;
    private CoolModel coolModel;

    public CoolPresenterImpl(ICoolView coolView) {
        this.coolView = coolView;
        coolModel = new CoolModelImpl();
    }

    //-----------------------------发布炫-------------------------------------
    @Override
    public void addCool(String coolVideoTypeId, String coolCoverPic, String coolFileAddress, String coolDecrip, String coolUserId, String coolMarkId, String coolAreaNo, String coolJwd, String coolRename) {
        if (!coolModel.isNetState()) {
            coolView.showToast("请检查网络连接!");
            return;
        }
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
        coolModel.addCool(Constant.API_KEY, Url.ADD_COOL, Constant.VALUE_VERSION, new Gson().toJson(maps), this);
    }

    @Override
    public void onAddCoolSuccess(CoolInfo coolInfo) {
        coolView.showSuccessMsg(coolInfo.getMsg());
    }

    @Override
    public void onAddCoolFailure(String msg) {
        coolView.showFailMsg(msg);
    }

    //-----------------------------查询炫-------------------------------------
    @Override
    public void getAllCool(String coolMarkId, String coolAreaNo, String coolUserId, String sStartpage, String sPagerows) {
        if (!coolModel.isNetState()) {
            coolView.showToast("请检查网络连接!");
            return;
        }
        Map<String, String> maps = new HashMap<>();
        maps.put("coolMarkId", coolMarkId);
        maps.put("coolAreaNo", coolAreaNo);
        maps.put("coolUserId", coolUserId);
        maps.put("sStartpage", sStartpage);
        maps.put("sPagerows", sPagerows);
        coolModel.getAllCool(Constant.API_KEY, Url.GET_ALL_COOL, Constant.VALUE_VERSION, new Gson().toJson(maps), this);
    }

    @Override
    public void onGetAllCoolSuccess(List<CoolInfo.CoolListInfo> list) {
        LogTool.d(TAG, "list=" + list);
        coolView.showList(list);
    }

    @Override
    public void onGetAllCoolFailure(String msg) {
        coolView.showFailMsg(msg);
    }


    //-----------------------------炫详情-------------------------------------
    @Override
    public void getCoolDetail(String coolId, String iCurrUserId) {
        if (!coolModel.isNetState()) {
            coolView.showToast("请检查网络连接!");
            return;
        }
        Map<String, String> maps = new HashMap<>();
        maps.put("coolId", coolId);
        maps.put("iCurrUserId", iCurrUserId);
        coolModel.getCoolDetail(Constant.API_KEY, Url.GET_COOL_DETAIL, Constant.VALUE_VERSION, new Gson().toJson(maps), this);
    }

    @Override
    public void onGetCoolDetailSuccess(CoolDetailInfo coolDetailInfo) {

    }

    @Override
    public void onGetCoolDetailFailure(String msg) {

    }

    //-----------------------------我炫的-------------------------------------
    @Override
    public void getCoolByMe(String coolUserId, String coolVideoTypeId, String sStartpage, String sPagerows) {
        if (!coolModel.isNetState()) {
            coolView.showToast("请检查网络连接!");
            return;
        }
        Map<String, String> maps = new HashMap<>();
        maps.put("coolUserId", coolUserId);
        maps.put("coolVideoTypeId", coolVideoTypeId);
        maps.put("sStartpage", sStartpage);
        maps.put("sPagerows", sPagerows);
        coolModel.getCoolByMe(Constant.API_KEY, Url.GET_COOL_BY_ME, Constant.VALUE_VERSION, new Gson().toJson(maps), this);
    }

    @Override
    public void onGetCoolByMeSuccess(List<CoolInfo> list) {

    }

    @Override
    public void onGetCoolByMeFailure(String msg) {

    }

    //-----------------------------编辑炫-------------------------------------
    @Override
    public void editCool(String coolId, String coolVideoTypeId, String coolCoverPic, String coolFileAddress, String coolDecrip, String coolUserId, String coolMarkId, String coolAreaNo, String coolPlayTimes, String coolJwd, String coolRename) {
        if (!coolModel.isNetState()) {
            coolView.showToast("请检查网络连接!");
            return;
        }
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
        coolModel.editCool(Constant.API_KEY, Url.EDIT_COOL, Constant.VALUE_VERSION, new Gson().toJson(maps), this);
    }

    @Override
    public void onEditCoolSuccess(String msg) {

    }

    @Override
    public void onEditCoolFailure(String msg) {

    }

    //-----------------------------关注炫-----------------------------
    @Override
    public void focusCool(String userAttentionIng, String userAttentionEd) {
        if (!coolModel.isNetState()) {
            coolView.showToast("请检查网络连接!");
            return;
        }
        Map<String, String> maps = new HashMap<>();
        maps.put("userAttentionIng", userAttentionIng);
        maps.put("userAttentionEd", userAttentionEd);
        coolModel.focusCool(Constant.API_KEY, Url.FOCUS_COOL, Constant.VALUE_VERSION, new Gson().toJson(maps), this);
    }

    //-----------------------------取消关注炫-----------------------------
    @Override
    public void unFocusCool(String userAttentionId, String userAttentionStatus) {
        if (!coolModel.isNetState()) {
            coolView.showToast("请检查网络连接!");
            return;
        }
        Map<String, String> maps = new HashMap<>();
        maps.put("userAttentionId", userAttentionId);
        maps.put("userAttentionStatus", userAttentionStatus);
        coolModel.unFocusCool(Constant.API_KEY, Url.UNFOCUS_COOL, Constant.VALUE_VERSION, new Gson().toJson(maps), this);
    }

    @Override
    public void onFocusSuccess(String msg) {

    }

    @Override
    public void onFocusFailure(String msg) {

    }
}
