package com.smartcity.adapter.chw.wyx;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseListAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: PopWindowAdapter.java
 * @author: fengliang
 * @date: 2016-05-12 16:33
 */
public class PopWindowAdapter extends BaseListAdapter<String> {
    private static final String TAG = PopWindowAdapter.class.getName();

    public PopWindowAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public View initView(int position, View convertView) {
        final String title = list.get(position);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.gird_item_pop_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mName.setText(title);

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.item_title)
        TextView mName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
