package com.example.paulovitor.layoutbars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class DebugActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate() chamado.");
    }

    @Override
    protected void onStart(){
        super.onStart();

        Log.d(TAG, "onStart() chamado.");
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.d(TAG, "onPause() chamado.");
    }

    @Override
    protected void onStop(){
        super.onStop();

        Log.d(TAG, "onStop() chamado.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy() chamado.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart() chamado.");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume() chamado.");
    }
}
