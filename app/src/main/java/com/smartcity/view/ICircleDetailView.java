package com.smartcity.view;

import com.smartcity.http.model.CircleDetailInfoModel;

import java.util.List;

/**
 * Created by Administrator on 2016/5/6.
 */
public interface ICircleDetailView {
    void getDetail(CircleDetailInfoModel list);

    void showFailMsg(String msg);

}
