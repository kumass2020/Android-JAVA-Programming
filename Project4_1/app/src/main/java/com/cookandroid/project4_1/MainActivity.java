package com.cookandroid.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etInput1, etInput2;
    Button btnAdd, btnSub, btnMult, btnDiv, btnRem;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput1 = (EditText)findViewById(R.id.etInput1);
        etInput2 = (EditText)findViewById(R.id.etInput2);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnMult = (Button)findViewById(R.id.btnMult);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnRem = (Button)findViewById(R.id.btnRem);

        tvResult = (TextView)findViewById(R.id.tvResult);

        btnAdd.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String num1 = etInput1.getText().toString();
                String num2 = etInput2.getText().toString();

                if (num1.equals("") || num2.equals(""))
                {
                    Toast.makeText(getApplicationContext(), text: "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double value1 = Double.parseDouble(num1);
                    double value2 = Double.parseDouble(num2);

                    double result = value1 + value2;

                    tvResult.setText("계산결과 : " + result);
                }
            }
        });


    }
}