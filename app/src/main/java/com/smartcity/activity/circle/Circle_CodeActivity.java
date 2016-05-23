package com.smartcity.activity.circle;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.utils.CommonUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/10.
 */
public class Circle_CodeActivity extends BaseActivity {
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.code)
    SimpleDraweeView code;

    @Override
    public void init() {
        titleTv.setText("设置");
        code.setImageURI(Uri.parse("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1462868651&di=f153dc06ed7b96616cd0f83581957782&src=http://pic.baike.soso.com/p/20131211/20131211091752-393669037.jpg"));
    }

    @Override
    public int getLayoutId() {
        return R.layout.cirlce_code;
    }

    @OnClick(R.id.back_img)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
