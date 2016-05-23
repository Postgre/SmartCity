package com.smartcity.adapter.chw.service;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartcity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyuan on 2016/5/19.
 */
public class ServiceFenNeiAdapter extends BaseAdapter {
    List<String> titles = new ArrayList<>();
    Context context;

    public ServiceFenNeiAdapter(List<String> titles, Context context) {
        this.titles = titles;
        this.context = context;
    }



    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return titles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_serviceactivity_fennei, null);
        }
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        tv_name.setText(titles.get(position));
        return convertView;
    }
}
