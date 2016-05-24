package com.smartcity.presenterImpl;

import android.text.TextUtils;

import com.smartcity.application.MyApplication;
import com.smartcity.http.model.HopShopAndBanner;
import com.smartcity.http.model.LifeBannerAndHotModel;
import com.smartcity.http.model.LifeClassifyModel;
import com.smartcity.model.LifeIndexModel;
import com.smartcity.model.modelImpl.LifeIndexModelImpl;
import com.smartcity.presenter.BasePresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.SharedPreferencesUtil;
import com.smartcity.view.ILifeIndexNearView;
import com.smartcity.view.ILifeIndexView;

import java.util.List;

/**
 * Created by Yancy on 2016/5/19.
 */
public class LifeIndexPresenter implements BasePresenter, LifeIndexModelImpl.OnGetHotShopOrBannerListener<HopShopAndBanner>, LifeIndexModelImpl.OnGetClassifyShopListener<LifeClassifyModel>, LifeIndexModelImpl.OnGetNearShopListener<HopShopAndBanner>,LifeIndexModelImpl.OnGetBannerAndHotListener<LifeBannerAndHotModel> {

    private LifeIndexModel model;
    private String apikey;
    private String id;
    private ILifeIndexView lifeIndexView;
    private ILifeIndexNearView lifeIndexNearView;

    public LifeIndexPresenter(ILifeIndexView lifeIndexView) {
        this.lifeIndexView = lifeIndexView;
        initConfig();
        init();
    }

    private void initConfig() {
        model = new LifeIndexModelImpl();
        apikey = MyApplication.getApikey();
        id = MyApplication.getId();
    }

    public LifeIndexPresenter(ILifeIndexNearView lifeIndexNearView) {
        this.lifeIndexNearView = lifeIndexNearView;
        initConfig();
    }

    public void initNear(int type) {
        if (!model.isNetState()) {
            lifeIndexNearView.showToast("请检查网络连接!");
            return;
        }
        if (TextUtils.isEmpty(apikey)) {
            lifeIndexNearView.showToast("请先登录!");
            return;
        }
        SharedPreferencesUtil spUtils = MyApplication.getSpUtils();
        // model.getNearShop(apikey,String.valueOf(type),"420100","420100",String.valueOf(1), spUtils.getString(Constant.LATITUDE,"30"),spUtils.getString(Constant.LONGITUDE,"120"),null,this);
        model.getNearShop(apikey, String.valueOf(4), "420100", "420106", String.valueOf(1), "30", "120", null, this);
    }


    private void init() {
       // initHotOrBanner();
      //  initClassify();

        initBannerAndClassify();
    }


    private void initBannerAndClassify() {
        if (!model.isNetState()) {
            lifeIndexNearView.showToast("请检查网络连接!");
            return;
        }
        model.getBannerAndClassify(apikey, this);

    }

    private void initClassify() {
        if (!model.isNetState()) {
            lifeIndexNearView.showToast("请检查网络连接!");
            return;
        }
        model.getListClassify(apikey, this);
    }

    private void initHotOrBanner() {
        if (!model.isNetState()) {
            lifeIndexNearView.showToast("请检查网络连接!");
            return;
        }
        if (TextUtils.isEmpty(apikey)) {
            lifeIndexView.showToast("请先登录!");
            lifeIndexView.startLogin();
            return;
        }
        lifeIndexNearView.setHasLoadDataOnce(true);
        lifeIndexView.showLoading("loading....");
        model.getHotShopOrBanner(apikey, LifeIndexModelImpl.HOT_SHOP, LifeIndexPresenter.this);
        model.getHotShopOrBanner(apikey, LifeIndexModelImpl.BANNER, LifeIndexPresenter.this);

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

    @Override
    public void loadHotShopOrBannerSuccess(HopShopAndBanner shopAndBanner, int type) {
        lifeIndexView.hideLoading();
        switch (type) {
            case LifeIndexModelImpl.HOT_SHOP:
                //设置首页热门商品
              //  lifeIndexView.setHotShop(shopAndBanner);
                break;
            default:
                //设置首页轮播图
             //   lifeIndexView.setBanner(shopAndBanner);
                break;
        }
    }

    @Override
    public void loadHotShopOrBannerError(String msg) {
        lifeIndexView.hideLoading();
        if (TextUtils.isEmpty(msg)) {
            lifeIndexView.startLogin();
        } else {
            lifeIndexView.showToast(msg);
        }
    }

    @Override
    public void loadClassifyShopSuccess(LifeClassifyModel lifeClassifyModel) {
        if (null != lifeClassifyModel && null != lifeClassifyModel.getData() && lifeClassifyModel.getData().size() > 0) {
          //  lifeIndexView.setClassify(lifeClassifyModel);
        } else {
            lifeIndexView.showToast("分类无数据!");
        }
    }

    @Override
    public void loadClassifyShopError(String msg) {
        if (TextUtils.isEmpty(msg)) {
            lifeIndexView.startLogin();
        } else {
            lifeIndexView.showToast(msg);
        }
    }

    @Override
    public void loadNearShopSuccess(HopShopAndBanner hopShopAndBanner) {
        lifeIndexNearView.setHasLoadDataOnce(false);
        LogTool.e("test", hopShopAndBanner.toString());
        if (null != hopShopAndBanner && null != hopShopAndBanner.getData() && hopShopAndBanner.getData().size() > 0) {
            lifeIndexNearView.setNearShop(hopShopAndBanner);
        } else {
            lifeIndexNearView.showToast("附近数据为空!");
        }

    }

    @Override
    public void loadNearShopError(String msg) {
        lifeIndexNearView.setHasLoadDataOnce(false);
        lifeIndexNearView.showToast(msg);
    }

    @Override
    public void loadDataSuccess(LifeBannerAndHotModel model) {
        if(null != model && null != model.getData())
        {
            LifeBannerAndHotModel.DataBean data = model.getData();

            lifeIndexView.setClassify(data.getCategoryList());
            lifeIndexView.setHotShop(data.getHotShopList());
            lifeIndexView.setBanner(data.getSlideShopList());
        }
        else
        {
            lifeIndexView.showToast("数据为空!");
        }

    }

    @Override
    public void loadDataError(String msg) {

        lifeIndexView.showToast(msg);
    }
}
