package com.smartcity.view.cittlist;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;

import com.smartcity.utils.UIUtils;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yancy on 2016/5/10.
 */
public class ChoseAreaFragment extends DialogFragment {

    private ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        lv = new ListView(getActivity());
        lv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.px2dip(500)));
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return lv;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


        List<String> datas = new ArrayList<>();

        for(int i=0;i<20;i++)
        {
            datas.add(String.valueOf(i));
        }

        lv.setAdapter(new CommonAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,datas) {
            @Override
            public void convert(ViewHolder viewHolder, String s) {

            }
        });
    }
}
