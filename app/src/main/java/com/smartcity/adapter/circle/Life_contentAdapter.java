package com.smartcity.adapter.circle;

import android.content.Context;

import com.smartcity.R;
import com.smartcity.http.model.Life_Content;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/5/23.
 */
public class Life_contentAdapter extends CommonAdapter<Life_Content.DataEntity.ScSysUserEntity> {

    public Life_contentAdapter(Context context, int layoutId, List<Life_Content.DataEntity.ScSysUserEntity> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder viewHolder, Life_Content.DataEntity.ScSysUserEntity life_content) {
        viewHolder.setImageUrl(R.id.sdv_head_image, "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=806167121,1268231582&fm=116&gp=0.jpg");
        viewHolder.setText(R.id.life_name, "马丁路德金");
    }
}
