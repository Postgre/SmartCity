package com.smartcity.presenter;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CoolPresenter.java
 * @author: fengliang
 * @date: 2016-05-04 16:43
 */
public interface CoolPresenter {

    void addCool(String coolVideoTypeId, String coolCoverPic, String coolFileAddress, String coolDecrip, String coolUserId, String coolMarkId, String coolAreaNo, String coolJwd, String coolRename);

    void getAllCool(String coolMarkId, String coolAreaNo, String coolUserId, String coolVideoTypeId, String sStartpage, String sPagerows);

    void getCoolDetail(String coolId, String iCurrUserId);

    void getCoolByMe(String coolUserId, String coolVideoTypeId, String sStartpage, String sPagerows);

    void editCool(String coolId, String coolVideoTypeId, String coolCoverPic, String coolFileAddress, String coolDecrip, String coolUserId, String coolMarkId, String coolAreaNo, String coolPlayTimes, String coolJwd, String coolRename);

    void focusCool(String userAttentionIng, String userAttentionEd);

    void unFocusCool(String userAttentionId, String userAttentionStatus);
}
