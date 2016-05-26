package com.smartcity.model.modelImpl;

import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.AddressList;
import com.smartcity.http.model.BaseModel;
import com.smartcity.http.service.AddressService;
import com.smartcity.model.AddressListModel;
import com.smartcity.utils.GsonUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Yancy on 2016/5/16.
 */
public class AddressListModelImpl extends BaseModelImpl implements AddressListModel {


    private AddressService addressService;

    public AddressListModelImpl() {
        addressService = HttpApi.getInstance().create(AddressService.class);
    }

    @Override
    public boolean isNetState() {
        return super.isNetState();
    }

    @Override
    public void getAllAddress(String
                                          userId, String apiKey, final GetAllAddressListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", userId);
        addressService.getAllList(Constant.VALUE_VERSION, AddressService.ALL_LIST_ADDRESS,GsonUtils.objectToJson(params), apiKey).enqueue(new Callback<AddressList>() {

            @Override
            public void onResponse(Call<AddressList> call, Response<AddressList> response) {
                AddressList addressList = response.body();
                if (null != addressList) {
                    if (ResCode.STATUS_SUCCESS_CODE == addressList.getCode()) {
                        listener.getAllSuccess(addressList);
                    } else {
                        listener.getAllListError(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<AddressList> call, Throwable t) {
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
        addressService.updateOrAddAddress(Constant.VALUE_VERSION,AddressService.UPDATE_ADD_ADDRESS, GsonUtils.objectToJson(params), apiKey).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                BaseModel body = response.body();
                if (null != body) {
                    if (ResCode.STATUS_SUCCESS_CODE == body.getCode()) {
                        listener.updateOrAddAddressSuccess(body);
                    } else {
                        listener.updateOrAddAddressError(body.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                listener.updateOrAddAddressError(t.getMessage());
            }
        });

    }


    @Override
    public void deteleAddress(final int addressId, String apiKey, final DeleteAddressListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", addressId);
        addressService.deleteAddAddressById(AddressService.DELETE_ADDRESS,Constant.VALUE_VERSION, GsonUtils.objectToJson(params), apiKey).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                BaseModel  addressList = response.body();
                if (null != addressList) {
                    if (ResCode.STATUS_SUCCESS_CODE == addressList.getCode()) {
                        listener.deleteAddressSuccess(addressList);
                    } else {
                        listener.deleteAddressError(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
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
