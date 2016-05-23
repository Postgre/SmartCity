package com.smartcity.activity.life;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.smartcity.R;
import com.smartcity.base.BaseFragment;
import com.smartcity.fragment.life.OrderStateFragment;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 订单页面
 * 待付款
 * 代发货
 * 待收货
 * */
public class LifeOrderStateActivity extends LifeBaseActivity {



    @Bind(R.id.order_tab_container)
    TabLayout tabContainer;

    @Bind(R.id.order_vp_container)
    ViewPager vpContainer;
    private String[] titles;



    @Override
    protected void initViews() {
        titles = UIUtils.getStringArray(R.array.order_state_title);
        for(String title: titles)
        {
            tabContainer.addTab(tabContainer.newTab().setText(title));
        }

        tabContainer.setTabMode(TabLayout.MODE_SCROLLABLE);

        vpContainer.setAdapter(new VpAdapter(getSupportFragmentManager()));
        tabContainer.setupWithViewPager(vpContainer);
    }

    @Override
    protected String getName() {
        return "订单页面";
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
        return R.layout.activity_life_order_state;
    }


    private class VpAdapter extends FragmentPagerAdapter
    {

        private List<BaseFragment> lists;
        public VpAdapter(FragmentManager fm) {
            super(fm);
            lists = new ArrayList<>();

            for(int i=0;i<titles.length;i++)
            {
                lists.add( OrderStateFragment.getInstance(i));

            }
        }

        @Override
        public Fragment getItem(int position) {
            return lists.get(position);
        }

        @Override
        public int getCount() {
            LogTool.e("test",String.valueOf(titles.length));
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
