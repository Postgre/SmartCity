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
import com.smartcity.adapter.chw.wyx.CoolAdapter;
import com.smartcity.base.BaseFragment;
import com.smartcity.config.Constant;
import com.smartcity.customview.SpacesItemDecoration;
import com.smartcity.http.model.CoolDetailInfo;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.presenterImpl.CoolPresenterImpl;
import com.smartcity.pulltofresh.PullToRefreshBase;
import com.smartcity.pulltofresh.PullToRefreshRecycleView;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.ToastTool;
import com.smartcity.view.ICoolView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class CoolFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2<RecyclerView>, ICoolView, CoolAdapter.ItemCliclListener {
    private static final String TAG = CoolFragment.class.getName();
    private View view = null;

    @Bind(R.id.cool_listview)
    PullToRefreshRecycleView cool_listview;

    private static final String ARG_PARAM1 = "param1";
    private int mParam1;

    private List<CoolInfo.CoolListInfo> coolList = new ArrayList<>();
    private CoolAdapter coolAdapter;

    private CoolPresenterImpl coolPresenterImpl;

    private boolean isVisible = false;
    private boolean isPrepared = false;
    private boolean mHasLoadedOnce = false;

    private int startPage = 0;
    private boolean isDown = false;//下拉
    private boolean isUp = false;//上拉

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    public static CoolFragment newInstance(int param1) {
        CoolFragment fragment = new CoolFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
        LogTool.d(TAG, "mParam1======================" + mParam1);
        coolPresenterImpl = new CoolPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (null == view) {
            view = super.onCreateView(inflater, container, savedInstanceState);
            initView();
            isPrepared = true;
            loadData();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (null != parent) {
            parent.removeView(view);
        }
        return view;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }


    private void initView() {
        cool_listview.setMode(PullToRefreshBase.Mode.BOTH);
        cool_listview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        cool_listview.setHasFixedSize(true);
        cool_listview.setItemAnimator(new DefaultItemAnimator());
        SpacesItemDecoration decoration = new SpacesItemDecoration(5);
        cool_listview.addItemDecoration(decoration);
        cool_listview.setOnRefreshListener(this);
        coolAdapter = new CoolAdapter(getActivity(), coolList);
        coolAdapter.setListener(this);
        cool_listview.setAdapter(coolAdapter);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void init() {

    }

    private void onVisible() {
        loadData();
    }

    private void onInvisible() {

    }

    private void loadData() {
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        }
        coolPresenterImpl.getAllCool("1", "HBWH", "60", "1", startPage, 10);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
        isDown = true;
        startPage = 0;
        coolPresenterImpl.getAllCool("1", "HBWH", "60", "1", startPage, 10);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
        isUp = true;
        coolPresenterImpl.getAllCool("1", "HBWH", "60", "1", startPage, 10);
    }


    private void loadMoreData(int page) {
        coolPresenterImpl.getAllCool("1", "HBWH", "60", "1", page, 10);
    }

    @Override
    public void showSuccessMsg(String msg) {

    }

    @Override
    public void showFailMsg(String msg) {
        ToastTool.showShort(getActivity(), msg);
        cool_listview.onRefreshComplete();
    }

    @Override
    public void showList(List<CoolInfo.CoolListInfo> list) {
        cool_listview.onRefreshComplete();
        LogTool.d(TAG, "list=====" + list.size());
        coolList.addAll(list);
        LogTool.d(TAG, "coolList=====" + coolList.size());
        startPage = coolList.size();
        LogTool.d(TAG, "startPage=====" + startPage);
        coolAdapter.notifyDataSetChanged();
        mHasLoadedOnce = true;
    }

    @Override
    public void onItemClick(int positon) {
        LogTool.d(TAG, " positon===========================" + positon);
        CoolInfo.CoolListInfo coolListInfo = coolList.get(positon);
        Intent detailIntent = new Intent(getActivity(), CoolDetailActivity.class);
        detailIntent.putExtra(Constant.USER_CODE, (String) coolListInfo.getSysUser().getUsercode());
        detailIntent.putExtra(Constant.COOLID, coolListInfo.getCoolId());
        startActivity(detailIntent);
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showInfo(CoolDetailInfo.CoolDetailItemInfo info) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_cool;
    }


}
