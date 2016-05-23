package com.smartcity.adapter.chw.twentyfourhour;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/17.
 */
public class TwentyFourHourFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> views = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    public TwentyFourHourFragmentAdapter(FragmentManager fm, List<Fragment> views, List<String> titles) {
        super(fm);
        this.views = views;
        this.titles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override

    public Fragment getItem(int position) {
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }
}
