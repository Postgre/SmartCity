package com.smartcity.presenterImpl;

import com.smartcity.http.model.ActivityModel;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.model.CircleByLabel;
import com.smartcity.http.model.CircleGroupInfo;
import com.smartcity.http.model.LabelBean;
import com.smartcity.model.CircleModel;
import com.smartcity.model.modelImpl.CircleModelImpl;
import com.smartcity.presenter.CirclePresenter;
import com.smartcity.view.IActivityView;
import com.smartcity.view.ICircleView;
import com.smartcity.view.IGroupView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/13.
 */
public class CirclePresenterImpl implements CirclePresenter, CircleModelImpl.OnLoadHotLabelsListener, CircleModelImpl.OnLoadCircleListListener,
        CircleModelImpl.OnLoadCirclesByLabel, CircleModelImpl.OnLoadMyCircle, CircleModelImpl.OnGetGroupsForCircleListener, CircleModelImpl.OnGetActivitiesListener {

    private ICircleView iCircleView;
    private CircleModel circleModel;
    private IActivityView iActivityView;

    private IGroupView iGroupView;

    public CirclePresenterImpl(ICircleView iCircleView) {
        this.iCircleView = iCircleView;
        this.circleModel = new CircleModelImpl();
    }

    public CirclePresenterImpl(IGroupView iGroupView, String flag) {
        this.iGroupView = iGroupView;
        this.circleModel = new CircleModelImpl();
    }

    public CirclePresenterImpl(IActivityView iActivityView, String flag, String flag2) {
        this.iActivityView = iActivityView;
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
    public void getGroupsListByPid(String apikey, String detailPid, String sStartpage, String sPagerows) {
        if (!circleModel.isNetState()) {
            iCircleView.showToast("请检查网络连接!");
            return;
        }

        circleModel.getGroupsListByPid(apikey, detailPid, sStartpage, sPagerows, this);
    }

    @Override
    public void getActivityList(String apikey, String detailCircleId, String sStartpage, String sPagerows) {
        if (!circleModel.isNetState()) {
            iCircleView.showToast("请检查网络连接!");
            return;
        }

        circleModel.getActivityList(apikey, detailCircleId, sStartpage, sPagerows, this);
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
    public void onLoadCirclesListSuccess(List<CircleByLabel.DataEntity> result) {
        iCircleView.hideLoading();
        iCircleView.addCirclesByLabel(result);
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

    @Override
    public void onGetGroupsSuccess(List<CircleGroupInfo.DataEntity> list) {
        iGroupView.hideLoading();
        iGroupView.addGroups(list);
    }

    @Override
    public void onGetGroupFaliure(String msg) {
        iGroupView.hideLoading();
        iGroupView.showToast("请求圈子小组列表数据失败");
    }

    @Override
    public void onGetActivitySuccess(List<ActivityModel.DataEntity> list) {
        iActivityView.addActivityData(list);
        iActivityView.hideLoading();
    }

    @Override
    public void onGetActivityFaliure(String msg) {
        iActivityView.hideLoading();
        iActivityView.showToast(msg);
    }
}
