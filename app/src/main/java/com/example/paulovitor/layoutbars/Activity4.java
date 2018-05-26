package com.example.paulovitor.layoutbars;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    private int[] imagens = {R.drawable.planeta_01_mercurio, R.drawable.planeta_02_venus, R.drawable.planeta_03_terra, R.drawable.planeta_04_marte,
    R.drawable.planeta_05_jupiter, R.drawable.planeta_06_saturno, R.drawable.planeta_07_urano, R.drawable.planeta_08_neptuno, R.drawable.planeta_09_plutao};

    private String[] planetas = new String[] {"Mercúrio", "Vênus", "Terra", "Marte", "Júpiter", "Saturno", "Urano", "Netuno", "Plutão"};
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        final ImageView imageView = (ImageView) findViewById(R.id.img);
        final Spinner combo = (Spinner) findViewById(R.id.spinnerid);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, planetas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combo.setAdapter(adapter);

        combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imagens[position]);



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

         progressBar = (ProgressBar) findViewById(R.id.progressBar);

         textView = (TextView) findViewById(R.id.idTexto);
        Button b = (Button) findViewById(R.id.startProgress);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the progress status zero on each button click
                progressStatus = 0;
                // Visible the progress bar and text view
                progressBar.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progressStatus < 100){
                            // Update the progress status
                            progressStatus +=1;

                            // Try to sleep the thread for 20 milliseconds
                            try{
                                Thread.sleep(40);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }

                            // Update the progress bar
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                    // Show the progress on TextView
                                    textView.setText(progressStatus+"");
                                    // If task execution completed
                                    if(progressStatus == 100){
                                        // Hide the progress bar from layout after finishing task
                                        progressBar.setVisibility(View.GONE);
                                        // Set a message of completion
                                        textView.setText("Operation completed...");
                                    }
                                }
                            });
                        }
                    }
                }).start(); // Start the operation
            }
        });

        Button button = (Button) findViewById(R.id.switchScreen4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity5.class);
                startActivity(intent);
            }
        });

    }

    public Context getContext(){
        return this;
    }

}
