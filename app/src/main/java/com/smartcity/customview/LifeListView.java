package com.smartcity.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Yancy on 2016/5/16.
 */
public class LifeListView extends ListView {

    public LifeListView(Context context) {
        super(context);
    }

    public LifeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LifeListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
