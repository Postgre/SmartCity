package com.smartcity.activity.chw.service;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.smartcity.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/5/23.
 */
public class WecanListActivity extends Activity {
    @Bind(R.id.backBtn)
    ImageView backBtn;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.ibtn_search)
    ImageButton ibtnSearch;
    @Bind(R.id.main_home)
    RadioButton mainHome;
    @Bind(R.id.main_tuan)
    RadioButton mainTuan;
    @Bind(R.id.main_search)
    RadioButton mainSearch;
    @Bind(R.id.main_my)
    RadioButton mainMy;
    @Bind(R.id.main_bottom_tabs)
    RadioGroup mainBottomTabs;
    @Bind(R.id.lv)
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wecanlist);
        ButterKnife.bind(this);
        initListener();
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
