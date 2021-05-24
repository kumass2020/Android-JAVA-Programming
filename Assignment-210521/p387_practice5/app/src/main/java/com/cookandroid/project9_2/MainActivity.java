package com.cookandroid.project9_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.media.Image;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton btnZoomIn, btnZoomOut, btnRotate, btnBright, btnDark, btnGray;

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static float satur = 1;

    MyGraphicView graphicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        LinearLayout pictureLayout = (LinearLayout)findViewById(R.id.pictureLayout);
        graphicView = (MyGraphicView)new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        LinearLayout contextMenu = (LinearLayout)findViewById(R.id.cxtMenuLayout);
        registerForContextMenu(pictureLayout);

//        clickIcons();

        pictureLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                registerForContextMenu(pictureLayout);
                openContextMenu(pictureLayout);
                return true;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 1, 0, "확대");
        menu.add(0, 2, 0, "축소");
        menu.add(0, 3, 0, "회전");
        menu.add(0, 4, 0, "밝게");
        menu.add(0, 5, 0, "어둡게");
        menu.add(0, 6, 0, "그레이영상");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case 1:
                scaleX += 0.2f;
                scaleY += 0.2f;
                graphicView.invalidate();
                break;
            case 2:
                scaleX -= 0.2f;
                scaleY -= 0.2f;
                graphicView.invalidate();
                break;
            case 3:
                angle += 20;
                graphicView.invalidate();
                break;
            case 4:
                color += 0.2f;
                graphicView.invalidate();
                break;
            case 5:
                color -= 0.2f;
                graphicView.invalidate();
                break;
            case 6:
                if (satur == 0) satur = 1;
                else satur = 0;
                graphicView.invalidate();
                break;
        }
        return super.onContextItemSelected(item);
    }



//    private void clickIcons() {
//
//        btnZoomIn = (ImageButton) findViewById(R.id.btnZoomIn);
//        btnZoomIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                scaleX += 0.2f;
//                scaleY += 0.2f;
//                graphicView.invalidate();
//            }
//        });
//
//        btnZoomOut = (ImageButton) findViewById(R.id.btnZoomOut);
//        btnZoomOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                scaleX -= 0.2f;
//                scaleY -= 0.2f;
//                graphicView.invalidate();
//            }
//        });
//
//        btnRotate = (ImageButton)findViewById(R.id.btnRotate);
//        btnRotate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                angle += 20;
//                graphicView.invalidate();
//            }
//        });
//
//        btnBright = (ImageButton)findViewById(R.id.btnBright);
//        btnBright.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                color += 0.2f;
//                graphicView.invalidate();
//            }
//        });
//
//        btnDark = (ImageButton)findViewById(R.id.btnDark);
//        btnDark.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                color -= 0.2f;
//                graphicView.invalidate();
//            }
//        });
//
//        btnGray = (ImageButton)findViewById(R.id.btnGray);
//        btnGray.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (satur == 0) satur = 1;
//                else satur = 0;
//                graphicView.invalidate();
//            }
//        });
//    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();
            float[] array = { color, 0, 0, 0, 0,
                              0, color, 0, 0, 0,
                              0, 0, color, 0, 0,
                              0, 0, 0, 1, 0 };
            ColorMatrix cm = new ColorMatrix(array);
            if (satur == 0) cm.setSaturation(satur);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.rabbit);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();
        }
    }

}