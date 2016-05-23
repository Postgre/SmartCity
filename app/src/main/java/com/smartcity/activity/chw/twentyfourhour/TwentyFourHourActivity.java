package com.smartcity.activity.chw.twentyfourhour;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.smartcity.R;
import com.smartcity.adapter.chw.twentyfourhour.TwentyFourHourFragmentAdapter;
import com.smartcity.fragment.chw.twentyfourhours.WuHanFragment;
import com.smartcity.fragment.life.CommodityFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyuan on 2016/5/17.
 */
public class TwentyFourHourActivity extends FragmentActivity {


    private TabLayout tab_fenlei;
    private ImageView iv_search;
    private ImageView iv_user;
    private ViewPager vp;
    private List<Fragment> views;
    private List<String> titles;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twentyfourhour);


        initView();
        initData();
        initListener();
    }

    private void initView() {
        tab_fenlei = (TabLayout) findViewById(R.id.tabl_fenlei);

      /*  tab_fenlei.addTab(tab_fenlei.newTab().setText("城会玩"));
        tab_fenlei.addTab(tab_fenlei.newTab().setText("圈子"));*/
        iv_search = (ImageView) findViewById(R.id.iv_search);
        iv_user = (ImageView) findViewById(R.id.iv_user);
        vp = (ViewPager) findViewById(R.id.vp);
    }

    private void initData() {
        views = new ArrayList<>();
        titles = new ArrayList<>();


        views.add(new WuHanFragment());
        views.add(new ListFragment());
        views.add(new CommodityFragment());
        views.add(new CommodityFragment());
        views.add(new CommodityFragment());
        views.add(new CommodityFragment());
        views.add(new CommodityFragment());
        views.add(new CommodityFragment());
        titles.add("武汉");
        titles.add("推荐");
        titles.add("视频");
        titles.add("美食");
        titles.add("时尚");
        titles.add("健康");
        titles.add("科技");
        titles.add("教育");


        TwentyFourHourFragmentAdapter adapter = new TwentyFourHourFragmentAdapter(getSupportFragmentManager(), views, titles);

        vp.setAdapter(adapter);
        tab_fenlei.setupWithViewPager(vp);
        tab_fenlei.setTabsFromPagerAdapter(adapter);

    }

    private void initListener() {

    }


}
