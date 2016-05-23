package com.smartcity.adapter.circle;

import android.content.Context;

import com.smartcity.R;
import com.smartcity.bean.CircleFragment_Model;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.List;

public class ImageViewAdapter extends CommonAdapter<CircleFragment_Model> {
	public ImageViewAdapter(Context context, List<CircleFragment_Model> list,
			int view) {
		super(context, list, view);
	}

	@Override
	public void convert(ViewHolder holder, CircleFragment_Model t) {
		if (holder.getPosition() == super.getCount()-1) {
			holder.setImageResource(R.id.imageview, R.mipmap.dajiahao);
		} else {
			holder.setImageResource(R.id.imageview, (Integer) t.getImageView());
		}
	}
}
