package com.example.paulovitor.layoutbars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Activity8 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    protected static final String TAG = "Livro";
    private ListView listView;
    private List<Planeta> planetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);

        this.listView = findViewById(R.id.listview1);
        this.planetas = Planeta.getPlanetas();

        listView.setAdapter(new PlanetaAdapter(this, this.planetas));
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Planeta p = this.planetas.get(position);
        Toast.makeText(this, "Texto selecionado: " + p.nome + ", posição: " + position, Toast.LENGTH_SHORT).show();

        if(position == 2){
            Intent intent = new Intent(this, Activity9.class);
            startActivity(intent);
        }

    }
}
