package com.smartcity.adapter.circle;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.smartcity.R;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.CommonAdapters;
import com.smartcity.utils.ViewHolder;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/7.
 */
public class CircleDetailAdapter extends CommonAdapters<Map<Object, String>> {
    private int selectItem;
    public CircleDetailAdapter(Context context, List<Map<Object, String>> list,
                                  int view) {
        super(context, list, view);
    }
    public void setSelectItem(int selectItem) {

        if (this.selectItem != selectItem) {
            this.selectItem = selectItem;
            notifyDataSetChanged();
        }
    }
    @Override
    public void convert(ViewHolder holder, Map<Object, String> data) {
        holder.setText(R.id.name, data.get("name"))
                .setImageURI(R.id.img, data.get("img"));
//        LinearLayout linearlayout = (LinearLayout) holder
//                .getView(R.id.linearlayout);
//        if (holder.getPosition() == selectItem) {
//            linearlayout.setPadding(0, 0, 0, 0);
//        } else if (holder.getPosition() == selectItem - 1) {
//            linearlayout.setPadding(0, 50, 0, 0);
//        } else if (holder.getPosition() == selectItem + 1) {
//            linearlayout.setPadding(0, 50, 0, 0);
//        } else if (holder.getPosition() == selectItem - 2) {
//            linearlayout.setPadding(0, 100, 0, 0);
//        } else if (holder.getPosition() == selectItem + 2) {
//            linearlayout.setPadding(0, 100, 0, 0);
//        }else if (holder.getPosition() == selectItem - 3) {
//            linearlayout.setPadding(0, 150, 0, 0);
//        }else if (holder.getPosition() == selectItem + 3) {
//            linearlayout.setPadding(0, 150, 0, 0);
//        }else if (holder.getPosition() == selectItem - 4) {
//            linearlayout.setPadding(0, 200, 0, 0);
//        }else if (holder.getPosition() == selectItem + 4) {
//            linearlayout.setPadding(0, 200, 0, 0);
//        }else if (holder.getPosition() == selectItem - 5) {
//            linearlayout.setPadding(0, 250, 0, 0);
//        }else if (holder.getPosition() == selectItem + 5) {
//            linearlayout.setPadding(0, 250, 0, 0);
//        }
    }
}
