package com.smartcity.fragment.life;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.smartcity.R;
import com.smartcity.base.BaseFragment;

import butterknife.Bind;

/**
 * Created by Yancy on 2016/5/13.
 */
public class ShopDetailFragment extends BaseFragment implements ScrollableHelper.ScrollableContainer{

    @Bind(R.id.shop_detail_ll_container)
    LinearLayout llContainer;
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
        return R.layout.shop_detail_frame_container;
    }

    @Override
    public View getScrollableView() {
        return llContainer;
    }
}
