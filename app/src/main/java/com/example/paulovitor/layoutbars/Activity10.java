package com.example.paulovitor.layoutbars;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity10 extends AppCompatActivity {

    private int[] imagens = {R.drawable.planeta_01_mercurio, R.drawable.planeta_02_venus, R.drawable.planeta_03_terra, R.drawable.planeta_04_marte,
            R.drawable.planeta_05_jupiter, R.drawable.planeta_06_saturno, R.drawable.planeta_07_urano, R.drawable.planeta_08_neptuno, R.drawable.planeta_09_plutao};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10);

        Gallery gallery = findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this, imagens));
        gallery.setOnItemClickListener(onGalleryItemClick(this));
    }

    private AdapterView.OnItemClickListener onGalleryItemClick(final Context context){
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView imgView = new ImageView(context);
                imgView.setImageResource(imagens[position]);

                Toast t = new Toast(context);
                t.setView(imgView);

                t.show();
            }
        };
    }

}
