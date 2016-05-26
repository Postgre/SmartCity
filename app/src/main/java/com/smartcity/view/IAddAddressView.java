package com.smartcity.view;

import com.smartcity.http.model.AddressList;

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

    void setUserName(String name);

    void  setPhoneNumber(String phone);

    void  setProvinceCity(String provinceCity);

    void setDetailAddress(String address);

    void  setIsDefaultAddress(int isDefaultAddress);

    void  setEditeResult(AddressList.LifeAddressModel lifeAddressModel);
}
