package com.smartcity.fragment.life;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.smartcity.R;
import com.smartcity.base.BaseFragment;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Yancy on 2016/5/14.
 * 商品评论列表
 */
public class CommodityFragment extends BaseFragment {

    private static int type;

    @Bind(R.id.commodity_recy_list)
    RecyclerView recyclerView;


    public static BaseFragment newInstance(int postion)
    {
        CommodityFragment commodityFragment = new CommodityFragment();
        type = postion;
        Bundle args = new Bundle();
        commodityFragment.setArguments(args);
        return commodityFragment;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {

        List<String> datas = new ArrayList<>();

        for(int i=0;i<20;i++)
        {
            datas.add(new String());
        }
        recyclerView.setAdapter(new CommonAdapter<String>(getActivity(),R.layout.commodity_list_left,datas) {

            @Override
            public void convert(ViewHolder viewHolder, String s) {
//                viewHolder.setVisible(R.id.commodity_ll_container,type ==1);
            }
        });
    }

    @Override
    protected void init() {

    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_commodity;
    }
}
