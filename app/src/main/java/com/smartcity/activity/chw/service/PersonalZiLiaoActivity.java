package com.smartcity.activity.chw.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/25.
 */
public class PersonalZiLiaoActivity extends Activity {

    @Bind(R.id.backBtn)
    ImageView backBtn;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.sdv_photo)
    SimpleDraweeView sdvPhoto;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_gender)
    TextView tvGender;
    @Bind(R.id.tv_age)
    TextView tvAge;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.rl_personal_xinxi)
    LinearLayout rlPersonalXinxi;
    @Bind(R.id.ll_pinfen)
    LinearLayout llPinfen;
    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.tv_gexing_qianming)
    TextView tvGexingQianming;
    @Bind(R.id.lv_circle)
    ListView lvCircle;
    @Bind(R.id.iv_photo2)
    ImageView ivPhoto2;
    @Bind(R.id.tv_wocan2)
    TextView tvWocan2;
    @Bind(R.id.tv_price2)
    TextView tvPrice2;
    @Bind(R.id.tv_num2)
    TextView tvNum2;
    @Bind(R.id.iv_photo3)
    ImageView ivPhoto3;
    @Bind(R.id.tv_wocan3)
    TextView tvWocan3;
    @Bind(R.id.tv_price3)
    TextView tvPrice3;
    @Bind(R.id.tv_num3)
    TextView tvNum3;
    @Bind(R.id.iv_photo)
    ImageView ivPhoto;
    @Bind(R.id.tv_wocan)
    TextView tvWocan;
    @Bind(R.id.tv_price)
    TextView tvPrice;
    @Bind(R.id.tv_num)
    TextView tvNum;
    @Bind(R.id.ll_service)
    LinearLayout llService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalziliao);
        ButterKnife.bind(this);
        initData();
        initListener();
    }


    private void initData() {

    }

    private void initListener() {
        llService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalZiLiaoActivity.this, PublicServiceActivity.class);
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

}
