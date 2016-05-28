package com.smartcity.presenterImpl;

import android.text.TextUtils;

import com.smartcity.application.MyApplication;
import com.smartcity.config.ResCode;
import com.smartcity.http.model.BaseModel;
import com.smartcity.http.model.CartInfo;
import com.smartcity.model.modelImpl.CartModelImpl;
import com.smartcity.presenter.BasePresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.view.BaseViews;
import com.smartcity.view.ICartView;

/**
 * Created by Yancy on 2016/5/18.
 */
public class CartPresenter implements BasePresenter {
    private CartModelImpl cartModel;
    private ICartView cartView;

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void stop() {

    }

    public CartPresenter() {
        initModel();
    }

    public CartPresenter(ICartView cartView) {
        initModel();
        this.cartView = cartView;
        getProductList();
    }

    private void initModel() {
        cartModel = new CartModelImpl();
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
                if (null != cartInfo.getData() && cartInfo.getData().size() > 0) {
                    LogTool.e("cartInfo", cartInfo.toString());
                    cartView.setList(cartInfo);
                } else {
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

    public void addGoodToCart(int goodsId, String goodsName, int shopId, final BaseViews views) {
        String apikey = MyApplication.getApikey();
        String id = MyApplication.getId();
        if (!cartModel.isNetState()) {
            views.showToast("请检查网络连接!");
            return;
        }
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(apikey)) {
            views.showToast("请先登录");
            return;
        }
        views.showLoading("正在加入购物车");
        cartModel.addGoodTotCart(id, goodsId, goodsName, shopId, apikey, new CartModelImpl.OnAddGoodResultListener() {
            @Override
            public void addGoodSuccess(BaseModel baseModel) {
                cartView.hideLoading();
                if (ResCode.STATUS_SUCCESS_CODE != baseModel.getCode()) {
                    views.showToast("添加失败!");
                } else {
                    views.showToast("添加成功!" + baseModel.getTotal());
                }
            }

            @Override
            public void addGoodError(String msg) {
                views.hideLoading();
                views.showToast(TextUtils.isEmpty(msg) ? "添加失败!" : msg);
            }
        });
    }

    public void addGoodToCart(int goodsId, String goodsName, int shopId) {
        String apikey = MyApplication.getApikey();
        String id = MyApplication.getId();
        if (!cartModel.isNetState()) {
            cartView.showToast("请检查网络连接!");
            return;
        }
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(apikey)) {
            cartView.showToast("请先登录");
            cartView.startLogin();
            return;
        }
        cartView.showLoading("正在加入购物车");
        cartModel.addGoodTotCart(id, goodsId, goodsName, shopId, apikey, new CartModelImpl.OnAddGoodResultListener() {
            @Override
            public void addGoodSuccess(BaseModel baseModel) {
                cartView.hideLoading();
                if (ResCode.STATUS_SUCCESS_CODE != baseModel.getCode()) {
                    cartView.showToast("添加失败!");
                } else {
                    cartView.showToast("添加成功!" + baseModel.getTotal());
                }
            }

            @Override
            public void addGoodError(String msg) {
                cartView.hideLoading();
                cartView.showToast(TextUtils.isEmpty(msg) ? "添加失败!" : msg);
            }
        });
    }


    public void upDateCartNumber(int goodId, int number, int stockId, final UpDataListener listener) {
        String apikey = MyApplication.getApikey();
        String id = MyApplication.getId();
        if (!cartModel.isNetState()) {
            cartView.showToast("请检查网络连接!");
            return;
        }
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(apikey)) {
            cartView.showToast("请先登录");
            cartView.startLogin();
            return;
        }

        cartView.showLoading("正在修改中...");
        cartModel.updateCartNum(Integer.parseInt(id), goodId, number, stockId, apikey, new CartModelImpl.OnUpdateResultListener() {

            @Override
            public void updateGoodSuccess(BaseModel baseModel) {
                cartView.hideLoading();
                listener.success();
            }

            @Override
            public void updateGoodError(String msg) {
                cartView.hideLoading();
                listener.error();
                cartView.showToast("修改失败!");
            }
        });
    }


    public void deleteGood(int goodsId, final DeleteGoodListener listener) {
        String apikey = MyApplication.getApikey();
        String id = MyApplication.getId();
        if (!cartModel.isNetState()) {
            cartView.showToast("请检查网络连接!");
            return;
        }
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(apikey)) {
            cartView.showToast("请先登录");
            cartView.startLogin();
            return;
        }
        cartView.showLoading("正在删除中..");
        cartModel.deleteGoodByShopIdAndUserId(goodsId, Integer.parseInt(id), apikey, new CartModelImpl.OnDeleteGoodListener() {
            @Override
            public void deleteGoodSuccess(BaseModel baseModel) {
                cartView.hideLoading();
                cartView.showToast("删除成功!");
                listener.deleteSuccess();
            }

            @Override
            public void deleteGoodError(String msg) {
                cartView.hideLoading();
                cartView.showToast("修改失败!");
                listener.delteteError();
            }
        });
    }

    public interface UpDataListener {
        void success();

        void error();
    }

    public interface DeleteGoodListener {
        void deleteSuccess();

        void delteteError();
    }
}
