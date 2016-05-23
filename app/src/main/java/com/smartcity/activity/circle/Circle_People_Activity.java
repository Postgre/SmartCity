package com.smartcity.activity.circle;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.smartcity.R;
import com.smartcity.adapter.circle.Circle_PeopleAdapter;
import com.smartcity.bean.Circle_PeopleBean;
import com.smartcity.bean.New;
import com.smartcity.utils.CommonUtils;
import com.smartcity.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/4/15.
 */
public class Circle_People_Activity extends FragmentActivity implements OnClickListener{
    @Bind(R.id.notice)
    LinearLayout notice;//通知
    @Bind(R.id.video)
    LinearLayout video;//视频
    @Bind(R.id.photo)
    LinearLayout photo;//相册
    @Bind(R.id.active)
    LinearLayout active;//活动
    @Bind(R.id.gridView)
    GridView gridview;//圈子成员
    @Bind(R.id.code)
    RelativeLayout code;// 二维码
    @Bind(R.id.mTogBtn)
    ToggleButton button;//消息免打扰设置
    private Circle_PeopleAdapter adapter;//圈子成员适配器
    @Bind(R.id.back_img)
    ImageView back;
    @Bind(R.id.title_tv)
    TextView title;
    @Bind(R.id.exit)
    TextView exit;
    private int detailId,PersonId;
    private List<Circle_PeopleBean.DataBean> list = new ArrayList<>();
    Bundle bundle;

    HorizontalScrollView horizontalScrollView;
    DisplayMetrics dm;
    private int NUM = 4; // 每行显示个数
    private int hSpacing = 20;// 水平间距
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_people);
        initView();
//        initNet();
    }
    private void initView() {
        bundle = new Bundle();
        bundle = this.getIntent().getExtras();
        detailId = bundle.getInt("detailId");
        UIUtils.addTouchLight(back,true);
        UIUtils.addTouchLight(exit,true);
        UIUtils.addTouchLight(notice,true);
        UIUtils.addTouchLight(video,true);
        UIUtils.addTouchLight(photo,true);
        UIUtils.addTouchLight(active,true);
//        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.scroll);

        title.setText("滑雪");
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);
        notice.setOnClickListener(this);
        video.setOnClickListener(this);
        photo.setOnClickListener(this);
        active.setOnClickListener(this);
        code.setOnClickListener(this);
        exit.setOnClickListener(this);
    }
    private List<New> getLists() {
        List<New> list = new ArrayList<New>();
        for (int i = 0; i < 40; i++) {
            list.add(new New());
        }
        return list;
    }
//    private void initNet() {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.3.185").addConverterFactory(GsonConverterFactory.create()).build();
//        ApiService service = retrofit.create(ApiService.class);
//        Map<String, Object> maps = new HashMap<>();
//        maps.put("date", DateUtil.getCurDateStr());
//        maps.put("personCircleId",detailId );
//        maps.put("sStartpage", 1);
//
//        maps.put("sPagerows", 10);
//        service.getCircle_People(MyApplication.getApikey(), "circle/getAllmembers", "1", GsonUtils.objectToJson(maps)).enqueue(new Callback<Circle_PeopleBean>() {
//            @Override
//            public void onResponse(Response<Circle_PeopleBean> response, Retrofit retrofit) {
//                if (response.body() != null) {
//                    if (response.body().getCode() == 1) {
//                        list = response.body().getData();
//                        initData();
//                    }
//                }
//            }
//            @Override
//            public void onFailure(Throwable t) {
//                Toast.makeText(Circle_People_Activity.this, "网络异常，访问服务器失败", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    private void initData() {
//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i).getPersonUserId() == Integer.parseInt(MyApplication.getUserid())){
//                PersonId = list.get(i).getPersonId();
//            }
//        }
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        adapter = new Circle_PeopleAdapter(this,list, R.layout.circle_memberlist);
        gridview.setAdapter(adapter);
        LinearLayout.LayoutParams params;
        if(list.size() > 8) {
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    dm.widthPixels / 4 * 3);
//            gridview.setColumnWidth(dm.widthPixels / NUM);
        }  else if(list.size() > 4 && list.size() <= 8){
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    dm.widthPixels / 2);
        }else{
            params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
        }
        gridview.setLayoutParams(params);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(((adapter.getCount() % 3 == 0) ? adapter.getCount() / 3 : adapter.getCount() / 3 + 1)*(dm.widthPixels / NUM),
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        gridview.setLayoutParams(params);
//        gridview.setColumnWidth(dm.widthPixels / NUM);
//        // gridView.setHorizontalSpacing(hSpacing);
//        gridview.setStretchMode(GridView.NO_STRETCH);
//        int count = adapter.getCount();
//        if(count <= 12){
//            gridview.setNumColumns(1);
//        }else {
//            gridview.setNumColumns((count % 3 == 0) ? count / 3 : count / 3 + 1);
//        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_img:
                finish();
                break;
            case R.id.notice:
                CommonUtils.launchActivity(this,Circle_NoticeActivity.class);
                break;
            case R.id.video:
                CommonUtils.launchActivity(this,Circle_VideoActivity.class);
                break;
            case R.id.photo:
                CommonUtils.launchActivity(this,Circle_PhotoActivity.class);
                break;
            case R.id.active:
                CommonUtils.launchActivity(this,Circle_Activity.class);
                break;
            case R.id.code:
                break;
            case R.id.exit:
                exit();
                break;
        }
    }
    private void exit() {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.3.185").addConverterFactory(GsonConverterFactory.create()).build();
//        ApiService service = retrofit.create(ApiService.class);
//        Map<String, Object> maps = new HashMap<>();
//        maps.put("date", DateUtil.getCurDateStr());
//        maps.put("personId",PersonId );
//        service.getExit(MyApplication.getApikey(), "circle/delPerson", "1", GsonUtils.objectToJson(maps)).enqueue(new Callback<Model>() {
//            @Override
//            public void onResponse(Response<Model> response, Retrofit retrofit) {
//                if (response.body() != null) {
//                    if (response.body().getCode() == 1) {
//                        T.showShort(Circle_People_Activity.this, response.body().getMsg());
//                        //数据是使用Intent返回
//                        Intent intent = new Intent(Constants.SEND);
//                        //把返回数据存入Intent
//                        intent.putExtra("result", "refresh");
////                        //设置返回数据
////                        Circle_People_Activity.this.setResult(Constants.REFRESH, intent);
//                        Circle_People_Activity.this.sendBroadcast(intent);
//                        //关闭Activity
//                        Circle_People_Activity.this.finish();
//                    }
//                }
//            }
//            @Override
//            public void onFailure(Throwable t) {
//                Toast.makeText(Circle_People_Activity.this, "网络异常，访问服务器失败", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
