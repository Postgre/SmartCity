package com.smartcity.activity.circle;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.R;
import com.smartcity.adapter.circle.CircleDetailAdapter;
import com.smartcity.adapter.circle.CircleDetailMemberAdapter;
import com.smartcity.base.BaseActivity;
import com.smartcity.utils.CommonUtils;
import com.zhy.base.adapter.recyclerview.OnItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/5/5.
 */
public class CircleDetailActivity extends BaseActivity  {
    private static final String[] mItemTexts = {"账户查询", "我要服务", "玩家挣钱", "白送白玩", "泡圈聊天", "粉旗帜"};
    private static final int[] mItemImgs = new int[]{R.mipmap.nrh_zhcx, R.mipmap.nrh_wyfw, R.mipmap.nrh_wjzq, R.mipmap.nrh_bsbw, R.mipmap.nrh_pqlt, R.mipmap.nrh_fqz};
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.recyclerviews)
    RecyclerView recyclerviews;
    @Bind(R.id.img)
    SimpleDraweeView img;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.quanzi)
    TextView quanzi;
    @Bind(R.id.detail)
    TextView detail;
    @Bind(R.id.title_tv)
    TextView title_tv;
    @Bind(R.id.right_sousuo)
    ImageView right_set;
//    @Bind(R.id.id_menulayout)
//    CircleGroup mCircleMenuLayout;
    CircleDetailMemberAdapter memberAdapter;
    String key;
    int detailId;
    int setSelectItem = 2;
    CircleDetailAdapter adapter;

    @Override
    public void init() {
        title_tv.setText("女人花登山详情");
        right_set.setImageResource(R.mipmap.icon_shezhi);
        right_set.setVisibility(View.VISIBLE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(linearLayoutManager);
//        adapter = new CircleDetailAdapter(this, getList(), R.layout.circle_group);
        recyclerview.setAdapter(new com.zhy.base.adapter.recyclerview.CommonAdapter<Map<Object,String>>(this, R.layout.circle_group, getList()) {
            @Override
            public void convert(com.zhy.base.adapter.ViewHolder viewHolder, Map<Object,String> data) {
                viewHolder.setText(R.id.name, data.get("name"))
                        .setImageUrl(R.id.img, data.get("img"));
            }
        });
        LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(this);
        linearLayoutManagers.setOrientation(LinearLayoutManager.HORIZONTAL);
        memberAdapter = new CircleDetailMemberAdapter(this, R.layout.circle_memberlist, getList());
        recyclerviews.setLayoutManager(linearLayoutManagers);
        recyclerviews.setAdapter(memberAdapter);
        memberAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup viewGroup, View view, Object o, int i) {
                CommonUtils.launchActivity(CircleDetailActivity.this,Circle_MemberActivity.class);
            }

            @Override
            public boolean onItemLongClick(ViewGroup viewGroup, View view, Object o, int i) {
                return false;
            }
        });

        Uri uri = Uri.parse("http://ww2.sinaimg.cn/crop.0.0.1080.1080.1024/d773ebfajw8eum57eobkwj20u00u075w.jpg");
        img.setImageURI(uri);
    }
    @OnClick(R.id.right_sousuo)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.right_sousuo:
                CommonUtils.launchActivity(this,Circle_SetActivity.class);
                break;
        }
    }
    public List<Map<Object, String>> getList() {
        List<Map<Object, String>> list = new ArrayList<>();
        Map<Object, String> map;
        for (int i = 0; i < 10; i++) {
            map = new HashMap<>();
            map.put("name", "小组");
            map.put("img", "http://ww2.sinaimg.cn/crop.0.0.1080.1080.1024/d773ebfajw8eum57eobkwj20u00u075w.jpg");
            list.add(map);
        }
        return list;
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_circledetail;
    }

}
