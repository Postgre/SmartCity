package com.smartcity.fragment.circle;

import android.content.Intent;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.os.AsyncTaskCompat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smartcity.R;
import com.smartcity.activity.circle.CircleDetailActivity;
import com.smartcity.activity.circle.Circle_Activity;
import com.smartcity.activity.circle.Circle_NoticeActivity;
import com.smartcity.activity.circle.Circle_PhotoActivity;
import com.smartcity.activity.circle.Circle_VideoActivity;
import com.smartcity.activity.circle.Circle_CreateActivity;
import com.smartcity.activity.circle.NewAllcircle_Activity;
import com.smartcity.activity.circle.NewChatMainActivity;
import com.smartcity.activity.circle.SearchActivity;
import com.smartcity.adapter.circle.CircleFragmentAdapter;
import com.smartcity.adapter.circle.CircleFragmentsAdapter;
import com.smartcity.adapter.circle.InnerAdapter;
import com.smartcity.application.MyApplication;
import com.smartcity.base.BaseFragment;
import com.smartcity.bean.Talent;
import com.smartcity.config.Constant;
import com.smartcity.customview.SwipeFlingAdapterView;
import com.smartcity.http.model.CircleBean;
import com.smartcity.http.model.LabelBean;
import com.smartcity.presenter.CirclePresenter;
import com.smartcity.presenterImpl.CirclePresenterImpl;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.CommonUtils;
import com.smartcity.utils.SharedPreferencesUtil;
import com.smartcity.utils.SpUtils;
import com.smartcity.utils.ToastTool;
import com.smartcity.view.ICircleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CircleFragment extends BaseFragment implements SwipeFlingAdapterView.onFlingListener,
        SwipeFlingAdapterView.OnItemClickListener, ICircleView {
    private static final String TAG = "CircleFragment";
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
    @Bind(R.id.back_img)
    ImageView back;
    @Bind(R.id.edittext_search)
    TextView edittext;
    @Bind(R.id.right_sousuo)
    ImageView right;
    @Bind(R.id.swipe_view)
    SwipeFlingAdapterView swipeView;
    @Bind(R.id.swipe_views)
    SwipeFlingAdapterView swipeViews;
    @Bind(R.id.nullquanzi)
    ImageView nullquanzi;
    @Bind(R.id.relalayout)
    RelativeLayout relalayout;
    private CircleFragmentAdapter adapter1;
    private CircleFragmentsAdapter adapter2;
    ArrayList<Talent> list1 = new ArrayList<>();
    List<CircleBean.CirDataEntity> list2 = new ArrayList<>();
    private boolean isnull = false;
    private CirclePresenter circlePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void init() {
        isnull(isnull);
        circlePresenter = new CirclePresenterImpl(this);
        SharedPreferencesUtil spUtils = MyApplication.getSpUtils();
        String apikey = spUtils.getString(Constant.API_KEY, "");
        String personUserId = spUtils.getString(Constant.ID, "");
        circlePresenter.getMyCircle(apikey, personUserId, "1", "10");
        initView();
        loadData();
//        loadDatas();
    }

    private void initView() {
        back.setVisibility(View.GONE);
        edittext.setVisibility(View.VISIBLE);
        right.setImageResource(R.mipmap.add_circle);
        right.setVisibility(View.VISIBLE);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float density = dm.density;
        cardWidth = (int) (dm.widthPixels - (2 * 18 * density));
        cardHeight = (int) (dm.heightPixels - (338 * density));
        swipeView.setFlingListener(this);
        swipeView.setOnItemClickListener(this);
        swipeViews.setFlingListener(this);
        swipeViews.setOnItemClickListener(this);
        if (isnull) {
            nullquanzi.setVisibility(View.VISIBLE);
            relalayout.setVisibility(View.VISIBLE);
            swipeView.setVisibility(View.VISIBLE);
            swipeViews.setVisibility(View.GONE);
        } else {
            nullquanzi.setVisibility(View.GONE);
            relalayout.setVisibility(View.GONE);
            swipeView.setVisibility(View.GONE);
            swipeViews.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_circle;
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

    @Override
    public void removeFirstObjectInAdapter() {
        if (swipeView.getVisibility() == View.VISIBLE) {
            adapter1.remove(0);
        }
        if (swipeViews.getVisibility() == View.VISIBLE) {
            adapter2.remove(0);
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
            if (swipeViews.getVisibility() == View.VISIBLE) {
                loadDatas();
            }
        }
    }

    @Override
    public void onScroll(float progress, float scrollXProgress) {

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
        adapter1.addClickListenerFromId(R.id.img1, R.id.img2, R.id.img3, R.id.img4);
        adapter1.setOnChildItemClickListener(new CommonAdapter.OnChildItemOnClickListener() {
            @Override
            public void OnChildItemOnClick(int position, View v, List<Map<String, Object>> list) {
                Intent intent;
                switch (v.getId()) {
                    case R.id.img1:
                        intent = new Intent();
                        intent.putExtra("id", 1);
                        intent.setClass(getActivity(), CircleDetailActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.img2:
                        intent = new Intent();
                        intent.putExtra("id", 1);
                        intent.setClass(getActivity(), CircleDetailActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.img3:
                        intent = new Intent();
                        intent.putExtra("id", 1);
                        intent.setClass(getActivity(), CircleDetailActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.img4:
                        intent = new Intent();
                        intent.putExtra("id", 1);
                        intent.setClass(getActivity(), CircleDetailActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        swipeView.setAdapter(adapter1);
    }

    private void loadDatas() {
        AsyncTaskCompat.executeParallel(new AsyncTask<Void, Void, List<CircleBean.CirDataEntity>>() {
            @Override
            protected List<CircleBean.CirDataEntity> doInBackground(Void... params) {
                List<CircleBean.CirDataEntity> list = new ArrayList<>();
                list = circleLists;
//                ArrayList<Card_new.Data> datalist = new ArrayList<>();
//                Card_new talent;
//                for (int i = 0; i < 10; i++) {
//                    datalist.add(new Card_new.Data("http://hdn.xnimg.cn/photos/hdn321/20130612/2235/h_main_NNN4_e80a000007df111a.jpg","智创工场"));
//                    datalist.add(new Card_new.Data("http://hdn.xnimg.cn/photos/hdn321/20130612/2235/h_main_NNN4_e80a000007df111a.jpg","登山圈"));
//                    datalist.add(new Card_new.Data("http://hdn.xnimg.cn/photos/hdn321/20130612/2235/h_main_NNN4_e80a000007df111a.jpg","瑜伽圈"));
//                    datalist.add(new Card_new.Data("http://hdn.xnimg.cn/photos/hdn321/20130612/2235/h_main_NNN4_e80a000007df111a.jpg","智创工场"));
//                    talent = new Card_new();
//                    talent.img = "http://hdn.xnimg.cn/photos/hdn321/20130612/2235/h_main_NNN4_e80a000007df111a.jpg";
//                    talent.title = "女人花登山圈";
//                    talent.quanzi = "尊享圈";
//                    talent.ren = "45人";
//                    talent.detail = "心中的美好";
//                    talent.setData(datalist);
//                    list.add(talent);
//                }
                return list;
            }

            @Override
            protected void onPostExecute(List<CircleBean.CirDataEntity> list) {
                super.onPostExecute(list);
                adapter2.addAll(list);
//                list2 = list;
            }
        });
        adapter2 = new CircleFragmentsAdapter(getActivity(), list2, R.layout.card_new);
        swipeViews.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
        adapter2.addClickListenerFromId(R.id.huodong, R.id.shiping, R.id.xiangji, R.id.tongzhi);
        adapter2.setOnChildItemClickListener(new CommonAdapter.OnChildItemOnClickListener() {
            @Override
            public void OnChildItemOnClick(int position, View v, List<Map<String, Object>> list) {
                switch (v.getId()) {
                    case R.id.huodong:
                        ToastTool.showShort(getActivity(), "活动");
                        CommonUtils.launchActivity(getActivity(), Circle_Activity.class);
                        break;
                    case R.id.shiping:
                        ToastTool.showShort(getActivity(), "视频");
                        CommonUtils.launchActivity(getActivity(), Circle_VideoActivity.class);
                        break;
                    case R.id.xiangji:
                        ToastTool.showShort(getActivity(), "相机");
                        CommonUtils.launchActivity(getActivity(), Circle_PhotoActivity.class);
                        break;
                    case R.id.tongzhi:
                        ToastTool.showShort(getActivity(), "通知");
                        CommonUtils.launchActivity(getActivity(), Circle_NoticeActivity.class);
                        break;
                }
            }
        });
//        adapter2 = new CircleFragmentsAdapter(getActivity(),list2,R.layout.card_new);
//        swipeViews.setAdapter(adapter2);
//        adapter2.addClickListenerFromId(R.id.huodong,R.id.shiping,R.id.xiangji,R.id.tongzhi);
//        adapter2.setOnChildItemClickListener(new CommonAdapter.OnChildItemOnClickListener() {
//            @Override
//            public void OnChildItemOnClick(int position, View v, List<Map<String, Object>> list) {
//                switch (v.getId()){
//                    case R.id.huodong:
//                        ToastTool.showShort(getActivity(),"活动");
//                        CommonUtils.launchActivity(getActivity(), Circle_Activity.class);
//                        break;
//                    case R.id.shiping:
//                        ToastTool.showShort(getActivity(),"视频");
//                        CommonUtils.launchActivity(getActivity(), Circle_VideoActivity.class);
//                        break;
//                    case R.id.xiangji:
//                        ToastTool.showShort(getActivity(),"相机");
//                        CommonUtils.launchActivity(getActivity(), Circle_PhotoActivity.class);
//                        break;
//                    case R.id.tongzhi:
//                        ToastTool.showShort(getActivity(),"通知");
//                        CommonUtils.launchActivity(getActivity(), Circle_NoticeActivity.class);
//                        break;
//                }
//            }
//        });
    }

    public void isnull(boolean isnull) {
        if (isnull) {
            nullquanzi.setVisibility(View.VISIBLE);
            relalayout.setVisibility(View.VISIBLE);
            swipeView.setVisibility(View.VISIBLE);
            swipeViews.setVisibility(View.GONE);
        } else {
            nullquanzi.setVisibility(View.GONE);
            relalayout.setVisibility(View.GONE);
            swipeView.setVisibility(View.GONE);
            swipeViews.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.right_sousuo, R.id.edittext_search, R.id.ll_allcircle, R.id.ll_chat})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.right_sousuo:
                CommonUtils.launchActivity(getActivity(), Circle_CreateActivity.class);
                break;
            case R.id.edittext_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.ll_chat:

                Boolean isloginyx = SpUtils.getIsloginyx();
                if (isloginyx.equals(true)) {
                    Intent inten = new Intent(getActivity(), NewChatMainActivity.class);
                    getActivity().startActivity(inten);
                } else {
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.ll_allcircle:
                Intent intent2 = new Intent(getActivity(), NewAllcircle_Activity.class);
                getActivity().startActivity(intent2);
                break;
        }
    }

    List<CircleBean.CirDataEntity> circleLists = new ArrayList<>();

    @Override
    public void addCircles(List<CircleBean.CirDataEntity> circleList) {
        circleLists = circleList;
        loadDatas();
    }

    @Override
    public void CircleGroup(List<CircleBean.CirDataEntity> circleList) {

    }

    @Override
    public void addLabels(List<LabelBean.DataEntity> labelList) {

    }
}
