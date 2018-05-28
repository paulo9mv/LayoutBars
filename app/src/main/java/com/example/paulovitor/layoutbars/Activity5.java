package com.example.paulovitor.layoutbars;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Activity5 extends AppCompatActivity {

    private static final String URL = "https://nexus.leagueoflegends.com/wp-content/uploads/2016/11/LOL_CMS_15_Article_AskRiot_Misfortune.jpg";
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        //Abre a janela enquanto busca a imagem
        dialog = ProgressDialog.show(this, "Exemplo", "Buscando imagem, aguarde...", false, true);
        downloadImagem(URL);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity6.class);
                startActivity(intent);
            }
        });

    }

    public Context getContext(){
        return this;
    }

    private void downloadImagem(final String urlImg){
        new Thread(){
            @Override
            public void run(){
                try{

                    //DOwnload da imagem
                    URL url = new URL(urlImg);
                    InputStream in = url.openStream();

                    //Converte para bitmap
                    final Bitmap imagem = BitmapFactory.decodeStream(in);
                    in.close();

                    atualizaImagem(imagem);
                }catch (IOException e){
                    Log.e("Erro durante download", e.getMessage(), e);
                }
            }
        }.start();
    }

    private void atualizaImagem(final Bitmap imagem){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                //Encerra o dialog
                dialog.dismiss();

                //Seta a imagem
                ImageView imageView = (ImageView) findViewById(R.id.img);
                imageView.setImageBitmap(imagem);
            }
        });
    }

}
