package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class CustomView extends View {

    private Paint paint;
    private Path path;

    public CustomView(Context context) {
        super(context);

    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int startX = 5;
        int startY = 100;
        int stopX = 95;
        int stopY = 100;
        canvas.drawLine(startX, startY, stopX, stopY, paint);
        canvas.drawCircle(200,100,40, paint);

        path = new Path();
        int x1 = 300, y1 = 5;
        int x2 = 400, y2 = 5;
        int x3 = 300, y3 = 195;
        int x4 = 400, y4 = 195;

        path.moveTo(x1, y1);
//连接第一个点和第二个点
        path.lineTo(x2, y2);
        path.lineTo(x4, y4);
        path.lineTo(x3, y3);
        path.lineTo(x1, y1);
        canvas.drawPath(path, paint);
    }
}
