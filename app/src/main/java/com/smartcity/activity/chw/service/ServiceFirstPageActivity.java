package com.smartcity.activity.chw.service;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.smartcity.R;
import com.smartcity.adapter.chw.service.HotServiceAdapter;
import com.smartcity.adapter.chw.service.ServiceFenNeiAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyuan on 2016/5/19.
 */
public class ServiceFirstPageActivity extends Activity {
    List<String> titles;
    GridView gridView;
    private ListView lv;
    private View header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_firstpage);
        initView();
        initData();
    }

    private void initView() {
        header = View.inflate(this, R.layout.header_listview_hot_service,null);
        gridView = (GridView) header.findViewById(R.id.gribview);
        lv = (ListView) findViewById(R.id.lv);

    }

    private void initData() {
        titles = new ArrayList<>();
        titles.add("租房");
        titles.add("教育");
        titles.add("招聘");
        titles.add("美妆");
        titles.add("健康");
        titles.add("商务");
        titles.add("维修");
        titles.add("专家团");
      ServiceFenNeiAdapter neiAdapter = new ServiceFenNeiAdapter(titles,this);
        gridView.setAdapter(neiAdapter);

        HotServiceAdapter serviceAdapter = new HotServiceAdapter(titles,this);

        lv.addHeaderView(header);
        lv.setAdapter(serviceAdapter);
    }


}
