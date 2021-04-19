package com.cookandroid.project7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvName, tvEmail;
    Button button1;

    EditText etName, etEmail;

    TextView toastText;

    View dlgView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView)findViewById(R.id.tvName);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        button1 = (Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dlgView = (View)View.inflate(MainActivity.this, R.layout.dialog1, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dlgView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        etName = (EditText)dlgView.findViewById(R.id.etName);
                        etEmail = (EditText)dlgView.findViewById(R.id.etEmail);

                        tvName.setText(etName.getText().toString());
                        tvEmail.setText( etEmail.getText().toString());
                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toastView = (View)View.inflate(MainActivity.this, R.layout.toast1, null);

                        Toast toast = new Toast(MainActivity.this);

                        toastText = (TextView)toastView.findViewById(R.id.toastText1);
                        toastText.setText("취소했습니다.");

                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

                        int xOffset = (int)(Math.random() * display.getWidth());
                        int yOffset = (int)(Math.random() * display.getHeight());

                        toast.setView(toastView);
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);

                        toast.show();
                    }
                });

                dlg.show();
            }
        });
    }
}