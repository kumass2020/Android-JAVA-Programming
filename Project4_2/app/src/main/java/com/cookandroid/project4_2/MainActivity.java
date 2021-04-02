package com.cookandroid.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbStart;
    TextView tv1;
    RadioGroup rg1;
    RadioButton rbDog, rbCat, rbRabbit;
    Button btn1;
    ImageView iv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("애완동물 사진 보기");

        cbStart = (CheckBox)findViewById(R.id.cbStart);

        tv1 = (TextView)findViewById(R.id.tv1);

        rg1 = (RadioGroup)findViewById(R.id.rg1);

        rbDog = (RadioButton)findViewById(R.id.rbDog);
        rbCat = (RadioButton)findViewById(R.id.rbCat);
        rbRabbit = (RadioButton)findViewById(R.id.rbRabbit);

        btn1 = (Button)findViewById(R.id.btn1);

        iv1 = (ImageView)findViewById(R.id.iv1);

        cbStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbStart.isChecked())
                {
                    tv1.setVisibility(View.VISIBLE);
                    rg1.setVisibility(View.VISIBLE);
                    btn1.setVisibility(View.VISIBLE);
                    iv1.setVisibility(View.VISIBLE);
                }
                else
                {
                    tv1.setVisibility(View.INVISIBLE);
                    rg1.setVisibility(View.INVISIBLE);
                    btn1.setVisibility(View.INVISIBLE);
                    iv1.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch(rg1.getCheckedRadioButtonId())
                {
                    case R.id.rbDog :
                        iv1.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rbCat:
                        iv1.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rbRabbit:
                        iv1.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 선택하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}