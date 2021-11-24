package com.example.examendario.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examendario.R;
import com.example.examendario.Utils.Vehiculo;

import java.util.List;

public class AdaptadorListaCoches extends BaseAdapter {
    List<Vehiculo> listaCoches;
    Context context;

    public AdaptadorListaCoches(List<Vehiculo> listaCoches, Context context) {
        this.listaCoches = listaCoches;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaCoches.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCoches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        Vehiculo vehiculoActual = listaCoches.get(position);
        convertview = LayoutInflater.from(context).inflate(R.layout.layoutlistacoches,parent,false);
        vehiculoActual
        return null;
    }
}
