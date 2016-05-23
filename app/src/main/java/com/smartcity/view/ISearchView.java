package com.smartcity.view;

import com.smartcity.http.model.CircleBean;

import java.util.List;

/**
 * Created by Administrator on 2016/5/12.
 */
public interface ISearchView extends BaseViews{

    void addList(List<CircleBean.CirDataEntity> list);
}
