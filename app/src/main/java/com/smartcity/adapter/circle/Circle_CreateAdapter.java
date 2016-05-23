package com.smartcity.adapter.circle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.R;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/13.
 */
public class Circle_CreateAdapter extends CommonAdapter<Map<Object,Object>> {
    List<Map<Object, Object>> datas;

    public Circle_CreateAdapter(Context context, List<Map<Object, Object>> datas, int layoutId) {
        super(context, datas,layoutId);
        this.datas = datas;
    }

//    @Override
//    public void convert(ViewHolder viewHolder, Map<Object, Object> data) {
//        SimpleDraweeView img = (SimpleDraweeView) viewHolder.getView(R.id.img);
//        ImageView jian = (ImageView) viewHolder.getView(R.id.jian);
//        if(viewHolder.getPosition() == 9){
//            img.setVisibility(View.GONE);
//        }else{
//            img.setVisibility(View.VISIBLE);
//        }
//        if(viewHolder.getPosition() == datas.size() -1 ){
//            viewHolder.setImageResource(R.id.img,R.mipmap.c_jia);
//            jian.setVisibility(View.GONE);
//        }else {
//            viewHolder.setImageUrl(R.id.img, (String) data.get("img"));
//        }
//    }

    @Override
    public void convert(ViewHolder viewHolder, Map<Object, Object> data) {
        SimpleDraweeView img = (SimpleDraweeView) viewHolder.getView(R.id.img);
        ImageView jian = (ImageView) viewHolder.getView(R.id.jian);
        if(viewHolder.getPosition() == 9){
            img.setVisibility(View.GONE);
        }else{
            img.setVisibility(View.VISIBLE);
        }
        if(viewHolder.getPosition() == datas.size() -1 ){
            viewHolder.setImageResource(R.id.img,R.mipmap.c_jia);
            jian.setVisibility(View.GONE);
        }else {
            viewHolder.setImageURI(R.id.img, (String) data.get("img"));
        }
    }
}
