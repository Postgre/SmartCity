package com.smartcity.adapter.chw.wyx;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.R;
import com.smartcity.base.BaseRecyclerViewAdapter;
import com.smartcity.base.RecyclerViewHolderBase;
import com.smartcity.config.Constant;
import com.smartcity.http.model.CommentInfo;
import com.smartcity.http.model.CoolDetailInfo;

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
    private CoolDetailInfo.CoolDetailItemInfo coolDetailItemInfo;
    private List<Map<String, Object>> splitList = new ArrayList<>();
    private int viewType = -1;

    private ItemCliclListener listener;

    public CoolDetailAdapter(Context context, List<Map<String, Object>> list, List<Map<String,
            Object>> splitList, CoolDetailInfo.CoolDetailItemInfo coolDetailItemInfo) {
        super(context, list);
        this.splitList = splitList;
        this.coolDetailItemInfo = coolDetailItemInfo;
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
    public void bindView(RecyclerViewHolderBase viewHolder, final int position, List<Map<String, Object>> list) {
        switch (viewHolder.getItemViewType()) {
            case TYPE_HEAD:
                final HeadViewHolder headViewHolder = (HeadViewHolder) viewHolder;
                headViewHolder.head_img.setImageURI(Uri.parse(coolDetailItemInfo.getSysUser().getUserpic()));
                headViewHolder.head.setImageURI(Uri.parse(coolDetailItemInfo.getCoolCoverPic()));
                headViewHolder.gzBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (headViewHolder.gzBtn.isSelected()) {
                            headViewHolder.gzBtn.setSelected(false);
                            if (null != listener) {
                                listener.onUnFocusClick();
                            }
                        } else {
                            headViewHolder.gzBtn.setSelected(true);
                            if (null != listener) {
                                listener.onFocusClick();
                            }
                        }
                    }
                });
                headViewHolder.head.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (null != listener) {
                            listener.onItemClick(coolDetailItemInfo.getCoolFileAddress());
                        }
                    }
                });
                headViewHolder.nameText.setText(coolDetailItemInfo.getSysUser().getUsername());
                headViewHolder.dateText.setText(coolDetailItemInfo.getCoolTime());
                headViewHolder.contentText.setText(coolDetailItemInfo.getCoolDecrip());
                headViewHolder.gzNumText.setText(coolDetailItemInfo.getCoolPlayTimes() + "");
                headViewHolder.viewCountText.setText(coolDetailItemInfo.getMPlmap().getIsClicked() + "");
                headViewHolder.commentNumText.setText(coolDetailItemInfo.getMPlmap().getTotalCount() + "");
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
                titleViewHolder.head_img.setImageURI(Uri.parse("http://tsnrhapp.oss-cn-hangzhou.aliyuncs.com/sysImg/01.jpg"));
                titleViewHolder.list_item_title_text.setText(commentInfo.getSCommentTitle());
                titleViewHolder.list_item_date_text.setText(commentInfo.getSCommentDate());
                titleViewHolder.list_item_content_text.setText(commentInfo.getSCommentContent());
                titleViewHolder.list_item_zan_text.setText(commentInfo.getsLikeCount() + "");
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
        @Bind(R.id.list_item_head_img)
        SimpleDraweeView head_img;
        @Bind(R.id.list_item_head)
        SimpleDraweeView head;
        @Bind(R.id.list_item_name_text)
        TextView nameText;
        @Bind(R.id.list_item_date_text)
        TextView dateText;
        @Bind(R.id.list_item_content)
        TextView contentText;
        @Bind(R.id.gzBtn)
        ImageView gzBtn;
        @Bind(R.id.list_item_gz_num_text)
        TextView gzNumText;
        @Bind(R.id.viewCountText)
        TextView viewCountText;
        @Bind(R.id.commentNum)
        TextView commentNumText;

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
        @Bind(R.id.list_item_head)
        SimpleDraweeView head_img;
        @Bind(R.id.list_item_title_text)
        TextView list_item_title_text;
        @Bind(R.id.list_item_date_text)
        TextView list_item_date_text;
        @Bind(R.id.list_item_content_text)
        TextView list_item_content_text;
        @Bind(R.id.list_item_zan_num)
        TextView list_item_zan_text;

        public TitleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setListener(ItemCliclListener listener) {
        this.listener = listener;
    }

    public interface ItemCliclListener {
        void onFocusClick();

        void onUnFocusClick();

        void onItemClick(String filePath);
    }
}
