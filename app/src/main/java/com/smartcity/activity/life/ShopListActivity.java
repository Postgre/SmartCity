package com.smartcity.activity.life;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

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
 *
 *
 *
 */
public class ShopListActivity extends LifeBaseActivity implements ShopListView {

    public static final String CLASSIFY_NAME="classifyName";
    public static final String CLASSIFY_Id="classifyId";
    private ShopListPresenter shopListPresenter;


    @Bind(R.id.shop_tv_location)
    TextView tvLocation;

    @Bind(R.id.shop_tv_brand)
    TextView tvBrand;

    @Bind(R.id.shop_tv_sales_volume)
    TextView tvSalesVolume;

    @Override
    protected void initViews() {
        tvLocation.setSelected(true);
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
        Intent intent = getIntent();

        shopListPresenter = new ShopListPresenter(intent.getIntExtra(CLASSIFY_Id,1));

        shopListPresenter.getShopListBannerInfo();

        shopListPresenter.getShopListByClassifyId("武汉","洪山区",null,null);

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

    @OnClick({R.id.shop_tv_location,R.id.shop_tv_brand,R.id.shop_tv_sales_volume})
    public void changeColor(View view)
    {
        switch (view.getId())
        {
            case R.id.shop_tv_location:
                tvLocation.setSelected(true);
                tvBrand.setSelected(false);
                tvSalesVolume.setSelected(false);
              break;

            case R.id.shop_tv_brand:
                tvLocation.setSelected(false);
                tvBrand.setSelected(true);
                tvSalesVolume.setSelected(false);
                break;

            case R.id.shop_tv_sales_volume:
                tvLocation.setSelected(false);
                tvBrand.setSelected(false);
                tvSalesVolume.setSelected(true);

                break;
            default:
                break;
        }
    }

}
