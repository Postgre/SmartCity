package com.smartcity.adapter.circle;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.http.model.CircleVideo;
import com.smartcity.utils.CommonAdapter;
import com.smartcity.utils.ViewHolder;

import java.util.List;
import java.util.Map;

public class Life_Adapters extends CommonAdapter<CircleVideo.DataBean> {
    TextView text;
    LinearLayout linear;

    public Life_Adapters(Context context, List<CircleVideo.DataBean> list,
                         int view) {
        super(context, list, view);
    }

    @Override
    public void convert(ViewHolder holder, CircleVideo.DataBean t) {
        if (holder.getPosition() == 0) {
            linear = (LinearLayout) holder.getView(R.id.linear);
            linear.setVisibility(View.GONE);
            holder.setImageResource(R.id.life_gird_image, R.color.gray2);
            text = (TextView) holder.getView(R.id.life_gird_chuang);
            text.setVisibility(View.VISIBLE);
        } else {
            if (t.getVideoAlbumUrl() == null) {
                holder.setImageURI(R.id.life_gird_image,
                        "http://img0.imgtn.bdimg.com/it/u=1445777302,2935091106&fm=21&gp=0.jpg");
            }else {
                holder.setImageURI(R.id.life_gird_image,t.getVideoAlbumUrl());
            }
            holder.setText(R.id.title, t.getVideoAlbumTypeName())
                    .setText(R.id.number,t.getSAlbPicNum()+"")
                    .setText(R.id.time,t.getVideoAlbumDescription());
        }
    }
}
