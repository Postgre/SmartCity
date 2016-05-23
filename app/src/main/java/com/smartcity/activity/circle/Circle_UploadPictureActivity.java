package com.smartcity.activity.circle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.adapter.circle.Group_UploadPictureAdapter;
import com.smartcity.adapter.circle.ImageViewAdapter;
import com.smartcity.adapter.circle.ImageViewsAdapter;
import com.smartcity.base.BaseActivity;
import com.smartcity.bean.CircleFragment_Model;
import com.smartcity.customview.MyGridView;
import com.smartcity.pulltofresh.PullToRefreshListView;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

public class Circle_UploadPictureActivity extends BaseActivity implements
		OnClickListener{
	@Bind(R.id.list)
	PullToRefreshListView listview;
	private View headview;
	@Bind(R.id.back_img)
	ImageView imgback;
	@Bind(R.id.right_text)
	TextView text;
	private MyGridView gridview;
	private ArrayList<CircleFragment_Model> list1, lists, lists1;
	private List<String> list;
	private ImageViewAdapter adapter;
	private ImageViewsAdapter adapter1;
	private Group_UploadPictureAdapter adapters;
	private Intent intent;
	private int position;
	LinearLayout create;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
//		AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
//		View header = getLayoutInflater().inflate(R.layout.invite_record_header, mInviteRecordLv, false);
//		header.setLayoutParams(layoutParams);
//		RecycleView lv = listview.getRefreshableView();
//		lv.addHeaderView(header);
		headview = (LinearLayout) LayoutInflater.from(this).inflate(
				R.layout.group_uploadpicture, null);
		listview.getRefreshableView().addHeaderView(headview);
		initData();
		InitView();
		listview.setAdapter(adapters);
		// listview.setOnItemClickListener(new OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> arg0, View arg1,
		// int position, long arg3) {
		// ImageView imageOK = (ImageView) arg1
		// .findViewById(R.id.imageViewOk);
		// imageOK.setVisibility(View.VISIBLE);
		// for (int i = 0; i < lists.size(); i++) {
		// lists.get(i).setNum(0);
		// }
		// lists.get(position).setNum(1);
		// adapter.notifyDataSetChanged();
		// }
		// });
	}

	@Override
	public void init() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.freshlist;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back_img:
			finish();
			break;
		case R.id.line_create:
			finish();
			CommonUtils.launchActivity(this, Circle_CreatePhotoActivity.class);
			break;
		default:
			break;
		}
	}

	private void InitView() {
		imgback.setVisibility(View.VISIBLE);
		imgback.setOnClickListener(this);
		text.setText("发布");
		text.setVisibility(View.VISIBLE);
		text.setOnClickListener(this);
		gridview = (MyGridView) findViewById(R.id.group_gridview);
		gridview.setAdapter(adapter);
		create = (LinearLayout) findViewById(R.id.line_create) ;
		create.setOnClickListener(this);

		intent = getIntent();
		Bundle bundle = intent.getExtras();
		if (bundle == null) {
			return;
		}
		list = (List<String>) bundle.getSerializable("list");
		list.add("");

		adapter1 = new ImageViewsAdapter(this, list, R.layout.imageview);
		adapter1.setOnChildItemClickListener(new CommonAdapter.OnChildItemOnClickListener() {
			@Override
			public void OnChildItemOnClick(int position, View v,
					List<Map<String, Object>> list) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.imageview:
					if (position == list.size() - 1) {
						finish();
					}
					break;

				default:
					break;
				}
			}
		});
		adapter1.addClickListenerFromId(R.id.imageview);
		gridview.setAdapter(adapter1);
		// gridview.setCurrentItem(position);

	}

	private void initData() {
		list1 = new ArrayList<CircleFragment_Model>();
		// list1.add(new CircleFragment_Model(R.drawable.pt_zhao1));
		// list1.add(new CircleFragment_Model(R.drawable.pt_zhao2));
		// list1.add(new CircleFragment_Model(R.drawable.pt_zhao3));
		// list1.add(new CircleFragment_Model(R.drawable.pt_zhao4));
		list1.add(new CircleFragment_Model(1));
		adapter = new ImageViewAdapter(this, list1, R.layout.imageview);
		adapter.setOnChildItemClickListener(new CommonAdapter.OnChildItemOnClickListener() {
			@Override
			public void OnChildItemOnClick(int position, View v,
					List<Map<String, Object>> list) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.imageview:
					if (position == list.size() - 1) {
						finish();
					}
					break;

				default:
					break;
				}
			}
		});
		adapter.addClickListenerFromId(R.id.imageview);
		lists1 = new ArrayList<CircleFragment_Model>();
		lists1.add(new CircleFragment_Model(R.mipmap.df, "泰国7日游", "",
				480, 1));
		lists1.add(new CircleFragment_Model(R.mipmap.df, "泰国7日游", "",
				480, 0));
		lists1.add(new CircleFragment_Model(R.mipmap.df, "泰国7日游", "",
				480, 0));
		lists1.add(new CircleFragment_Model(R.mipmap.df, "泰国7日游", "",
				480, 0));
		adapters = new Group_UploadPictureAdapter(this, lists1,
				R.layout.imagecheck_popwindow_item_layout);
		adapters.setOnChildItemClickListener(new CommonAdapter.OnChildItemOnClickListener() {

			@Override
			public void OnChildItemOnClick(int position, View v,
					List<Map<String, Object>> list) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.rela:
					for (int i = 0; i < lists1.size(); i++) {
						lists1.get(i).setNum(0);
					}
					lists1.get(position).setNum(1);
					adapters.notifyDataSetChanged();
					break;

				default:
					break;
				}
			}
		});
		adapters.addClickListenerFromId(R.id.rela);
	}
}
