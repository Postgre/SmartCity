package com.smartcity.presenterImpl;

import com.smartcity.http.model.CircleBean;
import com.smartcity.http.model.LabelBean;
import com.smartcity.model.CircleModel;
import com.smartcity.model.modelImpl.CircleModelImpl;
import com.smartcity.presenter.CirclePresenter;
import com.smartcity.view.ICircleView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/13.
 */
public class CirclePresenterImpl implements CirclePresenter, CircleModelImpl.onLoadHotLabelsListener, CircleModelImpl.onLoadCircleListListener,
        CircleModelImpl.onLoadCirclesByLabel, CircleModelImpl.onLoadMyCircle {

    private ICircleView iCircleView;
    private CircleModel circleModel;

    public CirclePresenterImpl(ICircleView iCircleView) {
        this.iCircleView = iCircleView;
        this.circleModel = new CircleModelImpl();
    }

    @Override
    public void loadCircleDetail(String detailId) {

    }

    @Override
    public void getDetail(String key, int detailId) {

    }

    @Override
    public void getLabels(String apikey, String sStartpage, String sPagerows) {
        if (!circleModel.isNetState()) {
            iCircleView.showToast("请检查网络连接!");
            return;
        }
        circleModel.getHotLabels(apikey, sStartpage, sPagerows, this);
    }

    @Override
    public void getCircles(String apikey, String sStartpage, String sPagerows, String sPersonUserId) {
        if (!circleModel.isNetState()) {
            iCircleView.showToast("请检查网络连接!");
            return;
        }
        circleModel.getCircles(apikey, sStartpage, sPagerows, sPersonUserId, this);
    }

    @Override
    public void getCircleListByLabel(String apikey, String detailMarkName, String sStartpage, String sPagerows) {
        if (!circleModel.isNetState()) {
            iCircleView.showToast("请检查网络连接!");
            return;
        }
        circleModel.getCirclesByLabelContent(apikey, detailMarkName, sStartpage, sPagerows, this);
    }

    @Override
    public void getMyCircle(String apikey, String getMyCircle, String sPagerows, String sPersonUserId) {
        if (!circleModel.isNetState()) {
            iCircleView.showToast("请检查网络连接!");
            return;
        }
        circleModel.getMyCircle(apikey, getMyCircle, sPagerows, sPersonUserId, this);
    }

    @Override
    public void onSuccess(List<LabelBean.DataEntity> list) {
        iCircleView.hideLoading();
        iCircleView.addLabels(list);
    }

    @Override
    public void onError(String msg) {
        iCircleView.hideLoading();
        iCircleView.showToast(msg);
    }

    @Override
    public void onGetCirclesSuccess(List<CircleBean.CirDataEntity> list) {
        iCircleView.hideLoading();
        iCircleView.addCircles(list);
    }

    @Override
    public void onGetCirclesFailure(String msg) {
        iCircleView.hideLoading();
        iCircleView.showToast(msg);
    }

    @Override
    public void onLoadCirclesListSuccess(List<CircleBean.CirDataEntity> result) {
        iCircleView.hideLoading();
        iCircleView.addCircles(result);
    }

    @Override
    public void onLoadCirclesListError(String msg) {
        iCircleView.hideLoading();
        iCircleView.showToast(msg);
    }

    @Override
    public void onLoadMyCirclesSuccess(List<CircleBean.CirDataEntity> result) {
        iCircleView.hideLoading();
        iCircleView.addCircles(result);
    }

    @Override
    public void onLoadMyCirclesError(String msg) {
        iCircleView.hideLoading();
        iCircleView.showToast(msg);
    }
}
