package com.smartcity.model;

import com.smartcity.model.modelImpl.CoolModelImpl;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CoolModel.java
 * @author: fengliang
 * @date: 2016-05-04 16:30
 */
public interface CoolModel extends BaseModel {
    void addCool(String coolVideoTypeId, String coolCoverPic, String coolFileAddress, String coolDecrip, String coolUserId, String coolMarkId, String coolAreaNo, String coolJwd, String coolRename, CoolModelImpl.AddCoolCallBack callBack);

    void getAllCool(String coolMarkId, String coolAreaNo, String coolUserId, String coolVideoTypeId, String sStartpage, String sPagerows, CoolModelImpl.GetAllCoolCallBack callBack);

    void getCoolDetail(String coolId, String iCurrUserId, CoolModelImpl.GetCoolDetailCallBack callBack);

    void getCoolByMe(String coolUserId, String coolVideoTypeId, String sStartpage, String sPagerows, CoolModelImpl.GetCoolByMeCallBack callBack);

    void editCool(String coolId, String coolVideoTypeId, String coolCoverPic, String coolFileAddress, String coolDecrip, String coolUserId, String coolMarkId, String coolAreaNo, String coolPlayTimes, String coolJwd, String coolRename, CoolModelImpl.EditCoolCallBack callBack);

    void focusCool(String userAttentionIng, String userAttentionEd, CoolModelImpl.FocusCallBack callBack);

    void unFocusCool(String userAttentionId, String userAttentionStatus, CoolModelImpl.FocusCallBack callBack);
}
