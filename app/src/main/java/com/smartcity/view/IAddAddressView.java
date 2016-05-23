package com.smartcity.view;

/**
 * Created by yancy on 16-5-18.
 */
public interface IAddAddressView extends BaseViews {
    String getUserName();

    String getPhoneNumber();

    String getProvinceCity();

    String getDetailAddress();

    int isDefaultAddress();

    void startLogin();
}
