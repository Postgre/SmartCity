package com.smartcity.fragment.circle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smartcity.R;
import com.smartcity.activity.circle.CircleInfoDetailActivity;
import com.smartcity.application.MyApplication;
import com.smartcity.base.BaseFragment;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.model.CircleByLabel;
import com.smartcity.http.model.LabelBean;
import com.smartcity.presenter.CirclePresenter;
import com.smartcity.presenterImpl.CirclePresenterImpl;
import com.smartcity.view.ICircleView;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;
import com.zhy.base.adapter.recyclerview.DividerItemDecoration;
import com.zhy.base.adapter.recyclerview.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/13.
 */
public class NewItemFragment extends BaseFragment implements ICircleView {
    @Bind(R.id.cr_recycleview)
    RecyclerView crRecycleview;
    private String arg;
    private CirclePresenter circlePresenter;
    private List<CircleBean.CirDataEntity> temList = new ArrayList<>();

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {
        arg = getArguments().getString("arg");
//        Log.i("NewItemFragment", arg);
    }

    @Override
    protected void init() {
        circlePresenter = new CirclePresenterImpl(this);

        String apikey = MyApplication.getApikey();

        circlePresenter.getCircleListByLabel(apikey, arg, "0", "10");
//        circlePresenter.getLabels(apikey, "1", "10");

        if (temList.size() != 0) {
            temList.clear();
        }

        temList.add(new CircleBean.CirDataEntity("智慧生活圈", "创建人：林志玲", "https://ss0.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=7f74bb149745d688bc02b5a494c37dab/f703738da97739120f92f746fd198618367ae265.jpg"));
        temList.add(new CircleBean.CirDataEntity("智慧生活圈", "创建人：林志玲", "https://ss0.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=7f74bb149745d688bc02b5a494c37dab/f703738da97739120f92f746fd198618367ae265.jpg"));
        temList.add(new CircleBean.CirDataEntity("智慧生活圈", "创建人：林志玲", "https://ss0.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=7f74bb149745d688bc02b5a494c37dab/f703738da97739120f92f746fd198618367ae265.jpg"));
        temList.add(new CircleBean.CirDataEntity("智慧生活圈", "创建人：林志玲", "https://ss0.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=7f74bb149745d688bc02b5a494c37dab/f703738da97739120f92f746fd198618367ae265.jpg"));
        temList.add(new CircleBean.CirDataEntity("智慧生活圈", "创建人：林志玲", "https://ss0.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=7f74bb149745d688bc02b5a494c37dab/f703738da97739120f92f746fd198618367ae265.jpg"));
        temList.add(new CircleBean.CirDataEntity("智慧生活圈", "创建人：林志玲", "https://ss0.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=7f74bb149745d688bc02b5a494c37dab/f703738da97739120f92f746fd198618367ae265.jpg"));


//        setTemListforRestcleView();

    }

    private void setTemListforRestcleView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        crRecycleview.setLayoutManager(manager);
        crRecycleview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        CommonAdapter<CircleBean.CirDataEntity> adapter = new CommonAdapter<CircleBean.CirDataEntity>(getActivity(), R.layout.fr_recycleview_item, temList) {
            @Override
            public void convert(ViewHolder viewHolder, CircleBean.CirDataEntity cirDataEntity) {
                viewHolder.setText(R.id.cir_name, cirDataEntity.getDetailName());
                viewHolder.setText(R.id.tv_cr_name, cirDataEntity.getSUserName());
                viewHolder.setImageUrl(R.id.header_img, cirDataEntity.getDetailEwmPic());

                viewHolder.setOnClickListener(R.id.join3, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "加入圈子成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        crRecycleview.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener<CircleBean.CirDataEntity>() {
            @Override
            public void onItemClick(ViewGroup viewGroup, View view, CircleBean.CirDataEntity cirDataEntity, int i) {
                Intent intent = new Intent(getActivity(), CircleInfoDetailActivity.class);
                getActivity().startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(ViewGroup viewGroup, View view, CircleBean.CirDataEntity cirDataEntity, int i) {
                return false;
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_new_item;
    }

    @Override
    public void addCircles(List<CircleBean.CirDataEntity> circleList) {

    }

    @Override
    public void addCirclesByLabel(List<CircleByLabel.DataEntity> circleList) {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        crRecycleview.setLayoutManager(manager);
        crRecycleview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        CommonAdapter<CircleByLabel.DataEntity> adapter = new CommonAdapter<CircleByLabel.DataEntity>(getActivity(), R.layout.fr_recycleview_item, circleList) {


            @Override
            public void convert(ViewHolder viewHolder, CircleByLabel.DataEntity dataEntity) {
                viewHolder.setImageUrl(R.id.header_img, "https://ss0.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=7f74bb149745d688bc02b5a494c37dab/f703738da97739120f92f746fd198618367ae265.jpg");
                viewHolder.setText(R.id.cir_name, dataEntity.getDetailName());
                viewHolder.setText(R.id.tv_cr_name, dataEntity.getSUserName());

                viewHolder.setOnClickListener(R.id.join3, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "加入圈子成功", Toast.LENGTH_SHORT).show();


                    }
                });
            }
        };
        crRecycleview.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener<CircleByLabel.DataEntity>() {
            @Override
            public void onItemClick(ViewGroup viewGroup, View view, CircleByLabel.DataEntity cirDataEntity, int i) {
                Intent intent = new Intent(getActivity(), CircleInfoDetailActivity.class);
                getActivity().startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(ViewGroup viewGroup, View view, CircleByLabel.DataEntity cirDataEntity, int i) {
                return false;
            }
        });
    }

    @Override
    public void CircleGroup(List<CircleBean.CirDataEntity> circleList) {

    }

    @Override
    public void addLabels(List<LabelBean.DataEntity> labelList) {
        Log.d("NewItemFragmentii", "labelList.size():" + labelList.size());
    }
}
