package com.cookandroid.example6_19;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    ActionBar.Tab tabSong, tabArtist, tabAlbum;
    MyTabFragment[] myFrags = new MyTabFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar bar = getSupportActionBar();

        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabSong = bar.newTab();
        tabSong.setText("음악별");
        tabSong.setTabListener(this);

        bar.addTab(tabSong);

        tabArtist = bar.newTab();
        tabArtist.setText("가수별");
        tabArtist.setTabListener(this);

        bar.addTab(tabArtist);

        tabAlbum = bar.newTab();
        tabAlbum.setText("앨범별");
        tabAlbum.setTabListener(this);

        bar.addTab(tabAlbum);
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {
        MyTabFragment myTabFragment = null;
        int position = tab.getPosition();

        if (myFrags[position] == null) {
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
    public void onTabUnselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {

    }

    public static class MyTabFragment extends Fragment {
        String tabName;
        MainActivity mainActivity;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );

            LinearLayout baseLayout = new LinearLayout( super.getActivity() );
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(params);

            if(tabName.equals("음악별"))
                baseLayout.setBackgroundColor( Color.RED );
            else if(tabName.equals("가수별"))
                baseLayout.setBackgroundColor( Color.GREEN );
            else if(tabName.equals("앨범별"))
                baseLayout.setBackgroundColor( Color.BLUE );

            return baseLayout;
        }
    }
}