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
import com.smartcity.config.Constant;
import com.smartcity.http.model.CoolInfo;
import com.smartcity.utils.UIUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CoolAdapter.java
 * @author: fengliang
 * @date: 2016-05-14 09:35
 */
public class CoolAdapter extends BaseRecyclerViewAdapter<CoolInfo.CoolListInfo> {
    private static final String TAG = CoolAdapter.class.getName();
    private static final int ITEM_TYPE_MOMENT = 1;
    private static final int ITEM_TYPE_MICRO_FILM = 2;

    private int viewType = -1;

    private ItemCliclListener listener;

    public CoolAdapter(Context context, List<CoolInfo.CoolListInfo> list) {
        super(context, list);
    }

    @Override
    public int getItemViewType(int position) {
        int type = list.get(position).getCoolVideoTypeId();
        if (type == Constant.TYPE_IMG) {
            viewType = ITEM_TYPE_MOMENT;
        } else if (type == Constant.TYPE_VIDEO) {
            viewType = ITEM_TYPE_MICRO_FILM;
        }
        return viewType;
    }

    @Override
    public void bindView(RecyclerViewHolderBase viewHolder, final int position, List<CoolInfo.CoolListInfo> list) {
        CoolInfo.CoolListInfo info = list.get(position);
        switch (viewHolder.getItemViewType()) {
            case ITEM_TYPE_MOMENT:
                MomentsViewHolder holder = (MomentsViewHolder) viewHolder;
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
                break;
            case ITEM_TYPE_MICRO_FILM:
                MicroFilmViewHolder mHolder = (MicroFilmViewHolder) viewHolder;
                int mWidth = (int) UIUtils.getScreenWidth() / 2;
                int mHeight = mWidth * (position + 10) / 10;
//        int height = width * img.getHeight() / img.getWidth();
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mHolder.itemImgView
                        .getLayoutParams();
                params.width = mWidth;
                params.height = mHeight;
                mHolder.itemImgView.setLayoutParams(params);
                mHolder.itemImgView.setImageResource(R.mipmap.createcircleimage);
                mHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (null != listener) {
                            listener.onItemClick(position);
                        }
                    }
                });
                break;
        }
    }

    @Override
    public View createView(ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case ITEM_TYPE_MOMENT:
                View momentView = layoutInflater.inflate(R.layout.list_item_cool_moment,
                        null);
                return momentView;
            case ITEM_TYPE_MICRO_FILM:
                View filmView = layoutInflater.inflate(R.layout.list_item_cool_film, null);
                return filmView;
        }
        return null;
    }

    @Override
    public RecyclerViewHolderBase createViewHolder(View view) {
        switch (viewType) {
            case ITEM_TYPE_MOMENT:
                return new MomentsViewHolder(view);
            case ITEM_TYPE_MICRO_FILM:
                return new MicroFilmViewHolder(view);
        }
        return null;
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

    static class MicroFilmViewHolder extends RecyclerViewHolderBase {
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

        public MicroFilmViewHolder(View itemView) {
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