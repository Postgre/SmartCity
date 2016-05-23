package com.smartcity.fragment.life;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;

import com.smartcity.R;
import com.smartcity.utils.UIUtils;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yancy on 2016/5/10.
 */
public class ChoseBrandFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return UIUtils.inflate(R.layout.fragment_chose_brand);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GridView gridView = (GridView) view.findViewById(R.id.chose_brand_gv);
        List<String> datas = new ArrayList<>();

        datas.add("花笙记");
        datas.add("优衣库");
        datas.add("速写");
        datas.add("花笙记");
        datas.add("优衣库");
        datas.add("速写");

        gridView.setAdapter(new CommonAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,datas) {
            @Override
            public void convert(ViewHolder viewHolder, String s) {
                viewHolder.setText(android.R.id.text1,s);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        final DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.y =  UIUtils.px2dip(-200);
        layoutParams.width = dm.widthPixels-UIUtils.px2dip(40);
        layoutParams.height = UIUtils.px2dip(150);
        getDialog().getWindow().setAttributes(layoutParams);
    }
}
