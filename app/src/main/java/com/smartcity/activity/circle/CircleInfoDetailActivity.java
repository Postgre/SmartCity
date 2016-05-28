package com.smartcity.activity.circle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.application.MyApplication;
import com.smartcity.base.BaseActivity;
import com.smartcity.customview.CustomViewPager;
import com.smartcity.fragment.circle.ItemFragment2;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.model.CircleByLabel;
import com.smartcity.http.model.CircleGroupInfo;
import com.smartcity.http.model.LabelBean;
import com.smartcity.presenter.ApplyJoinCirclePresenter;
import com.smartcity.presenter.CirclePresenter;
import com.smartcity.presenterImpl.ApplyJoinCirclePresenterImpl;
import com.smartcity.presenterImpl.CirclePresenterImpl;
import com.smartcity.view.ICircleView;
import com.smartcity.view.IGroupView;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;
import com.zhy.base.adapter.recyclerview.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Administrator on 2016/5/9.
 */
public class CircleInfoDetailActivity extends BaseActivity implements IGroupView, ICircleView {

    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.cr_name)
    TextView crName;
    @Bind(R.id.cr_type_name)
    ImageView crTypeName;
    @Bind(R.id.cr_type)
    TextView crType;
    @Bind(R.id.ll_type)
    LinearLayout llType;
    @Bind(R.id.cr_num_img)
    ImageView crNumImg;
    @Bind(R.id.cr_num)
    TextView crNum;
    @Bind(R.id.ll_num)
    LinearLayout llNum;
    @Bind(R.id.content)
    LinearLayout content;
    @Bind(R.id.tv_cd_join)
    TextView tvCdJoin;
    @Bind(R.id.tab)
    TabLayout tab;
    @Bind(R.id.vp)
    CustomViewPager vp;
    @Bind(R.id.back_img)
    ImageView back_img;
    @Bind(R.id.title_tv)
    TextView title_tv;
    @Bind(R.id.videoplayer)
    JCVideoPlayerStandard videoplayer;

    private List<Object[][]> groupNameList = new ArrayList<>();
    private String[] tabString = new String[]{"活动", "相册"};
    private CirclePresenter circlePresenter;
    private String circlrId;
    private ApplyJoinCirclePresenter joinCirclePresenter;
    private String apikey;
    private String userId;

    @Override
    public void init() {

        circlePresenter = new CirclePresenterImpl(this, "group");
        joinCirclePresenter = new ApplyJoinCirclePresenterImpl(this);

        circlrId = getIntent().getStringExtra("circlrId");
        String circlrName = getIntent().getStringExtra("circlrName");
        String circlrVideoUrl = getIntent().getStringExtra("circlrVideoUrl");
        int circlrPeopleNum = getIntent().getIntExtra("circlrPeopleNum", 0);
        int circlrtype = getIntent().getIntExtra("circlrtype", 0);
        apikey = MyApplication.getApikey();
        userId = MyApplication.getId();

        back_img.setVisibility(View.VISIBLE);
        title_tv.setVisibility(View.VISIBLE);
        title_tv.setText(circlrName);
        crName.setText(circlrName);
        crNum.setText(circlrPeopleNum + "人");

        if (circlrtype == 0) {
            crType.setText("玩家圈");
        } else if (circlrtype == 1) {
            crType.setText("尊享圈");
        }

        initData();

        initRecylerview();
        initTab();
    }

    private void initData() {
        //videoPlayer
        videoplayer.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4", "");
        videoplayer.ivThumb.setImageResource(R.mipmap.tem2);

        circlePresenter.getGroupsListByPid(apikey, "5", "1", "10");//temp
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    private void initTab() {
        vp.setAdapter(new TabPageIndicatorAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(vp);
        tab.setTabMode(TabLayout.MODE_FIXED);
    }


    private void initRecylerview() {
        groupNameList.add(new Object[][]{{"登山小组"}, {R.mipmap.temp_img}});
        groupNameList.add(new Object[][]{{"自拍小组"}, {R.mipmap.temp_img}});
        groupNameList.add(new Object[][]{{"散步小组"}, {R.mipmap.temp_img}});
        groupNameList.add(new Object[][]{{"登山小组"}, {R.mipmap.temp_img}});
        groupNameList.add(new Object[][]{{"登山小组"}, {R.mipmap.temp_img}});
        groupNameList.add(new Object[][]{{"登山小组"}, {R.mipmap.temp_img}});
        groupNameList.add(new Object[][]{{"登山小组"}, {R.mipmap.temp_img}});

        LinearLayoutManager manager = new LinearLayoutManager(this);

        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(manager);

        CommonAdapter<Object[][]> adapter = new CommonAdapter<Object[][]>(this, R.layout.grid_item, groupNameList) {

            @Override
            public void convert(ViewHolder viewHolder, Object[][] objects) {
                viewHolder.setText(R.id.tv_group_name, (String) objects[0][0]);
                viewHolder.setImageUrl(R.id.sv_group_img, "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1681882397,3535453166&fm=111&gp=0.jpg");
            }
        };
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener<Object[][]>() {
            @Override
            public void onItemClick(ViewGroup viewGroup, View view, Object[][] objects, int i) {
                Intent intent = new Intent(CircleInfoDetailActivity.this, AllCircleDetailActivity.class);
                intent.putExtra("group", 1);
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(ViewGroup viewGroup, View view, Object[][] objects, int i) {
                return false;
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_info_deatail;
    }

    @Override
    public void addGroups(List<CircleGroupInfo.DataEntity> list) {
        Log.d("CircleGroupInfo", "list.size():" + list.size());

        LinearLayoutManager manager = new LinearLayoutManager(this);

        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(manager);

        CommonAdapter<CircleGroupInfo.DataEntity> adapter = new CommonAdapter<CircleGroupInfo.DataEntity>(this, R.layout.grid_item, list) {

            @Override
            public void convert(ViewHolder viewHolder, CircleGroupInfo.DataEntity dataEntity) {
                viewHolder.setText(R.id.tv_group_name, dataEntity.getDetailName());
                viewHolder.setImageUrl(R.id.sv_group_img, dataEntity.getDetailTitlePic());
            }
        };
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener<CircleGroupInfo.DataEntity>() {


            @Override
            public void onItemClick(ViewGroup viewGroup, View view, CircleGroupInfo.DataEntity dataEntity, int i) {
                Intent intent = new Intent(CircleInfoDetailActivity.this, AllCircleDetailActivity.class);
                intent.putExtra("group", 1);
                intent.putExtra("groupId",String.valueOf(dataEntity.getDetailId()));
                intent.putExtra("groupName",dataEntity.getDetailName());
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(ViewGroup viewGroup, View view, CircleGroupInfo.DataEntity dataEntity, int i) {
                return false;
            }
        });

    }

    class TabPageIndicatorAdapter extends FragmentPagerAdapter {
        public TabPageIndicatorAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = new ItemFragment2();
            Bundle args = new Bundle();
            args.putString("arg", tabString[position]);
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabString[position];
        }

        @Override
        public int getCount() {
            return tabString.length;
        }
    }

    @OnClick({R.id.back_img, R.id.cr_name, R.id.tv_cd_join, R.id.videoplayer})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.back_img:
                finish();
                break;
            case R.id.videoplayer:

                finish();
                break;
            case R.id.tv_cd_join:
                joinCirclePresenter.applyJoinCircle(apikey, circlrId, userId);

                break;
            case R.id.cr_name:
                Intent intent = new Intent(this, AllCircleDetailActivity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void addCircles(List<CircleBean.CirDataEntity> circleList) {

    }

    @Override
    public void addCirclesByLabel(List<CircleByLabel.DataEntity> circleList) {

    }

    @Override
    public void CircleGroup(List<CircleBean.CirDataEntity> circleList) {

    }

    @Override
    public void addLabels(List<LabelBean.DataEntity> labelList) {

    }

}
