package com.smartcity.activity.chw.service;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.adapter.chw.service.LiuYanAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenyuan
 * 2016 05 20:00
 * 武汉智创工厂
 */
public class LiuYanActivity extends Activity {
    @Bind(R.id.backBtn)
    ImageView backBtn;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.lv)
    ListView lv;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liuyan);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initListener() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initData() {
        data = new ArrayList<>();
        data.add("1");
        data.add("1");
        data.add("1");
        LiuYanAdapter liuYanAdapter = new LiuYanAdapter(data,LiuYanActivity.this);
        lv.setAdapter(liuYanAdapter);

    }
}
