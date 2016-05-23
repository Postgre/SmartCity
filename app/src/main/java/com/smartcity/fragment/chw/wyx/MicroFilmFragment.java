package com.smartcity.fragment.chw.wyx;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartcity.R;
import com.smartcity.adapter.chw.wyx.MomentsAdapter;
import com.smartcity.base.BaseFragment;
import com.smartcity.customview.SpacesItemDecoration;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.pulltofresh.PullToRefreshBase;
import com.smartcity.pulltofresh.PullToRefreshRecycleView;
import com.smartcity.utils.ScrollableHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MicroFilmFragment extends BaseFragment implements ScrollableHelper.ScrollableContainer {

    @Bind(R.id.micro_listview)
    PullToRefreshRecycleView micro_listview;

    private List<CoolInfo.CoolListInfo> coolList = new ArrayList<>();
    private MomentsAdapter momentsAdapter;

    private static final String ARG_PARAM1 = "param1";

    public static MicroFilmFragment newInstance() {
        MicroFilmFragment fragment = new MicroFilmFragment();
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
        micro_listview.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        micro_listview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        micro_listview.setHasFixedSize(true);
        micro_listview.setItemAnimator(new DefaultItemAnimator());
        SpacesItemDecoration decoration = new SpacesItemDecoration(5);
        micro_listview.addItemDecoration(decoration);
        momentsAdapter = new MomentsAdapter(getActivity(), coolList);
        micro_listview.setAdapter(momentsAdapter);
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
        return micro_listview.getRefreshableView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_micro_film;
    }
}
