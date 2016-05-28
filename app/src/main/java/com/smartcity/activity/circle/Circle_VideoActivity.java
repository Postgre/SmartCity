package com.smartcity.activity.circle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.activity.Store_PopupWindow;
import com.smartcity.adapter.circle.Circle_VideoAdapter;
import com.smartcity.application.MyApplication;
import com.smartcity.base.BaseActivity;
import com.smartcity.config.Constant;
import com.smartcity.http.model.CircleVideo;
import com.smartcity.http.service.CircleService;
import com.smartcity.pulltofresh.PullToRefreshListView;
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

@SuppressLint("NewApi")
public class Circle_VideoActivity extends BaseActivity implements
        OnClickListener {
    @Bind(R.id.list)
    PullToRefreshListView listview;
    private View headview;
    @Bind(R.id.back_img)
    ImageView imgback;
    @Bind(R.id.right_sousuo)
    ImageView shangchuan;
    @Bind(R.id.title_tv)
    TextView text_tv;
    private Circle_VideoAdapter adapter;
    private ArrayList list;
    private Intent intent;
    String detailPid;
    private List<CircleVideo.DataBean> videolist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitView();
        initData();
        initNet();
    }

    @Override
    public void init() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.freshlist;
    }

    private void InitView() {
        Intent intent = getIntent();
        detailPid = intent.getStringExtra("detailPid");
        imgback.setVisibility(View.VISIBLE);
        imgback.setOnClickListener(this);
        text_tv.setText("视频");
        shangchuan.setImageResource(R.mipmap.icon_shangchuan);
        shangchuan.setVisibility(View.VISIBLE);
        shangchuan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.right_sousuo:
                intent = new Intent();
                intent.setClass(this, Circle_VideoUploadActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void initNet() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        CircleService service = retrofit.create(CircleService.class);
        Map<String, Object> maps = new HashMap<>();
        maps.put("videoAlbumCircleId", detailPid);
        maps.put("sStartpage", "0");
        maps.put("sPagerows", "10");
        service.getCircleVideo(MyApplication.getApikey(), CircleService.CIRCLEVIDEO,Constant.VALUE_VERSION, GsonUtils.objectToJson(maps)).enqueue(new Callback<CircleVideo>() {

            @Override
            public void onResponse(Call<CircleVideo> call, Response<CircleVideo> response) {
                LogTool.e("log", response.body() + "retrofit");
                if (response.body() != null) {
                    if (response.body().getCode() == 1) {
                        videolist = response.body().getData();
                        adapter = new Circle_VideoAdapter(Circle_VideoActivity.this, videolist, R.layout.circle_video_item);
                        listview.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        adapter.addClickListenerFromId(R.id.video_share);
                        adapter.setOnChildItemClickListener(new CommonAdapter.OnChildItemOnClickListener() {

                            @Override
                            public void OnChildItemOnClick(int position, View v,
                                                           List<Map<String, Object>> list) {
                                // TODO Auto-generated method stub
                                switch (v.getId()) {
                                    case R.id.video_share:
                                        intent = new Intent();
                                        intent.setClass(Circle_VideoActivity.this, Store_PopupWindow.class);
                                        startActivity(intent);
                                        break;

                                    default:
                                        break;
                                }
                            }
                        });
                    } else {
                        CommonUtils.launchActivity(Circle_VideoActivity.this, LoginActivity.class);
                    }
                }
            }

            @Override
            public void onFailure(Call<CircleVideo> call, Throwable t) {
                Toast.makeText(Circle_VideoActivity.this, "网络异常，访问服务器失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
//		list = new ArrayList<VideoModel>();
//		list.add(new VideoModel(R.mipmap.df, "黄山归来不看岳，九寨归来不看水",
//				R.mipmap.df, "7天游", 280));
//		list.add(new VideoModel(R.mipmap.df, "黄山归来不看岳，九寨归来不看水",
//				R.mipmap.df, "7天游", 300));
//		list.add(new VideoModel(R.mipmap.df, "黄山归来不看岳，九寨归来不看水",
//				R.mipmap.df, "7天游", 52));
//		list.add(new VideoModel(R.mipmap.df, "黄山归来不看岳，九寨归来不看水",
//				R.mipmap.df, "7天游", 280));
//		adapter = new Circle_VideoAdapter(this, list,
//				R.layout.circle_video_item);
//		adapter.setOnChildItemClickListener(new CommonAdapter.OnChildItemOnClickListener() {
//
//			@Override
//			public void OnChildItemOnClick(int position, View v,
//					List<Map<String, Object>> list) {
//				// TODO Auto-generated method stub
//				switch (v.getId()) {
//				case R.id.video_share:
//					intent=new Intent();
//					intent.setClass(Circle_VideoActivity.this, Store_PopupWindow.class);
//					startActivity(intent);
//					break;
//
//				default:
//					break;
//				}
//			}
//		});
//		adapter.addClickListenerFromId(R.id.video_share);
    }

    @Override
    protected void onPause() {
        super.onPause();
//		JCVideoPlayer.releaseAllVideos();
    }
}
