package com.smartcity.activity.life;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.http.model.CouponModel;
import com.smartcity.http.model.LifeGoodsModel;
import com.smartcity.http.model.ShopHomeMorePop;
import com.smartcity.model.modelImpl.ShopHomeModelImpl;
import com.smartcity.presenterImpl.ShopHomePresenter;
import com.smartcity.pulltofresh.PullToRefreshBase;
import com.smartcity.pulltofresh.PullToRefreshRecycleView;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.UIUtils;
import com.smartcity.view.ShopHomeView;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Yancy on 2016/5/11.
 */
public class ShopHomeActivity extends LifeBaseActivity implements ScrollableHelper.ScrollableContainer, ShopHomeView {

    private static final int PAGE_SIZE =15;
    @Bind(R.id.shop_iv_bg)
    SimpleDraweeView shopBg;


    @Bind(R.id.shop_is_collection)
    ImageView ivIsCollection;

    @Bind(R.id.shop_home_recy_container)
    RecyclerView recyContainer;

    private PopupWindow popupWindow;


    @Bind(R.id.shop_rule_multiple)
    TextView textView;

    @Bind(R.id.shop_home_scrollable)
    ScrollableLayout mScrollLayout;
    private CommonAdapter<LifeGoodsModel.DataBean> mGoodsAdapter;
    private ShopHomePresenter shopHomePresenter;


    private int currentType =-1;
    private int pageNo =1;
    @Override
    protected void initViews() {

        int id = getIntent().getIntExtra("id", 1);
        String bgImg = getIntent().getStringExtra("bg");
        if(TextUtils.isEmpty(bgImg))
        {
            setShopBgUrl(bgImg);
        }
        initRecy();

        initMorePopWindow();

        //设置综合为红色

        mScrollLayout.getHelper().setCurrentScrollableContainer(this);

        shopHomePresenter = new ShopHomePresenter(String.valueOf(id),this);

        //获取店铺信息
        shopHomePresenter.initShopInfo();
        //获取优惠券
        shopHomePresenter.initCouponList();
        //获取本店商品
        shopHomePresenter.initGoodsList(currentType,pageNo,PAGE_SIZE);

    }

    private void initMorePopWindow() {
        View view = UIUtils.inflate(R.layout.shop_home_more_popwindow);
        ListView lv = (ListView) view.findViewById(R.id.shop_home_more_pop_lv);
        List<ShopHomeMorePop> datas = new ArrayList<>();
        datas.add(new ShopHomeMorePop(R.mipmap.tanchuangshouye, "首页", 0));
        datas.add(new ShopHomeMorePop(R.mipmap.tanchuangsousu, "搜索", 0));
        datas.add(new ShopHomeMorePop(R.mipmap.fenxiang, "分享", 0));
        datas.add(new ShopHomeMorePop(R.mipmap.tanchuangshouye, "消息", 0));
        datas.add(new ShopHomeMorePop(R.mipmap.dianpujianjie, "店铺简介", 0));
        datas.add(new ShopHomeMorePop(R.mipmap.lianximaijia, "联系卖家", 0));
        lv.setAdapter(new com.zhy.base.adapter.abslistview.CommonAdapter<ShopHomeMorePop>(this, R.layout.shop_home_more_pop_item, datas) {
            @Override
            public void convert(ViewHolder viewHolder, ShopHomeMorePop shopHomeMorePop) {
                viewHolder.setImageResource(R.id.more_pop_iv_show, shopHomeMorePop.icon);
                viewHolder.setText(R.id.more_pop_tv_name, shopHomeMorePop.name);
            }
        });
        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
    }

    private void initRecy() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyContainer.setLayoutManager(layoutManager);
        recyContainer.setHasFixedSize(true);

        recyContainer.setAdapter(mGoodsAdapter = new CommonAdapter<LifeGoodsModel.DataBean>(this, R.layout.shop_home_item, null) {

            @Override
            public void convert(ViewHolder viewHolder, LifeGoodsModel.DataBean dataBean) {

            }

        });
       /* recyContainer.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                pageNo =1;
                shopHomePresenter.initGoodsList(currentType,pageNo,PAGE_SIZE);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                shopHomePresenter.initGoodsList(currentType,++pageNo,PAGE_SIZE);
            }
        });*/
    }

    @Override
    protected String getName() {
        return "店铺首页";
    }

    @Override
    protected View getCenterView() {
        return null;
    }

    @Override
    protected View getRightView() {
        View view = UIUtils.inflate(R.layout.shop_home_right_title);
        view.findViewById(R.id.right_title_rl_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != popupWindow && !popupWindow.isShowing()) {
                    popupWindow.showAsDropDown(v, UIUtils.px2dip(-10), UIUtils.px2dip(10));
                }
            }
        });
        view.findViewById(R.id.right_title_tv_classify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShopHomeActivity.this, ShopClassifyActivity.class));
            }
        });
        return view;
    }


    @Override
    protected int getContentId() {
        return R.layout.activity_shop_home;
    }


    //店铺简介
    @OnClick(R.id.shop_home_frame_detail)
    public void startShopProfileActivity() {
        startActivity(new Intent(this, ShopProfileActivity.class));
    }

    @Override
    public View getScrollableView() {
        return recyContainer;
    }

    @Override
    public void setShopBgUrl(String url) {
        if (!TextUtils.isEmpty(url)) {
            shopBg.setImageURI(Uri.parse(url));
        }

    }

    @Override
    public void setCouponList(CouponModel couponList) {
        List<CouponModel.DataBean> data = couponList.getData();
        LogTool.e("test", data.toString());
    }

    @Override
    public void setGoodsList(LifeGoodsModel goodsList) {
        mGoodsAdapter.setDatas(goodsList.getData());
    }

    @Override
    public void idCollection(boolean isCoolection) {
        ivIsCollection.setImageResource(isCoolection ? R.mipmap.yishoucang : R.mipmap.dianpushoucang);
    }

    @Override
    public void startLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    /**
     *  private final static int TIME =0;//时间
     private final static int SELL_COUNT =1;//销量由高到低
     private final static int PRICE_DOWN =2;//价格由低到高
     private final static int PRICE_UP =3;//价格由高到低
     * */
    private boolean priceUp = true;
    @OnClick({R.id.shop_rule_multiple, R.id.shop_rule_volume, R.id.shop_rule_minute, R.id.shop_rule_price})
    public void getGoodsListByRule(View view) {
        switch (view.getId()) {
            case R.id.shop_rule_multiple:
                shopHomePresenter.initGoodsList(-1,-1 == currentType?++pageNo:1,PAGE_SIZE);
                currentType = -1;

                break;
            case R.id.shop_rule_volume:
                shopHomePresenter.initGoodsList(ShopHomeModelImpl.SELL_COUNT,1,PAGE_SIZE);
                currentType = ShopHomeModelImpl.SELL_COUNT;
                break;
            case R.id.shop_rule_minute:
                shopHomePresenter.initGoodsList(ShopHomeModelImpl.TIME,1,PAGE_SIZE);
                currentType = ShopHomeModelImpl.TIME;
                break;
            case R.id.shop_rule_price:
                shopHomePresenter.initGoodsList(priceUp?ShopHomeModelImpl.PRICE_UP:ShopHomeModelImpl.PRICE_DOWN,1,PAGE_SIZE);
                currentType = priceUp?ShopHomeModelImpl.PRICE_UP:ShopHomeModelImpl.PRICE_DOWN;
                priceUp = !priceUp;
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.shop_is_collection)
    public void collectionShop()
    {
        shopHomePresenter.addFovShopOrShop(null);
    }
}
