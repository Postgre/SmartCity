package com.smartcity.view;

import com.smartcity.http.model.CartInfo;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface ICartView extends BaseViews {
    void setList(CartInfo info);
    void startLogin();
}
