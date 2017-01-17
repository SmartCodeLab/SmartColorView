package com.smart.colorview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.smart.colorview.R;

/**
 * 对勾的形状
 * Created by fengjh on 16/12/22.
 */

public class TickView extends View {

    private Paint mTickPaint;
    private int mTickWidth = 80;
    private int mTickHeight = 80;
    private int mTickStrokeWidth = 6;
    private int mTickStrokeColor = 0xffffffff;
    private int mTickBackgroundColor = 0xffdddddd;

    public TickView(Context context) {
        this(context, null);
    }

    public TickView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TickView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TickView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TickView, defStyleAttr, defStyleRes);
        if (attributes != null) {
            int count = attributes.getIndexCount();
            for (int i = 0; i < count; i++) {
                int index = attributes.getIndex(i);
                if (index == R.styleable.TickView_tickViewStrokeWidth) {
                    mTickStrokeWidth = attributes.getDimensionPixelSize(R.styleable.TickView_tickViewStrokeWidth, mTickStrokeWidth);
                } else if (index == R.styleable.TickView_tickViewStrokeColor) {
                    mTickStrokeColor = attributes.getColor(R.styleable.TickView_tickViewStrokeColor, mTickStrokeColor);
                } else if (index == R.styleable.TickView_tickViewBackgroundColor) {
                    mTickBackgroundColor = attributes.getColor(R.styleable.TickView_tickViewBackgroundColor, mTickBackgroundColor);
                }
            }
            attributes.recycle();
        }
        mTickPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTickPaint.setAntiAlias(true);
        mTickPaint.setStyle(Paint.Style.FILL);
    }

    public TickView(Context context, int tickWidth, int tickHeight, int tickStrokeWidth, int tickStrokeColor, int tickBackgroundColor) {
        super(context);
        this.mTickWidth = tickWidth;
        this.mTickHeight = tickHeight;
        this.mTickStrokeWidth = tickStrokeWidth;
        this.mTickStrokeColor = tickStrokeColor;
        this.mTickBackgroundColor = tickBackgroundColor;
        invalidate();
    }

    private void switch2Background() {
        mTickPaint.setColor(mTickBackgroundColor);
    }

    private void switch2Tick() {
        mTickPaint.setColor(mTickStrokeColor);
        mTickPaint.setStrokeWidth(mTickStrokeWidth);
        mTickPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch2Background();
        canvas.drawCircle(mTickWidth / 2, mTickHeight / 2, mTickWidth / 2, mTickPaint);
        switch2Tick();
        float startX = mTickWidth / 4.0f;
        float startY = mTickHeight / 2.0f;
        float endX = 3 * mTickWidth / 8.0f;
        float endY = 5 * mTickHeight / 8.0f;
        canvas.drawLine(startX, startY, endX, endY, mTickPaint);
        float endX2 = 3 * mTickWidth / 4.0f;
        float endY2 = 3 * mTickHeight / 8.0f;
        canvas.drawLine(endX, endY, endX2, endY2, mTickPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            mTickWidth = widthSize;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mTickHeight = heightSize;
        }
        int max = Math.max(mTickWidth, mTickHeight);
        mTickWidth = mTickHeight = max;
        setMeasuredDimension(mTickWidth, mTickHeight);
    }

    public void setTickBackgroundColor(int tickBackgroundColor) {
        mTickBackgroundColor = tickBackgroundColor;
        invalidate();
    }

    public void setTickHeight(int tickHeight) {
        mTickHeight = tickHeight;
        invalidate();
    }

    public void setTickStrokeColor(int tickStrokeColor) {
        mTickStrokeColor = tickStrokeColor;
        invalidate();
    }

    public void setTickStrokeWidth(int tickStrokeWidth) {
        mTickStrokeWidth = tickStrokeWidth;
        invalidate();
    }

    public void setTickWidth(int tickWidth) {
        mTickWidth = tickWidth;
        invalidate();
    }
}
