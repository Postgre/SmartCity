package com.smartcity.adapter.circle;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.activity.circle.AllCircleDetailActivity;
import com.smartcity.activity.circle.CircleDetailActivity;
import com.smartcity.activity.circle.CircleInfoDetailActivity;
import com.smartcity.bean.Talent;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.ArrayList;
import java.util.Collection;

public class CircleFragmentAdapter extends CommonAdapter<Talent> {
    ArrayList<Talent> objs;
    CircleCardAdapter adapter;
    ArrayList<Talent> list;
    Context context;
    ArrayList<Talent.Data> datalist = new ArrayList<>();

    public CircleFragmentAdapter(Context context, ArrayList<Talent> list,
                                 int view) {
        super(context, list, view);
        objs = list;
        this.list = list;
        this.context = context;
    }

    final CharSequence no = "暂无";

    @Override
    public void convert(ViewHolder holder, Talent talent) {
        holder.setImageURI(R.id.img1,talent.getData().get(0).img)
                .setImageURI(R.id.img2,talent.getData().get(1).img)
                .setImageURI(R.id.img3,talent.getData().get(2).img)
                .setImageURI(R.id.img4,talent.getData().get(3).img)
                .setText(R.id.text1,talent.getData().get(0).title)
                .setText(R.id.text2,talent.getData().get(1).title)
                .setText(R.id.text3,talent.getData().get(2).title)
                .setText(R.id.text4,talent.getData().get(3).title)
                .setText(R.id.text11,"创建人 " + talent.getData().get(0).name)
                .setText(R.id.text22,"创建人 " + talent.getData().get(1).name)
                .setText(R.id.text33,"创建人 " + talent.getData().get(2).name)
                .setText(R.id.text44,"创建人 " + talent.getData().get(3).name);
        TextView join1 = holder.getView(R.id.join1);
        TextView join2 = holder.getView(R.id.join2);
        TextView join3 = holder.getView(R.id.join3);
        TextView join4 = holder.getView(R.id.join4);
        if(talent.getData().get(0).join == 1){
            join1.setText("已加入");
        }else join1.setText("加入");
        if(talent.getData().get(1).join == 1){
            join1.setText("已加入");
        }else join1.setText("加入");
        if(talent.getData().get(2).join == 1){
            join1.setText("已加入");
        }else join1.setText("加入");
        if(talent.getData().get(3).join == 1){
            join1.setText("已加入");
        }else join1.setText("加入");

        join1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, AllCircleDetailActivity.class);
                Intent intent = new Intent(context, CircleInfoDetailActivity.class);
                context.startActivity(intent);
            }
        });
//        datalist = new ArrayList<>();
//        adapter = new CircleCardAdapter(mContext, (ArrayList<Talent.Data>) talent.getData(), R.layout.card_new_items);
//        RecyclerView mRecyclerViews = (RecyclerView) holder.getView(R.id.list);
//        ListView mRecyclerView = (ListView) holder.getView(R.id.listview);
//        mRecyclerViews.setLayoutManager(new LinearLayoutManager(mContext));//这里用线性显示 类似于listview
////设置Item增加、移除动画
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
////添加分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(
//                mContext, DividerItemDecoration.HORIZONTAL_LIST));
//        mRecyclerViews.setAdapter(new com.zhy.base.adapter.recyclerview.CommonAdapter<Talent.Data>(mContext, R.layout.card_new_items, talent.getData()) {
//            @Override
//            public void convert(com.zhy.base.adapter.ViewHolder viewHolder, Talent.Data data) {
//                viewHolder.setImageUrl(R.id.img, data.img)
//                        .setText(R.id.text, data.name);
//                TextView text = (TextView) viewHolder.getView(R.id.join);
//                if (data.join == 1) {
//                    text.setText("已加入");
//                } else {
//                    text.setText("加入");
//                }
//            }
//        });
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

    public void addAll(Collection<Talent> collection) {
        if (isEmpty()) {
            objs.addAll(collection);
            notifyDataSetChanged();
        } else {
            objs.addAll(collection);
        }
    }

    public void clear() {
        objs.clear();
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return objs.isEmpty();
    }

    public void remove(int index) {
        if (index > -1 && index < objs.size()) {
            objs.remove(index);
            notifyDataSetChanged();
        }
    }
}
