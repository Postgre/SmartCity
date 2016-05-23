package com.smartcity.fragment.circle;

import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.os.AsyncTaskCompat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.smartcity.R;
import com.smartcity.adapter.circle.CircleFragmentAdapter;
import com.smartcity.adapter.circle.InnerAdapter;
import com.smartcity.base.BaseFragment;
import com.smartcity.bean.Card_item_Model;
import com.smartcity.bean.Card_new;
import com.smartcity.bean.Talent;
import com.smartcity.customview.SwipeFlingAdapterView;
import com.smartcity.utils.ToastTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/4.
 */
public class ItemFragment extends BaseFragment implements SwipeFlingAdapterView.onFlingListener, SwipeFlingAdapterView.OnItemClickListener {


    String[] headerIcons = {"http://www.5djiaren.com/uploads/2015-04/17-115301_29.jpg",
            "http://img1.dzwww.com:8080/tupian_pl/20160106/32/4152697013403556460.jpg",
            "http://c.hiphotos.baidu.com/zhidao/pic/item/72f082025aafa40f191362cfad64034f79f019ce.jpg",
            "http://img.article.pchome.net/new/w600/00/35/15/66/pic_lib/wm/122532981493137o3iegiyx.jpg",
            "http://img0.imgtn.bdimg.com/it/u=3382799710,1639843170&fm=21&gp=0.jpg",
            "http://i2.sinaimg.cn/travel/2014/0918/U7398P704DT20140918143217.jpg",
            "http://photo.l99.com/bigger/21/1415193165405_4sg3ds.jpg",
            "http://img.pconline.com.cn/images/upload/upc/tx/photoblog/1305/15/c2/20949108_20949108_1368599174341.jpg",
            "http://pic29.nipic.com/20130501/12558275_114724775130_2.jpg",
            "http://photo.l99.com/bigger/20/1415193157174_j2fa5b.jpg"};

    String[] names = {"张三", "李四", "王五", "小明", "小红", "小花"};

    String[] citys = {"北京", "上海", "广州", "深圳"};

    String[] edus = {"大专", "本科", "硕士", "博士"};

    String[] years = {"1年", "2年", "3年", "4年", "5年"};
    Random ran = new Random();

    public static int cardWidth;
    public static int cardHeight;

//    @Bind(R.id.swipe_view)
//    SwipeFlingAdapterView swipeView;
    private View contextView;

    private List<Card_item_Model> card_list = new ArrayList<>();

    ArrayList<Talent> list1 = new ArrayList<>();
    ArrayList<Card_new> list2 = new ArrayList<>();
    private CircleFragmentAdapter adapter1;
    private SwipeFlingAdapterView swipeView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        contextView = inflater.inflate(R.layout.tem_layout, container, false);

        initView();

        ButterKnife.bind(this, contextView);
        return contextView;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    private void initView() {

        swipeView = (SwipeFlingAdapterView) contextView.findViewById(R.id.swipe_view);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        float density = dm.density;
        cardWidth = (int) (dm.widthPixels - (2 * 18 * density));
        cardHeight = (int) (dm.heightPixels - (338 * density));
        swipeView.setFlingListener(this);
        swipeView.setOnItemClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        initData();
        loadData();

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void init() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.tem_layout;
    }

    private void loadData() {
        AsyncTaskCompat.executeParallel(new AsyncTask<Void, Void, List<Talent>>() {
            @Override
            protected List<Talent> doInBackground(Void... params) {
                ArrayList<Talent> list = new ArrayList<>(10);
                ArrayList<Talent.Data> datalist = new ArrayList<>();
                Talent talent;
                for (int i = 0; i < 10; i++) {
                    datalist.add(new Talent.Data("http://hdn.xnimg.cn/photos/hdn321/20130612/2235/h_main_NNN4_e80a000007df111a.jpg", "智创工场", "胡元浩", 1));
                    datalist.add(new Talent.Data("http://hdn.xnimg.cn/photos/hdn321/20130612/2235/h_main_NNN4_e80a000007df111a.jpg", "登山圈", "胡元浩", 0));
                    datalist.add(new Talent.Data("http://hdn.xnimg.cn/photos/hdn321/20130612/2235/h_main_NNN4_e80a000007df111a.jpg", "瑜伽圈", "胡元浩", 1));
                    datalist.add(new Talent.Data("http://hdn.xnimg.cn/photos/hdn321/20130612/2235/h_main_NNN4_e80a000007df111a.jpg", "智创工场", "胡元浩", 0));
                    talent = new Talent();
                    talent.headerIcon = headerIcons[i];
                    talent.nickname = names[ran.nextInt(names.length - 1)];
                    talent.cityName = citys[ran.nextInt(citys.length - 1)];
                    talent.educationName = edus[ran.nextInt(edus.length - 1)];
                    talent.workYearName = years[ran.nextInt(years.length - 1)];
                    talent.setData(datalist);
                    list.add(talent);
                }
                return list;
            }

            @Override
            protected void onPostExecute(List<Talent> list) {
                super.onPostExecute(list);
                adapter1.addAll(list);
                list1 = (ArrayList<Talent>) list;
            }
        });
        adapter1 = new CircleFragmentAdapter(getActivity(), list1, R.layout.card_new_item);
        swipeView.setAdapter(adapter1);
    }

    private void initData() {
        card_list.add(new Card_item_Model("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=938096994,3074232342&fm=116&gp=0.jpg",
                0, "女人花圈子"));
        card_list.add(new Card_item_Model("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=938096994,3074232342&fm=116&gp=0.jpg",
                0, "女人花圈子"));
        card_list.add(new Card_item_Model("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=938096994,3074232342&fm=116&gp=0.jpg",
                0, "女人花圈子"));
        card_list.add(new Card_item_Model("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=938096994,3074232342&fm=116&gp=0.jpg",
                0, "女人花圈子"));
        card_list.add(new Card_item_Model("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=938096994,3074232342&fm=116&gp=0.jpg",
                0, "女人花圈子"));
        card_list.add(new Card_item_Model("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=938096994,3074232342&fm=116&gp=0.jpg",
                0, "女人花圈子"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void removeFirstObjectInAdapter() {
        if (swipeView.getVisibility() == View.VISIBLE) {
            adapter1.remove(0);
        }
    }

    @Override
    public void onLeftCardExit(Object dataObject) {

    }

    @Override
    public void onRightCardExit(Object dataObject) {

    }

    @Override
    public void onAdapterAboutToEmpty(int itemsInAdapter) {
        if (itemsInAdapter == 3) {
            if (swipeView.getVisibility() == View.VISIBLE) {
                loadData();
            }
        }
    }

    @Override
    public void onScroll(float progress, float scrollXProgress) {

    }

    @Override
    public void onItemClicked(MotionEvent event, View v, Object dataObject) {
        if (v.getTag() instanceof InnerAdapter.ViewHolder) {
            int x = (int) event.getRawX();
            int y = (int) event.getRawY();
            InnerAdapter.ViewHolder vh = (InnerAdapter.ViewHolder) v.getTag();
            View child = vh.portraitView;
            Rect outRect = new Rect();
            child.getGlobalVisibleRect(outRect);
            if (outRect.contains(x, y)) {
                ToastTool.showShort(getActivity(), "click 大图");
            } else {
                outRect.setEmpty();
                child = vh.collectView;
                child.getGlobalVisibleRect(outRect);
                if (outRect.contains(x, y)) {
                    ToastTool.showShort(getActivity(), "click 关注");
                }
            }
        }
    }
}
