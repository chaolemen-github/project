package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
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
        paint = new Paint();//画笔
        paint.setColor(Color.RED);//画笔颜色
        paint.setAntiAlias(true);//去锯齿
        paint.setStrokeWidth(5f);//画笔宽度（粗，细）
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

        //直线
        int startX = 5;
        int startY = 100;
        int stopX = 95;
        int stopY = 100;
        canvas.drawLine(startX, startY, stopX, stopY, paint);

        //圆
        paint.setStyle(Paint.Style.STROKE);//空心圆
        canvas.drawCircle(200, 100, 40, paint);

        //矩形
        path = new Path();
        int x1 = 250, y1 = 5;
        int x2 = 250, y2 = 195;
        int x3 = 350, y3 = 195;
        int x4 = 350, y4 = 5;

        //起始位置
        path.moveTo(x1, y1);
        //连接第一个点和第二个点
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        path.lineTo(x4, y4);
        path.lineTo(x1, y1);
        canvas.drawPath(path, paint);

        //扇形
        RectF rectF = new RectF(400, 50, 500, 150);
        int startAngle = 0;//起始位置
        int sweepAngle = 90;//旋转角度
        boolean useCenter = true;//是否显示边框
        canvas.drawArc(rectF,startAngle,sweepAngle,useCenter,paint);



    }
}
