package com.smartcity.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Yancy on 2016/5/9.
 */
public class LifeScrollView extends ScrollView {
    public LifeScrollView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mGestureDetector = new GestureDetector(new YScrollDetector());
        canScroll = true;
    }

    public LifeScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LifeScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private boolean canScroll;

    private GestureDetector mGestureDetector;
    OnTouchListener mGestureListener;


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        if(ev.getAction() == MotionEvent.ACTION_UP)
            canScroll = true;
        return super.onInterceptTouchEvent(ev) && mGestureDetector.onTouchEvent(ev);

    }

    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if(canScroll)
                if (Math.abs(distanceY) >= Math.abs(distanceX))
                    canScroll = true;
                else
                    canScroll = false;
            return canScroll;
        }

    }
}
