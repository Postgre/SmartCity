package com.smartcity.fragment.chw.wyx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartcity.R;
import com.smartcity.base.BaseFragment;
import com.smartcity.pulltofresh.PullToRefreshRecycleView;
import com.smartcity.utils.ScrollableHelper;

import butterknife.Bind;


public class TransmitFragment extends BaseFragment implements ScrollableHelper.ScrollableContainer {

    @Bind(R.id.trans_listview)
    PullToRefreshRecycleView trans_listview;

    private static final String ARG_PARAM1 = "param1";

    public static TransmitFragment newInstance() {
        TransmitFragment fragment = new TransmitFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
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
    public View getScrollableView() {
        return trans_listview.getRefreshableView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_transmit;
    }
}
