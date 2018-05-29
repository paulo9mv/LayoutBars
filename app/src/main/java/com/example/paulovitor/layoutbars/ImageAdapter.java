package com.example.paulovitor.layoutbars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private final int[] imagens;

    public ImageAdapter(Context context, int[] imagens){
        this.context = context;
        this.imagens = imagens;
    }

    @Override
    public int getCount() {
        return imagens.length;
    }

    @Override
    public Object getItem(int position) {
        return imagens[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Infla a view do XML
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_gridview, parent, false);

        //Linka os elementos
        ImageView imageView = view.findViewById(R.id.imgGridView);

        //Atualiza os elementos
        imageView.setImageResource(imagens[position]);

        return view;
    }
}
