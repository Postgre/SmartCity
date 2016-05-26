package com.smartcity.fragment.life;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartcity.R;
import com.smartcity.base.BaseFragment;
import com.smartcity.customview.LifeGridView;
import com.smartcity.http.model.HopShopAndBanner;
import com.smartcity.presenterImpl.LifeIndexPresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.view.ILifeIndexNearView;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;

import butterknife.Bind;

/**
 * Created by Yancy on 2016/5/9.
 * <p/>
 * 1.viewpager 重写setoflimint(1)'
 * 2.fragment重写setUserVisibleHint方法  是否可见
 * 2.1 通过getUserVisibleHint()方法   判断当前fragment是否可见
 * 2.2 如果可见  调用 onVisible()方法  init数据
 * 2.3 如果不可见  调用 onInvisible()方法
 * <p/>
 * 3.onVisible ()方法 何时加载数据
 * 通过标记isVisible  来判断加载数据
 */
public class LifeIndexNearFragment extends BaseFragment implements ILifeIndexNearView {

    @Bind(R.id.near_gv_container)
    LifeGridView gvContainer;

    private static final String TYPE = "type";
    private CommonAdapter<HopShopAndBanner.DataBean> adapter;
    private LifeIndexPresenter lifeIndexPresenter;

    private View view = null;
    private boolean isVisible;
    private boolean isPrepared;
    private boolean mHasLoadedOnce;

    public static LifeIndexNearFragment getinstance(int type) {
        LifeIndexNearFragment fragmen = new LifeIndexNearFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, type);
        fragmen.setArguments(bundle);
        return fragmen;
    }

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

    private void onInvisible() {

    }

    private void onVisible() {
        loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (null == view) {
            view = super.onCreateView(inflater, container, savedInstanceState);
            initView();
            isPrepared = true;
            lifeIndexPresenter = new LifeIndexPresenter(this);
            loadData();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (null != parent) {
            parent.removeView(view);
        }
        return view;
    }

    private void initView() {
        initGridView();
        LogTool.e("near","initView near");
    }


    private void loadData() {

        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        }
        LogTool.e("test","near load data");
        Bundle bundle = getArguments();
        lifeIndexPresenter.initNear(bundle.getInt(TYPE, 1));
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

    private void initGridView() {

        gvContainer.setAdapter(adapter = new com.zhy.base.adapter.abslistview.CommonAdapter<HopShopAndBanner.DataBean>(getActivity(), R.layout.near_item, null) {

            @Override
            public void convert(ViewHolder viewHolder, HopShopAndBanner.DataBean dataBean) {
                viewHolder.setText(R.id.near_tv_name, TextUtils.isEmpty(dataBean.getName()) ? "":dataBean.getName());
                viewHolder.setImageUrl(R.id.near_iv_img, dataBean.getLogoUrl());
            }
        });
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_life_index_near;
    }


    @Override
    public void setNearShop(HopShopAndBanner banner) {
        LogTool.e("banner", "banner = " + banner);
        adapter.setDatas(banner.getData());
    }

    @Override
    public void setHasLoadDataOnce(boolean hasLoadDataOnce) {
        mHasLoadedOnce = hasLoadDataOnce;
    }
}
