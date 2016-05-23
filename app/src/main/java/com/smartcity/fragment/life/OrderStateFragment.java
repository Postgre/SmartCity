package com.smartcity.fragment.life;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.smartcity.R;
import com.smartcity.base.BaseFragment;
import com.smartcity.pulltofresh.PullToRefreshListView;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Yancy on 2016/5/16.
 */
public class OrderStateFragment extends BaseFragment {

    @Bind(R.id.order_state_recy_container)
    PullToRefreshListView recyContainer;


    private int type ;
    public static OrderStateFragment getInstance(int type)
    {
        OrderStateFragment orderStateFragment = new OrderStateFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        orderStateFragment.setArguments(bundle);
        return orderStateFragment;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {
        Bundle bundle = getArguments();
        this.type = bundle.getInt("type",0);

        final List<String> datas = new ArrayList<>();

        for(int i=0;i<20;i++)
        {
            datas.add(new String("adfa"));
        }
        recyContainer.setAdapter(new com.zhy.base.adapter.abslistview.CommonAdapter<String>(getActivity(),R.layout.order_state_item,datas) {
            @Override
            public void convert(ViewHolder viewHolder, String s) {
                viewHolder.setText(R.id.state_item_tv_shop_name, s);
                RecyclerView recyclerView = viewHolder.getView(R.id.state_item_recy_container);
                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(manager);

                recyclerView.setAdapter(new CommonAdapter<String>(getActivity(),R.layout.order_state_item_recy_item,datas) {

                    @Override
                    public void convert(ViewHolder viewHolder, String s) {

                    }
                });
            }
        });

    }

    @Override
    protected void init() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_state;
    }
}
