package com.example.paulovitor.layoutbars;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity11 extends AppCompatActivity {

    private int[] imagens = {R.drawable.planeta_01_mercurio, R.drawable.planeta_02_venus, R.drawable.planeta_03_terra, R.drawable.planeta_04_marte,
            R.drawable.planeta_05_jupiter, R.drawable.planeta_06_saturno, R.drawable.planeta_07_urano, R.drawable.planeta_08_neptuno, R.drawable.planeta_09_plutao};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_11);

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new PlanetasPagerAdapter(this, Planeta.getPlanetas()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast t = Toast.makeText(getBaseContext(), "Imagem: " + position, Toast.LENGTH_SHORT);
                t.show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Button button = findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity11.this, Activity12.class);
                startActivity(intent);
            }
        });

    }
}
