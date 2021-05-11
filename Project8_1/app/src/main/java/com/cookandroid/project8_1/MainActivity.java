package com.cookandroid.project8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnWrite;
    EditText etDiary;
    DatePicker datePicker;

    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = (Button)findViewById(R.id.btnWrite);
        etDiary = (EditText)findViewById(R.id.etDiary);
        datePicker = (DatePicker)findViewById(R.id.datePicker1);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        datePicker.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear + 1) + "_" + Integer.toString(dayOfMonth) + ".txt";

                String str = readDiary(fileName);

                etDiary.setText(str);

                btnWrite.setEnabled(true);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);

                    String str = etDiary.getText().toString().trim();

                    fos.write(str.getBytes());

                    fos.close();

                    Toast.makeText(getApplicationContext(), fileName + "이 저장됨", Toast.LENGTH_SHORT).show();
                }
                catch(IOException ex)
                {

                }
            }
        });
    }

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream fis;

        try {
            fis = openFileInput(fName);
            byte[] txt = new byte[500];

            fis.read(txt);

            fis.close();

            diaryStr = new String(txt).trim();

            btnWrite.setText("수정하기");
        }
        catch(IOException ex)
        {
            etDiary.setHint("일기 없음");
            btnWrite.setText("새로 저장");
        }

        return diaryStr;
    }
}