package com.smartcity.adapter.circle;

import android.content.Context;

import com.smartcity.R;
import com.zhy.base.adapter.ViewHolder;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/10.
 */
public class CircleDetailMemberAdapter extends com.zhy.base.adapter.recyclerview.CommonAdapter<Map<Object, String>> {
    public CircleDetailMemberAdapter(Context context, int layoutId, List<Map<Object, String>> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder viewHolder, Map<Object, String> data) {
        viewHolder.setText(R.id.name, data.get("name"))
                .setImageUrl(R.id.img, data.get("img"));
    }
}
