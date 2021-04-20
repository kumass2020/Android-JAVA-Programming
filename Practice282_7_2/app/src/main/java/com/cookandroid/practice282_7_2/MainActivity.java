package com.cookandroid.project6;


import android.graphics.Color;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cookandroid.practice282_7_2.R;

import java.util.zip.Inflater;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{

    ActionBar.Tab tabDog, tabCat, tabRabbit, tabHorse;
    MyTabFragment[] myFrags = new MyTabFragment[4];

    ImageView iv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        iv = (ImageView)findViewById(R.id.iv);

        tabDog = bar.newTab();
        tabDog.setText("개");
        tabDog.setTabListener(this);
        bar.addTab(tabDog);

        tabCat = bar.newTab();
        tabCat.setText("고양이");
        tabCat.setTabListener(this);
        bar.addTab(tabCat);

        tabRabbit = bar.newTab();
        tabRabbit.setText("토끼");
        tabRabbit.setTabListener(this);
        bar.addTab(tabRabbit);

        tabHorse = bar.newTab();
        tabHorse.setText("말");
        tabHorse.setTabListener(this);
        bar.addTab(tabHorse);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        MyTabFragment myTabFragment = null;
        int position = tab.getPosition();

        if(myFrags[position] == null) {
            myTabFragment = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());

            myTabFragment.setArguments(data);

            myFrags[position] = myTabFragment;
        }
        else
            myTabFragment = myFrags[position];

        ft.replace(android.R.id.content, myTabFragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    public static class MyTabFragment extends androidx.fragment.app.Fragment {
        String tabName;
        private MainActivity mActivity;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            View myView = inflater.inflate(R.layout.actionbar1, null);
//            myView.setBac
            LinearLayout baseLayout = (LinearLayout)myView.findViewById(R.id.ll);
            ImageView iv = (ImageView)baseLayout.findViewById(R.id.iv);


//            LinearLayout baseLayout = new LinearLayout(super.getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);
            if (tabName == "개")
                iv.setImageResource(R.drawable.dog);
            if (tabName == "고양이")
                iv.setImageResource(R.drawable.cat);
            if (tabName == "토끼")
                iv.setImageResource(R.drawable.rabbit);
            if (tabName == "말")
                iv.setImageResource(R.drawable.horse);


            return baseLayout;
        }

    }
}
