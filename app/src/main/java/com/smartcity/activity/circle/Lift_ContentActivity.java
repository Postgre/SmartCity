package com.smartcity.activity.circle;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Lift_ContentActivity extends BaseActivity {

    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.right_imag)
    ImageView rightImag;
    @Bind(R.id.life_resyycleView)
    RecyclerView lifeResyycleView;

    @Override
    public void init() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_lift__content;
    }

    @OnClick(R.id.right_imag)
    public void onClick() {
        finish();
    }
}
