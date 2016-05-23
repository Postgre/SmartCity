package com.smartcity.activity.chw.wyx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.desmond.squarecamera.CameraActivity;
import com.desmond.squarecamera.ImageUtility;
import com.smartcity.R;
import com.smartcity.adapter.chw.wyx.CoolDetailAdapter;
import com.smartcity.base.BaseActivity;
import com.smartcity.config.Constant;
import com.smartcity.http.model.CommentInfo;
import com.smartcity.utils.LogTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

public class CoolDetailActivity extends BaseActivity {
    private static final String TAG = CoolDetailActivity.class.getName();

    private static final int REQUEST_CAMERA = 0;
    private static final int REQUEST_CAMERA_PERMISSION = 1;
    private Point mSize;

    @Bind(R.id.backBtn)
    ImageView backBtn;

    @Bind(R.id.addBtn)
    ImageView addBtn;

    @Bind(R.id.cool_detail_listview)
    RecyclerView cool_detail_listview;

    @Bind(R.id.bottom_info_layout)
    LinearLayout bottom_info_layout;

    @Bind(R.id.dzLayout)
    RelativeLayout dzLayout;

    @Bind(R.id.commentLayout)
    RelativeLayout commentLayout;

    @Bind(R.id.zfLayout)
    RelativeLayout zfLayout;

    @Bind(R.id.shareLayout)
    RelativeLayout shareLayout;

    private static final int SCROLL_Y = 0;
    private int mScrollY = 0;

    private List<Map<String, Object>> mylist = new ArrayList<>();
    private List<Map<String, Object>> splitList = new ArrayList<>();
    private List<CommentInfo> hotComments = new ArrayList<>();
    private List<CommentInfo> newComments = new ArrayList<>();

    private CoolDetailAdapter coolDetailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        mSize = new Point();
        display.getSize(mSize);
        initView();
        initData();
        setData(hotComments, newComments);
    }

    private void initView() {
        cool_detail_listview.setLayoutManager(new LinearLayoutManager(this));
        cool_detail_listview.setHasFixedSize(true);
        cool_detail_listview.setItemAnimator(new DefaultItemAnimator());

        coolDetailAdapter = new CoolDetailAdapter(CoolDetailActivity.this, mylist, splitList);
        cool_detail_listview.setAdapter(coolDetailAdapter);
        cool_detail_listview.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                mScrollY += dy;
                if (mScrollY > SCROLL_Y) {
                    bottom_info_layout.setVisibility(View.VISIBLE);
                } else {
                    bottom_info_layout.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            CommentInfo info = new CommentInfo();
            info.setTitle("吃货大王" + i);
            info.setDate("04.22 14:34");
            info.setContent("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
            hotComments.add(info);
        }
        for (int i = 0; i < 4; i++) {
            CommentInfo info = new CommentInfo();
            info.setTitle("吃货大王" + i);
            info.setDate("04.22 14:34");
            info.setContent("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
            newComments.add(info);
        }
    }

    private void setData(List<CommentInfo> hotComments, List<CommentInfo> newComments) {
        mylist.clear();
        splitList.clear();
        Map<String, Object> mp = new HashMap<>();
        mp.put(Constant.KEY, getResources().getString(R.string.str_hot_comment));
        mylist.add(mp);
        splitList.add(mp);
        for (CommentInfo commentInfo : hotComments) {
            Map<String, Object> map = new HashMap<>();
            map.put(Constant.KEY, commentInfo);
            mylist.add(map);
        }
        //----------------------------------------------------
        mp = new HashMap<>();
        mp.put(Constant.KEY, getResources().getString(R.string.str_new_comment));
        mylist.add(mp);
        splitList.add(mp);
        for (CommentInfo info : newComments) {
            Map<String, Object> map = new HashMap<>();
            map.put(Constant.KEY, info);
            mylist.add(map);
        }
    }

    @Override
    public void init() {

    }

    @OnClick({R.id.backBtn, R.id.addBtn, R.id.dzLayout, R.id.commentLayout, R.id.zfLayout, R.id.shareLayout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backBtn:
                finish();
                break;
            case R.id.addBtn:
                Intent startCustomCameraIntent = new Intent(CoolDetailActivity.this, CameraActivity.class);
                startActivityForResult(startCustomCameraIntent, REQUEST_CAMERA);
                break;
            case R.id.dzLayout:
                break;
            case R.id.commentLayout:
                break;
            case R.id.zfLayout:
                break;
            case R.id.shareLayout:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) return;

        if (requestCode == REQUEST_CAMERA) {
            Uri photoUri = data.getData();
            LogTool.d(TAG, "photoUri--------------" + photoUri);
            // Get the bitmap in according to the width of the device
            Bitmap bitmap = ImageUtility.decodeSampledBitmapFromPath(photoUri.getPath(), mSize.x, mSize.x);
            LogTool.d(TAG, "bitmap======================" + bitmap);
//            ((ImageView) findViewById(R.id.image)).setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cool_detail;
    }
}
