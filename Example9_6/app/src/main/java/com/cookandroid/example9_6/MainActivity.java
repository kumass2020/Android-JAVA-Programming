package com.cookandroid.example9_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.jeju14);

            int picX = (this.getWidth() - picture.getWidth() ) / 2;
            int picY = (this.getHeight() - picture.getHeight() ) / 2;

            Paint paint = new Paint();
//            BlurMaskFilter bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
//            BlurMaskFilter bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.INNER);
//            BlurMaskFilter bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.OUTER);
            BlurMaskFilter bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.SOLID);
            paint.setMaskFilter(bMask);

            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();

//            int cenX = this.getWidth() / 2;
//            int cenY = this.getHeight() / 2;
//
////            canvas.rotate(45, cenX, cenY);
////            canvas.translate(-150, 200);
////            canvas.scale(2, 2, cenX, cenY);
//            canvas.skew(0.3f, 0.3f);

            canvas.drawBitmap(picture, picX, picY, null);
            picture.recycle();
        }
    }
}