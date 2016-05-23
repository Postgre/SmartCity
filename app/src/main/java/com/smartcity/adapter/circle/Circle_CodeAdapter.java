package com.smartcity.adapter.circle;

import android.content.Context;

import com.smartcity.R;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/5/14.
 */
public class Circle_CodeAdapter extends CommonAdapter<String>{
    public Circle_CodeAdapter(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder viewHolder, String s) {
        viewHolder.setText(R.id.text,s);
    }
}
