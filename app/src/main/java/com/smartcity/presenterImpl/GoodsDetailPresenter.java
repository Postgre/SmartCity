package com.smartcity.presenterImpl;

import android.text.TextUtils;

import com.smartcity.application.MyApplication;
import com.smartcity.http.model.GoodsDetailInfo;
import com.smartcity.model.GoodsDetailsModel;
import com.smartcity.model.modelImpl.GoodsDetailsImpl;
import com.smartcity.utils.LogTool;

/**
 * Created by Administrator on 2016/5/23.
 */
public class GoodsDetailPresenter implements GoodsDetailsImpl.LoadGoodDetailListener<GoodsDetailInfo> {

    private final GoodsDetailsModel detailsModel;
    private final String apikey;

    public GoodsDetailPresenter() {
        detailsModel = new GoodsDetailsImpl();
        apikey = MyApplication.getApikey();
    }

    public void getDetailByGoodsId(String goodsId) {
        detailsModel.getGoodsDetail(apikey, goodsId, this);
    }

    @Override
    public void loadGoodDetailSuccess(GoodsDetailInfo o) {
        LogTool.e("test1", o.toString());
    }

    @Override
    public void loadGoodDetailError(String msg) {
        LogTool.e("test1", TextUtils.isEmpty(msg) ? "" : msg);
    }
}
