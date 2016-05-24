package com.smartcity.model.modelImpl;

import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.CartInfo;
import com.smartcity.http.service.CartService;
import com.smartcity.model.CartModel;
import com.smartcity.utils.GsonUtils;
import com.smartcity.utils.NetTool;

import java.util.Hashtable;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2016/5/18.
 */
public class CartModelImpl implements CartModel {
    private final CartService cartService;

    public CartModelImpl() {
        cartService = HttpApi.getInstance().create(CartService.class);
    }

    @Override
    public boolean isNetState() {
        return NetTool.isNetworkAvailable(MyApplication.getInstance());
    }

    @Override
    public void getProductList(String customerId, String apiKry, final OnProductListListener<CartInfo> listener) {
        Map<String, Object> params = new Hashtable<>();
        params.put("customerId", customerId);
        cartService.getAllProduct(Constant.VALUE_VERSION, GsonUtils.objectToJson(params), apiKry).enqueue(new Callback<CartInfo>() {
            @Override
            public void onResponse(Call<CartInfo> call, Response<CartInfo> response) {
                CartInfo cartInfo = response.body();
                if (null != cartInfo) {
                    if (ResCode.STATUS_SUCCESS_CODE == cartInfo.getCode()) {
                        if (null != listener) {
                            listener.getListProductSuccess(cartInfo);
                        }
                    } else {

                        if (null != listener) {
                            listener.getListProductError(null);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<CartInfo> call, Throwable t) {
                if (null != listener) {
                    listener.getListProductError(t.getMessage());
                }
            }
        });
    }

    public interface OnProductListListener<T> {
        void getListProductSuccess(T t);

        void getListProductError(String msg);
    }
}
