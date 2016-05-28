package com.smartcity.activity.chw.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smartcity.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/23.
 */
public class WeNeedDetialActivity extends Activity {
    @Bind(R.id.backBtn)
    ImageView backBtn;
    @Bind(R.id.sdv_photo)
    RelativeLayout sdvPhoto;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.iv_leibie)
    ImageView ivLeibie;
    @Bind(R.id.iv_location)
    ImageView ivLocation;
    @Bind(R.id.iv_phone)
    ImageView ivPhone;
    @Bind(R.id.ratingbar)
    RatingBar ratingbar;
    @Bind(R.id.bt_likeyuyue)
    Button btLikeyuyue;
    @Bind(R.id.bt_dianlian)
    Button btDianlian;
    @Bind(R.id.rl_liuyan)
    RelativeLayout rlLiuyan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weneed);
        ButterKnife.bind(this);
        initListener();
    }

    private void initListener() {

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rlLiuyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeNeedDetialActivity.this,LiuYanActivity.class);
                startActivity(intent);
            }
        });

    }
}
