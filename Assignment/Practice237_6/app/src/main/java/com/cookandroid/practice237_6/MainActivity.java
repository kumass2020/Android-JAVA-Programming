package com.cookandroid.practice237_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout1, layout2, layout3, layout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = (LinearLayout)findViewById(R.id.layout1);
        layout2 = (LinearLayout)findViewById(R.id.layout2);
        layout3 = (LinearLayout)findViewById(R.id.layout3);
        layout4 = (LinearLayout)findViewById(R.id.layout4);

        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Width : " + layout1.getWidth() + ", height : " + layout1.getHeight(), Toast.LENGTH_SHORT).show();
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Width : " + layout2.getWidth() + ", height : " + layout2.getHeight(), Toast.LENGTH_SHORT).show();
            }
        });

        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Width : " + layout3.getWidth() + ", height : " + layout3.getHeight(), Toast.LENGTH_SHORT).show();
            }
        });

        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Width : " + layout4.getWidth() + ", height : " + layout4.getHeight(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}