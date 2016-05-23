package com.smartcity.activity.circle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseActivity;
import com.smartcity.bean.CircleFragment_Model;
import com.smartcity.customview.EditTexts;
import com.smartcity.pulltofresh.PullToRefreshListView;

import java.util.ArrayList;

import butterknife.Bind;

@SuppressLint("ResourceAsColor")
public class Circle_CreatePhotoActivity extends BaseActivity implements
		OnClickListener{
	@Bind(R.id.list)
	PullToRefreshListView listview;
	private View headview;
	@Bind(R.id.back_img)
	ImageView imgback;
	@Bind(R.id.title_tv)
	TextView text;
//	@Bind(R.id.photo_name)
	EditTexts name;
//	@Bind(R.id.photo_text)
	EditTexts texts;
	private ArrayList<CircleFragment_Model> lists;
	private Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		headview = (LinearLayout) LayoutInflater.from(this).inflate(
				R.layout.group_createphoto, null);
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
		text.setText("创建相册");
		text.setVisibility(View.VISIBLE);
		text.setOnClickListener(this);
		name = (EditTexts) findViewById(R.id.photo_name);
		texts = (EditTexts) findViewById(R.id.photo_text);
		lists = new ArrayList<CircleFragment_Model>();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.back_img:
			finish();
			break;
		case R.id.right_text:
			if (name.getText().toString() == "" || name.getText() == null || name.getText().equals(null) || name.getText().toString().equals("")) {
				name.setHint("名字不能为空");
				name.setHintTextColor(this.getResources().getColor(R.color.red));
			} else {
//				lists.add(new CircleFragment_Model(R.drawable.df, name
//						.getText().toString(), texts.getText().toString(), 0, 1));
//				Bundle bundle = new Bundle(); 
//				bundle.putSerializable("lists", lists);
				Intent intent = new Intent(mContext, Circle_UploadPictureActivity.class);
//				intent.putExtras(bundle);
				startActivity(intent);
			}
			break;
		default:
			break;
		}
	}
}
