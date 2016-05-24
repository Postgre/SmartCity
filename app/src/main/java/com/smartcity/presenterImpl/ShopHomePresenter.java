package com.smartcity.presenterImpl;

import android.text.TextUtils;

import com.smartcity.application.MyApplication;
import com.smartcity.http.model.CouponModel;
import com.smartcity.http.model.FovShopGood;
import com.smartcity.http.model.LifeGoodsModel;
import com.smartcity.http.model.LifeShopModel;
import com.smartcity.model.ShopHomeModel;
import com.smartcity.model.modelImpl.ShopHomeModelImpl;
import com.smartcity.presenter.BasePresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.view.ShopHomeView;

/**
 * Created by Administrator on 2016/5/20.
 */
public class ShopHomePresenter implements BasePresenter, ShopHomeModelImpl.LoadShopInfoListener<LifeShopModel>, ShopHomeModelImpl.LoadCouPonListListener<CouponModel>, ShopHomeModelImpl.LoadShopGoodsListener<LifeGoodsModel>, ShopHomeModelImpl.AddFovShopOrGoodListener {

    private final String id;
    private ShopHomeView shopHomeView;
    private ShopHomeModel shopHomeModel;
    private String shopId;
    private final String apikey;
    private LifeShopModel lifeShopModel;

    public ShopHomePresenter(String shopId, ShopHomeView shopHomeView) {
        shopHomeModel = new ShopHomeModelImpl();
        apikey = MyApplication.getApikey();
        this.shopHomeView = shopHomeView;
        id = MyApplication.getId();
        this.shopId = shopId;
    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void stop() {

    }


    private boolean isLoadGoods;

    public void initGoodsList(int type, int pageNo, int pageSize) {
        if (!isLoadGoods) {
            shopHomeView.showLoading("正在获取商品列表数据...");
            shopHomeModel.getGoodsList(apikey, shopId, pageNo, pageSize, type, this);
            isLoadGoods = true;
        } else {
            shopHomeView.showToast("正在loading...");
        }
    }

    public void initShopInfo() {

        if (!TextUtils.isEmpty(apikey)) {
            shopHomeModel.getShopInfo(apikey, shopId, this);
        } else {
            shopHomeView.startLogin();
        }

    }

    @Override
    public void onLoadInfoSuccess(LifeShopModel lifeShopModel) {
        this.lifeShopModel = lifeShopModel;
        // shopHomeView.set
        LogTool.e("test", lifeShopModel.toString());
    }

    @Override
    public void onLaoInfoError(String msg) {
        if (TextUtils.isEmpty(msg)) {
            shopHomeView.startLogin();
        } else {
            shopHomeView.showToast(msg);
        }

    }

    public void initCouponList() {
        shopHomeModel.getCouPonList(apikey, shopId, this);
    }

    @Override
    public void onLoadCouPonSuccess(CouponModel couponModel) {
        if (null != couponModel && null != couponModel.getData() && couponModel.getData().size() > 0) {
            shopHomeView.setCouponList(couponModel);
        } else {
            shopHomeView.showToast("没有优惠券!");
        }
    }

    @Override
    public void onLaoCouPonError(String msg) {
        if (TextUtils.isEmpty(msg)) {
            shopHomeView.startLogin();
        } else {
            shopHomeView.showToast(msg);
        }
    }

    @Override
    public void onLoadGoodsSuccess(LifeGoodsModel goodsModel) {
        shopHomeView.hideLoading();
        isLoadGoods = false;
        if (null != goodsModel && null != goodsModel.getData() && goodsModel.getData().size() > 0) {
            shopHomeView.setGoodsList(goodsModel);
        } else {
            shopHomeView.showToast("没有商品!");
        }
    }

    @Override
    public void onLaoGoodsError(String msg) {
        shopHomeView.hideLoading();
        isLoadGoods = false;
        if (TextUtils.isEmpty(msg)) {
            shopHomeView.startLogin();
        } else {
            shopHomeView.showToast(msg);
        }
    }

    //收藏类别：1商品 2店铺
    public void addFovShopOrShop(LifeGoodsModel.DataBean model) {

        if (null != lifeShopModel) {
            shopHomeView.showLoading("正在收藏中..");
            FovShopGood fovShopGood = new FovShopGood();
            fovShopGood.setCustomerId(id);
            //商品

            if (null != model) {
                fovShopGood.setType(String.valueOf(1));
                fovShopGood.setFavId(String.valueOf(model.getId()));
                fovShopGood.setPicUrl(model.getPictureUrl());
                fovShopGood.setPrice(model.getPrice());
                fovShopGood.setDesc(model.getDescContent());
                fovShopGood.setFavName(model.getGoodsName());
            } else {
                LifeShopModel.DataBean data = lifeShopModel.getData();
                fovShopGood.setType(String.valueOf(2));

                fovShopGood.setFavName(data.getShopName());
                fovShopGood.setPicUrl(data.getBgImage());
            }

            shopHomeModel.addFovShopOrGood(apikey, fovShopGood, this);
        }
    }

    @Override
    public void onaddSuccess() {
        shopHomeView.showToast("收藏成功!");
        shopHomeView.hideLoading();
        shopHomeView.idCollection(true);
    }

    @Override
    public void onaddError(String msg) {
        shopHomeView.hideLoading();
        if (TextUtils.isEmpty(msg)) {
            shopHomeView.startLogin();
        } else {
            shopHomeView.showToast(msg);
        }
    }

    public void startShopProFile() {
        shopHomeView.goShopDesActivity(lifeShopModel);
    }
}
