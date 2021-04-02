package com.cookandroid.practice5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );

        setContentView(baseLayout, params);

        EditText et = new EditText(this);
        baseLayout.addView(et);

        Button btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(btn);

        TextView tv = new TextView(this);
        tv.setTextColor(Color.MAGENTA);
        tv.setTextSize(20);
        baseLayout.addView(tv);

        btn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                tv.setText(et.getText().toString());
            }
        });
    }
}