package com.smartcity.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.smartcity.R;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.ToastTool;
import com.smartcity.view.BaseViews;

import butterknife.ButterKnife;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: BaseFragment.java
 * @author: fengliang
 * @date: 2016-04-30 16:48
 */
public abstract class BaseFragment extends Fragment implements BaseViews {
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogTool.d(this.getClass().getName(), "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LogTool.d(this.getClass().getName(), "onCreateView");

        View view = inflater.inflate(getLayoutId(), null);
        initAllMembersView(savedInstanceState);
        ButterKnife.bind(this, view);
        return view;
    }

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogTool.d(this.getClass().getName(), "onActivityCreated");
        init();
    }

    protected abstract void initViews();

    protected abstract void init();

    public abstract int getLayoutId();

    @Override
    public void onResume() {
        super.onResume();
        LogTool.d(this.getClass().getName(), "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogTool.d(this.getClass().getName(), "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        LogTool.d(this.getClass().getName(), "onDestroy");
    }


    @Override
    public void showLoading(String msg) {
        progressDialog = ProgressDialog.show(getActivity(), null, TextUtils.isEmpty(msg) ? getString(R.string.loading) : msg);
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
        ToastTool.showShort(getActivity(), msg);
    }

    @Override
    public void showToast(int msg) {
        ToastTool.showShort(getActivity(), msg);
    }
}
