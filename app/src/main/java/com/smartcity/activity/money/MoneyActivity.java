package com.smartcity.activity.money;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class MoneyActivity extends BaseActivity {
    @Bind((R.id.icon_qucoumei))
    ImageView icon_qucoumei;
    @Bind((R.id.icon_zhaolezi))
    ImageView icon_zhaolezi;
    @Bind((R.id.icon_jiankangxing))
    ImageView icon_jiankangxing;
    @Bind((R.id.icon_dafuw))
    ImageView icon_dafuw;
    @Bind((R.id.icon_chaofan))
    ImageView icon_chaofan;
    @Bind((R.id.icon_xueleifeng))
    ImageView icon_xueleifeng;


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

    @OnClick({R.id.icon_qucoumei, R.id.icon_zhaolezi, R.id.icon_jiankangxing, R.id.icon_dafuw, R.id.icon_chaofan, R.id.icon_xueleifeng})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.icon_qucoumei:
                Intent qucoumeiIntent = new Intent(this, QuCouMeiActivity.class);
                startActivity(qucoumeiIntent);
                break;
            case R.id.icon_zhaolezi:
                Intent zhaoleziIntent = new Intent(this, ZhaoLeZiActivity.class);
                startActivity(zhaoleziIntent);
                break;
            case R.id.icon_jiankangxing:
                break;
            case R.id.icon_dafuw:
                break;
            case R.id.icon_chaofan:
                break;
            case R.id.icon_xueleifeng:
                break;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_money;
    }
}
