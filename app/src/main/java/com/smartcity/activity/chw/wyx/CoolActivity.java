package com.smartcity.activity.chw.wyx;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.smartcity.R;
import com.smartcity.adapter.chw.wyx.MarkAdapter;
import com.smartcity.adapter.chw.wyx.MyFragmentPagerAdapter;
import com.smartcity.base.BaseActivity;
import com.smartcity.bean.SelectItem;
import com.smartcity.config.Constant;
import com.smartcity.customview.MarkPopWindow;
import com.smartcity.fragment.chw.wyx.CoolFragment;
import com.smartcity.http.model.CoolDetailInfo;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.inter.UpLoadListener;
import com.smartcity.presenterImpl.CoolPresenterImpl;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.ToastTool;
import com.smartcity.utils.UploadManager;
import com.smartcity.view.ICoolView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnPageChange;

public class CoolActivity extends BaseActivity implements MarkPopWindow.ItemCallBack, MarkAdapter.ItemClickCallBack, ICoolView {
    private static final String TAG = CoolActivity.class.getName();

    private static final int REQUEST_CAMERA = 0;
    private static final int REQUEST_CAMERA_PERMISSION = 1;
    private Point mSize;

    @Bind(R.id.backBtn)
    ImageView backBtn;

    @Bind(R.id.addBtn)
    ImageView addBtn;

    @Bind(R.id.mark_listview)
    RecyclerView mark_listview;

    @Bind(R.id.markBtn)
    ImageView markBtn;

    @Bind(R.id.tabLyout)
    TabLayout tabLayout;

    @Bind(R.id.viewpager)
    ViewPager mPager;

    @Bind(R.id.topLayout)
    RelativeLayout topLayout;

    @Bind(R.id.edittext_search)
    EditText edittext_search;

    private List<String> markList = new ArrayList<>();
    private MarkAdapter markAdapter;

    private MarkPopWindow window = null;

    private CoolPresenterImpl coolPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        mSize = new Point();
        display.getSize(mSize);

        coolPresenterImpl = new CoolPresenterImpl(this);
        initView();
    }

    private void initView() {
        window = new MarkPopWindow(CoolActivity.this, R.array.arr_mark_type);
        window.setCallback(this);
        for (int i = 0; i < 10; i++) {
            markList.add("热门" + i);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CoolActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mark_listview.setLayoutManager(linearLayoutManager);
        mark_listview.setItemAnimator(new DefaultItemAnimator());
        mark_listview.setHasFixedSize(true);
        markAdapter = new MarkAdapter(CoolActivity.this, markList);
        markAdapter.setCallback(this);
        mark_listview.setAdapter(markAdapter);
        //------------------------------------------------
        mPager.setOffscreenPageLimit(1);
        setupViewPager(mPager);
        tabLayout.setupWithViewPager(mPager);
    }

    @Override
    public void init() {

    }

    private void setupViewPager(ViewPager viewPager) {
        List<SelectItem> listViews = new ArrayList<>();
        SelectItem momentItem = new SelectItem(CoolFragment.newInstance(Constant.TYPE_IMG), getResources().getString(R
                .string.str_jcsk));
        SelectItem filmItem = new SelectItem(CoolFragment.newInstance(Constant.TYPE_VIDEO), getResources().getString(R
                .string.str_wdy));
        listViews.add(momentItem);
        listViews.add(filmItem);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), listViews);
        viewPager.setAdapter(adapter);
    }

    @OnClick({R.id.backBtn, R.id.addBtn, R.id.edittext_search, R.id.markBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backBtn:
                finish();
                break;
            case R.id.addBtn:
//                Intent startCustomCameraIntent = new Intent(this, CameraActivity.class);
//                startActivityForResult(startCustomCameraIntent, REQUEST_CAMERA);


//                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
//                //设置视频大小
//                intent.putExtra(android.provider.MediaStore.EXTRA_SIZE_LIMIT, 768000);
//                //设置视频时间  毫秒单位
//                intent.putExtra(android.provider.MediaStore.EXTRA_DURATION_LIMIT, 45000);
//                startActivityForResult(intent, REQUEST_CAMERA);

                upload();
                break;
            case R.id.edittext_search:
                break;
            case R.id.markBtn:
                if (markBtn.isSelected()) {
                    markBtn.setSelected(false);
                    if (window.isShowing()) {
                        window.dismiss();
                    }
                } else {
                    markBtn.setSelected(true);
                    window.show(topLayout);
                }
                break;
        }
    }

    @OnPageChange(R.id.viewpager)
    public void onPageSelected(int position) {

    }

    private void upload() {
        UploadManager.getInstance().uploadVideo("/storage/emulated/0/Movies/QQ1982.mp4");
        UploadManager.getInstance().setUpLoadListener(new UpLoadListener() {
            @Override
            public void upLoading(long currentSize, long totalSize) {

            }

            @Override
            public void upLoadSuccess(Object result, String uploadPath) {

            }

            @Override
            public void upLoadSuccess(Object result, String thumbnailPath, String uploadPath) {
                LogTool.d(TAG, "thumbnailPath:" + thumbnailPath + "   uploadPath:" + uploadPath);
                coolPresenterImpl.addCool("1", thumbnailPath, uploadPath, "NB之人啊", "60", "1", "BJHD", "123,321", "湖北武汉");
            }

            @Override
            public void upLoadError(String msg) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) return;

        if (requestCode == REQUEST_CAMERA) {
            Uri photoUri = data.getData();
            LogTool.d(TAG, "photoUri--------------" + photoUri);
            LogTool.d(TAG, "===============" + photoUri.getPath());
            // Get the bitmap in according to the width of the device
//            Bitmap bitmap = ImageUtility.decodeSampledBitmapFromPath(photoUri.getPath(), mSize.x, mSize.x);
//            LogTool.d(TAG, "bitmap======================" + bitmap);
//            ((ImageView) findViewById(R.id.image)).setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_cool;
    }

    @Override
    public void onItemClick(int positon, String title) {
        ToastTool.showShort(CoolActivity.this, title);
        addMarkItem(title);
    }

    @Override
    public void onDismissCallback() {
        if (markBtn.isSelected()) {
            markBtn.setSelected(false);
        } else {
            markBtn.setSelected(true);
        }
    }

    private void addMarkItem(String title) {
        if (markList.contains(title)) {
            return;
        }
        markList.add(0, title);
        markAdapter.notifyItemInserted(0);
        mark_listview.scrollToPosition(0);
    }

    @Override
    public void onItemClick(int positon) {
        markAdapter.setSelectedPos(positon);
    }

    @Override
    public void showSuccessMsg(String msg) {
        ToastTool.showShort(CoolActivity.this, msg);
    }

    @Override
    public void showFailMsg(String msg) {
        ToastTool.showShort(CoolActivity.this, msg);
    }

    @Override
    public void showList(List<CoolInfo.CoolListInfo> list) {

    }

    @Override
    public void showInfo(CoolDetailInfo.CoolDetailItemInfo info) {

    }
}
