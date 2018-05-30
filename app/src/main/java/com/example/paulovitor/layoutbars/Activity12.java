package com.example.paulovitor.layoutbars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class Activity12 extends AppCompatActivity {

    private int[] imagens = {R.drawable.planeta_01_mercurio, R.drawable.planeta_02_venus, R.drawable.planeta_03_terra, R.drawable.planeta_04_marte,
            R.drawable.planeta_05_jupiter, R.drawable.planeta_06_saturno, R.drawable.planeta_07_urano, R.drawable.planeta_08_neptuno, R.drawable.planeta_09_plutao};
    private ImageSwitcher mImageSwitcher;
    private int idx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_12);

        mImageSwitcher = findViewById(R.id.imageSwitcher);
        mImageSwitcher.setFactory(new ImageSwitcher.ViewFactory(){
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getBaseContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                return imageView;
            }
        });

        mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        mImageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

        Button button = findViewById(R.id.buttonProxima);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idx == imagens.length)
                    idx = 0;

                mImageSwitcher.setImageResource(imagens[idx++]);
            }
        });

        Button button1 = findViewById(R.id.button12);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity12.this, Activity13.class);
                startActivity(intent);
            }
        });

    }
}
