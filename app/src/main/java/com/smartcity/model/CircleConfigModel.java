package com.smartcity.model;

import com.smartcity.model.modelImpl.CircleConfigModelImpl;

/**
 * Created by Administrator on 2016/5/24.
 */
public interface CircleConfigModel extends BaseModel {

    void applyJoinCircle(String apikey, String applyCircleId, String applyUserId , CircleConfigModelImpl.OnApplyJoinCircleListener listener);
    void joinCircle(String apikey, String personCircleId, String personUserId , CircleConfigModelImpl.OnApplyJoinCircleListener listener);
}
