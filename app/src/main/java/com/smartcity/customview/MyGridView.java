package com.smartcity.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/*
 * 自定义Gridview
 */
public class MyGridView extends GridView {
	public MyGridView(Context context) {
		super(context);

	}

	public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
//	 @Override 
//	 public boolean dispatchTouchEvent(MotionEvent event)
//	 { 
//		 getParent().requestDisallowInterceptTouchEvent(true); //让父类不拦截触摸事件 
//		 return super.dispatchTouchEvent(event); 
//	 }
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
		//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
