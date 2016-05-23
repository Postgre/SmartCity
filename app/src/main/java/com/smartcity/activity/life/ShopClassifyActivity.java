package com.smartcity.activity.life;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;

import com.smartcity.R;
import com.smartcity.http.model.LifeClassify;
import com.smartcity.utils.LogTool;
import com.smartcity.utils.ToastTool;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;
import com.zhy.base.adapter.recyclerview.MultiItemCommonAdapter;
import com.zhy.base.adapter.recyclerview.MultiItemTypeSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Yancy on 2016/5/12.
 */
public class ShopClassifyActivity extends LifeBaseActivity {

    @Bind(R.id.shop_classify_recy_container)
    RecyclerView classify_container;

    MultiItemCommonAdapter<LifeClassify> adapter;

    @Override
    protected void initViews() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        classify_container.setLayoutManager(manager);


        List<LifeClassify> datas = new ArrayList<>();

        List<String> params = new ArrayList<>();
        params.add("全部");
        params.add("洗发水");
        params.add("发膜");
        params.add("护法精油");
        params.add("护发素");

        datas.add(new LifeClassify(R.mipmap.hair_styling, "美发造型", "Hair styling", false, params, 1));
        datas.add(new LifeClassify(R.mipmap.shoes_bags, "潮流鞋包", "Shoses bags", false, params, 2));
        datas.add(new LifeClassify(R.mipmap.clothes_accessories, "时尚服饰", "Clothes & Accessories", false, params, 3));
        datas.add(new LifeClassify(R.mipmap.health_maintain, "健康养生", "Health maintain", false, params, 4));
        datas.add(new LifeClassify(R.mipmap.daily_care, "手机数码", "Digital equipment", false, params, 5));
        datas.add(new LifeClassify(R.mipmap.health_maintain, "酒水饮料", "Health maintain", false, params, 6));
        datas.add(new LifeClassify(R.mipmap.baby_toys, "母婴玩具", "Baby toys", false, params, 7));
        datas.add(new LifeClassify(R.mipmap.home_textile, "家居家纺", "Home Textile", false, params, 8));
        datas.add(new LifeClassify(R.mipmap.jewelry, "珠宝首饰", "Jewelry", false, params, 9));
        datas.add(new LifeClassify(R.mipmap.hair_styling, "美发造型", "Hair styling", false, params, 10));
        datas.add(new LifeClassify(R.mipmap.hair_styling, "美发造型", "Hair styling", false, params, 11));
        datas.add(new LifeClassify(R.mipmap.hair_styling, "美发造型", "Hair styling", false, params, 12));

        classify_container.setAdapter(adapter = new MultiItemCommonAdapter<LifeClassify>(this, datas, new MultiItemTypeSupport<LifeClassify>() {
            @Override
            public int getLayoutId(int i) {
                //图片在左  left
                return i % 2 == 0 ? R.layout.life_classify_left_item : R.layout.life_classify_right_item;
            }

            @Override
            public int getItemViewType(int i, LifeClassify lifeClassify) {
                return lifeClassify.type;
            }
        }) {

            @Override
            public void convert(ViewHolder viewHolder, final LifeClassify lifeClassify) {

                switch (viewHolder.getLayoutId()) {
                    case R.layout.life_classify_left_item:
                        viewHolder.setText(R.id.classify_left_tv_title, lifeClassify.title);
                        viewHolder.setText(R.id.classify_left_tv_name, lifeClassify.name);
                        viewHolder.setImageResource(R.id.classify_left_iv_show, lifeClassify.img);
                        viewHolder.setVisible(R.id.classify_left_ll_bottom, lifeClassify.isShow);

                        if(lifeClassify.isShow)
                        {
                            GridView rightGv = viewHolder.getView(R.id.classify_item_gv_left_container);

                            if(null != rightGv)
                            {
                                rightGv.setAdapter(new CommonAdapter<String>(ShopClassifyActivity.this,R.layout.life_classify_gv_item,lifeClassify.classify) {
                                    @Override
                                    public void convert(ViewHolder viewHolder, String s) {
                                        viewHolder.setText(R.id.classify_gv_item_tv,s);

                                    }
                                });
                            }
                        }

                        viewHolder.setOnClickListener(R.id.classify_left_ll_top, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                List<LifeClassify> lifeClassifies = adapter.getmDatas();
                                for(LifeClassify life:lifeClassifies)
                                {
                                   if(life.equals(lifeClassify))
                                   {
                                       lifeClassify.isShow = !lifeClassify.isShow;

                                   }
                                    else
                                   {
                                       life.isShow = false;
                                   }
                                }
                                notifyDataSetChanged();
                            }
                        });
                        break;

                    case R.layout.life_classify_right_item:
                        viewHolder.setText(R.id.classify_right_tv_title, lifeClassify.title);
                        viewHolder.setText(R.id.classify_right_tv_name, lifeClassify.name);

                        viewHolder.setImageResource(R.id.classify_right_iv_show, lifeClassify.img);

                        viewHolder.setVisible(R.id.classify_right_ll_bootm, lifeClassify.isShow);


                        if(lifeClassify.isShow)
                        {
                            GridView rightGv = viewHolder.getView(R.id.classify_item_gv_container);
                            if(null != rightGv)
                            {
                                rightGv.setAdapter(new CommonAdapter<String>(ShopClassifyActivity.this,R.layout.life_classify_gv_item,lifeClassify.classify) {
                                    @Override
                                    public void convert(ViewHolder viewHolder, String s) {
                                        viewHolder.setText(R.id.classify_gv_item_tv,s);

                                    }
                                });
                            }
                        }

                        viewHolder.setOnClickListener(R.id.classify_right_rl_top, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                List<LifeClassify> lifeClassifies = adapter.getmDatas();
                                for(LifeClassify life:lifeClassifies)
                                {
                                    if(life.equals(lifeClassify))
                                    {
                                        lifeClassify.isShow = !lifeClassify.isShow;
                                    }
                                    else
                                    {
                                        life.isShow = false;
                                    }
                                }
                                notifyDataSetChanged();
                            }
                        });
                        break;
                    default:
                    break;
                }
            }
        });

    }

    @Override
    protected String getName() {
        return "分类";
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
        return R.layout.activity_life_classify;
    }
}
