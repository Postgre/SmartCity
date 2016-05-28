package com.smartcity.activity.chw.service;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.fragment.chw.service.WeCanFragment;
import com.smartcity.fragment.chw.service.WeNeedFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenyuan
 * 2016 05 10:17
 * 武汉智创工厂
 */
public class FaBuServiceActivity extends FragmentActivity {
    @Bind(R.id.backBtn)
    ImageView backBtn;
    @Bind(R.id.rb_wecan)
    RadioButton rbWecan;
    @Bind(R.id.rb_weneed)
    RadioButton rbWeneed;
    @Bind(R.id.tv_fabu)
    TextView tvFabu;
    @Bind(R.id.fl_content)
    FrameLayout flContent;
    private FragmentManager fragmentManager;
    private WeCanFragment weCanFragment;
    private WeNeedFragment weNeedFragment;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabuservice);
        ButterKnife.bind(this);
        weCanFragment = new WeCanFragment();
        weNeedFragment = new WeNeedFragment();
        fragmentManager = getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();
        ft.add(R.id.fl_content, weCanFragment);
        ft.commit();
        initData();
        initListener();


    }


    private void initData() {


    }


    private void initListener() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvFabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        //选中我能的按钮
        rbWecan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weCanFragment == null) {
                    weCanFragment = new WeCanFragment();
                }
                ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fl_content, weCanFragment);
                ft.commit();
            }
        });
        //选中我需要的按钮
        rbWeneed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (weCanFragment == null) {
                    weNeedFragment = new WeNeedFragment();
                }
                ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fl_content, weNeedFragment);
                ft.commit();

            }
        });
    }
}
