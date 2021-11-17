package com.zhuelise.lab08drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DrawView extends View {
    Paint paint = new Paint();
    int width;
    int height;
    int dy = 0;

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();
        //DIMENSIONS: 2280 x 1080 pixels
        //make background
        drawBackground(canvas, paint);
        //draw tree
        drawTree(canvas, paint);
        //draw flowers
        dy+=20;
            //draw flowers on tree
            for (int k = 0; k < 250; k++) {
                int x = (int) (Math.random() * (1300) + 400);
                int y = (int) (Math.random() * (800) + 330) +dy;
                if (Math.sqrt((790 - x) * (790 - x) + (575 + dy - y) * (575 +dy - y)) < 500 && y>0) {
                    drawFlower(canvas, paint, x, y);
                }
                else if(y>0)
                    drawFlower(canvas, paint, x, height-(int)(Math.random() * 20 + 1));
            }
        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        invalidate();
    }

    private void drawFlower(Canvas canvas, Paint paint, int x, int y) {
        paint.setColor(0xffffd6f3);
        int a = (int)(Math.random()*10+1);
        if(a<4)
            paint.setColor(0xffffe8f8);
        if(a>8)
            paint.setColor(0xffedafdb);
        for (int k = 0; k < 5; k++) {
            canvas.save();
            canvas.drawOval(x - 7, y, x + 7, y - 20, paint);
            canvas.rotate(72, x, y);
        }
        paint.setColor(0xff536344);
        if(a<4)
            paint.setColor(0xff7b8c6b);
        if(a>8)
            paint.setColor(0xff455735);
        canvas.drawCircle(x, y, 5, paint);
    }

    private void drawBackground(Canvas canvas, Paint paint){
        Paint a = new Paint();
        a.setShader(new LinearGradient(0, 0, width, height, 0xffa1dae6, 0xff8fadcc, Shader.TileMode.MIRROR));
        canvas.drawRect(0, 0, width, height/2, a);
        //make ground
        paint.setColor(0xffa1e6bd);
        canvas.drawRect(0, (height) / 2, width, height, paint);
        //make clouds
        paint.setColor(0xffc9edf5);
        canvas.drawCircle(0, 200, 75, paint);
        canvas.drawCircle(75, 250, 75, paint);
        canvas.drawCircle(190, 260, 100, paint);
        canvas.drawCircle(270, 300, 75, paint);
        canvas.drawCircle(300, 330, 75, paint);
        canvas.drawCircle(360, 350, 75, paint);
        canvas.drawCircle(440, 370, 50, paint);
        canvas.drawCircle(100, 300, 75, paint);
        canvas.drawCircle(200, 330, 75, paint);
        paint.setColor(0xffbbe5f0);
        canvas.drawCircle(600, 600, 75, paint);
        canvas.drawCircle(675, 650, 75, paint);
        canvas.drawCircle(790, 660, 100, paint);
        canvas.drawCircle(870, 700, 75, paint);
        canvas.drawCircle(900, 730, 75, paint);
        canvas.drawCircle(960, 750, 75, paint);
        canvas.drawCircle(1040, 770, 50, paint);
        canvas.drawCircle(700, 700, 75, paint);
        canvas.drawCircle(800, 730, 75, paint);
        canvas.drawCircle(550, 640, 50, paint);
        canvas.drawCircle(520, 680, 50, paint);
        canvas.drawCircle(570, 700, 75, paint);
        //make river
        paint.setColor(0xff6abdc4);
        canvas.drawRect((width / 2) - 100, height, (width / 2) + 100, height / 2, paint);
        //left side of river
        Path leftRiver = new Path();
        leftRiver.moveTo((float) ((width / 2) - 100), height / 2);
        leftRiver.lineTo((float) ((width / 2) - 100), height);
        leftRiver.lineTo((float) ((width / 4) - 100), height);
        leftRiver.lineTo((float) ((width / 2) - 100), height / 2);
        leftRiver.close();
        canvas.drawPath(leftRiver, paint);
        //right side of river
        Path rightRiver = new Path();
        rightRiver.moveTo((float) ((width / 2) + 100), height / 2);
        rightRiver.lineTo((float) ((width / 2) + 100), height);
        rightRiver.lineTo((float) (3 * (width / 4) + 100), height);
        rightRiver.lineTo((float) ((width / 2) + 100), height / 2);
        rightRiver.close();
        canvas.drawPath(rightRiver, paint);
    }

    private void drawTree(Canvas canvas, Paint paint){
        //draw trunk
        paint.setColor(0xff5c3411);
        Path treeTrunk = new Path();
        treeTrunk.moveTo(width - 50, height);
        treeTrunk.lineTo(width - 70, height - 150);
        treeTrunk.lineTo(width - 70, height - 200);
        treeTrunk.lineTo(width - 80, height - 250);
        treeTrunk.lineTo(width - 110, height - 300);
        treeTrunk.lineTo(width - 110, height - 350);
        treeTrunk.lineTo(width - 120, height - 550);
        treeTrunk.lineTo(width - 118, height - 600);
        treeTrunk.lineTo(width - 155, height - 700);
        treeTrunk.lineTo(width - 200, height - 850);
        treeTrunk.lineTo(width - 230, height - 950);
        treeTrunk.lineTo(width - 245, height - 1000);
        treeTrunk.lineTo(width - 270, height - 1100);
        treeTrunk.lineTo(width - 320, height - 1200);
        treeTrunk.lineTo(width - 400, height - 1300);
        treeTrunk.lineTo(width - 500, height - 1375);
        treeTrunk.lineTo(width - 600, height - 1350);
        treeTrunk.lineTo(width - 500, height - 1400);
        treeTrunk.lineTo(width - 600, height - 1450);
        treeTrunk.lineTo(width - 400, height - 1350);
        treeTrunk.lineTo(width - 300, height - 1250);
        treeTrunk.lineTo(width - 270, height - 1200);
        treeTrunk.lineTo(width - 140, height - 900);
        treeTrunk.lineTo(width - 40, height - 600);
        treeTrunk.lineTo(width - 30, height - 500);
        treeTrunk.lineTo(width, height - 300);
        treeTrunk.lineTo(width, height - 50);
        treeTrunk.lineTo(width, height);
        treeTrunk.close();
        canvas.drawPath(treeTrunk, paint);
        //draw large branch from bottom of trunk
        Path branch1 = new Path();
        branch1.moveTo(width - 150, height - 750);
        branch1.lineTo(width - 220, height - 750);
        branch1.lineTo(width - 260, height - 775);
        branch1.lineTo(width - 300, height - 800);
        branch1.lineTo(width - 350, height - 825);
        branch1.lineTo(width - 450, height - 800);
        branch1.lineTo(width - 500, height - 790);
        branch1.lineTo(width - 600, height - 825);
        branch1.lineTo(width - 700, height - 850);
        branch1.lineTo(width - 800, height - 825);
        branch1.lineTo(width - 700, height - 875);
        branch1.lineTo(width - 600, height - 850);
        branch1.lineTo(width - 500, height - 830);
        branch1.lineTo(width - 450, height - 840);
        branch1.lineTo(width - 400, height - 850);
        branch1.lineTo(width - 300, height - 850);
        branch1.lineTo(width - 220, height - 800);
        branch1.lineTo(width - 150, height - 820);
        canvas.drawPath(branch1, paint);
        //draw small branch from top of large branch above
        branch1.moveTo(width - 325, height - 825);
        branch1.lineTo(width - 400, height - 900);
        branch1.lineTo(width - 500, height - 925);
        branch1.lineTo(width - 550, height - 1000);
        branch1.lineTo(width - 600, height - 1100);
        branch1.lineTo(width - 700, height - 1150);
        branch1.lineTo(width - 575, height - 1125);
        branch1.lineTo(width - 500, height - 980);
        branch1.lineTo(width - 400, height - 950);
        branch1.lineTo(width - 275, height - 825);
        canvas.drawPath(branch1, paint);
        //draw branch small branch from top of trunk
        branch1.moveTo(width - 240, height - 1140);
        branch1.lineTo(width - 350, height - 1100);
        branch1.lineTo(width - 400, height - 1150);
        branch1.lineTo(width - 500, height - 1170);
        branch1.lineTo(width - 600, height - 1250);
        branch1.lineTo(width - 500, height - 1200);
        branch1.lineTo(width - 360, height - 1170);
        branch1.lineTo(width - 340, height - 1150);
        branch1.lineTo(width - 260, height - 1180);
        canvas.drawPath(branch1, paint);
        //draw large branch from right side of trunk
        branch1.moveTo(width - 140, height - 900);
        branch1.lineTo(width - 80, height - 1000);
        branch1.lineTo(width - 70, height - 1200);
        branch1.lineTo(width - 70, height - 1250);
        branch1.lineTo(width - 30, height - 1400);
        branch1.lineTo(width - 90, height - 1300);
        branch1.lineTo(width - 100, height - 1200);
        branch1.lineTo(width - 120, height - 1000);
        branch1.lineTo(width - 200, height - 940);
        canvas.drawPath(branch1, paint);
        //draw small branch from left of branch above
        branch1.moveTo(width - 90, height - 1200);
        branch1.lineTo(width - 150, height - 1250);
        branch1.lineTo(width - 170, height - 1370);
        branch1.lineTo(width - 220, height - 1450);
        branch1.lineTo(width - 340, height - 1470);
        branch1.lineTo(width - 240, height - 1420);
        branch1.lineTo(width - 190, height - 1340);
        branch1.lineTo(width - 192, height - 1250);
        branch1.lineTo(width - 160, height - 1200);
        branch1.lineTo(width - 75, height - 1140);
        canvas.drawPath(branch1, paint);
    }
}
