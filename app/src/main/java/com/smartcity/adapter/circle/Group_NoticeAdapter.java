package com.smartcity.adapter.circle;

import android.content.Context;

import com.smartcity.R;
import com.smartcity.http.model.CircleNotice;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.List;
import java.util.Map;

public class Group_NoticeAdapter extends CommonAdapter<CircleNotice.DataBean> {
	public Group_NoticeAdapter(Context context, List<CircleNotice.DataBean> list, int view) {
		super(context, list, view);
	}
	@Override
	public void convert(ViewHolder holder, CircleNotice.DataBean map) {
		holder.setText(R.id.group_notice_title, (String) map.getInformTitle())
				.setText(R.id.group_notice_content,(String) map.getInformContent())
				.setText(R.id.group_notice_time, (String) map.getInformTime());
	}
}
