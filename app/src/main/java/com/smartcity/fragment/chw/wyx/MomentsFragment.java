package com.smartcity.fragment.chw.wyx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartcity.R;
import com.smartcity.activity.chw.wyx.CoolDetailActivity;
import com.smartcity.adapter.chw.wyx.MomentsAdapter;
import com.smartcity.base.BaseFragment;
import com.smartcity.customview.SpacesItemDecoration;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.presenterImpl.CoolPresenterImpl;
import com.smartcity.pulltofresh.PullToRefreshBase;
import com.smartcity.pulltofresh.PullToRefreshRecycleView;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.ScrollableHelper;
import com.smartcity.view.ICoolView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MomentsFragment extends BaseFragment implements ICoolView, PullToRefreshBase.OnRefreshListener2<RecyclerView>, MomentsAdapter.ItemCliclListener, ScrollableHelper
        .ScrollableContainer {
    private static final String TAG = MomentsFragment.class.getName();
    @Bind(R.id.moment_listview)
    PullToRefreshRecycleView momentListView;

    private static final String ARG_PARAM1 = "param1";
    private List<CoolInfo.CoolListInfo> coolList = new ArrayList<>();
    private MomentsAdapter momentsAdapter;

    private CoolPresenterImpl coolPresenterImpl;

    public static MomentsFragment newInstance() {
        MomentsFragment fragment = new MomentsFragment();
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
        initView();
        return view;
    }

    private void initView() {
        for (int i = 0; i < 13; i++) {
            CoolInfo.CoolListInfo info = new CoolInfo.CoolListInfo();
            info.setCoolCoverPic("http://1.2.3.4/1.png");
            coolList.add(info);
        }
        momentListView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        momentListView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        momentListView.setHasFixedSize(true);
        momentListView.setItemAnimator(new DefaultItemAnimator());
        SpacesItemDecoration decoration = new SpacesItemDecoration(5);
        momentListView.addItemDecoration(decoration);
        momentListView.setOnRefreshListener(this);
        coolPresenterImpl = new CoolPresenterImpl(this);
        coolPresenterImpl.getAllCool("1", "HBWH", "50", "0", "10");
        momentsAdapter = new MomentsAdapter(getActivity(), coolList);
        momentsAdapter.setListener(this);
        momentListView.setAdapter(momentsAdapter);
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
    public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
        momentListView.onRefreshComplete();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
        momentListView.onRefreshComplete();
    }

    @Override
    public View getScrollableView() {
        return momentListView.getRefreshableView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_moments;
    }

    @Override
    public void showSuccessMsg(String msg) {

    }

    @Override
    public void showFailMsg(String msg) {
        LogTool.d(TAG, "msg=" + msg);
    }

    @Override
    public void showList(List<CoolInfo.CoolListInfo> list) {
        LogTool.d(TAG, "list=====" + list.size());
    }

    @Override
    public void onItemClick(int positon) {
        LogTool.d(TAG, " positon===========================" + positon);
        Intent intent = new Intent(getActivity(), CoolDetailActivity.class);
        startActivity(intent);
    }
}
