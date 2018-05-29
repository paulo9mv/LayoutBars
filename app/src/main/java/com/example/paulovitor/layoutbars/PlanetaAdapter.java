package com.example.paulovitor.layoutbars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlanetaAdapter extends BaseAdapter {

    private final Context context;
    private final List<Planeta> planetas;

    public PlanetaAdapter(Context context, List<Planeta> planetas){
        this.context = context;
        this.planetas = planetas;
    }

    @Override
    public int getCount() {
        if(planetas != null)
            return planetas.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return planetas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Inflar a view
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_planeta, parent, false);

        //Linkar o textview e imageview
        TextView textView = view.findViewById(R.id.txtPlaneta);
        ImageView imageView = view.findViewById(R.id.imgPlaneta);

        //Atualiza o imageview/textview
        Planeta planeta = planetas.get(position);
        textView.setText(planeta.nome);
        imageView.setImageResource(planeta.img);

        return view;
    }
}
