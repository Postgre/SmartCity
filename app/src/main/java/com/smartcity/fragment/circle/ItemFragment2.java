package com.smartcity.fragment.circle;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smartcity.R;
import com.smartcity.base.BaseFragment;
import com.smartcity.bean.ActivityModel;
import com.smartcity.bean.Card_item_Model;
import com.smartcity.bean.Talent;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/4.
 */
public class ItemFragment2 extends BaseFragment {


    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    private View contextView;

    private List<ActivityModel.Activity> list = new ArrayList<>();

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {

    }


    @Override
    protected void init() {
//        Activity(int detailMaxTotal, int detailRealJoinNumber, String detailName, String detailPicUrl, int detailJoinMoney, int detailTypeId, int detailStatus) {
        list.add(new ActivityModel.Activity(100,60,"一路向南，新西兰之旅","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1681882397,3535453166&fm=111&gp=0.jpg",1000,0,0));
        list.add(new ActivityModel.Activity(100,60,"一路向南，新西兰之旅","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1681882397,3535453166&fm=111&gp=0.jpg",1000,0,0));
        list.add(new ActivityModel.Activity(100,60,"一路向南，新西兰之旅","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1681882397,3535453166&fm=111&gp=0.jpg",1000,0,0));
        list.add(new ActivityModel.Activity(100,60,"一路向南，新西兰之旅","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1681882397,3535453166&fm=111&gp=0.jpg",1000,0,0));
        list.add(new ActivityModel.Activity(100,60,"一路向南，新西兰之旅","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1681882397,3535453166&fm=111&gp=0.jpg",1000,0,0));

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
//        RecycleViewManager manager = new RecycleViewManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);

        recyclerview.setAdapter(new CommonAdapter<ActivityModel.Activity>(getActivity(), R.layout.circle_activity_item, list) {

            @Override
            public void convert(ViewHolder viewHolder, ActivityModel.Activity act) {
                viewHolder.setText(R.id.title,act.getDetailName());
                viewHolder.setText(R.id.allpeople, "总需人数："+act.getDetailMaxTotal()+"人");
                viewHolder.setText(R.id.stillpeople, "剩余人数："+(act.getDetailMaxTotal()-act.getDetailRealJoinNumber())+"人");
                viewHolder.setText(R.id.price, "¥ "+act.getDetailJoinMoney());
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.tem2layout;
    }


    private void initData() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
