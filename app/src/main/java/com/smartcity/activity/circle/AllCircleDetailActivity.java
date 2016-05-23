package com.smartcity.activity.circle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.R;
import com.smartcity.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/6.
 */
public class AllCircleDetailActivity extends BaseActivity {

    @Bind(R.id.cr_detail)
    SimpleDraweeView crDetail;
    @Bind(R.id.cr_name)
    TextView crName;
    @Bind(R.id.cr_type_name)
    ImageView crTypeName;
    @Bind(R.id.cr_type)
    TextView crType;
    @Bind(R.id.ll_type)
    LinearLayout llType;
    @Bind(R.id.cr_num_img)
    ImageView crNumImg;
    @Bind(R.id.cr_num)
    TextView crNum;
    @Bind(R.id.ll_num)
    LinearLayout llNum;
    @Bind(R.id.tv_join)
    TextView tvJoin;

    @Bind(R.id.back_img)
    ImageView back_img;
    @Bind(R.id.title_tv)
    TextView title_tv;

    @Override
    public void init() {
        int group = getIntent().getIntExtra("group", 0);
        if (group == 1){
            llType.setVisibility(View.GONE);
            crName.setText("春游小组");
        }

        back_img.setVisibility(View.VISIBLE);
        title_tv.setVisibility(View.VISIBLE);
        title_tv.setText("资料详情");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_allcircledetail;
    }


    @OnClick({R.id.back_img, R.id.tv_join})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.tv_join:
                Toast.makeText(this, "加入圈子成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
