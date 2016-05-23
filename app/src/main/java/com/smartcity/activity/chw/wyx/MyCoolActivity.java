package com.smartcity.activity.chw.wyx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.desmond.squarecamera.CameraActivity;
import com.desmond.squarecamera.ImageUtility;
import com.smartcity.R;
import com.smartcity.adapter.chw.wyx.MyFragmentPagerAdapter;
import com.smartcity.base.BaseActivity;
import com.smartcity.bean.SelectItem;
import com.smartcity.customview.ScrollableLayout;
import com.smartcity.fragment.chw.wyx.MicroFilmFragment;
import com.smartcity.fragment.chw.wyx.MomentsFragment;
import com.smartcity.fragment.chw.wyx.TransmitFragment;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.ScrollableHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnPageChange;

public class MyCoolActivity extends BaseActivity implements ScrollableLayout.OnScrollListener {
    private static final String TAG = MyCoolActivity.class.getName();

    private static final int REQUEST_CAMERA = 0;
    private static final int REQUEST_CAMERA_PERMISSION = 1;
    private Point mSize;

    @Bind(R.id.backBtn)
    ImageView backBtn;

    @Bind(R.id.addBtn)
    ImageView addBtn;

    @Bind(R.id.sl_root)
    ScrollableLayout sl_root;

    @Bind(R.id.img_head)
    ImageView img_head;

    @Bind(R.id.text_name)
    TextView text_name;

    @Bind(R.id.tabLyout)
    TabLayout tabLayout;

    @Bind(R.id.viewpager)
    ViewPager mPager;

    private List<SelectItem> listViews = new ArrayList<SelectItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        mSize = new Point();
        display.getSize(mSize);
        initView();
        setListener();
    }

    private void initView() {
        mPager.setOffscreenPageLimit(1);
        setupViewPager(mPager);
        tabLayout.setupWithViewPager(mPager);
    }

    @Override
    public void init() {

    }

    private void setListener() {
        sl_root.setOnScrollListener(this);
    }

    @OnClick({R.id.backBtn, R.id.addBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backBtn:
                finish();
                break;
            case R.id.addBtn:
                Intent startCustomCameraIntent = new Intent(this, CameraActivity.class);
                startActivityForResult(startCustomCameraIntent, REQUEST_CAMERA);
                break;
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        SelectItem momentItem = new SelectItem(MomentsFragment.newInstance(), getResources().getString(R
                .string.str_jcsk));
        SelectItem transItem = new SelectItem(TransmitFragment.newInstance(), getResources().getString(R
                .string.str_trans));
        SelectItem filmItem = new SelectItem(MicroFilmFragment.newInstance(), getResources().getString(R
                .string.str_wdy));
        listViews.add(momentItem);
        listViews.add(transItem);
        listViews.add(filmItem);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), listViews);
        viewPager.setAdapter(adapter);
        sl_root.getHelper().setCurrentScrollableContainer((ScrollableHelper.ScrollableContainer) listViews.get(0)
                .getFragment());
    }

    @OnPageChange(R.id.viewpager)
    public void onPageSelected(int position) {
        sl_root.getHelper().setCurrentScrollableContainer((ScrollableHelper.ScrollableContainer) listViews.get
                (position).getFragment());
    }

    @Override
    public void onScroll(int translationY, int maxY) {
        LogTool.d(TAG, "translationY======================" + translationY);
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
        return R.layout.activity_my_cool;
    }
}
