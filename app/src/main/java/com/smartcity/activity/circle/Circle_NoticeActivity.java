package com.smartcity.activity.circle;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.adapter.circle.Group_NoticeAdapter;
import com.smartcity.application.MyApplication;
import com.smartcity.base.BaseActivity;
import com.smartcity.config.Constant;
import com.smartcity.http.model.CircleNotice;
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


public class Circle_NoticeActivity extends BaseActivity implements OnClickListener {
    @Bind(R.id.list)
    PullToRefreshListView listview;
    private View headview;
    @Bind(R.id.back_img)
    ImageView imgback;
    @Bind(R.id.title_tv)
    TextView title;
    @Bind(R.id.right_text)
    TextView release;
    private Group_NoticeAdapter adapter;
    private List<CircleNotice.DataBean> noticelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
        initDatas();
        initNet();
    }

    @Override
    public void init() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.freshlist;
    }

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    private void initDatas() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "泰国七日游名单确认");
        map.put("content", "泰国7日游活动即将结束，目前报名的总共20人，名单如下：李允熹 朱晓婷 于和丽 张清姗 李梦露 吴丽萍 张梦华 刘希 赵燕何淑欢 林语溪 王思甜 景荣 雷涛 刘瑜 甘文 林宥嘉 陈奕迅 刘德华  杨幂   大家确认一下，看看有没有错漏的，谢谢大家的配合！");
        map.put("time", "2015-09-01");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "泰国七日游名单确认");
        map.put("content", "泰国7日游活动即将结束，目前报名的总共20人，名单如下：李允熹 朱晓婷 于和丽 张清姗 李梦露 吴丽萍 张梦华 刘希 赵燕何淑欢 林语溪 王思甜 景荣 雷涛 刘瑜 甘文 林宥嘉 陈奕迅 刘德华  杨幂   大家确认一下，看看有没有错漏的，谢谢大家的配合！");
        map.put("time", "2015-09-01");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "泰国七日游名单确认");
        map.put("content", "泰国7日游活动即将结束，目前报名的总共20人，名单如下：李允熹 朱晓婷 于和丽 张清姗 李梦露 吴丽萍 张梦华 刘希 赵燕何淑欢 林语溪 王思甜 景荣 雷涛 刘瑜 甘文 林宥嘉 陈奕迅 刘德华  杨幂   大家确认一下，看看有没有错漏的，谢谢大家的配合！");
        map.put("time", "2015-09-01");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "泰国七日游名单确认");
        map.put("content", "泰国7日游活动即将结束，目前报名的总共20人，名单如下：李允熹 朱晓婷 于和丽 张清姗 李梦露 吴丽萍 张梦华 刘希 赵燕何淑欢 林语溪 王思甜 景荣 雷涛 刘瑜 甘文 林宥嘉 陈奕迅 刘德华  杨幂   大家确认一下，看看有没有错漏的，谢谢大家的配合！");
        map.put("time", "2015-09-01");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("title", "泰国七日游名单确认");
        map.put("content", "泰国7日游活动即将结束，目前报名的总共20人，名单如下：李允熹 朱晓婷 于和丽 张清姗 李梦露 吴丽萍 张梦华 刘希 赵燕何淑欢 林语溪 王思甜 景荣 雷涛 刘瑜 甘文 林宥嘉 陈奕迅 刘德华  杨幂   \n\n大家确认一下，看看有没有错漏的，谢谢大家的配合！");
        map.put("time", "2015-09-01");
        list.add(map);
//		adapter = new Group_NoticeAdapter(this, list, R.layout.group_notice);
    }

    private void initNet() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        CircleService service = retrofit.create(CircleService.class);
        Map<String, Object> maps = new HashMap<>();
//		maps.put("detailCircleId", "4");
        maps.put("sStartpage", "1");
        maps.put("sPagerows", "10");
        service.getCircleNotice(MyApplication.getApikey(), Constant.VALUE_VERSION, GsonUtils.objectToJson(maps)).enqueue(new Callback<CircleNotice>() {

            @Override
            public void onResponse(Call<CircleNotice> call, Response<CircleNotice> response) {
                LogTool.e("log", response.body() + "retrofit");
                if (response.body() != null) {
                    if (response.body().getCode() == 1) {
                        noticelist = response.body().getData();
                        adapter = new Group_NoticeAdapter(Circle_NoticeActivity.this, noticelist, R.layout.group_notice);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    } else {
                        CommonUtils.launchActivity(Circle_NoticeActivity.this, LoginActivity.class);
                    }
                }
            }

            @Override
            public void onFailure(Call<CircleNotice> call, Throwable t) {
                Toast.makeText(Circle_NoticeActivity.this, "网络异常，访问服务器失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void InitView() {
        // TODO Auto-generated method stub
        imgback.setVisibility(View.VISIBLE);
        imgback.setOnClickListener(this);
        title.setText("通知");
        release.setVisibility(View.VISIBLE);
        release.setText("发布");
        release.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.right_text:
                break;
            default:
                break;
        }
    }

}
