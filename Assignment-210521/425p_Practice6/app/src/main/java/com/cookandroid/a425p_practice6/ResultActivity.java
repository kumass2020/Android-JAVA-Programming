package com.cookandroid.a425p_practice6;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class ResultActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer ivID[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9 };
        Integer imID[] = { R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9  };

        ImageView iv[] = new ImageView[9];
        int[] resultID = new int[9];

        for(int i=0;i<9;i++){
            iv[i]=(ImageView)findViewById(ivID[i]);
        }

        for(int i=0;i<9;i++){
            resultID[i]=0;
        }

        for(int i=0;i<8;i++){
            for(int j=i+1;j<9;j++) {
                if (voteResult[i] < voteResult[j])
                    resultID[i]++;
                else
                    resultID[j]++;
            }
        }

        for(int i=0;i<9;i++){
            iv[resultID[i]].setImageResource(imID[i]);
        }

        Button btnStart, btnStop;
        final ViewFlipper vFlipper;

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);


        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        vFlipper.setFlipInterval(1000);

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vFlipper.stopFlipping();
            }
        });
    }
}

//        for (int i = 0; i < voteResult.length; i++) {
//            tv[i] = (TextView) findViewById(tvID[i]);
//            rbar[i] = (RatingBar) findViewById(rbarID[i]);
//        }
//
//        for (int i = 0; i < voteResult.length; i++) {
//            tv[i].setText(imageName[i]);
//            rbar[i].setRating((float) voteResult[i]);
//        }
//
//        Button btnReturn = (Button) findViewById(R.id.btnReturn);
//        btnReturn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                finish();
//
//            }
//        });



//    }

//}