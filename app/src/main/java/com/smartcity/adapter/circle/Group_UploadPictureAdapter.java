package com.smartcity.adapter.circle;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.smartcity.R;
import com.smartcity.bean.CircleFragment_Model;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.List;

public class Group_UploadPictureAdapter extends
		CommonAdapter<CircleFragment_Model> {
	private ImageView imageOK;
	private RelativeLayout rela;

	public Group_UploadPictureAdapter(Context context,
									  List<CircleFragment_Model> list, int view) {
		super(context, list, view);
	}

	@Override
	public void convert(ViewHolder holder, CircleFragment_Model t) {
		holder.setImageResource(R.id.imageView_parent_show,
				(Integer) t.getImageView())
				.setText(R.id.textView_parent_name, (String) t.getName())
				.setText(R.id.textView_nums, (int) t.getVip() + "\t张照片");
		rela = (RelativeLayout) holder.getView(R.id.rela);
		imageOK = (ImageView) holder.getView(R.id.imageViewOk);
		if (t.getNum() == 1) {
			imageOK.setVisibility(View.VISIBLE);
		} else {
			imageOK.setVisibility(View.GONE);
		}
	}
}
