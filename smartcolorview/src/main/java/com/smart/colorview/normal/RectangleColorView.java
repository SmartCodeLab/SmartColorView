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
import com.smart.colorview.normal.model.RectangleColorModel;

/**
 * Created by fengjh on 16/12/27.
 */

public class RectangleColorView extends View {

    private static final String TAG = RectangleColorView.class.getName();

    private Paint mRectanglePaint;
    private float mRectangleWidth = 150;
    private float mRectangleHeight = 150;
    private int mRectangleColor = 0xfff53b53;
    private float mRectangleCornerRadius = 0;
    private float mRectOutlineStrokeWidth = 8;
    private int mRectOutlineStrokeColor = 0xff0000ff;
    private float mRectTickStrokeWidth = 4;
    private int mRectTickStrokeColor = 0xffffffff;
    private int mRectTickBackgroundColor = 0xffdddddd;
    private TickDirection mTickDirection = TickDirection.RIGHT_BOTTOM;
    private boolean mRectSelected = false;
    private boolean mRectShowTick = true;
    private TickType mTickType = TickType.AUTO;
    private float mRectTickWidth = 0;
    private float mRectTickHeight = 0;

    private TickDirection[] mTickDirectionArray = {
            TickDirection.LEFT_TOP,
            TickDirection.RIGHT_TOP,
            TickDirection.LEFT_BOTTOM,
            TickDirection.RIGHT_BOTTOM,
            TickDirection.CENTER
    };

    private TickType[] mTickTypeArray = {
            TickType.AUTO,
            TickType.CUSTOM
    };

    public RectangleColorView(Context context) {
        this(context, null);
    }

    public RectangleColorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectangleColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RectangleColorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RectangleColorView, defStyleAttr, defStyleRes);
        if (attributes != null) {
            int count = attributes.getIndexCount();
            for (int i = 0; i < count; i++) {
                int index = attributes.getIndex(i);
                if (index == R.styleable.RectangleColorView_rectangleColor) {
                    mRectangleColor = attributes.getColor(R.styleable.RectangleColorView_rectangleColor, mRectangleColor);
                } else if (index == R.styleable.RectangleColorView_rectangleSelected) {
                    mRectSelected = attributes.getBoolean(R.styleable.RectangleColorView_rectangleSelected, mRectSelected);
                } else if (index == R.styleable.RectangleColorView_rectangleCornerRadius) {
                    mRectangleCornerRadius = attributes.getDimension(R.styleable.RectangleColorView_rectangleCornerRadius, mRectangleCornerRadius);
                } else if (index == R.styleable.RectangleColorView_rectOutlineStrokeWidth) {
                    mRectOutlineStrokeWidth = attributes.getDimension(R.styleable.RectangleColorView_rectOutlineStrokeWidth, mRectOutlineStrokeWidth);
                } else if (index == R.styleable.RectangleColorView_rectOutlineStrokeColor) {
                    mRectOutlineStrokeColor = attributes.getColor(R.styleable.RectangleColorView_rectOutlineStrokeColor, mRectOutlineStrokeColor);
                } else if (index == R.styleable.RectangleColorView_rectTickDirection) {
                    int direction = attributes.getInt(R.styleable.RectangleColorView_rectTickDirection, -1);
                    if (direction >= 0) {
                        setTickDirection(mTickDirectionArray[direction]);
                    }
                } else if (index == R.styleable.RectangleColorView_rectTickStrokeWidth) {
                    mRectTickStrokeWidth = attributes.getDimension(R.styleable.RectangleColorView_rectTickStrokeWidth, mRectTickStrokeWidth);
                } else if (index == R.styleable.RectangleColorView_rectTickStrokeColor) {
                    mRectTickStrokeColor = attributes.getColor(R.styleable.RectangleColorView_rectTickStrokeColor, mRectTickStrokeColor);
                } else if (index == R.styleable.RectangleColorView_rectTickBackgroundColor) {
                    mRectTickBackgroundColor = attributes.getColor(R.styleable.RectangleColorView_rectTickBackgroundColor, mRectTickBackgroundColor);
                } else if (index == R.styleable.RectangleColorView_rectShowTick) {
                    mRectShowTick = attributes.getBoolean(R.styleable.RectangleColorView_rectShowTick, mRectShowTick);
                } else if (index == R.styleable.RectangleColorView_rectTickType) {
                    int type = attributes.getInt(R.styleable.RectangleColorView_rectTickType, -1);
                    if (type >= 0) {
                        setTickType(mTickTypeArray[type]);
                    }
                } else if (index == R.styleable.RectangleColorView_rectTickWidth) {
                    mRectTickWidth = attributes.getDimension(R.styleable.RectangleColorView_rectTickWidth, mRectTickWidth);
                } else if (index == R.styleable.RectangleColorView_rectTickHeight) {
                    mRectTickHeight = attributes.getDimension(R.styleable.RectangleColorView_rectTickHeight, mRectTickHeight);
                }
            }
            attributes.recycle();
        }
        mRectanglePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRectanglePaint.setAntiAlias(true);
    }

    private void switch2Rectangle() {
        mRectanglePaint.setStyle(Paint.Style.FILL);
        mRectanglePaint.setColor(mRectangleColor);
        mRectanglePaint.setStrokeWidth(1);
    }

    private void switch2Outline() {
        mRectanglePaint.setStyle(Paint.Style.STROKE);
        mRectanglePaint.setColor(mRectOutlineStrokeColor);
        mRectanglePaint.setStrokeWidth(mRectOutlineStrokeWidth);
    }

    private void switch2TickBackground() {
        mRectanglePaint.setColor(mRectTickBackgroundColor);
        mRectanglePaint.setStyle(Paint.Style.FILL);
    }

    private void switch2TickStroke() {
        mRectanglePaint.setColor(mRectTickStrokeColor);
        mRectanglePaint.setStrokeWidth(mRectTickStrokeWidth);
        mRectanglePaint.setStrokeCap(Paint.Cap.ROUND);
        mRectanglePaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float left = 0;
        float top = 0;
        float right = mRectangleWidth;
        float bottom = mRectangleHeight;
        if (mRectSelected) {
            if (mRectOutlineStrokeWidth < 0) {
                throw new IllegalArgumentException(TAG + " mRectOutlineStrokeWidth should greater than zero.");
            }
            if (mRectangleCornerRadius < 0) {
                throw new IllegalArgumentException(TAG + " mRectangleCornerRadius should greater than zero.");
            }
            if (mRectOutlineStrokeWidth > 0) {
                switch2Outline();
                float outlineLeft = mRectOutlineStrokeWidth / 2.0f;
                float outlineTop = mRectOutlineStrokeWidth / 2.0f;
                float outlineRight = mRectangleWidth - mRectOutlineStrokeWidth / 2.0f;
                float outlineBottom = mRectangleHeight - mRectOutlineStrokeWidth / 2.0f;
                RectF rectF = new RectF(outlineLeft, outlineTop, outlineRight, outlineBottom);
                if (mRectangleCornerRadius == 0) {
                    //绘制正方形边框
                    canvas.drawRect(rectF, mRectanglePaint);
                } else {
                    //绘制圆角正方形边框
                    canvas.drawRoundRect(rectF, mRectangleCornerRadius, mRectangleCornerRadius, mRectanglePaint);
                }
                left += mRectOutlineStrokeWidth;
                top += mRectOutlineStrokeWidth;
                right -= mRectOutlineStrokeWidth;
                bottom -= mRectOutlineStrokeWidth;
            }
            switch2Rectangle();
            RectF rectF = new RectF(left, top, right, bottom);
            if (mRectangleCornerRadius == 0) {
                //绘制正方形
                canvas.drawRect(rectF, mRectanglePaint);
            } else {
                //绘制圆角正方形
                float corner = innerCornerRadius();
                canvas.drawRoundRect(rectF, corner, corner, mRectanglePaint);
            }
            if (mRectTickStrokeWidth < 0) {
                throw new IllegalArgumentException(TAG + " mRectTickStrokeWidth should greater than zero.");
            }
            if (mRectShowTick) {
                //绘制对勾背景
                switch2TickBackground();
                float tickRadius = mRectangleCornerRadius;
                switch (mTickType) {
                    case AUTO:
                        tickRadius = mRectangleCornerRadius;
                        break;
                    case CUSTOM:
                        float min = Math.min(mRectTickWidth, mRectTickHeight);
                        tickRadius = min / 2.0f;
                        break;
                }
                float centerX;
                float centerY;
                switch (mTickDirection) {
                    case LEFT_TOP: {
                        centerX = tickRadius;
                        centerY = tickRadius;
                        canvas.drawCircle(centerX, centerY, tickRadius, mRectanglePaint);
                    }
                    break;
                    case RIGHT_TOP: {
                        centerX = mRectangleWidth - tickRadius;
                        centerY = tickRadius;
                        canvas.drawCircle(centerX, centerY, tickRadius, mRectanglePaint);
                    }
                    break;
                    case LEFT_BOTTOM: {
                        centerX = tickRadius;
                        centerY = mRectangleHeight - tickRadius;
                        canvas.drawCircle(centerX, centerY, tickRadius, mRectanglePaint);
                    }
                    break;
                    case RIGHT_BOTTOM: {
                        centerX = mRectangleWidth - tickRadius;
                        centerY = mRectangleHeight - tickRadius;
                        canvas.drawCircle(centerX, centerY, tickRadius, mRectanglePaint);
                    }
                    break;
                    case CENTER: {
                        centerX = mRectangleWidth / 2.0f;
                        centerY = mRectangleHeight / 2.0f;
                        canvas.drawCircle(centerX, centerY, tickRadius, mRectanglePaint);
                    }
                    break;
                }
                //绘制对勾
                switch2TickStroke();

                float tickWidth = 2 * tickRadius;
                float tickHeight = 2 * tickRadius;
                float space = (tickRadius * 2 - tickWidth) / 2;
                switch (mTickType) {
                    case AUTO:
                        tickWidth = 2 * tickRadius;
                        tickHeight = 2 * tickRadius;
                        space = (tickRadius * 2 - tickWidth) / 2;
                        break;
                    case CUSTOM:
                        tickWidth = mRectTickWidth;
                        tickHeight = mRectTickHeight;
                        float min = Math.min(tickWidth, tickHeight);
                        tickWidth = tickHeight = min;
                        space = 0;
                        break;
                }
                float horizontal = 0;
                float vertical = 0;
                float startX;
                float startY;
                float endX;
                float endY;
                float endX2;
                float endY2;
                switch (mTickDirection) {
                    case LEFT_TOP: {
                        horizontal = 0;
                        vertical = 0;
                    }
                    break;
                    case RIGHT_TOP: {
                        horizontal = mRectangleWidth - tickWidth;
                        vertical = 0;
                    }
                    break;
                    case LEFT_BOTTOM: {
                        horizontal = 0;
                        vertical = mRectangleHeight - tickHeight;
                    }
                    break;
                    case RIGHT_BOTTOM: {
                        horizontal = mRectangleWidth - tickWidth;
                        vertical = mRectangleHeight - tickHeight;
                    }
                    break;
                    case CENTER: {
                        horizontal = mRectangleWidth / 2.0f - tickWidth / 2.0f;
                        vertical = mRectangleHeight / 2.0f - tickHeight / 2.0f;
                    }
                    break;
                }
                startX = tickWidth / 4.0f + space + horizontal;
                startY = tickHeight / 2.0f + space + vertical;
                endX = 3 * tickWidth / 8.0f + space + horizontal;
                endY = 5 * tickHeight / 8.0f + space + vertical;
                canvas.drawLine(startX, startY, endX, endY, mRectanglePaint);
                endX2 = 3 * tickWidth / 4.0f + space + horizontal;
                endY2 = 3 * tickHeight / 8.0f + space + vertical;
                canvas.drawLine(endX, endY, endX2, endY2, mRectanglePaint);
            }
        } else {
            if (mRectangleCornerRadius < 0) {
                throw new IllegalArgumentException(TAG + " mRectangleCornerRadius should greater than zero.");
            }
            switch2Rectangle();
            RectF rectF = new RectF(left, top, right, bottom);
            if (mRectangleCornerRadius == 0) {
                //绘制正方形
                canvas.drawRect(rectF, mRectanglePaint);
            } else {
                //绘制圆角正方形
                canvas.drawRoundRect(rectF, mRectangleCornerRadius, mRectangleCornerRadius, mRectanglePaint);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            mRectangleWidth = widthSize;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mRectangleHeight = heightSize;
        }
        float min = Math.min(mRectangleWidth, mRectangleHeight);
        mRectangleWidth = mRectangleHeight = min;
        setMeasuredDimension((int) mRectangleWidth, (int) mRectangleHeight);
    }


    public void setRectSelected(boolean rectSelected) {
        mRectSelected = rectSelected;
        invalidate();
    }

    public void setTickDirection(TickDirection tickDirection) {
        if (tickDirection == null) {
            throw new NullPointerException();
        }
        if (mTickDirection != tickDirection) {
            mTickDirection = tickDirection;
            requestLayout();
            invalidate();
        }
    }

    public boolean isRectShowTick() {
        return mRectShowTick;
    }

    public void setRectShowTick(boolean rectShowTick) {
        mRectShowTick = rectShowTick;
        invalidate();
    }

    public int getRectangleColor() {
        return mRectangleColor;
    }

    public void setRectangleColor(int rectangleColor) {
        mRectangleColor = rectangleColor;
        invalidate();
    }

    public float getRectangleCornerRadius() {
        return mRectangleCornerRadius;
    }

    public void setRectangleCornerRadius(float rectangleCornerRadius) {
        if (rectangleCornerRadius < 0) {
            throw new IllegalArgumentException(TAG + " mRectangleCornerRadius should greater than zero.");
        }
        mRectangleCornerRadius = rectangleCornerRadius;
        invalidate();
    }

    public int getRectOutlineStrokeColor() {
        return mRectOutlineStrokeColor;
    }

    public void setRectOutlineStrokeColor(int rectOutlineStrokeColor) {
        mRectOutlineStrokeColor = rectOutlineStrokeColor;
        invalidate();
    }

    public float getRectOutlineStrokeWidth() {
        return mRectOutlineStrokeWidth;
    }

    public void setRectOutlineStrokeWidth(float rectOutlineStrokeWidth) {
        if (rectOutlineStrokeWidth < 0) {
            throw new IllegalArgumentException(TAG + " mRectOutlineStrokeWidth should greater than zero.");
        }
        mRectOutlineStrokeWidth = rectOutlineStrokeWidth;
        invalidate();
    }

    public boolean isRectSelected() {
        return mRectSelected;
    }

    public int getRectTickBackgroundColor() {
        return mRectTickBackgroundColor;
    }

    public void setRectTickBackgroundColor(int rectTickBackgroundColor) {
        mRectTickBackgroundColor = rectTickBackgroundColor;
        invalidate();
    }

    public int getRectTickStrokeColor() {
        return mRectTickStrokeColor;
    }

    public void setRectTickStrokeColor(int rectTickStrokeColor) {
        mRectTickStrokeColor = rectTickStrokeColor;
        invalidate();
    }

    public float getRectTickStrokeWidth() {
        return mRectTickStrokeWidth;
    }

    public void setRectTickStrokeWidth(float rectTickStrokeWidth) {
        if (rectTickStrokeWidth < 0) {
            throw new IllegalArgumentException(TAG + " mRectTickStrokeWidth should greater than zero.");
        }
        mRectTickStrokeWidth = rectTickStrokeWidth;
        invalidate();
    }

    public TickDirection getTickDirection() {
        return mTickDirection;
    }

    public void setTickType(TickType tickType) {
        if (null == tickType) {
            throw new NullPointerException();
        }
        if (mTickType != tickType) {
            mTickType = tickType;
            invalidate();
        }
    }

    public float getRectTickHeight() {
        return mRectTickHeight;
    }

    public void setRectTickHeight(float rectTickHeight) {
        if (rectTickHeight < 0) {
            throw new IllegalArgumentException(TAG + " mRectTickHeight should greater than zero.");
        }
        mRectTickHeight = rectTickHeight;
        invalidate();
    }

    public float getRectTickWidth() {
        return mRectTickWidth;
    }

    public void setRectTickWidth(float rectTickWidth) {
        if (rectTickWidth < 0) {
            throw new IllegalArgumentException(TAG + " mRectTickWidth should greater than zero.");
        }
        mRectTickWidth = rectTickWidth;
        invalidate();
    }

    public TickType getTickType() {
        return mTickType;
    }

    public void setRectangleColorModel(RectangleColorModel rectangleColorModel) {
        if (null == rectangleColorModel) {
            throw new NullPointerException();
        }
        float rectangleWidth = rectangleColorModel.getRectangleWidth();
        this.mRectangleWidth = rectangleWidth <= 0 ? this.mRectangleWidth : rectangleWidth;
        float rectangleHeight = rectangleColorModel.getRectangleHeight();
        this.mRectangleHeight = rectangleHeight <= 0 ? this.mRectangleHeight : rectangleHeight;
        int rectangleColor = rectangleColorModel.getRectangleColor();
        this.mRectangleColor = rectangleColor;
        float rectangleColorRadius = rectangleColorModel.getRectangleColorRadius();
        this.mRectangleCornerRadius = rectangleColorRadius < 0 ? this.mRectangleCornerRadius : rectangleColorRadius;
        float rectOutlineStrokeWidth = rectangleColorModel.getRectOutlineStrokeWidth();
        this.mRectOutlineStrokeWidth = rectOutlineStrokeWidth < 0 ? this.mRectangleCornerRadius : rectOutlineStrokeWidth;
        int rectOutlineStrokeColor = rectangleColorModel.getRectOutlineStrokeColor();
        this.mRectOutlineStrokeColor = rectOutlineStrokeColor;
        float rectTickStrokeWidth = rectangleColorModel.getRectTickStrokeWidth();
        this.mRectTickStrokeWidth = rectTickStrokeWidth < 0 ? this.mRectTickStrokeWidth : rectTickStrokeWidth;
        int rectTickStrokeColor = rectangleColorModel.getRectTickStrokeColor();
        this.mRectTickStrokeColor = rectTickStrokeColor;
        int rectTickBackgroundColor = rectangleColorModel.getRectTickBackgroundColor();
        this.mRectTickBackgroundColor = rectTickBackgroundColor;
        TickDirection tickDirection = rectangleColorModel.getTickDirection();
        this.mTickDirection = tickDirection == null ? this.mTickDirection : tickDirection;
        boolean rectSelected = rectangleColorModel.isRectSelected();
        this.mRectSelected = rectSelected;
        boolean rectShowTick = rectangleColorModel.isRectShowTick();
        this.mRectShowTick = rectShowTick;
        TickType tickType = rectangleColorModel.getTickType();
        this.mTickType = tickType == null ? this.mTickType : tickType;
        float rectTickWidth = rectangleColorModel.getRectTickWidth();
        this.mRectTickWidth = rectTickWidth < 0 ? this.mRectTickWidth : rectTickWidth;
        float rectTickHeight = rectangleColorModel.getRectTickHeight();
        this.mRectTickHeight = rectTickHeight < 0 ? this.mRectTickHeight : rectTickHeight;
        invalidate();
    }

    private float innerCornerRadius() {
        double diagonalLength = Math.sqrt((Math.pow(mRectangleWidth, 2) + Math.pow(mRectangleHeight, 2))) - 2.0f * mRectangleCornerRadius * (Math.sqrt(2) - 1.0f);
        float width = mRectangleWidth - mRectOutlineStrokeWidth;
        float height = mRectangleHeight - mRectOutlineStrokeWidth;
        //分子
        double numerator = Math.sqrt((Math.pow(width, 2) + Math.pow(height, 2))) - (diagonalLength - mRectOutlineStrokeWidth);
        //分母
        double denominator = 2 * (Math.sqrt(2) - 1);
        float innerRadius = (float) (numerator / denominator * 1.0f);
        if (innerRadius < 0) {
            innerRadius = 0;
        }
        return innerRadius;
    }

    public enum TickDirection {
        LEFT_TOP(0),
        RIGHT_TOP(1),
        LEFT_BOTTOM(2),
        RIGHT_BOTTOM(3),
        CENTER(4);

        TickDirection(int direction) {
            nativeInt = direction;
        }

        int nativeInt;
    }

    public enum TickType {
        AUTO(0),
        CUSTOM(1);

        TickType(int type) {
            nativeInt = type;
        }

        int nativeInt;
    }
}
