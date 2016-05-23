package com.smartcity.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.smartcity.R;
import com.smartcity.utils.ToastTool;

import java.util.Random;

public class CircleLayout extends ViewGroup {
    boolean m_isRunning = false;
    boolean m_isRain = false;

    int m_width, m_width1;
    int m_height, m_height1;

    short[] m_buf1, m_buf11;
    short[] m_buf2, m_buf22;

    int[] m_bitmap1, m_bitmap11;
    int[] m_bitmap2, m_bitmap22;

    Thread m_thread;

    int m_preX;
    int m_preY;

    Random random;

    // Event listeners
    private OnItemClickListener mOnItemClickListener = null;
    private OnItemSelectedListener mOnItemSelectedListener = null;
    private OnCenterClickListener mOnCenterClickListener = null;

    // 背景图片
    private Bitmap imageOriginal, bit_inner;
    private Matrix matrix;

    private int mTappedViewsPostition = -1;
    private View mTappedView = null;
    private int selected = 0;

    // 子控件的宽高
    private int mMaxChildWidth = 0;
    private int mMaxChildHeight = 0;
    private int childWidth = 0;
    private int childHeight = 0;

    // Sizes of the ViewGroup
    private int circleWidth, circleHeight;
    private int radius = 0;

    // Touch detection
    private GestureDetector mGestureDetector;
    // needed for detecting the inversed rotations
    private boolean[] quadrantTouched;

    // Settings of the ViewGroup
    private boolean allowRotating = true;
    private float angle;
    private float firstChildPos;
    private boolean rotateToCenter = true;
    private boolean isRotating = true;

    private int alpha = 0;

    /**
     * @param context
     */
    public CircleLayout(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public CircleLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public CircleLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init(attrs);
        random = new Random();
    }


    /**
     * Initializes the ViewGroup and modifies it's default behavior by the
     * passed attributes
     *
     * @param attrs
     * the attributes used to modify default settings
     */
    private int circleX;
    private int circleY;

    protected void init(AttributeSet attrs) {

        performClick();

        initView();

        circleX = (int) getResources().getDimension(R.dimen.x460);
        circleY = (int) getResources().getDimension(R.dimen.x600);

        mGestureDetector = new GestureDetector(getContext(),
                new MyGestureListener());
        quadrantTouched = new boolean[]{false, false, false, false, false};

        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs,
                    R.styleable.Circle);

            // The angle where the first menu item will be drawn
            angle = a.getInt(R.styleable.Circle_firstChildPosition, 0);
            inner_angle = 0;
            firstChildPos = angle;

            rotateToCenter = a.getBoolean(R.styleable.Circle_rotateToCenter,
                    true);
            isRotating = a.getBoolean(R.styleable.Circle_isRotating, true);

            // If the menu is not rotating then it does not have to be centered
            // since it cannot be even moved
            if (!isRotating) {
                rotateToCenter = false;
            }

            if (imageOriginal == null) {
                int picId = a.getResourceId(
                        R.styleable.Circle_circleBackground, -1);

                // If a background image was set as an attribute,
                // retrieve the image
                if (picId != -1) {
                    imageOriginal = BitmapFactory.decodeResource(
                            getResources(), picId);
                    imageOriginal = Bitmap.createScaledBitmap(imageOriginal, getDefaultWidth(), getDefaultWidth(), true);
                }
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
     * Returns the currently selected menu
     *
     * @return the view which is currently the closest to the start position
     */
    public View getSelectedItem() {
        return (selected >= 0) ? getChildAt(selected) : null;
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {

        // the sizes of the ViewGroup
        circleHeight = getHeight();
        circleWidth = getWidth();

        if (wavePaint.getAlpha() > 0) {
            // canvas.drawBitmap(m_bitmap2, 0, m_width, 0, 0, m_width, m_height,
            // false, null);
            // // if (startX > 0 && startY > 0) {
            // // // 绘制一个圆环
            // // canvas.drawCircle(startX, startY, waveRadius, wavePaint);
            // // // 绘制的同时，发送一个延迟消息
            // // handler.sendEmptyMessageDelayed(0, 50);
            // // }
        }
        matrix = new Matrix();
        matrix.postTranslate(circleX - imageOriginal.getWidth() / 2, circleY
                - imageOriginal.getHeight() / 2);
        matrix.postRotate(angle, circleX, circleY);
        Canvas g = canvas;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        g.drawBitmap(imageOriginal, matrix, paint);

        bit_inner = BitmapFactory.decodeResource(getResources(),
                R.mipmap.nrh_inner);
        bit_inner = Bitmap.createScaledBitmap(bit_inner, getDefaultWidth() * 2 / 7, getDefaultWidth() * 2 / 7, true);
        Matrix matrix_inner = new Matrix();
        matrix_inner.postTranslate(circleX - bit_inner.getWidth() / 2, circleY
                - bit_inner.getHeight() / 2);
        matrix_inner.postRotate(inner_angle, circleX, circleY);
        Paint inner = new Paint();
        inner.setAntiAlias(true);
        canvas.drawBitmap(bit_inner, matrix_inner, inner);

        Bitmap inner_circle = BitmapFactory.decodeResource(getResources(),
                R.mipmap.nrh_inner_circle);
        inner_circle = Bitmap.createScaledBitmap(inner_circle, getDefaultWidth() / 4, getDefaultWidth() / 4, true);
        Paint inner_circle_paint = new Paint();
        inner_circle_paint.setAntiAlias(true);
        inner_circle_paint.setAlpha(alpha);
        canvas.drawBitmap(inner_circle, circleX - inner_circle.getWidth() / 2,
                circleY - inner_circle.getHeight() / 2, inner_circle_paint);

        Bitmap inner_gray_bg = BitmapFactory.decodeResource(getResources(),
                R.mipmap.nrh_inner_circle);
        inner_gray_bg = Bitmap.createScaledBitmap(inner_gray_bg, getDefaultWidth() / 5, getDefaultWidth() / 5, true);
        Matrix matrix_inner_bg = new Matrix();
        Paint inner_bg = new Paint();
        inner_bg.setAntiAlias(true);
        canvas.drawBitmap(inner_gray_bg,
                circleX - inner_gray_bg.getWidth() / 2,
                circleY - inner_gray_bg.getHeight() / 2, inner_bg);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mMaxChildWidth = 0;
        mMaxChildHeight = 0;

        // Measure once to find the maximum child size.
        int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.AT_MOST);
        int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.AT_MOST);

        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);

            mMaxChildWidth = Math.max(mMaxChildWidth, child.getMeasuredWidth());
            mMaxChildHeight = Math.max(mMaxChildHeight,
                    child.getMeasuredHeight());
        }

        // Measure again for each child to be exactly the same size.
        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxChildWidth,
                MeasureSpec.EXACTLY);
        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(mMaxChildHeight,
                MeasureSpec.EXACTLY);

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }

            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        }

        setMeasuredDimension(resolveSize(mMaxChildWidth, widthMeasureSpec),
                resolveSize(mMaxChildHeight, heightMeasureSpec));
    }

	/*
     * // 内部模块到圆心的距离 private float smallRadius;
	 */

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int layoutWidth = r - l;
        int layoutHeight = b - t;

        // Laying out the child views
        final int childCount = getChildCount();
        int left, top;
        radius = (int) getResources().getDimension(R.dimen.x250);

        Bitmap bit = BitmapFactory.decodeResource(getResources(),
                R.mipmap.nrh_xiaoyuan);
        childWidth = (int) getResources().getDimension(R.dimen.x203);
        childHeight = (int) getResources().getDimension(R.dimen.x203);

        float angleDelay = 360 / getChildCount();

        for (int i = 0; i < childCount; i++) {
            final CircleImageView child = (CircleImageView) getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }

            if (angle > 360) {
                angle -= 360;
            } else {
                if (angle < 0) {
                    angle += 360;
                }
            }

            child.setAngle(angle);
            child.setPosition(i);

			/*
			 * left = Math .round((float) (((layoutWidth / 2) - childWidth / 2)
			 * + radius Math.cos(Math.toRadians(angle)))); top = Math
			 * .round((float) (((layoutHeight / 2) - childHeight / 2) + radius
			 * Math.sin(Math.toRadians(angle))));
			 */

            left = Math.round((float) (circleX - childWidth / 2 + radius
                    * Math.cos(Math.toRadians(angle))));
            top = Math.round((float) (circleY - childHeight / 2 + radius
                    * Math.sin(Math.toRadians(angle))));

            child.layout(left, top, left + childWidth, top + childHeight);
            angle += angleDelay;

        }
    }

    /**
     * Rotate the buttons.
     *
     * @param degrees The degrees,菜单项应该得到旋转。
     */
    private void rotateButtons(float degrees) {
        int left, top, childCount = getChildCount();
        float angleDelay = 360 / childCount;
        angle += degrees;

        if (angle > 360) {
            angle -= 360;
        } else {
            if (angle < 0) {
                angle += 360;
            }
        }

        for (int i = 0; i < childCount; i++) {
            if (angle > 360) {
                angle -= 360;
            } else {
                if (angle < 0) {
                    angle += 360;
                }
            }

            final CircleImageView child = (CircleImageView) getChildAt(i);
            if (child.getVisibility() == GONE) {
                continue;
            }
			/*
			 * left = Math .round((float) (((circleWidth / 2) - childWidth / 2)
			 * + radius Math.cos(Math.toRadians(angle)))); top = Math
			 * .round((float) (((circleHeight / 2) - childHeight / 2) + radius
			 * Math.sin(Math.toRadians(angle))));
			 */

            left = Math.round((float) (circleX - childWidth / 2 + radius
                    * Math.cos(Math.toRadians(angle))));
            top = Math.round((float) (circleY - childHeight / 2 + radius
                    * Math.sin(Math.toRadians(angle))));

            child.setAngle(angle);

            if (Math.abs(angle - firstChildPos) < (angleDelay / 2)
                    && selected != child.getPosition()) {
                selected = child.getPosition();

                if (mOnItemSelectedListener != null && rotateToCenter) {
                    mOnItemSelectedListener.onItemSelected(child, selected,
                            child.getId(), child.getName());
                }
            }
            child.layout(left, top, left + childWidth, top + childHeight);
            angle += angleDelay;
        }
    }

    /**
     * @return 根据象限，返回相应的角度
     */
    private double getAngle(double xTouch, double yTouch) {
        double x = xTouch - (circleWidth / 2d);
        double y = circleHeight - yTouch - (circleHeight / 2d);

        switch (getQuadrant(x, y)) {
            case 1:
                return Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI;

            case 2:
            case 3:
                return 180 - (Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI);

            case 4:
                return 360 + Math.asin(y / Math.hypot(x, y)) * 180 / Math.PI;

            default:
                // ignore, does not happen
                return 0;
        }
    }

    /**
     * @return 计算在第几象限
     */
    private static int getQuadrant(double x, double y) {
        if (x >= 0) {
            return y >= 0 ? 1 : 4;
        } else {
            return y >= 0 ? 2 : 3;
        }
    }

    private double startAngle;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int action = event.getAction();

        if (KeyEvent.ACTION_DOWN == action) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_0:
                    m_isRain = !m_isRain;
                    break;
            }
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        int x = (int) (event.getX());
        int y = (int) (event.getY());

        // switch (action) {
        // case MotionEvent.ACTION_DOWN:
        // dropStone(x, y, 8, 50);
        // m_preX = x;
        // m_preY = y;
        // break;
        //
        // case MotionEvent.ACTION_MOVE:
        // bresenhamDrop(m_preX, m_preY, x, y, 4, 40);
        // m_preX = x;
        // m_preY = y;
        // break;
        // }
        if (isEnabled()) {
            if (isRotating) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        m_preX = x;
                        m_preY = y;
                        int touchPosition = pointToPosition(event.getX(),
                                event.getY());
                        if (touchPosition == -1)
                            alpha = 255;
                        if (touchPosition == -2) {
                            // 1. 设置圆心
                            startX = event.getX() / 2;
                            startY = event.getY() / 2;
                            // 2.根据圆心创建新的圆
                            initView();
                            // 3.绘制
                            invalidate();
                        }

                        // reset the touched quadrants
                        for (int i = 0; i < quadrantTouched.length; i++) {
                            quadrantTouched[i] = false;
                        }

                        allowRotating = false;

                        startAngle = getAngle(event.getX(), event.getY());

                        invalidate();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        m_preX = x;
                        m_preY = y;
                        double currentAngle = getAngle(event.getX(), event.getY());
                        rotateButtons((float) (startAngle - currentAngle));
                        startAngle = currentAngle;
                        break;
                    case MotionEvent.ACTION_UP:
                        allowRotating = true;
                        rotateViewToCenter((CircleImageView) getChildAt(selected),
                                false);

                        if (alpha != 0)
                            alpha = 0;

                        // 是否进入指定页面
                        goActivity();
                        isLongTouch = false;
                        invalidate();
                        break;
                }
            }

            // 设置了象限为true
            quadrantTouched[getQuadrant(event.getX() - (circleWidth / 2),
                    circleHeight - event.getY() - (circleHeight / 2))] = true;
            mGestureDetector.onTouchEvent(event);
            return true;
        }
        return false;
    }

    private class MyGestureListener extends SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            if (!isRotating) {
                return false;
            }
            // get the quadrant of the start and the end of the fling
            int q1 = getQuadrant(e1.getX() - (circleWidth / 2), circleHeight
                    - e1.getY() - (circleHeight / 2));
            int q2 = getQuadrant(e2.getX() - (circleWidth / 2), circleHeight
                    - e2.getY() - (circleHeight / 2));

            // the inversed rotations
            if ((q1 == 2 && q2 == 2 && Math.abs(velocityX) < Math
                    .abs(velocityY))
                    || (q1 == 3 && q2 == 3)
                    || (q1 == 1 && q2 == 3)
                    || (q1 == 4 && q2 == 4 && Math.abs(velocityX) > Math
                    .abs(velocityY))
                    || ((q1 == 2 && q2 == 3) || (q1 == 3 && q2 == 2))
                    || ((q1 == 3 && q2 == 4) || (q1 == 4 && q2 == 3))
                    || (q1 == 2 && q2 == 4 && quadrantTouched[3])
                    || (q1 == 4 && q2 == 2 && quadrantTouched[3])) {

                CircleLayout.this.post(new FlingRunnable(-1
                        * (velocityX + velocityY)));
            } else {
                // the normal rotation
                CircleLayout.this
                        .post(new FlingRunnable(velocityX + velocityY));
            }
            return true;
        }

		/*
		 * @Override public void onShowPress(MotionEvent e) {
		 * 
		 * super.onShowPress(e); }
		 */

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
            mTappedViewsPostition = pointToPosition(e.getX(), e.getY());
            if (mTappedViewsPostition >= 0) {
                mTappedView = getChildAt(mTappedViewsPostition);
                mTappedView.setPressed(true);
            } else if (mTappedViewsPostition == -1) {
                if (mOnCenterClickListener != null) {
                    mOnCenterClickListener.onCenterClick();
                    return true;
                }

				/*
				 * float centerX = circleWidth / 2; float centerY = circleHeight
				 * / 2;
				 * 
				 * if (e.getX() < centerX + (childWidth / 2) && e.getX() >
				 * centerX - childWidth / 2 && e.getY() < centerY + (childHeight
				 * / 2) && e.getY() > centerY - (childHeight / 2)) { if
				 * (mOnCenterClickListener != null) {
				 * mOnCenterClickListener.onCenterClick(); return true; } }
				 */
            }

            if (mTappedView != null) {
                CircleImageView view = (CircleImageView) (mTappedView);
                if (selected != mTappedViewsPostition) {
                    rotateViewToCenter(view, false);

                    if (!rotateToCenter) {
                        if (mOnItemSelectedListener != null) {
                            mOnItemSelectedListener.onItemSelected(mTappedView,
                                    mTappedViewsPostition, mTappedView.getId(),
                                    view.getName());
                        }
                    }

                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(mTappedView,
                                mTappedViewsPostition, mTappedView.getId(),
                                view.getName());
                    }
                } else {
                    rotateViewToCenter(view, false);

                    if (mOnItemClickListener != null) {

                        mOnItemClickListener.onItemClick(mTappedView,
                                mTappedViewsPostition, mTappedView.getId(),
                                view.getName());
                    }
                }
                return true;
            } else if (mTappedViewsPostition == -1) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(null, -1, 0, null);
                }
            }

            return super.onSingleTapUp(e);
        }

    }

    /**
     * Rotates the given view to the center of the menu.
     *
     * @param view         the view to be rotated to the center
     * @param fromRunnable if the method is called from the runnable which animates the
     *                     rotation then it should be true, otherwise false
     */
    private void rotateViewToCenter(CircleImageView view, boolean fromRunnable) {
        if (rotateToCenter) {
            float velocityTemp = 1;
            float destAngle = (float) (firstChildPos - view.getAngle());
            float startAngle = 0;
            int reverser = 1;

            if (destAngle < 0) {
                destAngle += 360;
            }

            if (destAngle > 180) {
                reverser = -1;
                destAngle = 360 - destAngle;
            }

            while (startAngle < destAngle) {
                startAngle += velocityTemp / 75;
                velocityTemp *= 1.0666F;
            }
            CircleLayout.this.post(new FlingRunnable(reverser * velocityTemp,
                    !fromRunnable));
        }
    }

    public void rotateOneCircle() {
        float velocityTemp = 1;
        float startAngle = 0;
        float destAngle = 360;
        int reverser = 1;
        while (startAngle < destAngle) {
            startAngle += velocityTemp / 75;
            velocityTemp *= 1.0666F;
        }
        CircleLayout.this
                .post(new FlingRunnable(reverser * velocityTemp, false));
    }

    private class FlingRunnable implements Runnable {
        private float velocity;
        float angleDelay;
        boolean isFirstForwarding = true;

        public FlingRunnable(float velocity) {
            this(velocity, true);
        }

        public FlingRunnable(float velocity, boolean isFirst) {
            this.velocity = velocity;
            this.angleDelay = 360 / getChildCount();
            this.isFirstForwarding = isFirst;
        }

        public void run() {
            if (Math.abs(velocity) > 5 && allowRotating) {
                if (rotateToCenter) {
                    if (!(Math.abs(velocity) < 200 && (Math.abs(angle
                            - firstChildPos)
                            % angleDelay < 2))) {
                        rotateButtons(velocity / 75);
                        velocity /= 1.0666F;

                        CircleLayout.this.post(this);
                    }
                } else {
                    rotateButtons(velocity / 75);
                    velocity /= 1.0666F;

                    CircleLayout.this.post(this);
                }
            } else {
                if (isFirstForwarding) {
                    isFirstForwarding = false;
                    CircleLayout.this.rotateViewToCenter(
                            (CircleImageView) getChildAt(selected), true);
                }
            }
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
        if (x > circleX - bit_inner.getWidth() / 2
                && x < circleX + bit_inner.getWidth() / 2
                && y > circleY - bit_inner.getHeight() / 2
                && y < circleY + bit_inner.getHeight() / 2) {
            return -1;
        }
        return -2;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, long id, String name);
    }

    public void setOnItemSelectedListener(
            OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelectedListener = onItemSelectedListener;
    }

    public interface OnItemSelectedListener {
        void onItemSelected(View view, int position, long id, String name);
    }

    public interface OnCenterClickListener {
        void onCenterClick();
    }

    public void setOnCenterClickListener(
            OnCenterClickListener onCenterClickListener) {
        this.mOnCenterClickListener = onCenterClickListener;
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

//	private class InnerRunnable implements Runnable {
//
//		public InnerRunnable(float velocity) {
//			velocity = velocity;
//		}
//
//		public void run() {
//			if (Math.abs(velocity) > 5) {
//				if (isLongTouch) {
//					rotate(velocity / 75);
//					velocity /= 1.0666F;
//					CircleLayout.this.post(this);
//				} else {
//					rotateInnerView();
//				}
//			}
//		}
//	}

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

    private void goActivity() {
        if (isLongTouch) {
            float angle_new = 0;
            if (angle >= 290 && angle <= 360) {
                angle_new = 360 - angle;
            } else if (angle > 0 && angle < 290) {
                angle_new = angle + 70;
            }

            if (inner_angle > (angle_new - 30) % 360
                    && inner_angle < (angle_new + 30) % 360) {
                ToastTool.showShort(getContext(), "账户查询");
//				launchActivityWithParams(ServeActivity.class, 1);
            } else if (inner_angle > (angle_new + 60 - 30) % 360
                    && inner_angle < (angle_new + 60 + 30) % 360) {
                ToastTool.showShort(getContext(), "我要服务");
//				launchActivityWithParams(MediaplayerActivity.class, 2);
            } else if (inner_angle > (angle_new + 120 - 30) % 360
                    && inner_angle < (angle_new + 120 + 30) % 360) {
                ToastTool.showShort(getContext(), "玩家挣钱");
//				launchActivityWithParams(Women_FindGuestActivity.class, 3);
            } else if (inner_angle > (angle_new + 180 - 30) % 360
                    && inner_angle < (angle_new + 180 + 30) % 360) {
                ToastTool.showShort(getContext(), "白送白玩");
//				launchActivityWithParams(LiudaxingdongActivity.class, 3);
            } else if (inner_angle > (angle_new + 240 - 30) % 360
                    && inner_angle < (angle_new + 240 + 30) % 360) {
                ToastTool.showShort(getContext(), "泡圈聊天");
//				launchActivityWithParams(Query_Activity.class, 4);
            } else if ((inner_angle > (angle_new + 300 - 30) % 360 && inner_angle <= 360)
                    || (inner_angle >= 0 && inner_angle < (angle_new + 300 + 30) % 360)) {
                ToastTool.showShort(getContext(), "粉旗帜");
//				MainActivity.instance.onTabSelected(1);
//				MainActivity.instance.mTabWidget.setTabsDisplay(
//						MainActivity.instance, 1);
//				MainActivity.circle = true;
            }
        }
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

    private void launchActivityWithParams(Class<?> activity, int index) {
        Context context = getContext();
        Intent intent = new Intent(context, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra("index", index);
        context.startActivity(intent);
    }

    /**********************************************************************************/
    private Paint wavePaint;
    // 圆形坐标
    private float startX;
    private float startY;
    private int waveRadius;

    private void initView() {
        wavePaint = new Paint();
        // 设置颜色
        // wavePaint.setColor(Color.RED);
        wavePaint.setColor(Color.WHITE);
        // 设置抗锯齿
        wavePaint.setAntiAlias(true);
        // 设置圆环样式
        wavePaint.setStyle(Style.STROKE);
        // 半径为5
        waveRadius = 5;
        wavePaint.setStrokeWidth(waveRadius / 3);
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            // 1.透明度改变-小
            int alpha = wavePaint.getAlpha();
            alpha -= 10;
            if (alpha < 0) {
                alpha = 0;
            }
            // 透明度：0~255之间
            wavePaint.setAlpha(alpha);

            // 2.半径变大
            waveRadius += 5;
            wavePaint.setStrokeWidth(waveRadius / 3);

            // 3.再次绘制一个，执行onDraw方法
            invalidate();
        }

        ;
    };

}