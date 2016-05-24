package com.smartcity.activity.circle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.adapter.circle.CircleFragment_Adapter;
import com.smartcity.application.MyApplication;
import com.smartcity.base.BaseActivity;
import com.smartcity.bean.CircleFragment_Model;
import com.smartcity.config.Constant;
import com.smartcity.http.model.NewCircleListInfo;
import com.smartcity.http.service.CircleService;
import com.smartcity.pulltofresh.PullToRefreshListView;
import com.smartcity.utils.CommonUtils;
import com.smartcity.utils.GsonUtils;
import com.smartcity.utils.LogTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/4/18.
 */
public class Circle_Activity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.list)
    PullToRefreshListView xlistView;
    private ArrayList lists;
    private List<NewCircleListInfo.DataBean> list_CircleInfo = new ArrayList<>();
    private View headview;
    private CircleFragment_Adapter adapter;
    @Bind(R.id.back_img)
    ImageView back;
    @Bind(R.id.right_fq)
    ImageView faqi;
    @Bind(R.id.title_tv)
    TextView title;
    public static Circle_Activity instance;
    String detailPid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
//        headview = (LinearLayout) LayoutInflater.from(this)
//                .inflate(R.layout.fragment, null);
//        xlistView.addHeaderView(headview);
        initView();
        initData();
        xlistView.setAdapter(adapter);
    }

    @Override
    public void init() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.freshlist;
    }

    private void initView() {
        Intent intent = getIntent();
        detailPid = intent.getStringExtra("detailPid");
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);
        faqi.setVisibility(View.VISIBLE);
        faqi.setOnClickListener(this);
        title.setText("活动");
    }

    private void initData() {
        initNet();
    }

    private List getList() {
        lists = new ArrayList<CircleFragment_Model>();

        lists.add(new CircleFragment_Model(R.mipmap.circle_img,
                "一路向南，新西兰之旅", 100, 40, 360, 150, 0));
        lists.add(new CircleFragment_Model(R.mipmap.circle_img,
                "一路向南，新西兰之旅", 100, 40, 360, 150, 1));
        lists.add(new CircleFragment_Model(R.mipmap.circle_img,
                "一路向南，新西兰之旅", 100, 40, 360, 150, 0));
        lists.add(new CircleFragment_Model(R.mipmap.circle_img,
                "一路向南，新西兰之旅", 100, 40, 360, 150, 1));
        lists.add(new CircleFragment_Model(R.mipmap.circle_img,
                "一路向南，新西兰之旅", 100, 40, 360, 150, 0));
        return lists;
    }

    private void initNet() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        CircleService service = retrofit.create(CircleService.class);
        Map<String, Object> maps = new HashMap<>();
        maps.put("detailCircleId", detailPid);
        maps.put("sStartpage", "1");
        maps.put("sPagerows", "10");
        service.getMyCircleList(MyApplication.getApikey(), Constant.VALUE_VERSION, GsonUtils.objectToJson(maps)).enqueue(new Callback<NewCircleListInfo>() {
            @Override
            public void onResponse(Call<NewCircleListInfo> call, Response<NewCircleListInfo> response) {
                LogTool.e("log", response.body() + "retrofit");
                if (response.body() != null) {
                    if (response.body().getCode() == 1) {
                        list_CircleInfo = response.body().getData();
                        adapter = new CircleFragment_Adapter(Circle_Activity.this, list_CircleInfo, R.layout.circle_activity_item);
                        xlistView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    } else {
                        CommonUtils.launchActivity(Circle_Activity.this, LoginActivity.class);
                    }
                }
            }

            @Override
            public void onFailure(Call<NewCircleListInfo> call, Throwable t) {
                Toast.makeText(Circle_Activity.this, "网络异常，访问服务器失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent;
        switch (v.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.right_fq:
                break;
            default:
                break;
        }

    }

    public void join(int personCircleId) {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.3.185").addConverterFactory(GsonConverterFactory.create()).build();
//        ApiService service = retrofit.create(ApiService.class);
//        Map<String, Object> maps = new HashMap<>();
//        maps.put("date", DateUtil.getCurDateStr());
//        maps.put("personCircleId", personCircleId);
//        maps.put("personUserId", Application.getUserId());
//        maps.put("personVipId", null);
//        maps.put("personJob", 2);
//        maps.put("personIsVip", 1);
//        maps.put("personNewsNodisturb", 1);
//        maps.put("personLoginName", Application.getUserName());
//
//        String apiKey = Application.getApiKey();
//
//        service.getCircle_join(apiKey, "circle/addPerson", "1", new Gson().toJson(maps)).enqueue(new Callback<Model>() {
//            @Override
//            public void onResponse(Response<Model> response, Retrofit retrofit) {
////                Log.e("text", response.body().getCode() + "code");
//                if (response.body().getCode() == 1) {
//                    T.showShort(getActivity(), response.body().getMsg());
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Toast.makeText(getActivity(), "网络异常，访问服务器失败", Toast.LENGTH_SHORT).show();
//                Log.e("test", t.getMessage());
//            }
//        });
    }
}
