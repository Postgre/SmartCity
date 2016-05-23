package com.smartcity.model.modelImpl;

import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.config.Url;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.AddressList;
import com.smartcity.http.service.AddressService;
import com.smartcity.model.AddressListModel;
import com.smartcity.utils.GsonUtils;
import com.smartcity.utils.NetTool;

import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Yancy on 2016/5/16.
 */
public class AddressListModelImpl implements AddressListModel {


    private AddressService addressService;

    public AddressListModelImpl() {
        addressService = HttpApi.getInstance().create(AddressService.class);
    }

    @Override
    public boolean isNetState() {
        return NetTool.isNetworkAvailable(MyApplication.getInstance());
    }

    @Override
    public void getAllAddress(int userId, String apiKey, final GetAllAddressListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", userId);
        addressService.getAllList(Url.ALL_LIST_ADDRESS, Constant.VALUE_VERSION, GsonUtils.objectToJson(params), apiKey).enqueue(new Callback<AddressList>() {
            @Override
            public void onResponse(Response<AddressList> response, Retrofit retrofit) {
                AddressList addressList = response.body();
                if (null != addressList) {
                    if (Constant.STATUS_SUCCESS == addressList.getCode()) {
                        listener.getAllSuccess(addressList);
                    } else {
                        listener.getAllListError(null);
                    }
                }

            }

            @Override
            public void onFailure(Throwable t) {
                listener.getAllListError(t.getMessage());
            }
        });
    }


    @Override
    public void addAddress(AddressList.LifeAddressModel address, String apiKey, final UpdateOrAddAddressListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", address.getCustomerId());
        params.put("name", address.getName());
        params.put("phone", address.getPhone());
        params.put("zipcode", address.getZipcode());
        params.put("provinceId", address.getProvinceId());
        params.put("cityId", address.getCityId());
        params.put("areaId", address.getAreaId());
        params.put("address", address.getAddress());
        params.put("isDefault", address.getIsDefault());
        params.put("createTime", address.getCreateTime());
        params.put("modifyTime", address.getModifyTime());

        addressService.updateOrAddAddress(Url.UPDATE_ADD_ADDRESS, Constant.VALUE_VERSION, GsonUtils.objectToJson(params), apiKey).enqueue(new Callback<AddressList.LifeAddressModel>() {
            @Override
            public void onResponse(Response<AddressList.LifeAddressModel> response, Retrofit retrofit) {
                AddressList.LifeAddressModel body = response.body();
                if (null != body) {
                    if (Constant.STATUS_SUCCESS == body.getCode()) {
                        listener.updateOrAddAddressSuccess(body);
                    } else {
                        listener.updateOrAddAddressError(null);
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.updateOrAddAddressError(t.getMessage());
            }
        });

    }

    @Override
    public void deteleAddress(final int addressId, String apiKey, final DeleteAddressListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", addressId);

        addressService.getAllList(Url.ALL_LIST_ADDRESS, Constant.VALUE_VERSION, GsonUtils.objectToJson(params), apiKey).enqueue(new Callback<AddressList>() {
            @Override
            public void onResponse(Response<AddressList> response, Retrofit retrofit) {
                AddressList addressList = response.body();
                if (null != addressList) {
                    if (Constant.STATUS_SUCCESS == addressList.getCode()) {
                        listener.deleteAddressSuccess(addressId);
                    } else {
                        listener.deleteAddressError(null);
                    }
                }

            }

            @Override
            public void onFailure(Throwable t) {
                listener.deleteAddressError(t.getMessage());
            }
        });
    }

    public interface GetAllAddressListener<T> {
        void getAllSuccess(T t);

        void getAllListError(String msg);
    }

    public interface DeleteAddressListener<T> {
        void deleteAddressSuccess(T t);

        void deleteAddressError(String msg);
    }

    public interface UpdateOrAddAddressListener<T> {
        void updateOrAddAddressSuccess(T t);

        void updateOrAddAddressError(String msg);
    }
}
