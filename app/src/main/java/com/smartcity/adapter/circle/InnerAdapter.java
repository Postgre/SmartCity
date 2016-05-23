package com.smartcity.adapter.circle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.smartcity.bean.Talent;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Administrator on 2016/4/29.
 */
public class InnerAdapter extends BaseAdapter {

    ArrayList<Talent> objs;

    public InnerAdapter() {
        objs = new ArrayList<>();
    }

    public void addAll(Collection<Talent> collection) {
        if (isEmpty()) {
            objs.addAll(collection);
            notifyDataSetChanged();
        } else {
            objs.addAll(collection);
        }
    }

    public void clear() {
        objs.clear();
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return objs.isEmpty();
    }

    public void remove(int index) {
        if (index > -1 && index < objs.size()) {
            objs.remove(index);
            notifyDataSetChanged();
        }
    }


    @Override
    public int getCount() {
        return objs.size();
    }

    @Override
    public Talent getItem(int position) {
        if(objs==null ||objs.size()==0) return null;
        return objs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        Talent talent = getItem(position);
//        if (convertView == null)
//            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_new_item, parent, false);
//        ViewHolder holder = new ViewHolder();
//        convertView.setTag(holder);
//        convertView.getLayoutParams().width = CircleFragment.cardWidth;
//        holder.portraitView = (SimpleDraweeView) convertView.findViewById(R.id.portrait);
//        //holder.portraitView.getLayoutParams().width = cardWidth;
//        holder.portraitView.getLayoutParams().height = CircleFragment.cardHeight;
//        holder.nameView = (TextView) convertView.findViewById(R.id.name);
//        //parentView.getLayoutParams().width = cardWidth;
//        //holder.jobView = (TextView) convertView.findViewById(R.id.job);
//        //holder.companyView = (TextView) convertView.findViewById(R.id.company);
//        holder.cityView = (TextView) convertView.findViewById(R.id.city);
//        holder.eduView = (TextView) convertView.findViewById(R.id.education);
//        holder.workView = (TextView) convertView.findViewById(R.id.work_year);
//        holder.collectView = (CheckedTextView) convertView.findViewById(R.id.favorite);
//
//        holder.portraitView.setImageURI(Uri.parse(talent.headerIcon));
//        holder.nameView.setText(String.format("%s", talent.nickname));
//        //holder.jobView.setText(talent.jobName);
//
//        final CharSequence no = "暂无";
//
//        holder.cityView.setHint(no);
//        holder.cityView.setText(talent.cityName);
//        holder.cityView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_location,0,0);
//
//        holder.eduView.setHint(no);
//        holder.eduView.setText(talent.educationName);
//        holder.eduView.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.home01_icon_edu,0,0);
//
//        holder.workView.setHint(no);
//        holder.workView.setText(talent.workYearName);
//        holder.workView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home01_icon_work_year,0,0);

        return convertView;
    }
    public static class ViewHolder {
        public SimpleDraweeView portraitView;
        public TextView nameView;
        public TextView cityView;
        public TextView eduView;
        public TextView workView;
        public CheckedTextView collectView;
    }
}
