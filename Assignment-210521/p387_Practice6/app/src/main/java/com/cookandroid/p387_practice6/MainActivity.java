package com.cookandroid.p387_practice6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.drawable.GradientDrawable.RECTANGLE;

public class MainActivity extends AppCompatActivity {
    final static int LINE = 1, CIRCLE = 2;
    static int curShape = LINE;
    static int curColor = Color.DKGRAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("간단 그림판");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        menu.add(0, 3, 0, "사각형 그리기");
        SubMenu sMenu = menu.addSubMenu("색상 변경 >>");
        sMenu.add(0, 4, 0, "빨강");
        sMenu.add(0, 5, 0, "초록");
        sMenu.add(0, 6, 0, "파랑");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                curShape = LINE; // 선
                return true;
            case 2:
                curShape = CIRCLE; // 원
                return true;
            case 3:
                curShape = RECTANGLE; // 사각형
                return true;
            case 4:
                curColor = Color.RED;
                return true;
            case 5:
                curColor = Color.GREEN;
                return true;
            case 6:
                curColor = Color.BLUE;
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View {
        static List<MyShape> myshape = new ArrayList<MyShape>();
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        int i = 0;
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int)event.getX();
                    startY = (int)event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    stopX = (int)event.getX();
                    stopY = (int)event.getY();
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    stopX = (int)event.getX();
                    stopY = (int)event.getY();
                    myshape.add(new MyShape(curShape, startX, startY, stopX, stopY, curColor));
                    this.invalidate();
                    break;
            }
            return true;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(curColor);

            // 도형 남기기
            for(int i=0; i < myshape.size(); i++) {
                paint.setColor(myshape.get(i).curColor);
                switch(myshape.get(i).curShape) {
                    case LINE:
                        canvas.drawLine(myshape.get(i).startX, myshape.get(i).startY, myshape.get(i).stopX, myshape.get(i).stopY, paint);
                        break;
                    case CIRCLE:
                        int radius = (int)Math.sqrt(Math.pow(myshape.get(i).stopX - myshape.get(i).startX, 2) + Math.pow(myshape.get(i).stopY - myshape.get(i).startY, 2));
                        canvas.drawCircle(myshape.get(i).startX, myshape.get(i).startY, radius, paint);
                        break;
                    case RECTANGLE:
                        Rect rect = new Rect(myshape.get(i).startX, myshape.get(i).startY, myshape.get(i).stopX, myshape.get(i).stopY);
                        canvas.drawRect(rect, paint);
                        break;
                }
            }

            switch(curShape) {
                case LINE:
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int)Math.sqrt(Math.pow(stopX - startX, 2) + Math.pow(stopY - startY, 2));
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
                case RECTANGLE:
                    Rect rect = new Rect(startX, startY, stopX, stopY);
                    canvas.drawRect(rect, paint);
                    break;
            }
        }
    }

    private static class MyShape {
        int curShape;
        int startX, startY, stopX, stopY;
        int curColor;

        public MyShape(int curShape, int startX, int startY, int stopX, int stopY, int curColor) {
            this.curShape = curShape;
            this.startX = startX;
            this.startY = startY;
            this.stopX = stopX;
            this.stopY = stopY;
            this.curColor = curColor;
        }
    }



}