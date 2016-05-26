package com.smartcity.model.modelImpl;

import com.smartcity.config.Constant;
import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.GoodsDetailInfo;
import com.smartcity.http.service.LifeIndexService;
import com.smartcity.model.GoodsDetailsModel;
import com.smartcity.utils.GsonUtils;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2016/5/23.
 */
public class GoodsDetailsImpl extends BaseModelImpl implements GoodsDetailsModel {

    private final LifeIndexService indexService;

    public GoodsDetailsImpl() {
        indexService = HttpApi.getInstance().create(LifeIndexService.class);
    }

    @Override
    public boolean isNetState() {
        return super.isNetState();
    }

    @Override
    public void getGoodsDetail(String apikey, String goodsId, final LoadGoodDetailListener listener) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", goodsId);
        indexService.getGoodsDetails(apikey, LifeIndexService.GET_GOODS_DETAILS_CMD_VALUE,Constant.VALUE_VERSION, GsonUtils.objectToJson(params)).enqueue(new Callback<GoodsDetailInfo>() {
            @Override
            public void onResponse(Call<GoodsDetailInfo> call, Response<GoodsDetailInfo> response) {
                GoodsDetailInfo model = response.body();
                if (null != model) {
                    if (ResCode.STATUS_SUCCESS_CODE == model.getCode()) {
                        listener.loadGoodDetailSuccess(model);
                    } else {
                        listener.loadGoodDetailError(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<GoodsDetailInfo> call, Throwable t) {

                listener.loadGoodDetailError(t.getMessage());
            }


        });
    }

    public interface LoadGoodDetailListener<T> {
        void loadGoodDetailSuccess(T t);

        void loadGoodDetailError(String msg);
    }
}
