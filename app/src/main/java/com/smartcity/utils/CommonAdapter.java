package com.smartcity.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class CommonAdapter<T> extends BaseAdapter implements
        OnClickListener {

    protected static Context mContext;
    protected List<T> list;
    protected String[] string;
    protected LayoutInflater mInflater;
    protected final int mItemLayoutId;

    // DisplayImageOptions options = EcmobileApp.options;
    public CommonAdapter(Context context, List<T> list, int itemLayoutId) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.list = list;
        if (list == null)
            this.list = new ArrayList<T>();
        this.mItemLayoutId = itemLayoutId;
        // this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public T getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder = getViewHolder(position, convertView, parent);
        setListener(position, holder.getConvertView());
        convert(holder, getItem(position));
        //addListener(holder.getConvertView());
        return holder.getConvertView();
    }

    //public abstract void addListener(View convertView);
    public void setListener(int position, View conView) {
        if (listeners != null && conView != null) {
            Iterator<Integer> iterator = listeners.iterator();
            while (iterator.hasNext()) {
                int id = iterator.next();
                View view = conView.findViewById(id);
                if (view != null) {
                    view.setTag(Integer.valueOf(position));
                    view.setOnClickListener(this);
                }
            }
        }
    }

    public void addClickListenerFromId(int... ids) {
        if (listeners == null) {
            listeners = new HashSet<Integer>();
        }
        for (int i = 0; i < ids.length; i++) {
            listeners.add(ids[i]);
        }
    }

    public void setOnChildItemClickListener(OnChildItemOnClickListener listener) {
        this.listener = listener;
    }

    java.util.Set<Integer> listeners;
    OnChildItemOnClickListener listener;

    public interface OnChildItemOnClickListener {
        public void OnChildItemOnClick(int position, View v,
                                       List<Map<String, Object>> list);
    }

    public abstract void convert(ViewHolder holder, T t);

    private ViewHolder getViewHolder(int position, View convertView,
                                     ViewGroup parent) {
        return ViewHolder.get(mContext, convertView, parent, mItemLayoutId,
                position);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onClick(View v) {
        if (v.getTag() instanceof Integer && listener != null) {
            int position = (Integer) v.getTag();
            listener.OnChildItemOnClick(position, v, (List<Map<String, Object>>)
                    list);
        }
    }
}
