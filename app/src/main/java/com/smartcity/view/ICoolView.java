package com.smartcity.view;

import com.smartcity.http.model.CoolDetailInfo;
import com.smartcity.http.model.CoolInfo;

import java.util.List;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: ICoolView.java
 * @author: fengliang
 * @date: 2016-05-04 16:47
 */
public interface ICoolView extends BaseViews {
    void showSuccessMsg(String msg);

    void showFailMsg(String msg);

    void showList(List<CoolInfo.CoolListInfo> list);

    void showInfo(CoolDetailInfo.CoolDetailItemInfo info);
}
