package com.smartcity.activity.life;

import android.view.View;

import com.smartcity.R;
import com.smartcity.fragment.life.ChoseBrandFragment;
import com.smartcity.pulltofresh.PullToRefreshListView;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Yancy on 2016/5/10.
 */
public class ShopListActivity extends LifeBaseActivity {


    @Override
    protected void initViews() {
        initRecy();
    }


    private ChoseBrandFragment choseBrandFragment;

    private void initRecy() {


        choseBrandFragment = new ChoseBrandFragment();

        List<String> datas  = new ArrayList<>();

        for(int i=0;i<10;i++)
        {
            datas.add(new String());
        }
        recycleViewContainer.setAdapter(new CommonAdapter<String>(this,R.layout.shop_item,datas) {


            @Override
            public void convert(ViewHolder viewHolder, String s) {

            }
        });
    }

    @Override
    protected String getName() {
        return "xxx";
    }

    @Override
    protected View getCenterView() {
        return null;
    }

    @Override
    protected View getRightView() {
        return null;
    }


    @Bind(R.id.shop_recy_container)
    PullToRefreshListView recycleViewContainer;



    @Override
    protected int getContentId() {
        return R.layout.activity_shop_list;
    }


    //TODO 显示品牌弹窗
    @OnClick(R.id.shop_tv_brand)
    public void showBrand()
    {
        choseBrandFragment.show(getSupportFragmentManager(),"shopActivity");
    }

    public void showSales()
    {

    }

    public void showLocation()
    {

    }
}
