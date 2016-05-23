package com.smartcity.fragment.my;

import android.content.Intent;
import android.os.Bundle;

import com.smartcity.R;
import com.smartcity.activity.life.LifeAddressListActivity;
import com.smartcity.activity.life.LifeCratActivity;
import com.smartcity.base.BaseFragment;

public class MyFragment extends BaseFragment {
    private static final String TAG = "MyFragment";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void init() {
      //  startActivity(new Intent(getActivity(), CommodityReviewListActivity.class));
        startActivity(new Intent(getActivity(), LifeCratActivity.class));
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_life;
    }
}