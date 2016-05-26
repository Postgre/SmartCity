package com.smartcity.model;

import com.smartcity.http.model.AddressList;
import com.smartcity.model.modelImpl.AddressListModelImpl;

/**
 * Created by Yancy on 2016/5/16.
 */
public interface AddressListModel extends BaseModel {

    //获取所有地址列表
    void getAllAddress(String userId, String apiKey, AddressListModelImpl.GetAllAddressListener<AddressList> listener);

    //添加或更新地址
    void addAddress(AddressList.LifeAddressModel model, String apiKey, AddressListModelImpl.UpdateOrAddAddressListener listener);

    //根据id删除地址
    void deteleAddress(int addressId, String apiKey, AddressListModelImpl.DeleteAddressListener listener);
}
