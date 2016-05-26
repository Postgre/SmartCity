package com.smartcity.view;

import com.smartcity.http.model.AddressList;

/**
 * Created by Yancy on 2016/5/16.
 *
 * 地址列表
 */
public interface IAddressView extends BaseViews{
    void setListData(AddressList addressList);
    void startLogin();
}
