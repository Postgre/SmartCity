package com.smartcity.fragment.chw.twentyfourhours;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseFragment;
import com.smartcity.customview.CircleMenuLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by chenyuan on 2016/5/18.
 */
public class WuHanFragment extends Fragment {
    @Bind(R.id.vp)
    ViewPager vp;
    @Bind(R.id.ll_points)
    LinearLayout point_group;
    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.lv)
    ListView lv;
    private int lastPosition;
    List<String> titles = new ArrayList<>();
    List<View> views = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wuhan,null);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    protected void init() {

        if (titles != null) {
            titles.clear();
        }
        titles.add("我是第一页");
        titles.add("我是第二页");
        titles.add("我是第三页");

        View v1 = View.inflate(getActivity(), R.layout.vp_wuhanfragment, null);
        v1.setBackgroundResource(R.mipmap.add_more);
        View v2 = View.inflate(getActivity(), R.layout.vp_wuhanfragment, null);
        v1.setBackgroundResource(R.mipmap.add_circle);
        View v3 = View.inflate(getActivity(), R.layout.vp_wuhanfragment, null);

        v3.setBackgroundResource(R.mipmap.add_pic);
        if (views != null) {
            views.clear();
        }
        for (int i = 0; i < 3; i++) {
            ImageView point = new ImageView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.rightMargin = 20;
            point.setLayoutParams(params);

            point.setBackgroundResource(R.drawable.point_bg);
            if (i == 0) {
                point.setEnabled(true);
            } else {
                point.setEnabled(false);
            }
            point_group.addView(point);
        }
        views.add(v1);
        views.add(v2);
        views.add(v3);
        MyAdapter myAdapter = new MyAdapter();
        vp.setAdapter(myAdapter);
        vp.setCurrentItem(Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2 % views.size()));
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                position = position % views.size();
                tv.setText(titles.get(position));
                point_group.getChildAt(position).setEnabled(true);
                //把上一个点设为false
                point_group.getChildAt(lastPosition).setEnabled(false);
                lastPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position % views.size()));
            return views.get((position % views.size()));
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            object = null;
        }
    }
}
