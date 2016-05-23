package com.smartcity.adapter.circle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcity.R;

import java.util.HashMap;

public class CircleAction_PopAdapter extends BaseAdapter{
	private Context context;
	private String[] strings;
	private HashMap<Integer, View> lmap = new HashMap<Integer, View>();
	public int selectIndex = 0;
	public CircleAction_PopAdapter(Context context, String[] strings){
		this.context = context;
		this.strings = strings;
	}
	@Override
	public int getCount() {
		return strings.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(null != lmap.get(position)){
			convertView = lmap.get(position);
			holder = (ViewHolder) convertView.getTag();
		}else{
			convertView = View.inflate(context, R.layout.sixaction_listview_item, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.tv_sixaction_popitem_title);
			holder.img = (ImageView) convertView.findViewById(R.id.tv_sixaction_popitem_img);
			convertView.setTag(holder);
		}
		
		holder.title.setText(strings[position]);
		if(selectIndex == position)  holder.img.setVisibility(View.VISIBLE);
		else  holder.img.setVisibility(View.GONE);
		
		return convertView;
	}
	
	private class ViewHolder{
		public TextView title;
		public ImageView img;
	}
}
