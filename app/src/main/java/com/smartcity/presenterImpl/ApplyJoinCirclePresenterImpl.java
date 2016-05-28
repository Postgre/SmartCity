package com.smartcity.presenterImpl;

import com.smartcity.model.CircleConfigModel;
import com.smartcity.model.modelImpl.CircleConfigModelImpl;
import com.smartcity.presenter.ApplyJoinCirclePresenter;
import com.smartcity.view.ICircleView;

/**
 * Created by Administrator on 2016/5/25.
 */
public class ApplyJoinCirclePresenterImpl implements ApplyJoinCirclePresenter, CircleConfigModelImpl.OnApplyJoinCircleListener {

    private ICircleView iCircleView;
    private CircleConfigModel circleConfigModel;

    public ApplyJoinCirclePresenterImpl(ICircleView iCircleView) {
        this.iCircleView = iCircleView;
        this.circleConfigModel = new CircleConfigModelImpl();
    }

    @Override
    public void applyJoinCircle(String apikey, String applyCircleId, String applyUserId) {
        if (!circleConfigModel.isNetState()) {
            iCircleView.showToast("请检查网络连接!");
            return;
        }

        circleConfigModel.applyJoinCircle(apikey, applyCircleId, applyUserId, this);
    }

    @Override
    public void joinCircle(String apikey, String personCircleId, String personUserId) {
        if (!circleConfigModel.isNetState()) {
            iCircleView.showToast("请检查网络连接!");
            return;
        }

        circleConfigModel.joinCircle(apikey, personCircleId, personUserId, this);
    }

    @Override
    public void applyJoinCircleSuccess(String msg) {
        iCircleView.showToast(msg);
    }

    @Override
    public void applyCircleFailure(String msg) {
        iCircleView.showToast(msg);
    }
}
