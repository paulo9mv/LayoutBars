package com.example.paulovitor.layoutbars;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;

public class AutoCompleteExample extends DebugActivity{
    private static final String[] CAMPEOES = new String[]{"Ashe", "Aatrox", "Brand", "Lux", "Kalista", "...", "Rumble", "Swain", "Vladimir", "Zed"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_complete_activity);


        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.campeoes);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, CAMPEOES);
        autoCompleteTextView.setAdapter(adaptador);

        Button button = (Button) findViewById(R.id.switchScreen1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity3.class);
                startActivity(intent);
            }
        });

    }

    public Context getContext(){
        return this;
    }

}
