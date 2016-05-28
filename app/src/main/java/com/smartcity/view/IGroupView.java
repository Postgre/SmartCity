package com.smartcity.view;

import com.smartcity.http.model.CircleGroupInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public interface IGroupView extends BaseViews {
    /*--------------添加圈子小组数据---------------*/
    void addGroups(List<CircleGroupInfo.DataEntity> list);

}
