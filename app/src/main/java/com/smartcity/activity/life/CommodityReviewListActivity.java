package com.smartcity.activity.life;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.smartcity.R;
import com.smartcity.fragment.life.CommodityFragment;

import butterknife.Bind;

/**
* 生活评论列表
* **/
public class CommodityReviewListActivity extends LifeBaseActivity {



    @Bind(R.id.commodity_tab)
    TabLayout tab;

    @Bind(R.id.commodity_vp)
    ViewPager vp;

    private String[] titles ={"全部评论","有图评论"};
    @Override
    protected void initViews() {

        tab.addTab(tab.newTab().setText(titles[0]));
        tab.addTab(tab.newTab().setText(titles[1]));
        tab.setTabMode(TabLayout.MODE_FIXED);
        vp.setAdapter(new CommodityAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(vp);

    }

    @Override
    protected String getName() {
        return "商品评论";
    }

    @Override
    protected View getCenterView() {
        return null;
    }

    @Override
    protected View getRightView() {
        return null;
    }

    @Override
    protected int getContentId() {
        return R.layout.activity_commodity_review_list;
    }

    private class CommodityAdapter extends FragmentPagerAdapter
    {

        public CommodityAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return CommodityFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
