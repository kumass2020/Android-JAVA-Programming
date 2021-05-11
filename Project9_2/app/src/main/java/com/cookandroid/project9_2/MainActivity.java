package com.cookandroid.project9_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton btnZoomIn, btnZoomout, btnRotate, btnBright, btnDark, btnGray;

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static float satur = 1;

    MyGraphicView graphicView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));

        setTitle("미니 포토샵");

        graphicView = new MyGraphicView(this);

        LinearLayout pictureLayout = (LinearLayout)findViewById(R.id.pictureLayout);
        pictureLayout.addView(graphicView);

        clickIcons();
    }

    private void clickIcons() {

        btnZoomin = (ImageButton)findViewById(R.id.btnZoomin);
        btnZoomIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                scaleX += 0.2f;
                scaleY += 0.2f;
            }
        });

        btnZoomout = (ImageButton)findViewById(R.id.btnZoomout);
        btnZoomout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                scaleX -= 0.2f;
                scaleY -= 0.2f;

                graphicView.invalidate();
            }
        });

        btnRotate = (ImageButton)findViewById(R.id.btnRotate);
        btnRotate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                angle += 20;
                graphicView.
            }
        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.Lena256);

        int cenX = this.getWidth() / 2;
        int cenY = this.getHeight() / 2;

        int picX = (this.getWidth() - picture.getWidth()) / 2;
        int picY = (this.getHeight() - picture.getHeight()) / 2;

        Paint paint = new Paint();

        float[] array = {
                color, 0, 0, 0, -25,
                0, color, 0, 0, -25,
                0, 0, color, 0, -25,
                0, 0, 0, 0.5f, 0,
        }


    }
}