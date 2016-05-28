package com.smartcity.presenterImpl;

import android.text.TextUtils;

import com.smartcity.application.MyApplication;
import com.smartcity.http.model.GoodsDetailInfo;
import com.smartcity.model.GoodsDetailsModel;
import com.smartcity.model.modelImpl.GoodsDetailsImpl;
import com.smartcity.utils.LogTool;
import com.smartcity.view.cittlist.GoodsDetailsView;

/**
 * Created by Administrator on 2016/5/23.
 */
public class GoodsDetailPresenter implements GoodsDetailsImpl.LoadGoodDetailListener<GoodsDetailInfo> {

    private final GoodsDetailsModel detailsModel;
    private final String apikey;
    private  GoodsDetailsView goodsDetailsView;

    public GoodsDetailPresenter(GoodsDetailsView goodsDetailsView) {
        this.goodsDetailsView=goodsDetailsView;
        detailsModel = new GoodsDetailsImpl();
        apikey = MyApplication.getApikey();
    }

    public void getDetailByGoodsId(String goodsId) {
        detailsModel.getGoodsDetail(apikey, goodsId, this);
    }

    @Override
    public void loadGoodDetailSuccess(GoodsDetailInfo o) {
        LogTool.e("test1", o.toString());
        GoodsDetailInfo.DataBean data = o.getData();
        CartPresenter presenter = new CartPresenter();
        presenter.addGoodToCart(data.getId(),data.getGoodsName(),data.getShopId(),goodsDetailsView);
    }

    @Override
    public void loadGoodDetailError(String msg) {
        LogTool.e("test1", TextUtils.isEmpty(msg) ? "" : msg);
    }
}
