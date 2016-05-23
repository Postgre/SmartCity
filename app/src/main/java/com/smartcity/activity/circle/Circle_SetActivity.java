package com.smartcity.activity.circle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.utils.CommonUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/10.
 */
public class Circle_SetActivity extends BaseActivity {
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.code)
    RelativeLayout code;
    @Bind(R.id.mTogBtn)
    ToggleButton mTogBtn;
    @Bind(R.id.exit)
    TextView exit;

    @Override
    public void init() {
        titleTv.setText("二维码");
    }

    @Override
    public int getLayoutId() {
        return R.layout.circle_set;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_img, R.id.code, R.id.exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.code:
                CommonUtils.launchActivity(this,Circle_CodeActivity.class);
                break;
            case R.id.exit:
                break;
        }
    }
}
