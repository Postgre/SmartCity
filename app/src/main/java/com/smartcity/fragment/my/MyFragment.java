package com.smartcity.fragment.my;

import android.content.Intent;
import android.os.Bundle;

import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.activity.life.LifeAddressListActivity;
import com.smartcity.activity.life.LifeCratActivity;
import com.smartcity.base.BaseFragment;

import butterknife.OnClick;

public class MyFragment extends BaseFragment {



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

    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_fans;
    }

    @OnClick(R.id.fen_rl_city_account)
    public void startLogin()
    {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }

    @OnClick(R.id.fen_rl_publish_activites)
    public void startAddressList()
    {
        startActivity(new Intent(getActivity(), LifeAddressListActivity.class));
    }
    @OnClick(R.id.fen_rl_pay_order)
    public void startLifeCart()
    {
        startActivity(new Intent(getActivity(), LifeCratActivity.class));
    }

}