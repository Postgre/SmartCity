package com.smartcity.activity.circle;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.smartcity.R;
import com.smartcity.fragment.circle.ItemFragment;

/**
 * Created by Administrator on 2016/5/3.
 */
public class Allcircle_Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String[] TITLE = new String[] { "健康养生", "汽车世界", "美丽计划", "女人生活","快乐生活","其他圈子1","其他圈子2"};
    private EditText search_bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_allcircle);

        initView();
    }

    private void initView() {
        search_bar = (EditText) findViewById(R.id.search_bar);
        search_bar.setOnClickListener(this);
        RollPagerView rl_viewpager = (RollPagerView) findViewById(R.id.rl_viewpager);
//        rl_viewpager.setHintView(new IconHintView(this,R.mipmap.tab_focus,R.mipmap.tab_nomal));
//        rl_viewpager.setHintView(new TextHintView(this));
        rl_viewpager.setHintView(new ColorPointHintView(this, Color.RED, Color.WHITE));

        rl_viewpager.setAdapter(new VAdapter());


        //title tab
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        ViewPager vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new TabPageIndicatorAdapter(getSupportFragmentManager()));

        tabLayout.setupWithViewPager(vp);
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
    }

    private class VAdapter extends StaticPagerAdapter{

        int[] imgs = {R.mipmap.circle_header_img, R.mipmap.circle_header_img, R.mipmap.circle_header_img, R.mipmap.circle_header_img};

        @Override
        public View getView(ViewGroup container, int position) {
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(Allcircle_Activity.this);
            simpleDraweeView.setScaleType(SimpleDraweeView.ScaleType.CENTER);
            simpleDraweeView.setImageResource(imgs[position]);
            simpleDraweeView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            return simpleDraweeView;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }

    class TabPageIndicatorAdapter extends FragmentPagerAdapter {
        public TabPageIndicatorAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = new ItemFragment();
            Bundle args = new Bundle();
            args.putString("arg", TITLE[position]);
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position];
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }
    }

}
