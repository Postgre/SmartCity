package com.smartcity.activity.circle;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.adapter.circle.Life_contentAdapter;
import com.smartcity.base.BaseActivity;
import com.smartcity.http.model.Life_Content;
import com.zhy.base.adapter.recyclerview.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

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
    @Bind(R.id.life_recycleView)
    RecyclerView life_recycleView;

    private List<Life_Content.DataEntity.ScSysUserEntity> list = new ArrayList<>();

    @Override
    public void init() {

        titleTv.setText("生活感悟");

        list.add(new Life_Content.DataEntity.ScSysUserEntity("马丁路德金","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=806167121,1268231582&fm=116&gp=0.jpg"));
        list.add(new Life_Content.DataEntity.ScSysUserEntity("马丁路德金","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=806167121,1268231582&fm=116&gp=0.jpg"));
        list.add(new Life_Content.DataEntity.ScSysUserEntity("马丁路德金","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=806167121,1268231582&fm=116&gp=0.jpg"));
        list.add(new Life_Content.DataEntity.ScSysUserEntity("马丁路德金","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=806167121,1268231582&fm=116&gp=0.jpg"));
        list.add(new Life_Content.DataEntity.ScSysUserEntity("马丁路德金","https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=806167121,1268231582&fm=116&gp=0.jpg"));

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        life_recycleView.setLayoutManager(manager);
        Life_contentAdapter adapter = new Life_contentAdapter(this, R.layout.life_content_item, list);
        life_recycleView.setAdapter(adapter);
        life_recycleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        adapter.notifyDataSetChanged();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_lift__content;
    }

    @OnClick(R.id.back_img)
    public void onClick() {
        finish();
    }
}
