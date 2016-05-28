package com.smartcity.fragment.circle;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.smartcity.R;
import com.smartcity.application.MyApplication;
import com.smartcity.base.BaseFragment;
import com.smartcity.http.model.ActivityModel;
import com.smartcity.presenter.CirclePresenter;
import com.smartcity.presenterImpl.CirclePresenterImpl;
import com.smartcity.view.IActivityView;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/4.
 */
public class ItemFragment2 extends BaseFragment implements IActivityView {


    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {

    }


    @Override
    protected void init() {

        CirclePresenter circlePresenter = new CirclePresenterImpl(this,"1","1");
        circlePresenter.getActivityList(MyApplication.getApikey(),"2","1","10");
    }

    @Override
    public int getLayoutId() {
        return R.layout.tem2layout;
    }

    @Override
    public void addActivityData(List<ActivityModel.DataEntity> list) {
        Log.d("addActivityData", "list.size():" + list.size());

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);

        CommonAdapter<ActivityModel.DataEntity> adapter = new CommonAdapter<ActivityModel.DataEntity>(getActivity(),R.layout.circle_activity_item, list) {
            @Override
            public void convert(ViewHolder viewHolder, ActivityModel.DataEntity dataEntity) {
                viewHolder.setText(R.id.title,dataEntity.getDetailName());
                viewHolder.setText(R.id.allpeople, "总需人数："+dataEntity.getDetailMaxTotal()+"人");
                viewHolder.setText(R.id.stillpeople, "剩余人数："+(dataEntity.getDetailMaxTotal()-dataEntity.getDetailRealJoinNumber())+"人");
                viewHolder.setText(R.id.price, "¥ "+dataEntity.getDetailJoinMoney());
            }
        };

        recyclerview.setAdapter(adapter);

    }
}
