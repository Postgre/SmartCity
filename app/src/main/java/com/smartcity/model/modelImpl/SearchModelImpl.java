package com.smartcity.model.modelImpl;

import com.smartcity.application.MyApplication;
import com.smartcity.config.Constant;
import com.smartcity.http.HttpApi;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.service.SearchService;
import com.smartcity.model.SearchModel;
import com.smartcity.utils.NetTool;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Administrator on 2016/5/11.
 */
public class SearchModelImpl implements SearchModel {

    @Override
    public boolean isNetState() {
        return NetTool.isNetworkAvailable(MyApplication.getInstance());
    }

    @Override
    public void loadSearchData(String apikey, String cmd, String version, String data, final onLoadSearchListListener listener) {
        SearchService service = HttpApi.getInstance().create(SearchService.class);
        Call<CircleBean> call = service.getSearchData(apikey, cmd, version, data);
        call.enqueue(new Callback<CircleBean>() {
            @Override
            public void onResponse(Response<CircleBean> response, Retrofit retrofit) {
                CircleBean circleBean = response.body();
                if (null != circleBean) {

                    if (circleBean.getCode() == Constant.STATUS_SUCCESS)
                        listener.onSuccess(circleBean.getData());
                } else {
                    listener.onFailure(circleBean.getMsg());
                }

            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
    }

    public interface onLoadSearchListListener {
        void onSuccess(List<CircleBean.CirDataEntity> list);

        void onFailure(String msg);
    }
}
