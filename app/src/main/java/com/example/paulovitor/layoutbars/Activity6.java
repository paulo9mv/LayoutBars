package com.example.paulovitor.layoutbars;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        toast("Oi amigo");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.triste);
        builder.setTitle("!!ALERTA VIRUS!!");
        builder.setMessage("Seu dispositivo pode estar infectado com o novo vírus M219sHACK. Deseja limpar?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toast("Clicou no sim!");
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toast("Clicou no não!");
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        Button button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity7.class);
                startActivity(intent);
            }
        });


    }

    public Context getContext(){
        return this;
    }

    public void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void toast(ImageView imageView){
        Toast toast = new Toast(this);
        toast.setView(imageView);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

}
