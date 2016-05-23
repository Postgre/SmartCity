package com.smartcity.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Yancy on 2016/5/9.
 */
public class LifeGridView extends GridView {

    public LifeGridView(Context context) {
        super(context);
    }

    public LifeGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LifeGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
