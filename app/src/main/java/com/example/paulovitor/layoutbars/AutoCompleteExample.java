package com.example.paulovitor.layoutbars;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteExample extends DebugActivity{
    private static final String[] CAMPEOES = new String[]{"Ashe", "Aatrox", "Brand", "Lux", "Kalista", "...", "Rumble", "Swain", "Vladimir", "Zed"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_complete_activity);


        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.campeoes);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, CAMPEOES);
        autoCompleteTextView.setAdapter(adaptador);

    }
}
