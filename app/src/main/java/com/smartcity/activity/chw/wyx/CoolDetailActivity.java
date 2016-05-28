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
import android.widget.RelativeLayout;

import com.desmond.squarecamera.CameraActivity;
import com.desmond.squarecamera.ImageUtility;
import com.smartcity.R;
import com.smartcity.adapter.chw.wyx.CoolDetailAdapter;
import com.smartcity.base.BaseActivity;
import com.smartcity.config.Constant;
import com.smartcity.http.model.CommentInfo;
import com.smartcity.http.model.CoolDetailInfo;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.presenterImpl.CoolPresenterImpl;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.ToastTool;
import com.smartcity.view.ICoolView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

public class CoolDetailActivity extends BaseActivity implements ICoolView, CoolDetailAdapter.ItemCliclListener {
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

    @Bind(R.id.dzLayout)
    RelativeLayout dzLayout;

    @Bind(R.id.commentLayout)
    RelativeLayout commentLayout;

    @Bind(R.id.zfLayout)
    RelativeLayout zfLayout;

    @Bind(R.id.shareLayout)
    RelativeLayout shareLayout;

    private String usercode;
    private int coolId;

    private List<Map<String, Object>> mylist = new ArrayList<>();
    private List<Map<String, Object>> splitList = new ArrayList<>();
    private List<CommentInfo> hotComments = new ArrayList<>();
    private List<CommentInfo> newComments = new ArrayList<>();

    private CoolDetailAdapter coolDetailAdapter;

    private CoolPresenterImpl coolPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        coolPresenterImpl = new CoolPresenterImpl(this);
        Display display = getWindowManager().getDefaultDisplay();
        mSize = new Point();
        display.getSize(mSize);
        initView();
        coolPresenterImpl.getCoolDetail("36", "60");
    }

    private void initView() {
        cool_detail_listview.setLayoutManager(new LinearLayoutManager(this));
        cool_detail_listview.setHasFixedSize(true);
        cool_detail_listview.setItemAnimator(new DefaultItemAnimator());
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
                if (dzLayout.isSelected()) {
                    coolPresenterImpl.updateComment("0", "0");
                } else {
                    coolPresenterImpl.updateComment("1", "1");
                }
                break;
            case R.id.commentLayout:
                coolPresenterImpl.addComment("2", "36", "60", "admin", "NB的人", "Hello World。", "1");
                break;
            case R.id.zfLayout:
                ToastTool.showShort(CoolDetailActivity.this, "转发");
                break;
            case R.id.shareLayout:
                ToastTool.showShort(CoolDetailActivity.this, "分享");
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
    public void showSuccessMsg(String msg) {
        ToastTool.showShort(CoolDetailActivity.this, msg);
        if (dzLayout.isSelected()) {
            dzLayout.setSelected(false);
        } else {
            dzLayout.setSelected(true);
        }
    }

    @Override
    public void showFailMsg(String msg) {
        ToastTool.showShort(CoolDetailActivity.this, msg);
    }

    @Override
    public void showList(List<CoolInfo.CoolListInfo> list) {

    }

    @Override
    public void showInfo(CoolDetailInfo.CoolDetailItemInfo info) {
        LogTool.d(TAG, "info============" + info);
        LogTool.d(TAG, "info============" + info.getMPlmap().getHotCommentList());
        LogTool.d(TAG, "info============" + info.getMPlmap().getNewestCommentList());
        setData(info.getMPlmap().getHotCommentList(), info.getMPlmap().getNewestCommentList());
        coolDetailAdapter = new CoolDetailAdapter(CoolDetailActivity.this, mylist, splitList, info);
        cool_detail_listview.setAdapter(coolDetailAdapter);
        coolDetailAdapter.setListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cool_detail;
    }

    @Override
    public void onFocusClick() {
        coolPresenterImpl.focusCool("12", "13");
    }

    @Override
    public void onUnFocusClick() {
        coolPresenterImpl.unFocusCool("1", "1");
    }

    @Override
    public void onItemClick(String filePath) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(filePath), "video/mp4");
        startActivity(intent);
    }
}
