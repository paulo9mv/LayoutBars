package com.example.paulovitor.layoutbars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class Activity9 extends AppCompatActivity {

    private int[] imagens = {R.drawable.smile1, R.drawable.triste, R.drawable.louco,
            R.drawable.smile1, R.drawable.triste, R.drawable.louco,
            R.drawable.smile1, R.drawable.triste, R.drawable.louco,
            R.drawable.smile1, R.drawable.triste, R.drawable.louco,
            R.drawable.smile1, R.drawable.triste, R.drawable.smile2,
            R.drawable.smile1, R.drawable.triste, R.drawable.louco,
            R.drawable.smile1, R.drawable.triste, R.drawable.louco,
            R.drawable.android, R.drawable.triste, R.drawable.louco,
            R.drawable.smile1, R.drawable.smile2, R.drawable.louco,
            R.drawable.smile1, R.drawable.triste, R.drawable.louco};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_9);

        GridView gridView = findViewById(R.id.gridview);
        gridView.setOnItemClickListener(onGridViewItemClick());
        gridView.setAdapter(new ImageAdapter(this, imagens));

        Button button = findViewById(R.id.button9);
        button.setOnClickListener(onClick());

    }

    private View.OnClickListener onClick(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity9.this, Activity10.class);
                startActivity(intent);
            }
        };
    }

    private AdapterView.OnItemClickListener onGridViewItemClick(){
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Activity9.this, "Imagem selecionada: " + position + " .", Toast.LENGTH_SHORT).show();
            }
        };
    }


}
