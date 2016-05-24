package com.smartcity.activity.life;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.R;
import com.smartcity.http.model.LifeShopModel;

import butterknife.Bind;

/**
 * Created by Yancy on 2016/5/11.
 */
public class ShopProfileActivity extends LifeBaseActivity {

    @Bind(R.id.shop_profile_dis_value)
    TextView textDisValue;

    @Bind(R.id.shop_profile_sell_server_value)
    TextView textSellServerValue;


    @Bind(R.id.shop_profile_logistics_service_value)
    TextView textlogisticsValue;

    @Bind(R.id.shop_pro_tv_address)
    TextView tvAddress;

    @Bind(R.id.shop_pro_tv_phone)
    TextView tvPhone;

    @Bind(R.id.shop_pro_iv_bg)
    SimpleDraweeView draweeViewBg;

    @Bind(R.id.shop_pro_tv_name)
    TextView tvShopName;
    @Override
    protected void initViews() {
        Intent intent = getIntent();
        LifeShopModel lifeShopModel = (LifeShopModel) intent.getSerializableExtra("data");
        LifeShopModel.DataBean data = lifeShopModel.getData();
        if(null != data)
        {
            tvPhone.setText(data.getPhone());
            tvAddress.setText(data.getAddress());

            //textDisValue.setText(data.get);
            draweeViewBg.setImageURI(Uri.parse(data.getBgImage()));
            tvShopName.setText(data.getName());
        }
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
