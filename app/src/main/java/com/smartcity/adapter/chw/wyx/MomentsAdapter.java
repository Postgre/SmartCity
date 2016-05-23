package com.smartcity.adapter.chw.wyx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseRecyclerViewAdapter;
import com.smartcity.base.RecyclerViewHolderBase;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.utils.UIUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: MomentsAdapter.java
 * @author: fengliang
 * @date: 2016-05-10 11:18
 */
public class MomentsAdapter extends BaseRecyclerViewAdapter<CoolInfo.CoolListInfo> {
    private static final String TAG = MomentsAdapter.class.getName();

    private ItemCliclListener listener;

    public MomentsAdapter(Context context, List<CoolInfo.CoolListInfo> list) {
        super(context, list);
    }

    @Override
    public void bindView(RecyclerViewHolderBase viewHolder, final int position, List<CoolInfo.CoolListInfo> list) {
        CoolInfo.CoolListInfo info = list.get(position);
        MomentsViewHolder holder = (MomentsViewHolder) viewHolder;
        holder.itemImgView.setBackgroundResource(R.mipmap.circle_img);
        int width = (int) UIUtils.getScreenWidth() / 2;
        int height = width * (position + 10) / 10;
//        int height = width * img.getHeight() / img.getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) holder.itemImgView
                .getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        holder.itemImgView.setLayoutParams(layoutParams);
        holder.itemImgView.setImageResource(R.mipmap.circle_img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public View createView(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item_moments,
                null);
        return view;
    }

    @Override
    public RecyclerViewHolderBase createViewHolder(View view) {
        return new MomentsViewHolder(view);
    }

    static class MomentsViewHolder extends RecyclerViewHolderBase {
        @Bind(R.id.list_item_img)
        ImageView itemImgView;
        @Bind(R.id.list_item_title)
        TextView itemTitleView;
        @Bind(R.id.list_item_zan_num)
        TextView itemZanView;
        @Bind(R.id.list_item_head)
        ImageView itemHeadView;
        @Bind(R.id.list_item_name)
        TextView itemNameView;

        public MomentsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setListener(ItemCliclListener listener) {
        this.listener = listener;
    }

    public interface ItemCliclListener {
        void onItemClick(int positon);
    }
}
