package com.smartcity.activity.chw.wyx;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.inter.UpLoadListener;
import com.smartcity.presenterImpl.CoolPresenterImpl;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.ToastTool;
import com.smartcity.utils.UploadManager;
import com.smartcity.view.ICoolView;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class AddCoolActivity extends BaseActivity implements ICoolView {
    private static final String TAG = AddCoolActivity.class.getName();

    @Bind(R.id.btnBack)
    ImageView btnBack;

    @Bind(R.id.btnSubmit)
    Button btnSubmit;

    private CoolPresenterImpl coolPresenterImpl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        coolPresenterImpl = new CoolPresenterImpl(this);
        initView();
    }

    private void initView() {

    }

    @Override
    public void init() {

    }

    @OnClick({R.id.btnBack, R.id.btnSubmit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.infoBtn:
                finish();
                break;
            case R.id.btnSubmit:

                break;
        }
    }
    
    private void upload() {
        UploadManager.getInstance().uploadVideo("/storage/emulated/0/Pic/1458967613150.mp4");
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
                coolPresenterImpl.addCool("1", thumbnailPath, uploadPath, "Nb的人生", "60", "1", "BJHD", "123,321", "湖北武汉");
            }

            @Override
            public void upLoadError(String msg) {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_cool;
    }

    @Override
    public void showSuccessMsg(String msg) {
        ToastTool.showShort(AddCoolActivity.this, msg);
    }

    @Override
    public void showFailMsg(String msg) {
        ToastTool.showShort(AddCoolActivity.this, msg);
    }

    @Override
    public void showList(List<CoolInfo.CoolListInfo> list) {

    }
}
