package com.smartcity.activity.life;

import android.view.View;

import com.smartcity.R;

/**
 * Created by Yancy on 2016/5/11.
 */
public class ShopProfileActivity extends LifeBaseActivity {
    @Override
    protected void initViews() {

    }

    @Override
    protected String getName() {
        return "店铺简介";
    }

    @Override
    protected View getCenterView() {
        return null;
    }

    @Override
    protected View getRightView() {
        return null;
    }

    @Override
    protected int getContentId() {
        return R.layout.activity_shop_profile;
    }
}
