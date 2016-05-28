package com.smartcity.view;

import com.smartcity.http.model.ScShopComment;

/**
 * Created by Yancy on 2016/5/27.
 */
public interface CommentListView extends BaseViews {
    void startLogin();

    void setListData(int type,ScShopComment shopComment);

    void stopFresh();

    boolean isResh();
}
