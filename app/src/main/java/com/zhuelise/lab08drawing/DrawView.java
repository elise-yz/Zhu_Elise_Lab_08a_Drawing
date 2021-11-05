package com.zhuelise.lab08drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    Paint paint = new Paint();

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(0xff446196);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setColor(0xff44967f);
        canvas.drawRect(0, (getHeight()) / 2, getWidth(), getHeight(), paint);
        //canvas.drawRoundRect(200,550, 1300,450, 200, 50,paint);
        //canvas.drawCircle(750, 800, 500, paint);
        paint.setColor(0xffa62929);
        canvas.drawOval(200, 800, 1300, 450, paint);
        paint.setColor(0xff446196);
        canvas.drawRoundRect(200,800,1300,600, 300, 50, paint);
        paint.setColor(0xffded59b);
        //fix this so it touches bottom of red
        canvas.drawRect(700, 1200, 800, 800, paint);
    }
}
