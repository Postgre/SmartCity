package com.smartcity.model;

import com.smartcity.http.model.CartInfo;
import com.smartcity.model.modelImpl.CartModelImpl;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface CartModel extends BaseModel {
    void getProductList(String customerId, String apiKey, CartModelImpl.OnProductListListener<CartInfo> listener);
}
