package com.smartcity.activity.circle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.adapter.circle.Life_Adapters;
import com.smartcity.application.MyApplication;
import com.smartcity.base.BaseActivity;
import com.smartcity.config.Constant;
import com.smartcity.http.model.CircleVideo;
import com.smartcity.http.service.CircleService;
import com.smartcity.pulltofresh.PullToRefreshGridView;
import com.smartcity.utils.CommonAdapter;
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


public class Circle_PhotoActivity extends BaseActivity implements OnClickListener {
    //    private MyGridView gridview;
    private Life_Adapters adapter;
    @Bind(R.id.gridview)
    PullToRefreshGridView gridview;
    View headview;
    @Bind(R.id.back_img)
    ImageView imgback;
    @Bind(R.id.right_sousuo)
    ImageView back_photo;
    @Bind(R.id.title_tv)
    TextView title;
    String detailPid;
    private List<CircleVideo.DataBean> videolist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
//		headview = (LinearLayout) LayoutInflater.from(this).
//				inflate(R.layout.freshgrid, null);
//		listview.getRefreshableView().addHeaderView(headview);
//		listview.setAdapter(null);

        InitView();
        initDatas();
        initNet();
//		gridview.setAdapter(adapter);
    }

    @Override
    public void init() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.freshgrid;
    }

    private void initDatas() {
        // TODO Auto-generated method stub
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.df);
        map.put("title", "泰国7日游");
        map.put("introduce", "1");
        map.put("price", "2015-09-20");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.df);
        map.put("title", "泰国7日游");
        map.put("introduce", "2");
        map.put("price", "2015-09-20");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.df);
        map.put("title", "泰国7日游");
        map.put("introduce", "3");
        map.put("price", "2015-09-20");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.df);
        map.put("title", "泰国7日游");
        map.put("introduce", "4");
        map.put("price", "2015-09-20");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.df);
        map.put("title", "泰国7日游");
        map.put("introduce", "480");
        map.put("price", "2015-09-20");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.df);
        map.put("title", "泰国7日游");
        map.put("introduce", "480");
        map.put("price", "2015-09-20");
        list.add(map);
//		adapter = new Life_Adapters(this, list, R.layout.girdview_group);

    }

    private void initNet() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        CircleService service = retrofit.create(CircleService.class);
        Map<String, Object> maps = new HashMap<>();
        maps.put("videoAlbumCircleId", "4");
        maps.put("sStartpage", "1");
        maps.put("sPagerows", "10");
        service.getCircleVideo(MyApplication.getApikey(), CircleService.CIRCLEPHOTO,Constant.VALUE_VERSION, GsonUtils.objectToJson(maps)).enqueue(new Callback<CircleVideo>() {
            @Override
            public void onResponse(Call<CircleVideo> call, Response<CircleVideo> response) {
                LogTool.e("log", detailPid + "retrofit");
                if (response.body() != null) {
                    if (response.body().getCode() == 1) {
                        videolist = response.body().getData();
                        videolist.add(0, new CircleVideo.DataBean());
                        LogTool.e("sfsf", videolist.get(1).getVideoAlbumTypeName() + "videolist");
                        adapter = new Life_Adapters(Circle_PhotoActivity.this, videolist, R.layout.girdview_group);
                        gridview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        adapter.setOnChildItemClickListener(new CommonAdapter.OnChildItemOnClickListener() {

                            @Override
                            public void OnChildItemOnClick(int position, View v,
                                                           List<Map<String, Object>> list) {
                                // TODO Auto-generated method stub
                                switch (v.getId()) {
                                    case R.id.life_gird_image:
                                        if (position == 0) {
                                            CommonUtils.launchActivity(Circle_PhotoActivity.this, Circle_CreatePhotoActivity.class);
                                        }
                                        break;

                                    default:
                                        break;
                                }
                            }
                        });
                        adapter.addClickListenerFromId(R.id.life_gird_image);
                    } else {
                        CommonUtils.launchActivity(Circle_PhotoActivity.this, LoginActivity.class);
                    }
                }
            }

            @Override
            public void onFailure(Call<CircleVideo> call, Throwable t) {
                Toast.makeText(Circle_PhotoActivity.this, "网络异常，访问服务器失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void InitView() {
        Intent intent = getIntent();
        detailPid = intent.getStringExtra("detailPid");
        imgback.setVisibility(View.VISIBLE);
        imgback.setOnClickListener(this);
        back_photo.setImageResource(R.mipmap.icon_xiangji);
        back_photo.setVisibility(View.VISIBLE);
        back_photo.setOnClickListener(this);
        title.setText("相册");
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.right_sousuo:
                CommonUtils.launchActivity(this, Circle_UploadPictureActivity.class);
            default:
                break;
        }
    }
}
