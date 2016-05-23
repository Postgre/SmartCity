package com.smartcity.customview;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupWindow;

import com.smartcity.R;
import com.smartcity.adapter.chw.wyx.PopWindowAdapter;
import com.smartcity.utils.CovertUtils;

import java.util.List;

/**
 * 在此写类用途
 *
 * @version V2.0
 * @FileName: MarkPopWindow.java
 * @author: fengliang
 * @date: 2016-05-12 16:31
 */
public class MarkPopWindow extends PopupWindow {
    private static final String TAG = "MarkPopWindow";
    private View popView = null;
    private GridView gridView = null;
    private PopWindowAdapter adapter = null;
    private WindowManager.LayoutParams lp = null;
    private Window window = null;

    private ItemCallBack callback;

    public MarkPopWindow(Activity activity, int resId) {
        popView = LayoutInflater.from(activity).inflate(R.layout.gird_item_pop, null);
        popView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        gridView = (GridView) popView.findViewById(R.id.popGridview);
        final List<String> list = CovertUtils.getListByResource(activity, resId);
        adapter = new PopWindowAdapter(activity, list);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = list.get(position);
                if (null != callback) {
                    callback.onItemClick(position, title);
                }
            }
        });
        this.setContentView(popView);
        this.setWidth(LayoutParams.MATCH_PARENT);
        this.setHeight(LayoutParams.MATCH_PARENT);
//        this.setAnimationStyle(R.style.popwindow_anim);
        ColorDrawable dw = new ColorDrawable(0x80000000);
        this.setBackgroundDrawable(dw);
        // 产生背景变暗效果
        lp = activity.getWindow().getAttributes();
        window = activity.getWindow();
        this.setOutsideTouchable(true);
        this.setFocusable(true);
        this.setOnDismissListener(new OnDismissListener() {

            // 在dismiss中恢复透明度
            @Override
            public void onDismiss() {
                lp.alpha = 1f;
                window.setAttributes(lp);
                callback.onDismissCallback();
            }
        });
    }

    public void show(View view) {
        showAsDropDown(view, 0, 0);
    }

    public void setCallback(ItemCallBack callback) {
        this.callback = callback;
    }

    public interface ItemCallBack {
        void onItemClick(int positon, String title);

        void onDismissCallback();
    }

}
