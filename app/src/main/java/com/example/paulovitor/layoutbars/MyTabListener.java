package com.example.paulovitor.layoutbars;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

public class MyTabListener implements ActionBar.TabListener {

    private int tabId;
    private Fragment frag;
    private Context context;

    public MyTabListener(Context context, int tabId){
        this.context = context;
        this.tabId = tabId;
    }

    public MyTabListener(Context context, Fragment frag){
        this.context = context;
        this.frag = frag;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.replace(R.id.layoutFrag, this.frag, null);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
