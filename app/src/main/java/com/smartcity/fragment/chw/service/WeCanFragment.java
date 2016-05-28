package com.smartcity.fragment.chw.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.customview.RoundProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenyuan
 * 2016 05 11:48
 * 武汉智创工厂
 */
public class WeCanFragment extends Fragment {

    @Bind(R.id.iv_addphoto)
    ImageView ivAddphoto;
    @Bind(R.id.tv_leixin)
    TextView tvLeixin;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.iv)
    ImageView iv;
    @Bind(R.id.tv_wocan)
    TextView tvWocan;
    @Bind(R.id.tv_nouse)
    TextView tvNouse;
    @Bind(R.id.roundProgressBar1)
    RoundProgressBar roundProgressBar1;
    @Bind(R.id.roundProgressBar2)
    RoundProgressBar roundProgressBar2;
    @Bind(R.id.roundProgressBar3)
    RoundProgressBar roundProgressBar3;
    @Bind(R.id.roundProgressBar4)
    RoundProgressBar roundProgressBar4;
    @Bind(R.id.roundProgressBar5)
    RoundProgressBar roundProgressBar5;
    @Bind(R.id.roundProgressBar6)
    RoundProgressBar roundProgressBar6;
    @Bind(R.id.roundProgressBar7)
    RoundProgressBar roundProgressBar7;
    @Bind(R.id.iv_sm)
    ImageView ivSm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wecan, null);
        ButterKnife.bind(this, view);
        return view;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
    }

    private void initData() {
        roundProgressBar1.setProgress(0,33);
        roundProgressBar2.setProgress(60,33);
        roundProgressBar3.setProgress(-60,67);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
