package com.smartcity.model.modelImpl;

import com.smartcity.http.HttpApi;
import com.smartcity.http.service.CircleService;
import com.smartcity.model.CircleConfigModel;

/**
 * Created by Administrator on 2016/5/24.
 */
public class CircleConfigModelImpl extends BaseModelImpl implements CircleConfigModel {

    private final CircleService circleService;

    public CircleConfigModelImpl() {

        circleService = HttpApi.getInstance().create(CircleService.class);
    }

    @Override
    public boolean isNetState() {
        return super.isNetState();
    }

    @Override
    public void applyJoinCircle(String applyCircleId, String applyUserId, String applyReferrerId) {

    }
}
