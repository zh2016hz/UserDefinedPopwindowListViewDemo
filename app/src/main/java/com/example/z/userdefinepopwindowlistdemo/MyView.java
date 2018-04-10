package com.example.z.userdefinepopwindowlistdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by z on 2018/4/10.
 */

public class MyView extends View {


    private final RectF mR;
    private Paint mPaint;
    private int mProgress;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
        // 锯齿状去除
        mPaint.setAntiAlias(true);

        mR = new RectF(5, 5, 185, 185);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(1,1,111,111,mPaint);
        float sweepAngle = (mProgress / 100f) * 360;
        canvas.drawArc(mR, -90, sweepAngle, false, mPaint);

    }

    public void setProgress(int progress) {
        mProgress = progress;
//        invalidate();
            postInvalidate();
    }
}
