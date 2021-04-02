package com.cookandroid.practice111_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    EditText et1;
    RadioGroup rg1;
    RadioButton rb1, rb2;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("좀 그럴듯한 앱");

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        et1 = (EditText)findViewById(R.id.et1);
        rg1 = (RadioGroup)findViewById(R.id.rg1);
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        iv1 = (ImageView)findViewById(R.id.iv1);

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(et1.getText())));
            }
        });

////        rg1.setOnClickListener(new View.OnClickListener() {
////
////            @Override
////            public void onClick(View view) {
//                switch(rg1.getCheckedRadioButtonId()) {
//                    case R.id.rb1:
//                        iv1.setImageResource(R.drawable.q10);
//                        break;
//                    case R.id.rb2:
//                        iv1.setImageResource(R.drawable.r11);
//                        break;
//                }
////            }
////        });

        rb1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                iv1.setImageResource(R.drawable.q10);
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                iv1.setImageResource(R.drawable.r11);
            }
        });




    }
}