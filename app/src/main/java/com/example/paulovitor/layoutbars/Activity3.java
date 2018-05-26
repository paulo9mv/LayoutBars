package com.example.paulovitor.layoutbars;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkEmail);
        boolean receberEmail = checkBox.isChecked();

        Button button = (Button) findViewById(R.id.buttonactivity3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity4.class);
                startActivity(intent);
            }
        });

    }

    public Context getContext(){
        return this;
    }

}
