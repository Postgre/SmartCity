package com.smartcity.activity.money;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.smartcity.R;
import com.smartcity.adapter.chw.wyx.MyFragmentPagerAdapter;
import com.smartcity.bean.SelectItem;
import com.smartcity.fragment.chw.wyx.CoolFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class QuCouMeiActivity extends AppCompatActivity {

    @Bind(R.id.tabLyout)
    TabLayout tabLayout;

    @Bind(R.id.viewpager)
    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qu_cou_mei);
    }

    private void initView() {
        setupViewPager(mPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        List<SelectItem> listViews = new ArrayList<>();
        SelectItem momentItem = new SelectItem(CoolFragment.newInstance(1), getResources().getString(R
                .string.str_jcsk));
        SelectItem filmItem = new SelectItem(CoolFragment.newInstance(2), getResources().getString(R
                .string.str_wdy));
        listViews.add(momentItem);
        listViews.add(filmItem);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), listViews);
        viewPager.setAdapter(adapter);
    }
}
