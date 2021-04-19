package com.cookandroid.practice322_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    View toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                toastView = (View)View.inflate(MainActivity.this, R.layout.toast1, null);

                Toast toast = new Toast(MainActivity.this);

                Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

                int xOffset = (int)(Math.random() * display.getWidth());
                int yOffset = (int)(Math.random() * display.getHeight());

                toast.setView(toastView);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);

                toast.show();
            }
        });
    }
}