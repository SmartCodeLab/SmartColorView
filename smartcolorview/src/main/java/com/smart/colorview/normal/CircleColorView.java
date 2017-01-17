package com.smart.colorview.normal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.smart.colorview.R;
import com.smart.colorview.normal.model.CircleColorModel;


/**
 * Created by fengjh on 16/12/15.
 */

public class CircleColorView extends View {

    private static final String TAG = CircleColorView.class.getName();

    private Paint mCirclePaint;
    private float mCircleWidth = 150;
    private float mCircleHeight = 150;
    private int mCircleColor = 0xff9258c2;
    private boolean mCircleSelected = true;
    //是否使用边框
    private boolean mSelectUseOutline = true;
    private boolean mNormalUseOutline = false;
    private float mOutlineStrokeWidth = 8;
    private int mOutlineStrokeColor = 0xff000000;
    //是否使用轮廓
    private boolean mSelectUseFrame = true;
    private float mFrameStrokeWidth = 8;
    private int mFrameStrokeColor = 0xff0000ff;
    private float mFrameCornerRadius = 20;
    private InnerType mInnerType = InnerType.NORMAL;
    private float mInnerStrokeWidth = 8;
    private int mInnerStrokeColor = 0xfff53b53;
    private float mInnerStrokeDividerWidth = 10;
    private float mTickStrokeWidth = 4;
    private int mTickStrokeColor = 0xffffffff;
    private float mTickBackgroundDividerWidth = 20;
    private int mTickBackgroundColor = 0x88dddddd;

    private static final InnerType[] mInnerTypeArray = {
            InnerType.NORMAL,
            InnerType.INNER,
            InnerType.TICK
    };

    public CircleColorView(Context context) {
        this(context, null);
    }

    public CircleColorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CircleColorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircleColorView, defStyleAttr, defStyleRes);
        if (attributes != null) {
            int count = attributes.getIndexCount();
            for (int i = 0; i < count; i++) {
                int index = attributes.getIndex(i);
                if (index == R.styleable.CircleColorView_circleColor) {
                    mCircleColor = attributes.getColor(R.styleable.CircleColorView_circleColor, mCircleColor);
                } else if (index == R.styleable.CircleColorView_circleSelected) {
                    mCircleSelected = attributes.getBoolean(R.styleable.CircleColorView_circleSelected, mCircleSelected);
                } else if (index == R.styleable.CircleColorView_selectUseOutline) {
                    mSelectUseOutline = attributes.getBoolean(R.styleable.CircleColorView_selectUseOutline, mSelectUseOutline);
                } else if (index == R.styleable.CircleColorView_normalUseOutline) {
                    mNormalUseOutline = attributes.getBoolean(R.styleable.CircleColorView_normalUseOutline, mNormalUseOutline);
                } else if (index == R.styleable.CircleColorView_outlineStrokeWidth) {
                    mOutlineStrokeWidth = attributes.getDimension(R.styleable.CircleColorView_outlineStrokeWidth, mOutlineStrokeWidth);
                } else if (index == R.styleable.CircleColorView_outlineStrokeColor) {
                    mOutlineStrokeColor = attributes.getColor(R.styleable.CircleColorView_outlineStrokeColor, mOutlineStrokeColor);
                } else if (index == R.styleable.CircleColorView_selectUseFrame) {
                    mSelectUseFrame = attributes.getBoolean(R.styleable.CircleColorView_selectUseFrame, mSelectUseFrame);
                } else if (index == R.styleable.CircleColorView_frameStrokeWidth) {
                    mFrameStrokeWidth = attributes.getDimension(R.styleable.CircleColorView_frameStrokeWidth, mFrameStrokeWidth);
                } else if (index == R.styleable.CircleColorView_frameStrokeColor) {
                    mFrameStrokeColor = attributes.getColor(R.styleable.CircleColorView_frameStrokeColor, mFrameStrokeColor);
                } else if (index == R.styleable.CircleColorView_frameCornerRadius) {
                    mFrameCornerRadius = attributes.getDimension(R.styleable.CircleColorView_frameCornerRadius, mFrameCornerRadius);
                } else if (index == R.styleable.CircleColorView_innerType) {
                    final int type = attributes.getInt(R.styleable.CircleColorView_innerType, -1);
                    if (type >= 0) {
                        setInnerType(mInnerTypeArray[type]);
                    }
                } else if (index == R.styleable.CircleColorView_innerStrokeWidth) {
                    mInnerStrokeWidth = attributes.getDimension(R.styleable.CircleColorView_innerStrokeWidth, mInnerStrokeWidth);
                } else if (index == R.styleable.CircleColorView_innerStrokeColor) {
                    mInnerStrokeColor = attributes.getColor(R.styleable.CircleColorView_innerStrokeColor, mInnerStrokeColor);
                } else if (index == R.styleable.CircleColorView_innerStrokeDividerWidth) {
                    mInnerStrokeDividerWidth = attributes.getDimension(R.styleable.CircleColorView_innerStrokeDividerWidth, mInnerStrokeDividerWidth);
                } else if (index == R.styleable.CircleColorView_tickBackgroundDividerWidth) {
                    mTickBackgroundDividerWidth = attributes.getDimension(R.styleable.CircleColorView_tickBackgroundDividerWidth, mTickBackgroundDividerWidth);
                } else if (index == R.styleable.CircleColorView_tickStrokeWidth) {
                    mTickStrokeWidth = attributes.getDimension(R.styleable.CircleColorView_tickStrokeWidth, mTickStrokeWidth);
                } else if (index == R.styleable.CircleColorView_tickStrokeColor) {
                    mTickStrokeColor = attributes.getColor(R.styleable.CircleColorView_tickStrokeColor, mTickStrokeColor);
                } else if (index == R.styleable.CircleColorView_tickBackgroundColor) {
                    mTickBackgroundColor = attributes.getColor(R.styleable.CircleColorView_tickBackgroundColor, mTickBackgroundColor);
                }
            }
            attributes.recycle();
        }
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setAntiAlias(true);
    }

    private void switch2Circle() {
        mCirclePaint.setColor(mCircleColor);
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setStrokeWidth(1);
    }

    private void switch2Outline() {
        mCirclePaint.setColor(mOutlineStrokeColor);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setStrokeWidth(mOutlineStrokeWidth);
    }

    private void switch2Frame() {
        mCirclePaint.setColor(mFrameStrokeColor);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setStrokeWidth(mFrameStrokeWidth);
    }

    private void switch2Inner() {
        mCirclePaint.setColor(mInnerStrokeColor);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setStrokeWidth(mInnerStrokeWidth);
    }

    private void switch2TickStroke() {
        mCirclePaint.setColor(mTickStrokeColor);
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setStrokeCap(Paint.Cap.ROUND);
        mCirclePaint.setStrokeWidth(mTickStrokeWidth);
    }

    private void switch2TickBackground() {
        mCirclePaint.setColor(mTickBackgroundColor);
        mCirclePaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float centerX = mCircleWidth / 2.0f;
        float centerY = mCircleHeight / 2.0f;
        if (mCircleSelected) {
            //有轮廓
            if (mSelectUseFrame) {
                if (mFrameStrokeWidth < 0) {
                    throw new IllegalArgumentException(TAG + " mFrameStrokeWidth should greater than zero.");
                }
                //绘制轮廓
                switch2Frame();
                float left = mFrameStrokeWidth / 2.0f;
                float top = mFrameStrokeWidth / 2.0f;
                float right = mCircleWidth - mFrameStrokeWidth / 2.0f;
                float bottom = mCircleHeight - mFrameStrokeWidth / 2.0f;
                RectF rectF = new RectF(left, top, right, bottom);
                if (mFrameCornerRadius <= 0) {
                    //绘制正方形
                    canvas.drawRect(rectF, mCirclePaint);
                } else {
                    //绘制圆角正方形轮廓
                    canvas.drawRoundRect(rectF, mFrameCornerRadius, mFrameCornerRadius, mCirclePaint);
                }
            }
            if (mSelectUseOutline) {
                if (mOutlineStrokeWidth < 0) {
                    throw new IllegalArgumentException(TAG + " mOutlineStrokeWidth should greater than zero.");
                }
                //绘制圆形边框
                switch2Outline();
                float radius = mCircleWidth / 2.0f - mOutlineStrokeWidth / 2.0f;
                if (mSelectUseFrame) {
                    radius -= mFrameStrokeWidth;
                    canvas.drawCircle(centerX, centerY, radius, mCirclePaint);
                } else {
                    canvas.drawCircle(centerX, centerY, radius, mCirclePaint);
                }
            }
            switch (mInnerType) {
                case NORMAL: {
                    switch2Circle();
                    float radius = mCircleWidth / 2.0f;
                    if (mSelectUseFrame) {
                        radius -= mFrameStrokeWidth;
                    }
                    if (mSelectUseOutline) {
                        radius -= mOutlineStrokeWidth;
                    }
                    canvas.drawCircle(centerX, centerY, radius, mCirclePaint);
                }
                break;
                case INNER: {
                    if (mInnerStrokeWidth < 0) {
                        throw new IllegalArgumentException(TAG + " mInnerStrokeWidth should greater than zero.");
                    }
                    if (mInnerStrokeDividerWidth < 0) {
                        throw new IllegalArgumentException(TAG + " mInnerStrokeDividerWidth should greater than zero.");
                    }
                    switch2Inner();
                    float innerRadius = mCircleWidth / 2.0f - mInnerStrokeWidth / 2.0f;
                    if (mSelectUseFrame) {
                        innerRadius -= mFrameStrokeWidth;
                    }
                    if (mSelectUseOutline) {
                        innerRadius -= mOutlineStrokeWidth;
                    }
                    innerRadius -= mInnerStrokeDividerWidth;
                    canvas.drawCircle(centerX, centerY, innerRadius, mCirclePaint);
                    //绘制中心圆形
                    switch2Circle();
                    float radius = mCircleWidth / 2.0f - mInnerStrokeWidth;
                    if (mSelectUseFrame) {
                        radius -= mFrameStrokeWidth;
                    }
                    if (mSelectUseOutline) {
                        radius -= mOutlineStrokeWidth;
                    }
                    radius -= mInnerStrokeDividerWidth;
                    canvas.drawCircle(centerX, centerY, radius, mCirclePaint);
                }
                break;
                case TICK: {
                    if (mTickBackgroundDividerWidth < 0) {
                        throw new IllegalArgumentException(TAG + " mTickBackgroundDividerWidth should greater than zero.");
                    }
                    switch2Circle();
                    float radius = mCircleWidth / 2.0f;
                    if (mSelectUseFrame) {
                        radius -= mFrameStrokeWidth;
                    }
                    if (mSelectUseOutline) {
                        radius -= mOutlineStrokeWidth;
                    }
                    canvas.drawCircle(centerX, centerY, radius, mCirclePaint);
                    //绘制对勾圆形背景
                    switch2TickBackground();
                    float tickRadius = radius - mTickBackgroundDividerWidth;
                    canvas.drawCircle(centerX, centerY, tickRadius, mCirclePaint);
                    if (mTickStrokeWidth < 0) {
                        throw new IllegalArgumentException(TAG + " mTickStrokeWidth should greater than zero.");
                    }
                    //绘制对勾
                    switch2TickStroke();
                    float tickWidth = 2 * tickRadius;
                    float tickHeight = 2 * tickRadius;
                    float space = (mCircleWidth - tickWidth) / 2;
                    float startX = tickWidth / 4.0f + space;
                    float startY = tickHeight / 2.0f + space;
                    float endX = 3 * tickWidth / 8.0f + space;
                    float endY = 5 * tickHeight / 8.0f + space;
                    canvas.drawLine(startX, startY, endX, endY, mCirclePaint);
                    float endX2 = 3 * tickWidth / 4.0f + space;
                    float endY2 = 3 * tickHeight / 8.0f + space;
                    canvas.drawLine(endX, endY, endX2, endY2, mCirclePaint);
                }
                break;
            }
        } else {
            float radius = mCircleWidth / 2.0f;
            if (mNormalUseOutline) {
                if (mOutlineStrokeWidth < 0) {
                    throw new IllegalArgumentException(TAG + " mOutlineStrokeWidth should greater than zero.");
                }
                switch2Outline();
                radius -= mOutlineStrokeWidth / 2.0f;
                canvas.drawCircle(centerX, centerY, radius, mCirclePaint);
                radius -= mOutlineStrokeWidth / 2.0f;
            }
            switch2Circle();
            canvas.drawCircle(centerX, centerY, radius, mCirclePaint);
        }
    }

    public void setCircleSelected(boolean circleSelected) {
        mCircleSelected = circleSelected;
        invalidate();
    }

    public void setInnerType(InnerType innerType) {
        if (innerType == null) {
            throw new NullPointerException();
        }
        if (mInnerType != innerType) {
            mInnerType = innerType;
            requestLayout();
            invalidate();
        }
    }

    public InnerType getInnerType() {
        return mInnerType;
    }

    public int getCircleColor() {
        return mCircleColor;
    }

    public void setCircleColor(int circleColor) {
        mCircleColor = circleColor;
        invalidate();
    }

    public boolean isCircleSelected() {
        return mCircleSelected;
    }

    public float getFrameCornerRadius() {
        return mFrameCornerRadius;
    }

    public void setFrameCornerRadius(float frameCornerRadius) {
        mFrameCornerRadius = frameCornerRadius;
        invalidate();
    }

    public int getFrameStrokeColor() {
        return mFrameStrokeColor;
    }

    public void setFrameStrokeColor(int frameStrokeColor) {
        mFrameStrokeColor = frameStrokeColor;
        invalidate();
    }

    public float getFrameStrokeWidth() {
        return mFrameStrokeWidth;
    }

    public void setFrameStrokeWidth(float frameStrokeWidth) {
        if (frameStrokeWidth < 0) {
            throw new IllegalArgumentException(TAG + " mFrameStrokeWidth should greater than zero.");
        }
        mFrameStrokeWidth = frameStrokeWidth;
        invalidate();
    }

    public int getInnerStrokeColor() {
        return mInnerStrokeColor;
    }

    public void setInnerStrokeColor(int innerStrokeColor) {
        mInnerStrokeColor = innerStrokeColor;
        invalidate();
    }

    public float getInnerStrokeDividerWidth() {
        return mInnerStrokeDividerWidth;
    }

    public void setInnerStrokeDividerWidth(float innerStrokeDividerWidth) {
        if (innerStrokeDividerWidth < 0) {
            throw new IllegalArgumentException(TAG + " mInnerStrokeDividerWidth should greater than zero.");
        }
        mInnerStrokeDividerWidth = innerStrokeDividerWidth;
        invalidate();
    }

    public float getInnerStrokeWidth() {
        return mInnerStrokeWidth;
    }

    public void setInnerStrokeWidth(float innerStrokeWidth) {
        if (innerStrokeWidth < 0) {
            throw new IllegalArgumentException(TAG + " mInnerStrokeWidth should greater than zero.");
        }
        mInnerStrokeWidth = innerStrokeWidth;
        invalidate();
    }

    public boolean isNormalUseOutline() {
        return mNormalUseOutline;
    }

    public void setNormalUseOutline(boolean normalUseOutline) {
        mNormalUseOutline = normalUseOutline;
        invalidate();
    }

    public boolean isSelectUseFrame() {
        return mSelectUseFrame;
    }

    public void setSelectUseFrame(boolean selectUseFrame) {
        mSelectUseFrame = selectUseFrame;
        invalidate();
    }

    public boolean isSelectUseOutline() {
        return mSelectUseOutline;
    }

    public void setSelectUseOutline(boolean selectUseOutline) {
        mSelectUseOutline = selectUseOutline;
        invalidate();
    }

    public int getOutlineStrokeColor() {
        return mOutlineStrokeColor;
    }

    public void setOutlineStrokeColor(int outlineStrokeColor) {
        mOutlineStrokeColor = outlineStrokeColor;
        invalidate();
    }

    public float getOutlineStrokeWidth() {
        return mOutlineStrokeWidth;
    }

    public void setOutlineStrokeWidth(float outlineStrokeWidth) {
        if (outlineStrokeWidth < 0) {
            throw new IllegalArgumentException(TAG + " mOutlineStrokeWidth should greater than zero.");
        }
        mOutlineStrokeWidth = outlineStrokeWidth;
        invalidate();
    }

    public int getTickBackgroundColor() {
        return mTickBackgroundColor;
    }

    public void setTickBackgroundColor(int tickBackgroundColor) {
        mTickBackgroundColor = tickBackgroundColor;
        invalidate();
    }

    public float getTickBackgroundDividerWidth() {
        return mTickBackgroundDividerWidth;
    }

    public void setTickBackgroundDividerWidth(float tickBackgroundDividerWidth) {
        if (tickBackgroundDividerWidth < 0) {
            throw new IllegalArgumentException(TAG + " mTickBackgroundDividerWidth should greater than zero.");
        }
        mTickBackgroundDividerWidth = tickBackgroundDividerWidth;
        invalidate();
    }

    public int getTickStrokeColor() {
        return mTickStrokeColor;
    }

    public void setTickStrokeColor(int tickStrokeColor) {
        mTickStrokeColor = tickStrokeColor;
        invalidate();
    }

    public float getTickStrokeWidth() {
        return mTickStrokeWidth;
    }

    public void setTickStrokeWidth(float tickStrokeWidth) {
        if (tickStrokeWidth < 0) {
            throw new IllegalArgumentException(TAG + " mTickStrokeWidth should greater than zero.");
        }
        mTickStrokeWidth = tickStrokeWidth;
        invalidate();
    }

    public void setCircleColorModel(CircleColorModel circleColorModel) {
        if (null == circleColorModel) {
            throw new NullPointerException();
        }
        float circleWidth = circleColorModel.getCircleWidth();
        this.mCircleWidth = circleWidth <= 0 ? this.mCircleWidth : circleWidth;
        float circleHeight = circleColorModel.getCircleHeight();
        this.mCircleHeight = circleHeight <= 0 ? this.mCircleHeight : circleHeight;
        int circleColor = circleColorModel.getCircleColor();
        this.mCircleColor = circleColor;
        boolean circleSelected = circleColorModel.isCircleSelected();
        this.mCircleSelected = circleSelected;
        boolean selectUseOutline = circleColorModel.isSelectUseOutline();
        this.mSelectUseOutline = selectUseOutline;
        boolean normalUseOutline = circleColorModel.isNormalUseOutline();
        this.mNormalUseOutline = normalUseOutline;
        float outlineStrokeWidth = circleColorModel.getOutlineStrokeWidth();
        this.mOutlineStrokeWidth = outlineStrokeWidth < 0 ? this.mOutlineStrokeWidth : outlineStrokeWidth;
        int outlineStrokeColor = circleColorModel.getOutlineStrokeColor();
        this.mOutlineStrokeColor = outlineStrokeColor;
        boolean selectUseFrame = circleColorModel.isSelectUseFrame();
        this.mSelectUseFrame = selectUseFrame;
        float frameStrokeWidth = circleColorModel.getFrameStrokeWidth();
        this.mFrameStrokeWidth = frameStrokeWidth < 0 ? this.mFrameStrokeWidth : frameStrokeWidth;
        int frameStrokeColor = circleColorModel.getFrameStrokeColor();
        this.mFrameStrokeColor = frameStrokeColor;
        int frameCornerRadius = circleColorModel.getFrameCornerRadius();
        this.mFrameCornerRadius = frameCornerRadius < 0 ? this.mFrameCornerRadius : frameCornerRadius;
        InnerType innerType = circleColorModel.getInnerType();
        this.mInnerType = innerType == null ? this.mInnerType : innerType;
        float innerStrokeWidth = circleColorModel.getInnerStrokeWidth();
        this.mInnerStrokeWidth = innerStrokeWidth < 0 ? this.mInnerStrokeWidth : innerStrokeWidth;
        int innerStrokeColor = circleColorModel.getInnerStrokeColor();
        this.mInnerStrokeColor = innerStrokeColor;
        float innerStrokeDividerWidth = circleColorModel.getInnerStrokeDividerWidth();
        this.mInnerStrokeDividerWidth = innerStrokeDividerWidth < 0 ? this.mInnerStrokeDividerWidth : innerStrokeDividerWidth;
        float tickStrokeWidth = circleColorModel.getTickStrokeWidth();
        this.mTickStrokeWidth = tickStrokeWidth < 0 ? this.mTickStrokeWidth : tickStrokeWidth;
        int tickStrokeColor = circleColorModel.getTickStrokeColor();
        this.mTickStrokeColor = tickStrokeColor;
        float tickBackgroundDividerWidth = circleColorModel.getTickBackgroundDividerWidth();
        this.mTickBackgroundDividerWidth = tickBackgroundDividerWidth < 0 ? this.mTickBackgroundDividerWidth : tickBackgroundDividerWidth;
        int tickBackgroundColor = circleColorModel.getTickBackgroundColor();
        this.mTickBackgroundColor = tickBackgroundColor;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            mCircleWidth = widthSize;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mCircleHeight = heightSize;
        }
        float min = Math.min(mCircleWidth, mCircleHeight);
        mCircleWidth = mCircleHeight = min;
        setMeasuredDimension((int) mCircleWidth, (int) mCircleHeight);
    }

    public enum InnerType {
        NORMAL(0),
        INNER(1),
        TICK(2);

        InnerType(int i) {
            nativeInt = i;
        }

        int nativeInt;
    }
}
