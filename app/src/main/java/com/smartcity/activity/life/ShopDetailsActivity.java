package com.smartcity.activity.life;

import android.content.Intent;
import android.view.View;
import android.widget.ScrollView;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.smartcity.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Yancy on 2016/5/12.
 */
public class ShopDetailsActivity  extends LifeBaseActivity implements ScrollableHelper.ScrollableContainer{

    @Bind(R.id.scrollableLayout)
    ScrollableLayout scrollableLayout;


    @Bind(R.id.shop_detail_scro_container)
    ScrollView scrollView;

    @Override
    protected void initViews() {

       // ivShow.setImageResource(R.mipmap.fanhui);
       // lifeBg.setBackgroundColor(Color.parseColor("#c9c9c9"));

        scrollableLayout.getHelper().setCurrentScrollableContainer(this);
    }

    @Override
    protected String getName() {
        return "";
    }

    @Override
    protected View getCenterView() {
        return null;
    }

    @Override
    protected View getRightView() {
        return null;
    }

    @Override
    protected int getContentId() {
        return R.layout.activity_shop_details;
    }

    @Override
    public View getScrollableView() {
        return scrollView;
    }


    @OnClick(R.id.shop_detail_commodity_review)
    public void startReview()
    {
        startActivity(new Intent(this,LifeEvaluationActivity.class));
    }
}
