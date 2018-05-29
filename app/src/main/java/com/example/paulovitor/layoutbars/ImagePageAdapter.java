package com.example.paulovitor.layoutbars;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ImagePageAdapter extends PagerAdapter {

    private Context context;
    private int[] imagens;

    public ImagePageAdapter(Context context, int[] imagens){
        this.context = context;
        this.imagens = imagens;
    }

    @Override
    public int getCount() {
        if(imagens != null)
            return imagens.length;
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view){
        container.removeView((View) view);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){

        //Inflar a view
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_gridview, container, false);

        ImageView imageView = view.findViewById(R.id.imgGridView);
        imageView.setImageResource(imagens[position]);

        container.addView(view);

        return view;
    }

}
