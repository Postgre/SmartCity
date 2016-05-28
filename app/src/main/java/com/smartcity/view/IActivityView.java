package com.smartcity.view;

import com.smartcity.http.model.ActivityModel;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public interface IActivityView extends BaseViews {
    void addActivityData(List<ActivityModel.DataEntity> list);
}
