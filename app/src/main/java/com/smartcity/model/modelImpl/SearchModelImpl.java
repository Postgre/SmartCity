package com.smartcity.model.modelImpl;

import com.smartcity.config.ResCode;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.service.SearchService;
import com.smartcity.model.SearchModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Administrator on 2016/5/11.
 */
public class SearchModelImpl extends BaseModelImpl implements SearchModel {

    @Override
    public boolean isNetState() {
        return super.isNetState();
    }

    @Override
    public void loadSearchData(String apikey, String version, String data, final onLoadSearchListListener listener) {
        SearchService service = HttpApi.getInstance().create(SearchService.class);
        Call<CircleBean> call = service.getSearchData(apikey, version, data);
        call.enqueue(new Callback<CircleBean>() {

            @Override
            public void onResponse(Call<CircleBean> call, Response<CircleBean> response) {
                CircleBean circleBean = response.body();
                if (null != circleBean) {
                    if (circleBean.getCode() == ResCode.STATUS_SUCCESS_CODE)
                        listener.onSuccess(circleBean.getData());
                } else {
                    listener.onFailure(circleBean.getMsg());
                }
            }

            @Override
            public void onFailure(Call<CircleBean> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
    }

    public interface onLoadSearchListListener {
        void onSuccess(List<CircleBean.CirDataEntity> list);

        void onFailure(String msg);
    }
}
