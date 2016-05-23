package com.smartcity.fragment.life;

import android.os.Bundle;
import android.text.TextUtils;

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
 */
public class LifeIndexNearFragment  extends BaseFragment implements ILifeIndexNearView {

    @Bind(R.id.near_gv_container)
    LifeGridView gvContainer;

    private static final String TYPE = "type";
    private CommonAdapter<HopShopAndBanner.DataBean> adapter;
    private LifeIndexPresenter lifeIndexPresenter;
    private boolean isVisible;
    private boolean isPrepared;
    private boolean mHasLoadedOnce;

    public static LifeIndexNearFragment getinstance(int type)
    {
        LifeIndexNearFragment fragmen= new LifeIndexNearFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE,type);
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
        LogTool.e("test","onInvisible");
    }

    private void onVisible() {
        LogTool.e("test","onVisible");

        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        }
        loadData();
    }

    private void loadData() {
        Bundle bundle = getArguments();
        lifeIndexPresenter = new LifeIndexPresenter(this,bundle.getInt(TYPE, 1));
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {
        initGridView();
        if (getUserVisibleHint() && !mHasLoadedOnce) {
            isPrepared = true;
            loadData();
        }
        mHasLoadedOnce = true;
    }

    private void initGridView() {

        gvContainer.setAdapter(adapter = new com.zhy.base.adapter.abslistview.CommonAdapter<HopShopAndBanner.DataBean>(getActivity(),R.layout.near_item,null) {

            @Override
            public void convert(ViewHolder viewHolder, HopShopAndBanner.DataBean dataBean) {
                viewHolder.setText(R.id.near_tv_name, TextUtils.isEmpty(dataBean.getName())?dataBean.getName():"");
                viewHolder.setImageUrl(R.id.near_iv_img,dataBean.getLogoUrl());
            }
        });
    }

    @Override
    protected void init() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_life_index_near;
    }


    @Override
    public void setNearShop(HopShopAndBanner banner) {
        adapter.setDatas(banner.getData());
    }

}
