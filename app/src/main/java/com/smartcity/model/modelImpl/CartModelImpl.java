package com.smartcity.model.modelImpl;

import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.BaseModel;
import com.smartcity.http.model.CartInfo;
import com.smartcity.http.service.CartService;
import com.smartcity.model.CartModel;
import com.smartcity.utils.GsonUtils;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2016/5/18.
 */
public class CartModelImpl extends BaseModelImpl implements CartModel {
    private final CartService cartService;

    public CartModelImpl() {
        cartService = HttpApi.getInstance().create(CartService.class);
    }

    @Override
    public boolean isNetState() {
        return super.isNetState();
    }

    @Override
    public void getProductList(String customerId, String apiKry, final OnProductListListener<CartInfo> listener) {
        Map<String, Object> params = new Hashtable<>();
        params.put("customerId", customerId);
        cartService.getAllProduct(Constant.VALUE_VERSION, CartService.ALL_PRODUCT, GsonUtils.objectToJson(params), apiKry).enqueue(new Callback<CartInfo>() {
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

    @Override
    public void addGoodTotCart(String customerId, String goodsId, String goodsName, String shopId, String apiKey, final OnAddGoodResultListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", customerId);
        params.put("goodsId", goodsId);
        params.put("goodsName", goodsName);
        params.put("shopId", shopId);

        cartService.addGoodsToCart(Constant.VALUE_VERSION, CartService.ADD_GOOD, GsonUtils.objectToJson(params), apiKey).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                if (null != response.body()) {
                    if (ResCode.STATUS_SUCCESS_CODE == response.body().getCode()) {
                        if (null != listener) {
                            listener.addGoodSuccess(response.body());
                        }
                    } else {

                        if (null != listener) {
                            listener.addGoodError(null);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                if (null != listener) {
                    listener.addGoodError(t.getMessage());
                }
            }
        });
    }

    @Override
    public void deleteGoodsByShopId(String shopId, String apiKey, final OnDeleteGoodsListener listener) {
        HashMap<String ,Object> params = new HashMap<>();

        params.put("shopId",shopId);

        cartService.deleteGoodByUserId(Constant.VALUE_VERSION,CartService.DELETE_GOODS,GsonUtils.objectToJson(params),apiKey).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                if (null != response.body()) {
                    if (ResCode.STATUS_SUCCESS_CODE == response.body().getCode()) {
                        if (null != listener) {
                            listener.deleteGoodsSuccess(response.body());
                        }
                    } else {

                        if (null != listener) {
                            listener.deleteGoodsError(null);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                if (null != listener) {
                    listener.deleteGoodsError(t.getMessage());
                }
            }
        });
    }

    @Override
    public void deleteGoodByShopIdAndUserId(String goodsId, String customerId, String apiKey,final OnDeleteGoodListener listener) {
        HashMap<String ,Object> params = new HashMap<>();

        params.put("customerId",customerId);
        params.put("goodsId",goodsId);

        cartService.deleteGoodByUserId(Constant.VALUE_VERSION,CartService.DELETE_GOOD_BY_USER_ID,GsonUtils.objectToJson(params),apiKey).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                if (null != response.body()) {
                    if (ResCode.STATUS_SUCCESS_CODE == response.body().getCode()) {
                        if (null != listener) {
                            listener.deleteGoodSuccess(response.body());
                        }
                    } else {

                        if (null != listener) {
                            listener.deleteGoodError(null);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                if (null != listener) {
                    listener.deleteGoodError(t.getMessage());
                }
            }
        });

    }

    @Override
    public void updateCartNum(String customerId, String goodsId, int number, String stockId, String apikey,final OnUpdateResultListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", customerId);
        params.put("goodsId", goodsId);
        params.put("number", number);
        params.put("stockId", stockId);

        cartService.addGoodsToCart(Constant.VALUE_VERSION, CartService.UPDATE_GOOD, GsonUtils.objectToJson(params), apikey).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                if (null != response.body()) {
                    if (ResCode.STATUS_SUCCESS_CODE == response.body().getCode()) {
                        if (null != listener) {
                            listener.updateGoodSuccess(response.body());
                        }
                    } else {

                        if (null != listener) {
                            listener.updateGoodError(null);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                if (null != listener) {
                    listener.updateGoodError(t.getMessage());
                }
            }
        });
    }


    public interface OnProductListListener<T> {
        void getListProductSuccess(T t);

        void getListProductError(String msg);
    }

    public interface OnAddGoodResultListener {
        void addGoodSuccess(BaseModel baseModel);

        void addGoodError(String msg);
    }

    public interface OnDeleteGoodsListener {
        void deleteGoodsSuccess(BaseModel baseModel);

        void deleteGoodsError(String msg);

    }

    public interface OnDeleteGoodListener {
        void deleteGoodSuccess(BaseModel baseModel);

        void deleteGoodError(String msg);
    }

    public interface OnUpdateResultListener {
        void updateGoodSuccess(BaseModel baseModel);

        void updateGoodError(String msg);
    }
}
