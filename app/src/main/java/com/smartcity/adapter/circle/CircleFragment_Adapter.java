package com.smartcity.adapter.circle;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.http.model.NewCircleListInfo;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.List;

public class CircleFragment_Adapter extends CommonAdapter<NewCircleListInfo.DataBean> {
	public CircleFragment_Adapter(Context context,
								  List<NewCircleListInfo.DataBean> list, int view) {
		super(context, list, view);
	}

	@Override
	public void convert(ViewHolder holder, NewCircleListInfo.DataBean map) {
		holder.setImageURI(R.id.group_image,map.getDetailPicUrl());
		holder.setText(R.id.title, map.getDetailName());
		holder.setText(R.id.allpeople,"总需人数：" + map.getDetailAppliedPersonNumber());
		holder.setText(R.id.stillpeople,"剩余人数："+map.getDetailRealJoinNumber());
		holder.setText(R.id.price,"¥："+map.getDetailJoinMoney());
		holder.setText(R.id.biaoqian,map.getDetailPublishTime());
		final TextView text = holder.getView(R.id.group_join);
//		text.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				AllcircleFragment.instance.join(circleInfo.getDetailId());
//				text.setBackgroundResource(R.drawable.rect_grayall);
//				text.setText(R.string.isjoin);
//				text.setClickable(false);
//			}
//		});
//		if(circleInfo.getIsApply() == 1) {
//			text.setBackgroundResource(R.drawable.rect_grayall);
//			text.setText(R.string.isjoin);
//			text.setClickable(false);
//		}
//		else{
//			text.setBackgroundResource(R.drawable.rect_blue);
//			text.setText(R.string.tojoin);
//			text.setClickable(true);
//		}
	}

}
