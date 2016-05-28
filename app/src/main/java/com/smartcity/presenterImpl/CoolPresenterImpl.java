package com.smartcity.presenterImpl;

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
 * 我要炫PresenterImpl
 *
 * @version V2.0
 * @FileName: CoolPresenterImpl.java
 * @author: fengliang
 * @date: 2016-05-04 16:46
 */
public class CoolPresenterImpl implements CoolPresenter, CoolModelImpl.AddCoolCallBack, CoolModelImpl.GetAllCoolCallBack, CoolModelImpl.GetCoolDetailCallBack, CoolModelImpl.GetCoolByMeCallBack, CoolModelImpl.EditCoolCallBack, CoolModelImpl.FocusCallBack, CoolModelImpl.CommentCallBack {
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
        coolModel.addCool(coolVideoTypeId, coolCoverPic, coolFileAddress, coolDecrip, coolUserId, coolMarkId, coolAreaNo, coolJwd, coolRename, this);
    }

    @Override
    public void onAddCoolSuccess(String msg) {
        coolView.showSuccessMsg(msg);
    }

    @Override
    public void onAddCoolFailure(String msg) {
        coolView.showFailMsg(msg);
    }

    //-----------------------------查询炫-------------------------------------
    @Override
    public void getAllCool(String coolMarkId, String coolAreaNo, String coolUserId, String coolVideoTypeId, int sStartpage, int sPagerows) {
        if (!coolModel.isNetState()) {
            coolView.showToast("请检查网络连接!");
            return;
        }
        coolModel.getAllCool(coolMarkId, coolAreaNo, coolUserId, coolVideoTypeId, sStartpage, sPagerows, this);
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
        coolModel.getCoolDetail(coolId, iCurrUserId, this);
    }

    @Override
    public void onGetCoolDetailSuccess(CoolDetailInfo.CoolDetailItemInfo coolDetailItemInfo) {
        coolView.showInfo(coolDetailItemInfo);
    }

    @Override
    public void onGetCoolDetailFailure(String msg) {
        coolView.showFailMsg(msg);
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
        coolModel.getCoolByMe(coolUserId, coolVideoTypeId, sStartpage, sPagerows, this);
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
        coolModel.editCool(coolId, coolVideoTypeId, coolCoverPic, coolFileAddress, coolDecrip, coolUserId, coolMarkId, coolAreaNo, coolPlayTimes, coolJwd, coolRename, this);
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
        coolModel.focusCool(userAttentionIng, userAttentionEd, this);
    }

    //-----------------------------取消关注炫-----------------------------
    @Override
    public void unFocusCool(String userAttentionId, String userAttentionStatus) {
        if (!coolModel.isNetState()) {
            coolView.showToast("请检查网络连接!");
            return;
        }
        coolModel.unFocusCool(userAttentionId, userAttentionStatus, this);
    }

    @Override
    public void onFocusSuccess(String msg) {
        coolView.showSuccessMsg(msg);
    }

    @Override
    public void onFocusFailure(String msg) {
        coolView.showFailMsg(msg);
    }

    //------------------------------添加评论---------------------------------------
    @Override
    public void addComment(String sType, String sCoolId, String sUserId, String sUserCode, String sCommentTitle, String sCommentContent, String sIsLike) {
        if (!coolModel.isNetState()) {
            coolView.showToast("请检查网络连接!");
            return;
        }
        coolModel.addComment(sType, sCoolId, sUserId, sUserCode, sCommentTitle, sCommentContent, sIsLike, this);
    }

    @Override
    public void onCommentSuccess(String msg) {
        coolView.showSuccessMsg(msg);
    }

    @Override
    public void onCommentFailure(String msg) {
        coolView.showSuccessMsg(msg);
    }

    //------------------------------点赞---------------------------------------
    @Override
    public void updateComment(String sIsLike, String sLikeCount) {
        if (!coolModel.isNetState()) {
            coolView.showToast("请检查网络连接!");
            return;
        }
        coolModel.updateComment(sIsLike, sLikeCount, this);
    }


}
