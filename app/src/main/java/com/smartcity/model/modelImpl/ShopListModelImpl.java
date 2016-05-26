package com.smartcity.model.modelImpl;


import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.BannerInfo;
import com.smartcity.http.model.HopShopAndBanner;
import com.smartcity.http.model.ShopParameterInfo;
import com.smartcity.http.service.LifeIndexService;
import com.smartcity.model.ShopListModel;
import com.smartcity.utils.GsonUtils;
import com.smartcity.utils.LogTool;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Yancy on 2016/5/23.
 */
public class ShopListModelImpl extends BaseModelImpl implements ShopListModel {

    private final LifeIndexService lifeIndexService;

    public ShopListModelImpl() {
        lifeIndexService = HttpApi.getInstance().create(LifeIndexService.class);
    }

    /**
     * @param shopParameterInfo 参数对象
     *                          <p/>
     *                          monthSellCntSort 排序规则
     *                          <p/>
     *                          0-降序；1-升序。为null时，默认按距离排序
     */
    @Override
    public void getShopList(String apiKey, ShopParameterInfo shopParameterInfo, final ShopListListener listener) {
        HashMap<String, Object> pars = new HashMap<>();
        pars.put("categoryId", shopParameterInfo.getCategoryId());
        pars.put("cityId", shopParameterInfo.getCityId());
        pars.put("areaId", shopParameterInfo.getAreaId());
        pars.put("brandId", shopParameterInfo.getBrandId());
        pars.put("longitude", shopParameterInfo.getLongitude());
        pars.put("latitude", shopParameterInfo.getLatitude());
        pars.put("monthSellCntSort", shopParameterInfo.getMonthSellCntSort());

        lifeIndexService.getShopList(apiKey, LifeIndexService.GET_NEAR_SHOP_CMD_VALUE,Constant.VALUE_VERSION, GsonUtils.objectToJson(pars)).enqueue(new Callback<HopShopAndBanner>() {
            @Override
            public void onResponse(Call<HopShopAndBanner> call, Response<HopShopAndBanner> response) {
                HopShopAndBanner body = response.body();
                LogTool.e("test1", body.toString());
                if(null != body && ResCode.STATUS_SUCCESS_CODE == body.getCode())
                {
                    listener.loadShopListSuccess(body);
                }
                else
                {
                    listener.loadShopListError(null);
                }
            }

            @Override
            public void onFailure(Call<HopShopAndBanner> call, Throwable t) {
                listener.loadShopListError(t.getMessage());
            }

        });
    }

    @Override
    public void getBannerList(String apiKey, final BannerListListener listener) {
        lifeIndexService.getShopBanner(apiKey,LifeIndexService.GET_SHOP_LIST_BANNER_CMD_VALUE, Constant.VALUE_VERSION, GsonUtils.objectToJson(new HashMap<String, Object>() {
            @Override
            public Object put(String key, Object value) {
                return super.put("data", "fuck");
            }
        })).enqueue(new Callback<BannerInfo>() {
            @Override
            public void onResponse(Call<BannerInfo> call, Response<BannerInfo> response) {
                BannerInfo body = response.body();
                if (null != body && ResCode.STATUS_SUCCESS_CODE == body.getCode()) {
                    listener.loadBannerInfoListSuccess(body);
                } else {
                    listener.loadBannerInfoListError(null);
                }
            }

            @Override
            public void onFailure(Call<BannerInfo> call, Throwable t) {
                listener.loadBannerInfoListError(t.getMessage());
            }

        });
    }

    @Override
    public boolean isNetState() {
        return super.isNetState();
    }

    public interface ShopListListener<T> {
        void loadShopListSuccess(T t);

        void loadShopListError(String msg);
    }

    public interface BannerListListener<T> {
        void loadBannerInfoListSuccess(T t);

        void loadBannerInfoListError(String msg);
    }
}
