package com.smartcity.activity.chw.wyx;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.presenterImpl.CoolPresenterImpl;

import butterknife.Bind;
import butterknife.OnClick;

public class AddCoolActivity extends BaseActivity {
    private static final String TAG = AddCoolActivity.class.getName();

    @Bind(R.id.btnBack)
    ImageView btnBack;

    @Bind(R.id.btnSubmit)
    Button btnSubmit;

    private CoolPresenterImpl coolPresenterImpl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_cool;
    }

}
