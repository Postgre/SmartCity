package com.smartcity.activity.life;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Yancy on 2016/5/10.
 */
public abstract class LifeBaseActivity extends BaseActivity {

    @Bind(R.id.life_head_container)
    FrameLayout frameContainer;

    @Bind(R.id.life_head_right_container)
    FrameLayout frameRightContainer;


    @Bind(R.id.life_head_tv_name)
    TextView tvTitle;

    @Bind(R.id.life_head_iv_right)
    ImageView ivShow;

    @Bind(R.id.life_bg)
    RelativeLayout lifeBg;

    @Override
    public void init() {

        showTitle();
        initHead();
        initViews();
    }

    protected abstract void initViews();

    private void showTitle() {

        if(null != tvTitle)
        {
            tvTitle.setText(getName());
        }
    }

    protected abstract String getName();

    private void initHead() {
        View rightView = getRightView();
        if(null != rightView)
        {
            ivShow.setVisibility(View.GONE);
            frameRightContainer.addView(rightView);
        }

        View centerView = getCenterView();
        if(null != centerView)
        {
            frameContainer.addView(centerView);
        }
    }

    protected abstract View getCenterView();

    protected abstract View getRightView();


    @OnClick(R.id.life_head_back)
    public void back(){
        finish();
    }

    public void hindTextView()
    {
        tvTitle.setVisibility(View.GONE);
    }

    public void hindImageView()
    {
        ivShow.setVisibility(View.GONE);
    }

    @Override
    public int getLayoutId() {
        return this.getContentId();
    }

    protected abstract int getContentId();

}
