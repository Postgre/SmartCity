package com.smartcity.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.smartcity.R;
import com.smartcity.application.MyApplication;

public class UIUtils {

	/**
	 * 获取上下文
	 *
	 * @return
	 */
	public static Context getContext() {
		return MyApplication.getApplication();
	}

	/**
	 * 获取主线程
	 *
	 * @return
	 */
	public static Thread getMainThread() {
		return MyApplication.getMainThread();
	}

	/**
	 * 获取主线程id
	 *
	 * @return
	 */
	public static long getMainThreadId() {
		return MyApplication.getMainThreadId();
	}

	/**
	 * 获取到主线程的looper
	 *
	 * @return
	 */
	public static Looper getMainThreadLooper() {
		return MyApplication.getMainThreadLooper();
	}

	/**
	 * dip转换px
	 */
	public static int dip2px(int dip) {
		final float scale = getContext().getResources().getDisplayMetrics().density;
		return (int) (dip * scale + 0.5f);
	}

	/**
	 * pxz转换dip
	 */
	public static int px2dip(int px) {
		final float scale = getContext().getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}

	/**
	 * 获取主线程的handler
	 */
	public static Handler getHandler() {
		return MyApplication.getMainThreadHandler();
	}

	/**
	 * 延时在主线程执行runnable
	 */
	public static boolean postDelayed(Runnable runnable, long delayMillis) {
		return getHandler().postDelayed(runnable, delayMillis);
	}

	/**
	 * 在主线程执行runnable
	 */
	public static boolean post(Runnable runnable) {
		return getHandler().post(runnable);
	}

	/**
	 * 从主线程looper里面移除runnable
	 */
	public static void removeCallbacks(Runnable runnable) {
		getHandler().removeCallbacks(runnable);
	}

	/**
	 * 获取布局
	 *
	 * @param resId
	 * @return
	 */
	public static View inflate(int resId) {
		return LayoutInflater.from(getContext()).inflate(resId, null);
	}

	/**
	 * 获取资源
	 */
	public static Resources getResources() {

		return getContext().getResources();
	}

	/**
	 * 获取文字
	 */
	public static String getString(int resId) {
		return getResources().getString(resId);
	}

	/**
	 * 获取文字数组
	 */
	public static String[] getStringArray(int resId) {
		return getResources().getStringArray(resId);
	}

	/**
	 * 获取dimen
	 */
	public static int getDimens(int resId) {
		return getResources().getDimensionPixelSize(resId);
	}

	/**
	 * 获取drawable
	 */
	public static Drawable getDrawable(int resId) {
		return getResources().getDrawable(resId);
	}

	/**
	 * 获取颜色
	 */
	public static int getColor(int resId) {
		return getResources().getColor(resId);
	}

	/**
	 * 获取颜色选择器
	 */
	public static ColorStateList getColorStateList(int resId) {
		return getResources().getColorStateList(resId);
	}

	// 判断当前的线程是不是在主线程
	public static boolean isRunInMainThread() {
		return android.os.Process.myTid() == getMainThreadId();
	}

	public static void runInMainThread(Runnable runnable) {
		// 在主线程运行
		if (isRunInMainThread()) {
			runnable.run();
		} else {
			post(runnable);
		}
	}

	/**
	 * 获得默认该layout的尺寸
	 *
	 * @return
	 */
	public static int getDefaultWidth() {
		WindowManager wm = (WindowManager) getContext().getSystemService(
				Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return Math.min(outMetrics.widthPixels, outMetrics.heightPixels);
	}

	public static DisplayMetrics getDisplayMetrics() {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		((WindowManager) getContext().getSystemService(
				Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(
				displaymetrics);
		return displaymetrics;
	}

	public static float getScreenHeight() {
		return getDisplayMetrics().heightPixels;
	}

	public static float getScreenWidth() {
		return getDisplayMetrics().widthPixels;
	}

	/**
	 * 对toast的简易封装。线程安全，可以在非UI线程调用。
	 */
	public static void showToastSafe(final int resId) {
		showToastSafe(getString(resId));
	}

	/**
	 * 对toast的简易封装。线程安全，可以在非UI线程调用。
	 */
	public static void showToastSafe(final String str) {
		if (isRunInMainThread()) {
			showToast(str);
		} else {
			post(new Runnable() {
				@Override
				public void run() {
					showToast(str);
				}
			});
		}
	}

	private static void showToast(String str) {
		Toast.makeText(getContext(), str, Toast.LENGTH_LONG).show();
	}

	/**
	 * 给试图添加点击效果,让背景变深
	 */
	public static void addTouchDrak(View view, boolean isClick) {
		view.setOnTouchListener(VIEW_TOUCH_DARK);

		if (!isClick) {
			view.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
				}
			});
		}
	}

	/**
	 * 给试图添加点击效果,让背景变暗
	 */
	public static void addTouchLight(View view, boolean isClick) {
		view.setOnTouchListener(VIEW_TOUCH_LIGHT);

		if (!isClick) {
			view.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
				}
			});
		}
	}


	/**
	 * 让控件点击时，颜色变深
	 */
	public static final View.OnTouchListener VIEW_TOUCH_DARK = new View.OnTouchListener() {

		public final float[] BT_SELECTED = new float[]{1, 0, 0, 0, -50, 0, 1,
				0, 0, -50, 0, 0, 1, 0, -50, 0, 0, 0, 1, 0};
		public final float[] BT_NOT_SELECTED = new float[]{1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0};

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				if (v instanceof ImageView) {
					ImageView iv = (ImageView) v;
					iv.setColorFilter(new ColorMatrixColorFilter(BT_SELECTED));
				} else {
					v.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_SELECTED));
					v.setBackgroundDrawable(v.getBackground());
				}
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				if (v instanceof ImageView) {
					ImageView iv = (ImageView) v;
					iv.setColorFilter(new ColorMatrixColorFilter(BT_NOT_SELECTED));
				} else {
					v.getBackground().setColorFilter(
							new ColorMatrixColorFilter(BT_NOT_SELECTED));
					v.setBackgroundDrawable(v.getBackground());
				}
			}
			return false;
		}
	};

	/**
	 * 让控件点击时，颜色变暗
	 */
	public static final View.OnTouchListener VIEW_TOUCH_LIGHT = new View.OnTouchListener() {

		public final float[] BT_SELECTED = new float[]{1, 0, 0, 0, 50, 0, 1,
				0, 0, 50, 0, 0, 1, 0, 50, 0, 0, 0, 1, 0};
		public final float[] BT_NOT_SELECTED = new float[]{1, 0, 0, 0, 0, 0,
				1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0};

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				if (v instanceof ImageView) {
					ImageView iv = (ImageView) v;
					iv.setDrawingCacheEnabled(true);
					iv.setColorFilter(new ColorMatrixColorFilter(BT_SELECTED));
				} else if (v instanceof ViewGroup) {
					ViewGroup iv = (ViewGroup) v;
					iv.setDrawingCacheEnabled(true);
					iv.setBackgroundColor(getResources().getColor(R.color.silver));
				} else {
					v.getBackground().setColorFilter(new ColorMatrixColorFilter(BT_SELECTED));
					v.setBackgroundDrawable(v.getBackground());
				}
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				if (v instanceof ImageView) {
					ImageView iv = (ImageView) v;
					iv.setColorFilter(new ColorMatrixColorFilter(BT_NOT_SELECTED));
					System.out.println("变回来");
				} else if (v instanceof ViewGroup) {
					ViewGroup iv = (ViewGroup) v;
					iv.setDrawingCacheEnabled(true);
					iv.setBackgroundColor(getResources().getColor(R.color.transparent));
				} else {
					v.getBackground().setColorFilter(
							new ColorMatrixColorFilter(BT_NOT_SELECTED));
					v.setBackgroundDrawable(v.getBackground());
				}
			}
			return false;
		}
	};
}