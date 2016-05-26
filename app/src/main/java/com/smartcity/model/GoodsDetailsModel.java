package com.smartcity.model;

import com.smartcity.model.modelImpl.GoodsDetailsImpl;

/**
 * Created by Yancy on 2016/5/23.
 * 商品详情界面
 */
public interface GoodsDetailsModel extends BaseModel {

    void getGoodsDetail(String apikey, String goodsId, GoodsDetailsImpl.LoadGoodDetailListener listener);

}
