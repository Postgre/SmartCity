package com.smartcity.view;

import com.smartcity.http.model.LifeBannerAndHotModel;

import java.util.List;

/**
 * Created by Administrator on 2016/5/19.
 */
public interface LifeIndexView extends BaseViews{

        void startLogin();

        void setBanner(List<LifeBannerAndHotModel.DataBean.SlideShopListBean> banner);

        void setHotShop(List<LifeBannerAndHotModel.DataBean.HotShopListBean> banner);

        void setClassify(List<LifeBannerAndHotModel.DataBean.CategoryListBean> classifyModel);
}
