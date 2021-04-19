package com.cookandroid.practice322_6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg1;
    RadioButton rbDog, rbCat, rbRabbit, rbHorse;
    Button btn1;

    View dlgView;

    TextView tv1;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg1 = (RadioGroup)findViewById(R.id.rg1);
        rbDog = (RadioButton)findViewById(R.id.rbDog);
        rbCat = (RadioButton)findViewById(R.id.rbCat);
        rbRabbit = (RadioButton)findViewById(R.id.rbRabbit);
        rbHorse = (RadioButton)findViewById(R.id.rbHorse);
        btn1 = (Button)findViewById(R.id.btn1);

        dlgView = (View)View.inflate(MainActivity.this, R.layout.dialog1, null);

        tv1 = (TextView)dlgView.findViewById(R.id.tv1);
        iv1 = (ImageView)dlgView.findViewById(R.id.iv1);



        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

        dlg.setView(dlgView);

        dlg.setPositiveButton("닫기", null);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {


                if(checkedId == R.id.rbDog) {
                    tv1.setText("강아지");
                    iv1.setImageResource(R.drawable.dog);
                }
                if(checkedId == R.id.rbCat) {
                    tv1.setText("고양이");
                    iv1.setImageResource(R.drawable.cat);
                }
                if(checkedId == R.id.rbRabbit) {
                    tv1.setText("토끼");
                    iv1.setImageResource(R.drawable.rabbit);
                }
                if(checkedId == R.id.rbHorse) {
                    tv1.setText("말");
                    iv1.setImageResource(R.drawable.horse);
                }

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//                dlgView = (View)View.inflate(MainActivity.this, R.layout.dialog1, null);
//
//                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
//
//                dlg.setView(dlgView);
//
//                dlg.setPositiveButton("닫기", null);



                if(dlgView.getParent() != null) {
                    ((ViewGroup)dlgView.getParent()).removeView(dlgView);
                }
                dlg.show();
            }
        });






    }
}