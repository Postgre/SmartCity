package com.smartcity.activity.circle;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.smartcity.R;
import com.smartcity.application.MyApplication;
import com.smartcity.base.BaseActivity;
import com.smartcity.config.Constant;
import com.smartcity.fragment.circle.ItemFragment;
import com.smartcity.fragment.circle.NewItemFragment;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.model.LabelBean;
import com.smartcity.http.model.MyCircle_Bean;
import com.smartcity.presenter.CirclePresenter;
import com.smartcity.presenterImpl.CirclePresenterImpl;
import com.smartcity.utils.SharedPreferencesUtil;
import com.smartcity.view.ICircleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/3.
 */
public class NewAllcircle_Activity extends BaseActivity implements ICircleView {

    @Bind(R.id.back_img)
    ImageView back;
    @Bind(R.id.edittext_search)
    TextView edittext;
    @Bind(R.id.right_sousuo)
    ImageView right;
    private CirclePresenter circlePresenter;
    private List<String> stringList = new ArrayList<>();
    private TabPageIndicatorAdapter adapter;

    @Override
    public void init() {

        circlePresenter = new CirclePresenterImpl(this);

        initData();
        initView();

    }

    private void initData() {
        SharedPreferencesUtil spUtils = MyApplication.getSpUtils();
        String apikey = spUtils.getString(Constant.API_KEY, "");
        circlePresenter.getLabels(apikey, "1", "10");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_allcircle;
    }

    private void initView() {
        edittext.setVisibility(View.VISIBLE);
        right.setImageResource(R.mipmap.add_circle);
        right.setVisibility(View.VISIBLE);
        RollPagerView rl_viewpager = (RollPagerView) findViewById(R.id.rl_viewpager);
//        rl_viewpager.setHintView(new IconHintView(this,R.mipmap.tab_focus,R.mipmap.tab_nomal));
//        rl_viewpager.setHintView(new TextHintView(this));
        rl_viewpager.setHintView(new ColorPointHintView(this, Color.RED, Color.WHITE));

        rl_viewpager.setAdapter(new VAdapter());

        //title tab
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        ViewPager vp = (ViewPager) findViewById(R.id.vp);
        adapter = new TabPageIndicatorAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);

        tabLayout.setupWithViewPager(vp);
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        adapter.notifyDataSetChanged();
    }

    @OnClick({R.id.back_img, R.id.right_sousuo, R.id.edittext_search})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.right_sousuo:
                break;
            case R.id.edittext_search:
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void addCircles(List<CircleBean.CirDataEntity> circleList) {

    }

    @Override
    public void CircleGroup(List<CircleBean.CirDataEntity> circleList) {

    }

    @Override
    public void addLabels(List<LabelBean.DataEntity> labelList) {
        for (int i = 0; i < labelList.size(); i++) {
            String markContent = labelList.get(i).getMarkContent();
            stringList.add(markContent);
        }

        if (null != adapter) {
            adapter.notifyDataSetChanged();
        }
    }

    private class VAdapter extends StaticPagerAdapter {

        int[] imgs = {R.mipmap.circle_header_img, R.mipmap.circle_header_img, R.mipmap.circle_header_img, R.mipmap.circle_header_img};

        @Override
        public View getView(ViewGroup container, int position) {
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(NewAllcircle_Activity.this);
            simpleDraweeView.setScaleType(SimpleDraweeView.ScaleType.CENTER);
            simpleDraweeView.setImageResource(imgs[position]);
            simpleDraweeView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return simpleDraweeView;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }

    class TabPageIndicatorAdapter extends FragmentPagerAdapter {
        public TabPageIndicatorAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new NewItemFragment();
            Bundle args = new Bundle();
//            args.putString("arg", TITLE[position]);
            args.putString("arg", stringList.get(position));
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }

        @Override
        public int getCount() {

            return stringList.size();
        }
    }

}
