package com.example.paulovitor.layoutbars;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentExample1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example1);

        if(savedInstanceState == null) {
            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

            android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();

            Fragment1 fragment1 = new Fragment1();
            ft.add(R.id.layoutFrag, fragment1, "Fragment 1");
            ft.commit();
        }

        android.support.v7.app.ActionBar actionBar =  getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        android.support.v7.app.ActionBar.Tab tab1 = actionBar.newTab().setText("Frag 1");
        tab1.setTabListener(new MyTabListener(this, new Fragment1()));
        actionBar.addTab(tab1);

        android.support.v7.app.ActionBar.Tab tab2 = actionBar.newTab().setText("Frag 2");
        tab2.setTabListener(new MyTabListener(this, new Fragment2()));
        actionBar.addTab(tab2);

        android.support.v7.app.ActionBar.Tab tab3 = actionBar.newTab().setText("Frag 3");
        tab3.setTabListener(new MyTabListener(this, new Fragment3()));
        actionBar.addTab(tab3);


    }
}
