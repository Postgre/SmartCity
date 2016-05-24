package com.smartcity.adapter.circle;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.activity.circle.Circle_Activity;
import com.smartcity.activity.circle.Circle_NoticeActivity;
import com.smartcity.activity.circle.Circle_PhotoActivity;
import com.smartcity.activity.circle.Circle_VideoActivity;
import com.smartcity.http.model.CircleBean;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CircleFragmentsAdapter extends CommonAdapter<CircleBean.CirDataEntity> implements View.OnClickListener{
    List<CircleBean.CirDataEntity> objs;
    CircleCardAdapter adapter;
    List<CircleBean.CirDataEntity> list;
    Context context;
    List<Map<String,String>> datalist = new ArrayList<>();
    private ViewHolder holder;
    public static String detailPid;
    RecyclerView mRecyclerView;
    Adapter adapters;
    LinearLayoutManager linearLayoutManager;
    public CircleFragmentsAdapter(Context context, List<CircleBean.CirDataEntity> list,
                                  int view) {
        super(context, list, view);
        objs = list;
        this.list = list;
        this.context = context;
    }

    final CharSequence no = "暂无";

    @Override
    public void convert(ViewHolder holder, CircleBean.CirDataEntity talent) {
        this.holder = holder;
        detailPid = talent.getDetailId() + "";
        holder.setImageURI(R.id.img, "http://img4.imgtn.bdimg.com/it/u=2317499888,864114656&fm=21&gp=0.jpg")
                .setText(R.id.title, talent.getDetailName())
//                .setText(R.id.quanzi,talent.get)
                .setText(R.id.ren, talent.getDetailNumber() + "")
                .setText(R.id.detail, talent.getDetailTitle());
        TextView huodong = holder.getView(R.id.huodong);
        TextView shiping = holder.getView(R.id.shiping);
        TextView xiangji = holder.getView(R.id.xiangji);
        TextView tongzhi = holder.getView(R.id.tongzhi);
        huodong.setOnClickListener(this);
        shiping.setOnClickListener(this);
        xiangji.setOnClickListener(this);
        tongzhi.setOnClickListener(this);
        mRecyclerView = (RecyclerView) holder.getView(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
//设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        if(talent.getLscd() != null) {
            adapters = new Adapter(context, R.layout.card_new_group, talent.getLscd());
            mRecyclerView.setAdapter(adapters);
            adapters.notifyDataSetChanged();
        }
//        initNet();
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(
//                mContext, DividerItemDecoration.HORIZONTAL_LIST));
//		view.setAdapter(new SectionAdapter<String>(this, R.layout.item_list, mDatas, sectionSupport)
//		{
//			@Override
//			public void convert(ViewHolder holder, String s)
//			{
//				holder.setText(R.id.id_item_list_title, s);
//			}
//		});
//		view.setAdapter(adapter);
//        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				switch (event.getAction())
//				{
//					case MotionEvent.ACTION_MOVE:
//                        T.showShort(mContext,"滑动");
//						return false;
//					default:
//						break;
//				}
//                return false;
//			}
//		});
//		holder.setImageURI(R.id.portrait,talent.headerIcon)
//				.setText(R.id.name,talent.nickname);
//		TextView city = holder.getView(R.id.city);
//		city.setHint(no);
//		city.setText(talent.cityName);
//		city.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_location,0,0);
//		TextView education = holder.getView(R.id.education);
//		education.setHint(no);
//		education.setText(talent.educationName);
//		education.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_edu,0,0);
//		TextView work_year = holder.getView(R.id.work_year);
//		work_year.setHint(no);
//		work_year.setText(talent.workYearName);
//		work_year.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_location,0,0);
    }

    public void addAll(Collection<CircleBean.CirDataEntity> collection) {
        if (isEmpty()) {
            objs.addAll(collection);
            notifyDataSetChanged();
        } else {
            objs.addAll(collection);
        }
    }
    Intent intent;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.huodong:
                intent = new Intent();
                intent.putExtra("detailPid",detailPid);
                intent.setClass(mContext, Circle_Activity.class);
                mContext.startActivity(intent);
                break;
            case R.id.shiping:
                intent = new Intent();
                intent.putExtra("detailPid",detailPid);
                intent.setClass(mContext, Circle_VideoActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.xiangji:
                intent = new Intent();
                intent.putExtra("detailPid",detailPid);
                intent.setClass(mContext, Circle_PhotoActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.tongzhi:
                intent = new Intent();
                intent.putExtra("detailPid",detailPid);
                intent.setClass(mContext, Circle_NoticeActivity.class);
                mContext.startActivity(intent);
                break;
        }
    }
    public void clear() {
        objs.clear();
        notifyDataSetChanged();
    }

//    private void initNet() {
//        for (int i = 0; i < 10; i++) {
//            Map<String,String> map= new HashMap<String,String>();
//            map.put("img","http://img4.imgtn.bdimg.com/it/u=2317499888,864114656&fm=21&gp=0.jpg");
//            map.put("text","你好");
//            datalist.add(map);
//        }
////        adapters = new Adapter(mContext, R.layout.card_new_group, datalist);
////        mRecyclerView.setAdapter(adapters);
////        adapters.notifyDataSetChanged();
//        SharedPreferencesUtil spUtils = MyApplication.getSpUtils();
//        String apikey = spUtils.getString(Constant.API_KEY, "");
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
//        CircleService service = retrofit.create(CircleService.class);
//        Map<String, Object> pam = new HashMap<>();
//        pam.put("detailPid", detailPid);
//        pam.put("sStartpage", 1);
//        pam.put("sPagerows", 10);
//
//        service.getCircleGroup(apikey, Url.MYGROUP, Constant.VALUE_VERSION, GsonUtils.objectToJson(pam)).enqueue(new Callback<CircleGroup_bean>() {
//            @Override
//            public void onResponse(Response<CircleGroup_bean> response, Retrofit retrofit) {
//
////                Log.e("getgroup", "response.body():" + response.body().getCode());
//                CircleGroup_bean circleBean = response.body();
//                if (null != circleBean) {
//                    if (circleBean.getCode() == Constant.STATUS_SUCCESS) {
//                        adapters = new Adapter(mContext, R.layout.card_new_group, circleBean.getData());
//                        Log.e("getgroup", "getData:" + circleBean.getData().toArray());
//                        mRecyclerView.setAdapter(adapters);
//                        adapters.notifyDataSetChanged();
//                    } else {
//                        ToastTool.showShort(context,"失败");
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                ToastTool.showShort(context,"失败");
//            }
//        });
//    }

    public boolean isEmpty() {
        return objs.isEmpty();
    }

    public void remove(int index) {
        if (index > -1 && index < objs.size()) {
            objs.remove(index);
            notifyDataSetChanged();
        }
    }

//    public void CircleGroup(List<CircleBean.CirDataEntity> circleList) {
//        ToastTool.showShort(context,"成功" + circleList.get(1).getDetailName());
//        adapters = new Adapter(mContext, R.layout.card_new_group, circleList);
//        mRecyclerView.setAdapter(adapters);
//        adapters.notifyDataSetChanged();
//    }

    public class Adapter extends com.zhy.base.adapter.recyclerview.CommonAdapter<CircleBean.CirDataEntity.LscdBean> {
        public Adapter(Context context, int layoutId, List<CircleBean.CirDataEntity.LscdBean> datas) {
            super(context, layoutId, datas);
        }

        @Override
        public void convert(com.zhy.base.adapter.ViewHolder viewHolder, CircleBean.CirDataEntity.LscdBean data) {
//            ToastTool.showShort(context,"成功" + data.getDetailName());
            viewHolder.setImageUrl(R.id.img, data.getDetailTitlePic())
                    .setText(R.id.group, data.getDetailName());
        }
    }

}
