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
public class WecanDetialActivity extends Activity {
    @Bind(R.id.backBtn)
    ImageView backBtn;
    @Bind(R.id.sdv_photo)
    RelativeLayout sdvPhoto;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.iv_leibie)
    ImageView ivLeibie;
    @Bind(R.id.rl_personalziliao)
    RelativeLayout rlPersonalziliao;
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
    @Bind(R.id.rl_comment)
    RelativeLayout rlComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wecan);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initListener() {
        rlPersonalziliao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进入个人资料页面
                Intent intent = new Intent(WecanDetialActivity.this, PersonalZiLiaoActivity.class);
                startActivity(intent);
            }
        });
        rlComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WecanDetialActivity.this, CommentActivity.class);
                startActivity(intent);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void initData() {
    }
}