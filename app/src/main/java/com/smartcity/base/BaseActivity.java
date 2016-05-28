package com.smartcity.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Window;

import com.smartcity.R;
import com.smartcity.utils.AppManager;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.ToastTool;
import com.smartcity.view.BaseViews;

import butterknife.ButterKnife;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: BaseActivity.java
 * @author: fengliang
 * @date: 2016-04-30 16:45
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseViews {
    private static final String TAG = "BaseActivity";
    //应用是否销毁标志
    protected boolean isDestroy;
    protected LayoutInflater inflater = null;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isDestroy = false;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ButterKnife.bind(this);
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
        init();
    }

    public abstract void init();

    public abstract int getLayoutId();

    @Override
    protected void onStart() {
        super.onStart();
        LogTool.d(this.getClass().getName(), "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogTool.d(this.getClass().getName(), "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogTool.d(this.getClass().getName(), "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogTool.d(this.getClass().getName(), "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestroy = true;
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
        LogTool.d(this.getClass().getName(), "onDestroy()");
    }

    @Override
    public void showLoading(String msg) {
        progressDialog = ProgressDialog.show(this, null, TextUtils.isEmpty(msg) ? getString(R.string.loading) : msg);
    }

    @Override
    public void hideLoading() {
        if (null != progressDialog && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void hideEmpty() {

    }

    @Override
    public void showToast(String msg) {
        ToastTool.showShort(this, msg);
    }

    @Override
    public void showToast(int msg) {
        ToastTool.showShort(this, msg);
    }
}
