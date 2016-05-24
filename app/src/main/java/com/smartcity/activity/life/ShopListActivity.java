package com.smartcity.activity.life;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.smartcity.R;
import com.smartcity.fragment.life.ChoseBrandFragment;
import com.smartcity.presenterImpl.ShopListPresenter;
import com.smartcity.pulltofresh.PullToRefreshListView;
import com.smartcity.view.ShopListView;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Yancy on 2016/5/10.
 */
public class ShopListActivity extends LifeBaseActivity implements ShopListView {

    public static final String CLASSIFY_NAME="classifyName";
    public static final String CLASSIFY_Id="classifyId";
    private ShopListPresenter shopListPresenter;

    @Override
    protected void initViews() {
        initRecy();
    }


    private ChoseBrandFragment choseBrandFragment;

    private void initRecy() {

        choseBrandFragment = new ChoseBrandFragment();

        List<String> datas  = new ArrayList<>();

        for(int i=0;i<10;i++)
        {
            datas.add(new String());
        }
        recycleViewContainer.setAdapter(new CommonAdapter<String>(this,R.layout.shop_item,datas) {


            @Override
            public void convert(ViewHolder viewHolder, String s) {

            }
        });

        shopListPresenter = new ShopListPresenter();

        shopListPresenter.getShopListBannerInfo();

        Intent intent = getIntent();
        int classifyId = intent.getIntExtra(CLASSIFY_Id,1);
        shopListPresenter.getShopListByClassifyId(classifyId,"武汉","洪山区",null,null);

    }

    @Override
    protected String getName() {
        Intent intent = getIntent();
        String name = intent.getStringExtra(CLASSIFY_NAME);
        if(TextUtils.isEmpty(name))
        {
            return "更多店铺";
        }
        return name;
    }

    @Override
    protected View getCenterView() {
        return null;
    }

    @Override
    protected View getRightView() {
        return null;
    }


    @Bind(R.id.shop_recy_container)
    PullToRefreshListView recycleViewContainer;

    @Override
    protected int getContentId() {
        return R.layout.activity_shop_list;
    }


    //TODO 显示品牌弹窗
    @OnClick(R.id.shop_tv_brand)
    public void showBrand()
    {
        choseBrandFragment.show(getSupportFragmentManager(),"shopActivity");
    }

    /**
     * 根据销量排序
     * */
    public void showSales()
    {

    }

    /**
     * 选择城市
     * */
    public void showLocation()
    {

    }

    /**
     * 设置商品列表
     * */
    @Override
    public void setShopList() {

    }
    /**
     * 设置品牌列表
     * */
    @Override
    public void setBrand() {

    }
}
