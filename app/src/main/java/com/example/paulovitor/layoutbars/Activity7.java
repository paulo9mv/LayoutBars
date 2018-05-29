package com.example.paulovitor.layoutbars;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Activity7 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    protected static final String TAG = "Livro";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_7);

        //Listview
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new SimplesAdapter(this));
        listView.setOnItemClickListener(this);

        Button button = findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity8.class);
                startActivity(intent);
            }
        });

    }

    public Context getContext(){
        return this;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String s = (String) parent.getAdapter().getItem(position);
        Toast.makeText(this, "Texto selecionado: " + s + ", posição: " + position, Toast.LENGTH_SHORT).show();
    }
}
