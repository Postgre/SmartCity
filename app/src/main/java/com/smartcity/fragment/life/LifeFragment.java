package com.smartcity.fragment.life;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.smartcity.R;
import com.smartcity.activity.LoginActivity;
import com.smartcity.activity.SelectCityActivity;
import com.smartcity.activity.life.ShopDetailsActivity;
import com.smartcity.activity.life.ShopHomeActivity;
import com.smartcity.activity.life.ShopListActivity;
import com.smartcity.base.BaseFragment;
import com.smartcity.config.Constant;
import com.smartcity.customview.CustomViewPager;
import com.smartcity.customview.LazyViewPager;
import com.smartcity.http.model.HopShopAndBanner;
import com.smartcity.http.model.LifeBannerAndHotModel;
import com.smartcity.http.model.LifeClassifyModel;
import com.smartcity.presenterImpl.LifeIndexPresenter;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.UIUtils;
import com.smartcity.view.ILifeIndexView;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;
import com.zhy.base.adapter.recyclerview.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class LifeFragment extends BaseFragment implements ILifeIndexView {


    //分类
    @Bind(R.id.life_index_gv_classify)
    GridView gvClassify;

    //附近的导航标题
    @Bind(R.id.life_index_tab_near_title)
    TabLayout tabNearTitle;

    //热门店铺
    @Bind(R.id.life_index_recy_hot_container)
    RecyclerView reContainer;

    //轮播图
    @Bind(R.id.life_index_auto_page)
    RollPagerView autoViewPager;

    @Bind(R.id.life_index_pag_near_container)
    CustomViewPager nearContainer;

    private CommonAdapter<LifeBannerAndHotModel.DataBean.CategoryListBean> classifyAdapter;
    private MyAutoViewPager autoPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {

    }

    @Override
    protected void initViews() {
        initGridView();
        initRecyView();

        initBanner();
        initNear();
        new LifeIndexPresenter(this);
    }

    private void initBanner() {
        autoViewPager.setHintView(new ColorPointHintView(getActivity(), Color.RED, Color.WHITE));
        autoPagerAdapter = new MyAutoViewPager(autoViewPager, null);
        autoViewPager.setAdapter(autoPagerAdapter);
        autoPagerAdapter.setOnItemClick(new AutoPageOnItemClick() {
            @Override
            public void onItemClick(int postion) {
                List<LifeBannerAndHotModel.DataBean.SlideShopListBean> data = autoPagerAdapter.getData();
                LifeBannerAndHotModel.DataBean.SlideShopListBean listBean = data.get(postion);
                int id = listBean.getId();
                Intent intent = new Intent(getActivity(), ShopDetailsActivity.class);
                if(!TextUtils.isEmpty(String.valueOf(id)))
                {
                    intent.putExtra(ShopDetailsActivity.GOODS_ID,String.valueOf(id));
                    startActivity(intent);
                }
            }
        });
    }

    com.zhy.base.adapter.recyclerview.CommonAdapter<LifeBannerAndHotModel.DataBean.HotShopListBean> hotAdapter;

    private void initRecyView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        reContainer.setLayoutManager(manager);


        reContainer.setAdapter(hotAdapter = new com.zhy.base.adapter.recyclerview.CommonAdapter<LifeBannerAndHotModel.DataBean.HotShopListBean>(getActivity(), R.layout.life_index_hot_shop_item, null) {

            @Override
            public void convert(ViewHolder viewHolder, LifeBannerAndHotModel.DataBean.HotShopListBean hotShopListBean) {
                viewHolder.setImageUrl(R.id.hotshop_item_tv_shop_img, hotShopListBean.getLabelImageUrl());
                viewHolder.setText(R.id.hotshop_item_tv_shop_name, hotShopListBean.getName());
            }



        });
        hotAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup viewGroup, View view, Object o, int i) {
                LifeBannerAndHotModel.DataBean.HotShopListBean dataBean = hotAdapter.getmDatas().get(i);
                int id = dataBean.getId();
                Intent intent = new Intent(getActivity(), ShopHomeActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("bg",dataBean.getBgImage());
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(ViewGroup viewGroup, View view, Object o, int i) {
                return false;
            }
        });

    }

    private void initNear() {

        String[] nearTitles = UIUtils.getStringArray(R.array.life_near_title);

        for (int i = 0; i < nearTitles.length; i++) {
            tabNearTitle.addTab(tabNearTitle.newTab().setText(nearTitles[i]));
        }
        tabNearTitle.setTabMode(TabLayout.MODE_SCROLLABLE);

        nearContainer.setAdapter(new LifeNearAdapter(getActivity().getSupportFragmentManager(), nearTitles));
        nearContainer.setOffscreenPageLimit(1);
        tabNearTitle.setupWithViewPager(nearContainer);

    }


    private void initGridView() {

        gvClassify.setAdapter(classifyAdapter = new CommonAdapter<LifeBannerAndHotModel.DataBean.CategoryListBean>(getActivity(), R.layout.life_index_classify_item, null) {

            @Override
            public void convert(ViewHolder viewHolder, LifeBannerAndHotModel.DataBean.CategoryListBean dataBean) {
                viewHolder.setText(R.id.classify_item_tv_shop_name, dataBean.getCategoryName());

                ImageView ivShop = viewHolder.getView(R.id.classify_item_iv_shop);
                int categoryType = dataBean.getCategoryType();

                switch (categoryType) {
                    case Constant.LifeClassify.HEALTHCARE:
                        ivShop.setImageResource(R.mipmap.cofee_cup_1);
                        break;
                    case Constant.LifeClassify.FASHIONSHOE:
                        ivShop.setImageResource(R.mipmap.shopping_bag_1);
                        break;
                    case Constant.LifeClassify.FASHIONAPPAREA:
                        ivShop.setImageResource(R.mipmap.shirt_1);
                        break;
                    case Constant.LifeClassify.LUGGAGEJEWELRY:
                        ivShop.setImageResource(R.mipmap.diamond);
                        break;
                    case Constant.LifeClassify.DRINKS:
                        ivShop.setImageResource(R.mipmap.icon_yingl);
                        break;
                    case Constant.LifeClassify.BEAUTY:
                        ivShop.setImageResource(R.mipmap.icon_kouhong);
                        break;
                    case Constant.LifeClassify.FRESHLVING:
                        ivShop.setImageResource(R.mipmap.icon_yu);
                        break;
                    case Constant.LifeClassify.HOMETEXTILE:
                        ivShop.setImageResource(R.mipmap.icon_fangzi);
                        break;
                    case Constant.LifeClassify.BABYTOYS:
                        ivShop.setImageResource(R.mipmap.icon_muyin);
                        break;
                    case Constant.LifeClassify.ALLCLASSIFY:
                        ivShop.setImageResource(R.mipmap.icon_fenlei);
                        break;
                    default:
                        break;
                }
            }
        });

        gvClassify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ShopListActivity.class);
                LifeBannerAndHotModel.DataBean.CategoryListBean bean = classifyAdapter.getmDatas().get(position);

                intent.putExtra(ShopListActivity.CLASSIFY_NAME,bean.getCategoryName());
                intent.putExtra(ShopListActivity.CLASSIFY_Id,bean.getId());
                startActivity(intent);
            }
        });
    }


    @Override
    protected void init() {

    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_life;
    }

    @Override
    public void startLogin() {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }




    @Override
    public void setBanner(List<LifeBannerAndHotModel.DataBean.SlideShopListBean> banner) {
        LogTool.e("SlideShopListBean","SlideShopListBean = "+ banner.toString());
        autoPagerAdapter.setDatas(banner);
    }

    @Override
    public void setHotShop(List<LifeBannerAndHotModel.DataBean.HotShopListBean> banner) {
        LogTool.e("HotShopListBean","HotShopListBean = "+ banner.toString());
        hotAdapter.setDatas(banner);
    }

    @Override
    public void setClassify(List<LifeBannerAndHotModel.DataBean.CategoryListBean> classifyModel) {
        classifyAdapter.setDatas(classifyModel);
        LogTool.e("CategoryListBean","CategoryListBean = "+ classifyModel.toString());
    }


    private class MyAutoViewPager extends LoopPagerAdapter {

        private List<LifeBannerAndHotModel.DataBean.SlideShopListBean> dataBeen;

        public MyAutoViewPager(RollPagerView viewPager, List<LifeBannerAndHotModel.DataBean.SlideShopListBean> dataBeen) {
            super(viewPager);
            this.dataBeen = dataBeen;
        }

        public void setDatas(List<LifeBannerAndHotModel.DataBean.SlideShopListBean> dataBeen) {
            this.dataBeen = dataBeen;
            notifyDataSetChanged();
        }

        private AutoPageOnItemClick onItemClick;

        public void setOnItemClick(AutoPageOnItemClick onItemClick) {
            this.onItemClick = onItemClick;
        }

        @Override
        public View getView(ViewGroup container, final int position) {
            SimpleDraweeView view = new SimpleDraweeView(container.getContext());
            view.setImageURI(Uri.parse(dataBeen.get(position).getLabelImageUrl()));
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != onItemClick) {
                        onItemClick.onItemClick(position);
                    }
                }
            });
            return view;

        }

        @Override
        protected int getRealCount() {
            return null == dataBeen ? 0 : dataBeen.size();
        }

        public List<LifeBannerAndHotModel.DataBean.SlideShopListBean> getData()
        {
            return dataBeen;
        }

    }

    public interface AutoPageOnItemClick {
        void onItemClick(int postion);
    }

    private class LifeNearAdapter extends FragmentPagerAdapter {
        private String[] titles;
        private List<BaseFragment> fragments;

        public LifeNearAdapter(FragmentManager fm, String[] titles) {
            super(fm);
            this.titles = titles;
            fragments = new ArrayList<>();

            for (int i = 1; i < titles.length+1; i++) {
                fragments.add(LifeIndexNearFragment.getinstance(i));
            }
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return null == titles ? 0 : titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

    @OnClick(R.id.life_index_tv_location)
    public void startSelectCity() {
        startActivity(new Intent(getActivity(), SelectCityActivity.class));
    }
}