package com.smartcity.activity.chw.service;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by chenyuan
 * 2016 05 11:43
 * 武汉智创工厂
 */
//评论
public class CommentActivity extends Activity {
    @Bind(R.id.sdv_photo)
    SimpleDraweeView sdvPhoto;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.room_ratingbar)
    RatingBar roomRatingbar;
    @Bind(R.id.backBtn)
    ImageView backBtn;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commentactivity);
        ButterKnife.bind(this);
        initData();
        initListener();

    }

    private void initData() {
    }

    private void initListener() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
