package com.smartcity.adapter.circle;

import android.content.Context;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.bean.Talent;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.ArrayList;

public class CircleCardAdapter extends CommonAdapter<Talent.Data> {
	ArrayList<Talent.Data> objs;
	public CircleCardAdapter(Context context, ArrayList<Talent.Data> list,
							 int view) {
		super(context, list, view);
		objs = list;
	}
	final CharSequence no = "暂无";
	@Override
	public void convert(ViewHolder holder, Talent.Data t) {
		holder.setImageURI(R.id.img,"http://hdn.xnimg.cn/photos/hdn321/20130612/2235/h_main_NNN4_e80a000007df111a.jpg")
				.setText(R.id.text,"智创工场");
		TextView text = (TextView) holder.getView(R.id.join);
		if(t.join == 1){
			text.setText("已加入");
		}else {
			text.setText("加入");
		}
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
}
