package com.smartcity.activity.chw.service;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.smartcity.R;
import com.smartcity.adapter.chw.service.HotServiceAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/26.
 */
public class PublicServiceActivity extends Activity {
    @Bind(R.id.backBtn)
    ImageView backBtn;
    @Bind(R.id.rlv)
    ListView rlv;
    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicpervice);
        ButterKnife.bind(this);
        initData();
        initListener();

    }


    private void initData() {
        titles = new ArrayList<>();
        titles.add("租房");
        titles.add("教育");
        titles.add("招聘");
        HotServiceAdapter hotServiceAdapter = new HotServiceAdapter(titles, PublicServiceActivity.this);
        rlv.setAdapter(hotServiceAdapter);

    }

    private void initListener() {

        //返回键事件
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
