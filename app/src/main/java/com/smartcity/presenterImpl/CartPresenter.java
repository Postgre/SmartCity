package com.smartcity.presenterImpl;

import android.text.TextUtils;

import com.smartcity.application.MyApplication;
import com.smartcity.http.model.CartInfo;
import com.smartcity.model.modelImpl.CartModelImpl;
import com.smartcity.presenter.BasePresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.view.ICartView;

/**
 * Created by Yancy on 2016/5/18.
 */
public class CartPresenter implements BasePresenter {
    private final CartModelImpl cartModel;
    private final ICartView cartView;

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void stop() {

    }

    public CartPresenter(ICartView cartView) {
        cartModel = new CartModelImpl();
        this.cartView = cartView;
        getProductList();
    }

    public void getProductList() {
        String apikey = MyApplication.getApikey();
        String id = MyApplication.getId();
        if (!cartModel.isNetState()) {
            cartView.showToast("请检查网络连接!");
            return;
        }
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(apikey)) {
            cartView.startLogin();
            return;
        }
        cartModel.getProductList(id, apikey, new CartModelImpl.OnProductListListener<CartInfo>() {
            @Override
            public void getListProductSuccess(CartInfo cartInfo) {
                if(null != cartInfo.getData() && cartInfo.getData().size()>0)
                {
                    LogTool.e("cartInfo", cartInfo.toString());
                    cartView.setList(cartInfo);
                }
                else
                {
                    cartView.showToast("购物车没有商品!");
                }
            }

            @Override
            public void getListProductError(String msg) {
                if (TextUtils.isEmpty(msg)) {
                    cartView.startLogin();
                } else {
                    cartView.showToast(msg);
                }
            }
        });
    }
}
