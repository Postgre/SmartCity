package com.smartcity.view;

import com.smartcity.http.model.CircleBean;
import com.smartcity.http.model.LabelBean;

import java.util.List;

/**
 * Created by Administrator on 2016/5/7.
 */
public interface ICircleView extends BaseViews{

    void addCircles(List<CircleBean.CirDataEntity> circleList);
    void CircleGroup(List<CircleBean.CirDataEntity> circleList);
    void addLabels(List<LabelBean.DataEntity> labelList);
}
