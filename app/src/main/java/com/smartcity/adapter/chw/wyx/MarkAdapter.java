package com.smartcity.adapter.chw.wyx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseRecyclerViewAdapter;
import com.smartcity.base.RecyclerViewHolderBase;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: MarkAdapter.java
 * @author: fengliang
 * @date: 2016-05-12 14:14
 */
public class MarkAdapter extends BaseRecyclerViewAdapter<String> {
    private static final String TAG = MarkAdapter.class.getName();
    private int mSelectedPos = -1;

    private ItemClickCallBack callback;

    public MarkAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public void bindView(final RecyclerViewHolderBase viewHolder, final int position, List<String> list) {
        String title = list.get(position);
        MarkViewHolder holder = (MarkViewHolder) viewHolder;
        holder.itemTitleView.setText(title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != callback) {
                    callback.onItemClick(viewHolder.getLayoutPosition());
                }
            }
        });
        if (mSelectedPos == position) {
            holder.itemTitleView.setBackgroundResource(R.drawable.layout_border_bg_1);
//            holder.itemTitleView.setTextColor(context.getResources().getColor(R.color.red));
        } else {
            holder.itemTitleView.setBackgroundResource(R.drawable.layout_border_bg);
//            holder.itemTitleView.setTextColor(context.getResources().getColor(R.color.white));
        }
    }

    @Override
    public View createView(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item_mark_item, null);
        return view;
    }

    @Override
    public RecyclerViewHolderBase createViewHolder(View view) {
        return new MarkViewHolder(view);
    }

    static class MarkViewHolder extends RecyclerViewHolderBase {
        @Bind(R.id.list_item_title)
        TextView itemTitleView;
        @Bind(R.id.list_item_img_chacha)
        ImageView itemCancelView;

        public MarkViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setSelectedPos(int position) {
        this.mSelectedPos = position;
        notifyDataSetChanged();
    }

    public void setCallback(ItemClickCallBack callback) {
        this.callback = callback;
    }

    public interface ItemClickCallBack {
        void onItemClick(int positon);
    }

}
