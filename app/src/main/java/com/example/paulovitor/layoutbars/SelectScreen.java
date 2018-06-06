package com.example.paulovitor.layoutbars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_screen);

        Button b = findViewById(R.id.buttonSelect);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button b1 = findViewById(R.id.buttonSelect1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectScreen.this, FragmentExample1.class);
                startActivity(intent);
            }
        });

    }
}
