package com.smartcity.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcity.R;
import com.smartcity.utils.ToastTool;

public class CircleMenuLayout extends ViewGroup {
    private float mRadius;
    /**
     * 该容器内child item的默认尺寸
     */
    private static final float RADIO_DEFAULT_CHILD_DIMENSION = 1 / 4.2f;
    /**
     * 菜单的中心child的默认尺寸
     */
    private float RADIO_DEFAULT_CENTERITEM_DIMENSION = 1 / 3.0f;
    /**
     * 该容器的内边距,无视padding属性，如需边距请用该变量
     */
    private static final float RADIO_PADDING_LAYOUT = 1 / 80f;

    /**
     * 当每秒移动角度达到该值时，认为是快速移动
     */
    private static final int FLINGABLE_VALUE = 300;

    /**
     * 如果移动角度达到该值，则屏蔽点击
     */
    private static final int NOCLICK_VALUE = 3;

    /**
     * 当每秒移动角度达到该值时，认为是快速移动
     */
    private int mFlingableValue = FLINGABLE_VALUE;
    /**
     * 该容器的内边距,无视padding属性，如需边距请用该变量
     */
    private float mPadding;
    /**
     * 布局时的开始角度
     */
    private double mStartAngle = 0;
    /**
     * 菜单项的文本
     */
    private String[] mItemTexts;
    /**
     * 菜单项的图标
     */
    private int[] mItemImgs;

    /**
     * 菜单的个数
     */
    private int mMenuItemCount;

    /**
     * 检测按下到抬起时旋转的角度
     */
    private float mTmpAngle;
    /**
     * 检测按下到抬起时使用的时间
     */
    private long mDownTime;

    /**
     * 判断是否正在自动滚动
     */
    private boolean isFling;

    private int mMenuItemLayoutId = R.layout.circle_menu_item;

    // 背景图片
    private Bitmap imageOriginal, imageOriginals, bit_inner;
    private Matrix matrix;

    private boolean[] quadrantTouched;

    // Touch detection
    private GestureDetector mGestureDetector;

    private int alpha = 255;

    @SuppressLint("NewApi")
    public CircleMenuLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        mGestureDetector = new GestureDetector(getContext(),
                new MyGestureListener());
        quadrantTouched = new boolean[]{false, false, false, false, false};
        // 无视padding
        setPadding(0, 0, 0, 0);

        inner_angle = 0;
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs,
                    R.styleable.CircleMenuLayout);
            if (imageOriginal == null) {
                int picId = a.getResourceId(
                        R.styleable.CircleMenuLayout_CircleMenuLayoutBackground, -1);

                // If a background image was set as an attribute,
                // retrieve the image
                if (picId != -1) {
                    imageOriginal = BitmapFactory.decodeResource(
                            getResources(), picId);
                    imageOriginal = Bitmap.createScaledBitmap(imageOriginal, getDefaultWidth() * 6 / 5, getDefaultWidth() * 6 / 5, true);
                }
//                Bitmap bmp = BitmapFactory.decodeResource(this.getResources(),picId);
//                mBitmap = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), Bitmap.Config.RGB_565);
            }
            a.recycle();

            // initialize the matrix only once
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                // not needed, you can also post the matrix immediately to
                // restore the old state
                matrix.reset();
            }
            // Needed for the ViewGroup to be drawn
            setWillNotDraw(false);
        }
    }

    /**
     * 设置布局的宽高，并策略menu item宽高
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int resWidth = 0;
        int resHeight = 0;

        /**
         * 根据传入的参数，分别获取测量模式和测量值
         */
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        /**
         * 如果宽或者高的测量模式非精确值
         */
        if (widthMode != MeasureSpec.EXACTLY
                || heightMode != MeasureSpec.EXACTLY) {
            // 主要设置为背景图的高度
            resWidth = getSuggestedMinimumWidth();
            // 如果未设置背景图片，则设置为屏幕宽高的默认值
            resWidth = resWidth == 0 ? getDefaultWidth() : resWidth;

            resHeight = getSuggestedMinimumHeight();
            // 如果未设置背景图片，则设置为屏幕宽高的默认值
            resHeight = resHeight == 0 ? getDefaultWidth() * 6 / 5 : resHeight;
        } else {
            // 如果都设置为精确值，则直接取小值；
            resWidth = resHeight = Math.max(width, height);
        }

        setMeasuredDimension(resWidth, resHeight);

        // 获得半径
        mRadius = Math.max(getMeasuredWidth(), getMeasuredHeight());

        // menu item数量
        final int count = getChildCount();
        // menu item尺寸
        int childSize = (int) (mRadius * RADIO_DEFAULT_CHILD_DIMENSION);
        // menu item测量模式
        int childMode = MeasureSpec.EXACTLY;

        // 迭代测量
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }

            // 计算menu item的尺寸；以及和设置好的模式，去对item进行测量
            int makeMeasureSpec = -1;

            if (child.getId() == R.id.id_circle_menu_item_center) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(
                        (int) (mRadius * RADIO_DEFAULT_CENTERITEM_DIMENSION),
                        childMode);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(childSize,
                        childMode);
            }
            child.measure(makeMeasureSpec, makeMeasureSpec);
        }

        mPadding = RADIO_PADDING_LAYOUT * mRadius;
//        mPadding = RADIO_PADDING_LAYOUT;

    }

    /**
     * MenuItem的点击事件接口
     *
     * @author zhy
     */
    public interface OnMenuItemClickListener {
        void itemClick(View view, int pos);

        void itemCenterClick(View view);
    }

    /**
     * MenuItem的点击事件接口
     */
    private OnMenuItemClickListener mOnMenuItemClickListener;

    /**
     * 设置MenuItem的点击事件接口
     *
     * @param mOnMenuItemClickListener
     */
    public void setOnMenuItemClickListener(
            OnMenuItemClickListener mOnMenuItemClickListener) {
        this.mOnMenuItemClickListener = mOnMenuItemClickListener;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        matrix = new Matrix();

//        canvas.drawBitmap(m_bitmap2, 0, m_width, 0, 0, m_width, m_height,
//        false, null);

//        imageOriginal = BitmapFactory.decodeResource(getResources(),
//                R.mipmap.nrh_yuanpan1);
        matrix.postTranslate(mRadius / 2 - imageOriginal.getWidth() / 2, mRadius / 2
                - imageOriginal.getHeight() / 2);
        matrix.postRotate((float) mStartAngle, mRadius / 2, mRadius / 2);
        Canvas g = canvas;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        g.drawBitmap(imageOriginal, matrix, paint);
        postInvalidate();

        bit_inner = BitmapFactory.decodeResource(getResources(),
                R.mipmap.zhongjianyuan);
        bit_inner = Bitmap.createScaledBitmap(bit_inner, (int) mRadius / 7 * 2, (int) mRadius / 7 * 2, true);
        Matrix matrix_inner = new Matrix();
        matrix_inner.postTranslate(mRadius / 2 - bit_inner.getWidth() / 2, mRadius / 2
                - bit_inner.getHeight() / 2);
        matrix_inner.postRotate(inner_angle, mRadius / 2, mRadius / 2);
        Paint inner = new Paint();
        inner.setAntiAlias(true);
        canvas.drawBitmap(bit_inner, matrix_inner, inner);
        postInvalidate();

        Bitmap inner_circle = BitmapFactory.decodeResource(getResources(),
                R.mipmap.xiaoshi);
        inner_circle = Bitmap.createScaledBitmap(inner_circle, (int) mRadius / 5, (int) mRadius / 5, true);
        Paint inner_circle_paint = new Paint();
        inner_circle_paint.setAntiAlias(true);
        inner_circle_paint.setAlpha(alpha);
        canvas.drawBitmap(inner_circle, mRadius / 2 - inner_circle.getWidth() / 2,
                mRadius / 2 - inner_circle.getHeight() / 2, inner_circle_paint);
        postInvalidate();

    }

    /**
     * 设置menu item的位置
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int layoutRadius = (int) mRadius;

        // Laying out the child views
        final int childCount = getChildCount();

        int left, top;
        // menu item 的尺寸
        int cWidth = (int) (layoutRadius * RADIO_DEFAULT_CHILD_DIMENSION);

        // 根据menu item的个数，计算角度
        float angleDelay = 360 / (getChildCount() - 1);

        // 遍历去设置menuitem的位置
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);

            if (child.getId() == R.id.id_circle_menu_item_center)
                continue;

            if (child.getVisibility() == GONE) {
                continue;
            }

            mStartAngle %= 360;

            // 计算，中心点到menu item中心的距离
            float tmp = layoutRadius / 2f - cWidth / 2 - mPadding;

            // tmp cosa 即menu item中心点的横坐标
            left = layoutRadius
                    / 2
                    + (int) Math.round(tmp
                    * Math.cos(Math.toRadians(mStartAngle)) - 1 / 2f
                    * cWidth);
            // tmp sina 即menu item的纵坐标
            top = layoutRadius
                    / 2
                    + (int) Math.round(tmp
                    * Math.sin(Math.toRadians(mStartAngle)) - 1 / 2f
                    * cWidth);

            child.layout(left, top, left + cWidth, top + cWidth);
            // 叠加尺寸
            mStartAngle += angleDelay;
        }

        // 找到中心的view，如果存在设置onclick事件
        View cView = findViewById(R.id.id_circle_menu_item_center);
        if (cView != null) {
            cView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnMenuItemClickListener != null) {
                        mOnMenuItemClickListener.itemCenterClick(v);
                    }
                }
            });
            cView.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int x = (int) event.getX();
                    int y = (int) event.getY();
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            alpha = 150;
                            break;
                        case MotionEvent.ACTION_MOVE:
                            break;
                        case MotionEvent.ACTION_UP:
                            if (alpha != 255)
                                alpha = 255;
                            break;
                    }
                    return false;
                }
            });
            // 设置center item位置
            int cl = layoutRadius / 2 - cView.getMeasuredWidth() / 2;
            int cr = cl + cView.getMeasuredWidth();
            cView.layout(cl, cl, cr, cr);
        }

    }

    private int pointToPosition(float x, float y) {

        for (int i = 0; i < getChildCount(); i++) {

            View item = (View) getChildAt(i);
            if (item.getLeft() < x && item.getRight() > x & item.getTop() < y
                    && item.getBottom() > y) {
                return i;
            }

        }
        if (x > mRadius - bit_inner.getWidth() / 2
                && x < mRadius + bit_inner.getWidth() / 2
                && y > mRadius - bit_inner.getHeight() / 2
                && y < mRadius + bit_inner.getHeight() / 2) {
            return -1;
        }
        return -2;
    }

    /***************************************************************/
    private boolean isLongTouch = false;
    private float inner_angle;

    private void rotateInnerView() {
        if (isLongTouch) {
            float velocityTemp = 0.5f;
            float destAngle = Integer.MAX_VALUE;
            float startAngle = 0;
            int reverser = 1;

            while (startAngle < destAngle) {
                startAngle += velocityTemp / 75;
                velocityTemp *= 1.0666F;
            }
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Message message = new Message();
                    message.what = 1;
                    mHandler.sendMessage(message);
                }
            });
            thread.start();
//			CircleLayout.this.post(new InnerRunnable(700));
        }
    }

    private float velocity;
    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            velocity = 300;
            switch (msg.what) {
                case 1:
                    if (Math.abs(velocity) > 5) {
                        if (isLongTouch) {
                            rotate(velocity / 75);
                            velocity /= 1.0666F;
                            Message message = new Message();
                            message.what = 1;
                            mHandler.sendMessage(message);
                        } else {
                            rotateInnerView();
                        }
                    }
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void rotate(float degrees) {
        inner_angle += degrees;
        if (inner_angle > 360) {
            inner_angle -= 360;
        } else {
            if (inner_angle < 0) {
                inner_angle += 360;
            }
        }
        invalidate();
    }

    /**
     * 记录上一次的x，y坐标
     */
    private int mLastX;
    private int mLastY;

    /**
     * 自动滚动的Runnable
     */
    private AutoFlingRunnable mFlingRunnable;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                mDownTime = System.currentTimeMillis();
                mTmpAngle = 0;

                // 如果当前已经在快速滚动
                if (isFling) {
                    // 移除快速滚动的回调
                    removeCallbacks(mFlingRunnable);
                    isFling = false;
                    return true;
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if (!isLongTouch) {
                    /**
                     * 获得开始的角度
                     */
                    float start = getAngle(mLastX, mLastY);
                    /**
                     * 获得当前的角度
                     */
                    float end = getAngle(x, y);

                    // Log.e("TAG", "start = " + start + " , end =" + end);
                    // 如果是一、四象限，则直接end-start，角度值都是正值
                    if (getQuadrant(x, y) == 1 || getQuadrant(x, y) == 4) {
                        mStartAngle += end - start;
                        mTmpAngle += end - start;
                    } else
                    // 二、三象限，色角度值是付值
                    {
                        mStartAngle += start - end;
                        mTmpAngle += start - end;
                    }
                    // 重新布局
                    postInvalidate();
                    requestLayout();

                    mLastX = x;
                    mLastY = y;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (alpha != 255)
                    alpha = 255;
                // 计算，每秒移动的角度
                float anglePerSecond = mTmpAngle * 1000
                        / (System.currentTimeMillis() - mDownTime);

                // Log.e("TAG", anglePrMillionSecond + " , mTmpAngel = " +
                // mTmpAngle);

                // 如果达到该值认为是快速移动
                if (Math.abs(anglePerSecond) > mFlingableValue && !isFling) {
                    // post一个任务，去自动滚动
                    post(mFlingRunnable = new AutoFlingRunnable(anglePerSecond));

                    return true;
                }

                // 如果当前旋转角度超过NOCLICK_VALUE屏蔽点击
                if (Math.abs(mTmpAngle) > NOCLICK_VALUE) {
                    return true;
                }

                goActivity();
                isLongTouch = false;
                postInvalidate();
                invalidate();
                break;
        }
        mGestureDetector.onTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            CircleMenuLayout.this.setLongClickable(false);
            return false;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            int touchPosition = pointToPosition(e.getX(), e.getY());
            if (touchPosition >= 0) {
                isLongTouch = true;
                rotateInnerView();
            }
            super.onLongPress(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return super.onSingleTapUp(e);
        }

    }

    /**
     * 主要为了action_down时，返回true
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    /*
     * 启动时转几圈
     */
    public void rotateOneCircle() {
        post(mFlingRunnable = new AutoFlingRunnable(526));
    }

    /**
     * 根据触摸的位置，计算角度
     *
     * @param xTouch
     * @param yTouch
     * @return
     */
    private float getAngle(float xTouch, float yTouch) {
        double x = xTouch - (mRadius / 2d);
        double y = yTouch - (mRadius / 2d);
        return (float) (Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI);
    }

    /**
     * 根据当前位置计算象限
     *
     * @param x
     * @param y
     * @return
     */
    private int getQuadrant(float x, float y) {
        int tmpX = (int) (x - mRadius / 2);
        int tmpY = (int) (y - mRadius / 2);
        if (tmpX >= 0) {
            return tmpY >= 0 ? 4 : 1;
        } else {
            return tmpY >= 0 ? 3 : 2;
        }

    }

    /**
     * 设置菜单条目的图标和文本
     *
     * @param resIds
     */
    public void setMenuItemIconsAndTexts(int[] resIds, String[] texts) {
        mItemImgs = resIds;
        mItemTexts = texts;

        // 参数检查
        if (resIds == null && texts == null) {
            throw new IllegalArgumentException("菜单项文本和图片至少设置其一");
        }

        // 初始化mMenuCount
        mMenuItemCount = resIds == null ? texts.length : resIds.length;

        if (resIds != null && texts != null) {
            mMenuItemCount = Math.min(resIds.length, texts.length);
        }

        addMenuItems();

    }

    /**
     * 设置MenuItem的布局文件，必须在setMenuItemIconsAndTexts之前调用
     *
     * @param mMenuItemLayoutId
     */
    public void setMenuItemLayoutId(int mMenuItemLayoutId) {
        this.mMenuItemLayoutId = mMenuItemLayoutId;
    }

    /**
     * 添加菜单项
     */
    private void addMenuItems() {
        LayoutInflater mInflater = LayoutInflater.from(getContext());

        /**
         * 根据用户设置的参数，初始化view
         */
        for (int i = 0; i < mMenuItemCount; i++) {
            final int j = i;
            View view = mInflater.inflate(mMenuItemLayoutId, this, false);
            ImageView iv = (ImageView) view
                    .findViewById(R.id.id_circle_menu_item_image);
            TextView tv = (TextView) view
                    .findViewById(R.id.id_circle_menu_item_text);

            if (iv != null) {
                iv.setVisibility(View.VISIBLE);
                iv.setImageResource(mItemImgs[i]);
                iv.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mOnMenuItemClickListener != null) {
                            mOnMenuItemClickListener.itemClick(v, j);
                        }
                    }
                });
            }
            if (tv != null) {
                tv.setVisibility(View.GONE);
                tv.setText(mItemTexts[i]);
            }
            // 添加view到容器中
            addView(view);
        }
    }

    /**
     * 如果每秒旋转角度到达该值，则认为是自动滚动
     *
     * @param mFlingableValue
     */
    public void setFlingableValue(int mFlingableValue) {
        this.mFlingableValue = mFlingableValue;
    }

    /**
     * 设置内边距的比例
     *
     * @param mPadding
     */
    public void setPadding(float mPadding) {
        this.mPadding = mPadding;
    }

    /**
     * 获得默认该layout的尺寸
     *
     * @return
     */
    private int getDefaultWidth() {
        WindowManager wm = (WindowManager) getContext().getSystemService(
                Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return Math.min(outMetrics.widthPixels, outMetrics.heightPixels);
    }

    /**
     * 自动滚动的任务
     *
     * @author zhy
     */
    private class AutoFlingRunnable implements Runnable {

        private float angelPerSecond;

        public AutoFlingRunnable(float velocity) {
            this.angelPerSecond = velocity;
        }

        public void run() {
            // 如果小于20,则停止
            if ((int) Math.abs(angelPerSecond) < 20) {
                isFling = false;
                return;
            }
            isFling = true;
            // 不断改变mStartAngle，让其滚动，/30为了避免滚动太快
            mStartAngle += (angelPerSecond / 30);
            // 逐渐减小这个值
            angelPerSecond /= 1.0666F;
            postDelayed(this, 30);
            // 重新布局
            requestLayout();
        }
    }

    private void goActivity() {
        if (isLongTouch) {
            int angle_new = 0;
            int angle_news = 0;
//            angle_new = (int)mStartAngle - 59;
            if ((int) mStartAngle >= 299 && (int) mStartAngle <= 419) {
                angle_news = (int) mStartAngle % 299;
            } else {
                angle_news = (int) mStartAngle + 61;
            }
            angle_new = (int) inner_angle;
//            for (int i = 30; i <= 330; i+= 30) {
//                if((i + (int)angle_news) %360 == 0){
//                    angle_new = 360;
//                }
//            }

            if (angle_new >= (0 + (int) angle_news) % 360 && angle_new < (30 + (int) angle_news - 1) % 360
                    || angle_new >= (30 + (int) angle_news + 1) % 360 && angle_new < (60 + (int) angle_news) % 360) {
                ToastTool.showShort(getContext(), "我要炫");
            } else if (angle_new >= (60 + (int) angle_news) % 360 && angle_new < (90 + (int) angle_news - 1) % 360
                    || angle_new >= (90 + (int) angle_news + 1) % 360 && angle_new < (120 + (int) angle_news) % 360) {
                ToastTool.showShort(getContext(), "呼叫服务");
            } else if (angle_new >= (120 + (int) angle_news) % 360 && angle_new < (150 + (int) angle_news - 1) % 360
                    || angle_new >= (150 + (int) angle_news + 1) % 360 && angle_new < (180 + (int) angle_news) % 360) {
                ToastTool.showShort(getContext(), "白送白玩");
            } else if (angle_new >= (180 + (int) angle_news) % 360 && angle_new < (210 + (int) angle_news - 1) % 360
                    || angle_new >= (210 + (int) angle_news + 1) % 360 && angle_new < (240 + (int) angle_news) % 360) {
                ToastTool.showShort(getContext(), "泡圈聊天");
            } else if (angle_new >= (240 + (int) angle_news) % 360 && angle_new < (270 + (int) angle_news - 1) % 360
                    || angle_new >= (270 + (int) angle_news + 1) % 360 && angle_new < (300 + (int) angle_news) % 360) {
                ToastTool.showShort(getContext(), "粉旗帜");
            } else if (angle_new >= (300 + (int) angle_news) % 360 && angle_new < (330 + (int) angle_news - 1) % 360 ||
                    angle_new >= (330 + (int) angle_news + 1) % 360 && angle_new < (360 + (int) angle_news) % 360) {
                ToastTool.showShort(getContext(), "粉账户");
            }
        }
    }
}