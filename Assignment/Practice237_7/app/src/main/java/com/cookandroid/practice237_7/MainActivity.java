package com.cookandroid.practice237_7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        params.weight = 1;

        LinearLayout baselayout = new LinearLayout(this);
        baselayout.setOrientation(LinearLayout.VERTICAL);
//        baselayout.setBackgroundColor(Color.BLUE);
        setContentView(baselayout, params);



        LinearLayout layout2 = new LinearLayout(this);
        layout2.setOrientation(LinearLayout.HORIZONTAL);
        layout2.setBackgroundColor(Color.RED);
        baselayout.addView(layout2, params);
//        layout1.addView(layout2, params);

        LinearLayout layout3 = new LinearLayout(this);
        layout3.setOrientation(LinearLayout.HORIZONTAL);
        layout3.setBackgroundColor(Color.YELLOW);
        layout2.addView(layout3, params);

        LinearLayout layout4 = new LinearLayout(this);
        layout4.setOrientation(LinearLayout.HORIZONTAL);
        layout4.setBackgroundColor(Color.BLACK);
        layout3.addView(layout4, params);


        LinearLayout layout1 = new LinearLayout(this);
        layout1.setOrientation(LinearLayout.HORIZONTAL);
        layout1.setBackgroundColor(Color.BLUE);
//        setContentView(layout1, params);
        baselayout.addView(layout1, params);

    }
}