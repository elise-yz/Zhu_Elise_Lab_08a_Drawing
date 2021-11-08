package com.zhuelise.lab08drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
        //DIMENSIONS: 2280 x 1080 pixels
        //make background
        paint.setColor(0xffa1dae6);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        //make ground
        paint.setColor(0xffa1e6bd);
        canvas.drawRect(0, (getHeight()) / 2, getWidth(), getHeight(), paint);
        //make river
        paint.setColor(0xff6abdc4);
        canvas.drawRect((getWidth()/2)-100, getHeight(), (getWidth()/2)+100, getHeight()/2, paint);
        //left side of river
        Path leftRiver = new Path();
        leftRiver.moveTo((float)((getWidth()/2)-100), getHeight()/2);
        leftRiver.lineTo((float)((getWidth()/2)-100), getHeight());
        leftRiver.lineTo((float)((getWidth()/4)-100), getHeight());
        leftRiver.lineTo((float)((getWidth()/2)-100), getHeight()/2);
        leftRiver.close();
        canvas.drawPath(leftRiver, paint);
        //right side of river
        Path rightRiver = new Path();
        rightRiver.moveTo((float)((getWidth()/2)+100), getHeight()/2);
        rightRiver.lineTo((float)((getWidth()/2)+100), getHeight());
        rightRiver.lineTo((float)(3*(getWidth()/4)+100), getHeight());
        rightRiver.lineTo((float)((getWidth()/2)+100), getHeight()/2);
        rightRiver.close();
        canvas.drawPath(rightRiver, paint);
        //draw trunk
        //NOT DONE
        paint.setColor(0xff5c3411);
        Path treeTrunk = new Path();
        treeTrunk.moveTo(getWidth(), getHeight());
        treeTrunk.lineTo(getWidth()-100, getHeight()-150);
        treeTrunk.lineTo(getWidth()-150, getHeight()-200);
        treeTrunk.lineTo(getWidth()-175, getHeight()-250);
        treeTrunk.lineTo(getWidth()-175, getHeight()-300);
        treeTrunk.lineTo(getWidth()-160, getHeight()-350);
        treeTrunk.lineTo(getWidth()-175, getHeight()-550);
        treeTrunk.lineTo(getWidth()-165, getHeight()-600);
        treeTrunk.lineTo(getWidth(), getHeight());
        treeTrunk.close();
        canvas.drawPath(treeTrunk, paint);
    }
}
