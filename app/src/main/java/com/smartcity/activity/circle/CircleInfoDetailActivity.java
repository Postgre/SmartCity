package com.smartcity.activity.circle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.customview.CustomViewPager;
import com.smartcity.fragment.circle.ItemFragment2;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;
import com.zhy.base.adapter.recyclerview.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/9.
 */
public class CircleInfoDetailActivity extends BaseActivity {

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

    private List<Object[][]> groupNameList = new ArrayList<>();
    private String[] tabString = new String[]{"活动", "相册"};

    @Override
    public void init() {
        back_img.setVisibility(View.VISIBLE);
        title_tv.setVisibility(View.VISIBLE);
        title_tv.setText("智享工厂圈");
        initRecylerview();
        initTab();
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
                Intent intent = new Intent(CircleInfoDetailActivity.this,AllCircleDetailActivity.class);
                intent.putExtra("group",1);
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

    @OnClick({R.id.back_img,R.id.cr_name})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.back_img:
                finish();
                break;
            case R.id.cr_name:
                Intent intent = new Intent(this, AllCircleDetailActivity.class);
                startActivity(intent);
                break;

        }
    }
}
