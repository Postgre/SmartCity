package com.smartcity.model.modelImpl;

import com.smartcity.config.Constant;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.BaseModel;
import com.smartcity.http.model.CouponModel;
import com.smartcity.http.model.FovShopGood;
import com.smartcity.http.model.LifeGoodsModel;
import com.smartcity.http.model.LifeShopModel;
import com.smartcity.http.service.LifeIndexService;
import com.smartcity.model.ShopHomeModel;
import com.smartcity.utils.GsonUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Yancy on 2016/5/20.
 */
public class ShopHomeModelImpl implements ShopHomeModel {

    private final LifeIndexService lifeIndexService;

    public final static int TIME = 0;//时间
    public final static int SELL_COUNT = 1;//销量由高到低
    public final static int PRICE_DOWN = 2;//价格由低到高
    public final static int PRICE_UP = 3;//价格由高到低

    public ShopHomeModelImpl() {
        lifeIndexService = HttpApi.getInstance().create(LifeIndexService.class);
    }

    @Override
    public void getShopInfo(String apiKey, String shopId, final LoadShopInfoListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", shopId);
        lifeIndexService.getShopHome(apiKey, LifeIndexService.GET_SHOP_HONE_CMD_VALUE, Constant.VALUE_VERSION, GsonUtils.objectToJson(params)).enqueue(new Callback<LifeShopModel>() {
            @Override
            public void onResponse(Response<LifeShopModel> response, Retrofit retrofit) {
                LifeShopModel body = response.body();
                if (null != body) {
                    if (Constant.STATUS_SUCCESS == body.getCode()) {
                        listener.onLoadInfoSuccess(body);
                    } else {
                        listener.onLaoInfoError(null);
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onLaoInfoError(t.getMessage());
            }
        });
    }

    @Override
    public void getCouPonList(String apikey, String shopid, final LoadCouPonListListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("shopId", shopid);
        lifeIndexService.getCouponList(apikey, LifeIndexService.GET_SHOP_COUPON_CMD_VALUE, Constant.VALUE_VERSION, GsonUtils.objectToJson(params)).enqueue(new Callback<CouponModel>() {
            @Override
            public void onResponse(Response<CouponModel> response, Retrofit retrofit) {
                CouponModel body = response.body();
                if (null != body) {
                    if (Constant.STATUS_SUCCESS == body.getCode()) {
                        listener.onLoadCouPonSuccess(body);
                    } else {
                        listener.onLaoCouPonError(null);
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onLaoCouPonError(t.getMessage());
            }
        });
    }

    @Override
    public void getGoodsList(String apikey, String shopId, int pageNo, int pageSize, int sortType, final LoadShopGoodsListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("shopId", shopId);
        params.put("pageNo", pageNo);
        params.put("pageSize", pageSize);
        switch (sortType) {
            case TIME:
                params.put("sortType", TIME);
                break;
            case SELL_COUNT:
                params.put("sortType", SELL_COUNT);
                break;
            case PRICE_DOWN:
                params.put("sortType", PRICE_DOWN);
                break;
            case PRICE_UP:
                params.put("sortType", PRICE_UP);
                break;
            default:

                break;
        }

        lifeIndexService.getGoodsList(apikey, LifeIndexService.GET_SHOP_GOODS_CMD_VALUE, Constant.VALUE_VERSION, GsonUtils.objectToJson(params)).enqueue(new Callback<LifeGoodsModel>() {
            @Override
            public void onResponse(Response<LifeGoodsModel> response, Retrofit retrofit) {
                LifeGoodsModel body = response.body();
                if (null != body) {
                    if (Constant.STATUS_SUCCESS == body.getCode()) {
                        listener.onLoadGoodsSuccess(body);
                    } else {
                        listener.onLaoGoodsError(null);
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onLaoGoodsError(t.getMessage());
            }
        });
    }

    @Override
    public void addFovShopOrGood(String apikey, FovShopGood fovShopGood, final AddFovShopOrGoodListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("customerId", fovShopGood.getCustomerId());
        params.put("favId", fovShopGood.getFavId());
        params.put("favName", fovShopGood.getFavName());
        params.put("picUrl", fovShopGood.getPicUrl());
        params.put("desc", fovShopGood.getDesc());
        params.put("type", fovShopGood.getType());
        params.put("favUrl", fovShopGood.getFavUrl());
        params.put("price", fovShopGood.getPrice());
        lifeIndexService.addFovShopOrGood(apikey, LifeIndexService.ADD_FAV_SHOP_OR_GOOD_CMD_VALUE, Constant.VALUE_VERSION, GsonUtils.objectToJson(params)).enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Response<BaseModel> response, Retrofit retrofit) {
                BaseModel body = response.body();
                if (null != body) {
                    if (Constant.STATUS_SUCCESS == body.getCode()) {
                        listener.onaddSuccess();
                    } else {
                        listener.onaddError(null);
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onaddError(t.getMessage());
            }
        });
    }


    public interface LoadShopInfoListener<T> {
        void onLoadInfoSuccess(T t);

        void onLaoInfoError(String msg);
    }

    public interface LoadCouPonListListener<T> {
        void onLoadCouPonSuccess(T t);

        void onLaoCouPonError(String msg);
    }

    public interface LoadShopGoodsListener<T> {
        void onLoadGoodsSuccess(T t);

        void onLaoGoodsError(String msg);
    }

    public interface AddFovShopOrGoodListener {
        void onaddSuccess();

        void onaddError(String msg);
    }
}
