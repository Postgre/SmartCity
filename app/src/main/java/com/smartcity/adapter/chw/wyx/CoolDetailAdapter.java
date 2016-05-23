package com.smartcity.adapter.chw.wyx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.base.BaseRecyclerViewAdapter;
import com.smartcity.base.RecyclerViewHolderBase;
import com.smartcity.config.Constant;
import com.smartcity.http.model.CommentInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: CoolDetailAdapter.java
 * @author: fengliang
 * @date: 2016-05-13 10:32
 */
public class CoolDetailAdapter extends BaseRecyclerViewAdapter<Map<String, Object>> {
    private static final String TAG = CoolDetailAdapter.class.getName();
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_TAG = 1;
    private static final int TYPE_TITLE = 2;

    private List<Map<String, Object>> splitList = new ArrayList<>();
    private int viewType = -1;

    public CoolDetailAdapter(Context context, List<Map<String, Object>> list, List<Map<String,
            Object>> splitList) {
        super(context, list);
        this.splitList = splitList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            viewType = TYPE_HEAD;
        } else {
            if (splitList.contains(list.get(position - 1))) {
                viewType = TYPE_TAG;
            } else {
                viewType = TYPE_TITLE;
            }
        }
        return viewType;
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public void bindView(RecyclerViewHolderBase viewHolder, int position, List<Map<String, Object>> list) {
        switch (viewHolder.getItemViewType()) {
            case TYPE_HEAD:
                final HeadViewHolder headViewHolder = (HeadViewHolder) viewHolder;
                headViewHolder.gzBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (headViewHolder.gzBtn.isSelected()) {
                            headViewHolder.gzBtn.setSelected(false);
                        } else {
                            headViewHolder.gzBtn.setSelected(true);
                        }
                    }
                });
                break;
            case TYPE_TAG:
                TagViewHolder tagViewHolder = (TagViewHolder) viewHolder;
                String tag = (String) list.get(position - 1).get(Constant.KEY);
                tagViewHolder.list_item_name_text.setText(tag);
                break;
            case TYPE_TITLE:
                TitleViewHolder titleViewHolder = (TitleViewHolder) viewHolder;
                CommentInfo commentInfo = (CommentInfo) list.get(position - 1).get
                        (Constant.KEY);
                titleViewHolder.list_item_title_text.setText(commentInfo.getTitle());
                titleViewHolder.list_item_date_text.setText(commentInfo.getDate());
                titleViewHolder.list_item_content_text.setText(commentInfo.getContent());
                break;
        }
    }

    @Override
    public View createView(ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case TYPE_HEAD:
                View headView = layoutInflater.inflate(R.layout.list_item_head, null);
                return headView;
            case TYPE_TAG:
                View tagView = layoutInflater.inflate(R.layout.list_item_tag, null);
                return tagView;
            case TYPE_TITLE:
                View titleView = layoutInflater.inflate(R.layout.list_item_info, null);
                return titleView;
        }
        return null;
    }

    @Override
    public RecyclerViewHolderBase createViewHolder(View view) {
        switch (viewType) {
            case TYPE_HEAD:
                return new HeadViewHolder(view);
            case TYPE_TAG:
                return new TagViewHolder(view);
            case TYPE_TITLE:
                return new TitleViewHolder(view);
        }
        return null;
    }

    static class HeadViewHolder extends RecyclerViewHolderBase {
        @Bind(R.id.gzBtn)
        ImageView gzBtn;

        public HeadViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class TagViewHolder extends RecyclerViewHolderBase {
        @Bind(R.id.list_item_name_text)
        TextView list_item_name_text;

        public TagViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class TitleViewHolder extends RecyclerViewHolderBase {
        @Bind(R.id.list_item_title_text)
        TextView list_item_title_text;

        @Bind(R.id.list_item_date_text)
        TextView list_item_date_text;

        @Bind(R.id.list_item_content_text)
        TextView list_item_content_text;

        public TitleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
