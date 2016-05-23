package com.smartcity.model.modelImpl;

import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.HopShopAndBanner;
import com.smartcity.http.model.LifeBannerAndHotModel;
import com.smartcity.http.model.LifeClassifyModel;
import com.smartcity.http.service.LifeIndexService;
import com.smartcity.model.LifeIndexModel;
import com.smartcity.utils.GsonUtils;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.NetTool;

import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Administrator on 2016/5/19.
 */
public class LifeIndexModelImpl implements LifeIndexModel {

    public static final int HOT_SHOP = 0x1;
    public static final int BANNER = 0x2;
    private final LifeIndexService lifeIndexService;

    public LifeIndexModelImpl() {
        lifeIndexService = HttpApi.getInstance().create(LifeIndexService.class);
    }

    @Override
    public boolean isNetState() {
        return NetTool.isNetworkAvailable(MyApplication.getInstance());
    }

    @Override
    public void getListClassify(String apikey, final OnGetClassifyShopListener listener) {
        String params = GsonUtils.objectToJson(new HashMap<String, Object>());
        LogTool.e("test", params);
        lifeIndexService.getLifeClassify(apikey, LifeIndexService.GET_CLASSIFY_CMD_VALUE, Constant.VALUE_VERSION, params).enqueue(new Callback<LifeClassifyModel>() {
            @Override
            public void onResponse(Response<LifeClassifyModel> response, Retrofit retrofit) {
                LifeClassifyModel body = response.body();
                if (null != body) {
                    listener.loadClassifyShopSuccess(body);
                } else {
                    listener.loadClassifyShopError(null);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.loadClassifyShopError(t.getMessage());
            }
        });
    }

    @Override
    public void getHotShopOrBanner(String apikey, final int type, final OnGetHotShopOrBannerListener<HopShopAndBanner> listener) {
        Map<String, Object> params = new HashMap<>();
        switch (type) {
            case HOT_SHOP:
                params.put("label", "hot");
                break;
            default:
                params.put("label", "mallSlideList");
                break;

        }
        lifeIndexService.getBannnerOrHotShop(apikey, LifeIndexService.GET_BANNER_CMD_VALUE, Constant.VALUE_VERSION, GsonUtils.objectToJson(params)).enqueue(new Callback<HopShopAndBanner>() {
            @Override
            public void onResponse(Response<HopShopAndBanner> response, Retrofit retrofit) {
                HopShopAndBanner body = response.body();
                if (null != body) {
                    listener.loadHotShopOrBannerSuccess(body, type);
                } else {
                    listener.loadHotShopOrBannerError(null);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (null != listener) {
                    listener.loadHotShopOrBannerError(t.getMessage());
                }
            }
        });
    }

    @Override
    public void getNearShop(String apikey, String categoryId, String cityId, String areaId, String brandId, String longitude, String latitude, String monthSellCntSort, final OnGetNearShopListener listener) {
        Map<String, Object> params = new HashMap<>();
        params.put("categoryId", categoryId);
        params.put("cityId", cityId);
        params.put("areaId", areaId);
        params.put("brandId", brandId);
        params.put("longitude", longitude);
        params.put("latitude", latitude);
        params.put("monthSellCntSort", monthSellCntSort);
        String str = GsonUtils.objectToJson(params);
        LogTool.e("test", str);
        lifeIndexService.getLifeNear(apikey, LifeIndexService.GET_NEAR_SHOP_CMD_VALUE, Constant.VALUE_VERSION, str).enqueue(new Callback<HopShopAndBanner>() {
            @Override
            public void onResponse(Response<HopShopAndBanner> response, Retrofit retrofit) {
                HopShopAndBanner body = response.body();
                if (null != body) {
                    listener.loadNearShopSuccess(body);
                } else {
                    listener.loadNearShopError(null);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (null != listener) {
                    listener.loadNearShopError(t.getMessage());
                }
            }
        });
    }

    @Override
    public void getBannerAndClassify(String apikey, OnGetBannerAndHotListener listener) {
        lifeIndexService.getBannerAndHotList(apikey,LifeIndexService.GET_BANNER_AND_HOT_CMD_VALUE,Constant.VALUE_VERSION,null).enqueue(new Callback<LifeBannerAndHotModel>() {
            @Override
            public void onResponse(Response<LifeBannerAndHotModel> response, Retrofit retrofit) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }


    public interface OnGetNearShopListener<T> {
        void loadNearShopSuccess(T t);

        void loadNearShopError(String msg);
    }

    public interface OnGetHotShopOrBannerListener<T> {
        void loadHotShopOrBannerSuccess(T t, int type);

        void loadHotShopOrBannerError(String msg);
    }

    public interface OnGetClassifyShopListener<T> {
        void loadClassifyShopSuccess(T t);

        void loadClassifyShopError(String msg);
    }

    public interface OnGetBannerAndHotListener<T> {
        void loadDataSuccess(T t);

        void loadDataError(String msg);
    }

}
