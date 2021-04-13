package com.cookandroid.example7_14;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);

        AlertDialog.Builder dlg = new AlertDialog.Builder(getApplicationContext());

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final String[] versionArray = new String[] { "파이", "Q(10)", "R(11)"};
//                final boolean[] checkArray = new boolean[] { true, false, false };

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this); // 내부기때문에 getApplicationContext() 안 씀

                dlg.setTitle("제목입니다");
                dlg.setIcon(R.mipmap.ic_launcher);

                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        button1.setText(versionArray[which]);
                    }
                });

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "확인을 눌렀네요", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "취소를 눌렀네요", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();

            }
        });
    }
}