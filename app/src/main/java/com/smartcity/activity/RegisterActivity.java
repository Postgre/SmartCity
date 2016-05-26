package com.smartcity.activity;

import android.widget.EditText;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.presenter.RegistPresenter;
import com.smartcity.presenterImpl.RegistPresenterImpl;
import com.smartcity.utils.ToastTool;
import com.smartcity.view.IRegistViews;

import butterknife.Bind;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements IRegistViews {


    @Bind(R.id.r_et_phone)
    EditText etPhone;

    @Bind(R.id.r_et_pwd)
    EditText etPwd;

    @Bind(R.id.r_et_com_pwd)
    EditText etComPwd;

    @Bind(R.id.r_et_code)
    EditText etCode;


    @Bind(R.id.r_tv_code)
    TextView tvCode;
    private RegistPresenter presenter;


    @Override
    public void init() {
        presenter = new RegistPresenterImpl(this);
    }

    @Override
    public String getPwd() {
        return etPwd.getText().toString().trim();
    }

    @Override
    public String getPhone() {
        return etPhone.getText().toString().trim();
    }

    @Override
    public String getComPwd() {
        return etComPwd.getText().toString().trim();
    }

    @Override
    public String getPhoneCode() {
        return etCode.getText().toString().trim();
    }

    @Override
    public void setTvHint(String msg) {
        tvCode.setText(msg);
    }

    @Override
    public void setTvClickable(boolean isClick) {
        tvCode.setEnabled(isClick);
    }

    @Override
    public void showMessage(String msg) {
        ToastTool.showShort(this, msg);
    }

    @OnClick(R.id.r_tv_code)
    public void getCode() {
        presenter.getNewCode(getPhone());
    }

    @OnClick(R.id.r_bt_submit)
    public void regist() {
        presenter.regist(getPhone(), getPwd(), getComPwd(), getPhoneCode(

        ));
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_regist;
    }
}
