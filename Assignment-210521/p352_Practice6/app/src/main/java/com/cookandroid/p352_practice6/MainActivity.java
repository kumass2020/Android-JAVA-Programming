package com.cookandroid.p352_practice6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;

    // sd카드 경로를 지정
    final String SDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
    final File myDir = new File(SDpath + "/myDiary");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장");

        dp = (DatePicker)findViewById(R.id.datePicker1);
        edtDiary = (EditText)findViewById(R.id.edtDiary);
        btnWrite = (Button)findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        // 처음 실행 시 파일 이름 검사
        if(!myDir.exists()) {
            myDir.mkdir();
        }
        fileName = Integer.toString(cYear) + "_" + Integer.toString(cMonth+1)
                + "_" + Integer.toString(cDay) + ".txt";
        String str = readDiary(fileName);
        edtDiary.setText(str);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear + 1) + "_" + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    myDir.mkdir();
                    File file = new File(SDpath + "/" + fileName);
                    FileOutputStream outFs = new FileOutputStream(file);
//                    FileOutputStream outFs = openFileOutput(SDpath + fileName, Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
//                    if(!file.exists()) {
//                        file.createNewFile();
//                    }
//                    FileWriter writer = new FileWriter(file, false);
//                    writer.write(str);
//                    writer.close();
                    Toast.makeText(getApplicationContext(), fileName+" 이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

    }

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        final String SDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File myDir = new File(SDpath + "/myDiary");
        File file = new File(SDpath, fileName);
        myDir.mkdir();
        try {
//            inFs = openFileInput("/sdcard/myDiary/" + fName);
            inFs = new FileInputStream(SDpath + "/" + fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정하기");
        } catch (IOException e) {
            edtDiary.setHint("일기 없음");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }

}