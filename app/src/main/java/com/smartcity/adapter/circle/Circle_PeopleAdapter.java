package com.smartcity.adapter.circle;

import android.content.Context;
import android.view.View;

import com.smartcity.R;
import com.smartcity.bean.Circle_PeopleBean;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/4/15.
 */
public class Circle_PeopleAdapter extends CommonAdapter<Circle_PeopleBean.DataBean> {
    public Circle_PeopleAdapter(Context context, List<Circle_PeopleBean.DataBean> list, int view) {
        super(context, list, view);
    }
    @Override
    public void convert(ViewHolder holder, Circle_PeopleBean.DataBean v) {
        holder.setImageURI(R.id.img, v.getScSysUser().getUserpic())
                .setText(R.id.name,v.getScSysUser().getUsername());
        if(holder.getPosition() == 0){
            holder.getView(R.id.lingxiu).setVisibility(View.VISIBLE);
        }else {
            holder.getView(R.id.lingxiu).setVisibility(View.GONE);
        }
    }
}
