package com.smartcity.activity.circle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.pulltofresh.PullToRefreshListView;

import butterknife.Bind;

public class Circle_VideoUploadActivity extends BaseActivity implements OnClickListener{
	@Bind(R.id.list)
	PullToRefreshListView listview;
	private View headview;
	@Bind(R.id.back_img)
	ImageView imgback;
	@Bind(R.id.right_sousuo)
	ImageView shangchuan;
	@Bind(R.id.title_tv)
	TextView text_tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		headview = (LinearLayout) LayoutInflater.from(this).
				inflate(R.layout.group_video_upload, null);
		listview.getRefreshableView().addHeaderView(headview);
		listview.setAdapter(null);
		InitView();
	}

	@Override
	public void init() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.freshlist;
	}

	private void InitView() {
		imgback.setVisibility(View.VISIBLE);
		imgback.setOnClickListener(this);
		text_tv.setText("上传");
		shangchuan.setImageResource(R.mipmap.white_gou);
		shangchuan.setVisibility(View.VISIBLE);
		shangchuan.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.back_img:
			finish();
			break;
		case R.id.right_fq:
			break;
		default:
			break;
		}
	}
}
