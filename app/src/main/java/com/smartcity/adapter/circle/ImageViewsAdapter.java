package com.smartcity.adapter.circle;

import android.content.Context;
import android.widget.ImageView;

import com.smartcity.R;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.List;

public class ImageViewsAdapter extends CommonAdapter<String> {
	public ImageViewsAdapter(Context context, List<String> list, int view) {
		super(context, list, view);
	}

	@Override
	public void convert(ViewHolder holder, String t) {
		if (holder.getPosition() == super.getCount() - 1) {
			holder.setImageResource(R.id.imageview, R.mipmap.dajiahao);
		} else {
			ImageView view = (ImageView) holder.getView(R.id.imageview);
//			ImageDownLoader.showLocationImage(t, view, R.mipmap.df);
			holder.setImageURI(R.id.imageview,t);
		}
	}
}
