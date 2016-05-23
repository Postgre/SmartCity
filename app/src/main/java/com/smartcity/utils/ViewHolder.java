package com.smartcity.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.android.volley.toolbox.ImageLoader;
import com.facebook.drawee.view.SimpleDraweeView;
//import com.nostra13.universalimageloader.core.DisplayImageOptions;
//import com.nostra13.universalimageloader.core.imageaware.ImageAware;
//import com.smartcity.app.EcmobileApp;

public class ViewHolder {
//	static DisplayImageOptions options = EcmobileApp.options;
	/** Key Ϊ int �� map Ч�ʸ�� */
	private int mPosition;
	private View mConvertView;
	private SparseArray<View> mViews;
	private Context mContext;
//	private AsyncImageLoader asyncImageLoader;

	public int getPosition() {
		return mPosition;
	}

	public void setPosition(int mPosition) {
		this.mPosition = mPosition;
	}

	public ViewHolder(Context context, ViewGroup parent, int layoutId,
			int position) {
		this.mContext = context;
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		if (mConvertView == null) {
			mConvertView = LayoutInflater.from(context).inflate(layoutId,
					parent, false);
		}
		mConvertView.setTag(this);
	}

	/**
	 * 
	 * @��������: �ṩ����ʼ�����
	 * @param context
	 * @param convertView
	 * @param parent
	 * @param layoutId
	 * @param position
	 * @return ViewHolder����
	 */
	public static ViewHolder get(Context context, View convertView,
								 ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			return new ViewHolder(context, parent, layoutId, position);
		} else {
			ViewHolder holder = (ViewHolder) convertView.getTag();
			holder.mPosition = position;
			return holder;
		}

	}

	/**
	 * ͨ��viewId��ȡ�ؼ�
	 * 
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	public View getConvertView() {
		return mConvertView;
	}

	/**
	 * ����TextView��ֵ
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public ViewHolder setText(int viewId, String text) {
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}

	/**
	 * ΪImageView����ͼƬ
	 * 
	 * @param viewId
	 * @param drawableId
	 * @return
	 */
	public ViewHolder setImageResource(int viewId, int drawableId) {
		ImageView view = getView(viewId);
		view.setImageResource(drawableId);
		return this;
	}

	public ViewHolder setTextBackground(int viewId, int drawableId) {
		TextView view = getView(viewId);
		view.setBackgroundResource(drawableId);
		return this;
	}

	public ViewHolder setLinearLayoutBackground(int viewId, int drawableId) {
		LinearLayout view = getView(viewId);
		view.setBackgroundResource(drawableId);
		return this;
	}

	public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
		ImageView view = getView(viewId);
		view.setImageBitmap(bitmap);
		return this;
	}

	public static void setImage(Context context, View view, String url) {
//		com.nostra13.universalimageloader.core.ImageLoader.getInstance()
//				.displayImage(url, (ImageAware) view, options);// 图片加载
		// RequestQueue mQueue = Volley.newRequestQueue(context);
		// ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
		// ImageListener listener = ImageLoader.getImageListener((ImageView)
		// view,
		// R.drawable.shibai, R.drawable.shibai);
		// imageLoader.get(url, listener);
		// 指定图片允许的最大宽度和高度
		// imageLoader.get("http://developer.android.com/images/home/aw_dac.png",listener,
		// 200, 200);
	}

	public ViewHolder setImageURI(int viewId, String url) {
		SimpleDraweeView imageView = getView(viewId);
		Uri uris = Uri.parse(url);
		imageView.setImageURI(uris);

//		com.nostra13.universalimageloader.core.ImageLoader imageLoader = com.nostra13.universalimageloader.core.ImageLoader
//				.getInstance();
//		imageLoader.displayImage(url, imageView, options);
		// com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(url,
		// imageView,
		// options);// 图片加载
		// imageView = BeeQuery.serviceUrl() + "/uploadfiles/" + imageView;
		// ImageLoader.getInstance().displayImage(productImage,
		// hView.productImage,
		// options);// 图片加载
		// final NetworkImageView view = (NetworkImageView) getView(viewId);
		// //初始化imageLoader
		// LruImageCache lruImageCache = LruImageCache.instance();
		// ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue
		// (mContext), lruImageCache);
		// view.setDefaultImageResId(R.drawable.shibai);
		// view.setErrorImageResId(R.drawable.shibai);
		// view.setImageUrl(url, imageLoader);

		// RequestQueue mQueue = Volley.newRequestQueue(mContext);
		// ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
		// ImageListener listener = ImageLoader.getImageListener(imageView,
		// R.drawable.shibai, R.drawable.shibai);
		// imageLoader.get(url, listener);
		// 指定图片允许的最大宽度和高度
		// imageLoader.get("http://developer.android.com/images/home/aw_dac.png",listener,
		// 200, 200);
		// Drawable cachedImage =
		// asyncImageLoader.loadDrawable("http://developer.android.com/images/home/aw_dac.png",
		// imageView, new ImageCallback(){
		// public void imageLoaded(Drawable imageDrawable,ImageView
		// imageView,String imageUrl){
		// imageView.setImageDrawable(imageDrawable);
		// }
		// });
		// if (cachedImage == null)
		// {
		// imageView.setImageResource(R.drawable.df);
		// }else{
		// imageView.setImageDrawable(cachedImage);
		// }
		return this;
	}

	public ViewHolder setImageDrawable(int viewId, Drawable resId) {
		ImageView view = getView(viewId);
		view.setImageDrawable(resId);
		return this;
	}

	/**
	 * 
	 * @��������: ΪCheckBox����ֵ
	 * @param viewId
	 *            ����Id
	 * @param
	 * @return ������󣨻�����ʽ��̣�
	 */

	public ViewHolder setChecked(int viewId, Boolean checked) {
		CheckBox cb = getView(viewId);
		cb.setChecked(checked);
		return this;
	}
}
