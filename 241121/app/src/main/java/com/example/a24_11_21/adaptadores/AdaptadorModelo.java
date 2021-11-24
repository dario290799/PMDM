package com.example.a24_11_21.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a24_11_21.utils.Modelo;

import java.util.List;


import com.example.a24_11_21.R;
import com.example.a24_11_21.utils.Marca;
import com.example.a24_11_21.utils.Modelo;

import java.util.List;
public class AdaptadorModelo extends BaseAdapter {

    private List<Modelo> listaModelo;
    private Context context;

    public AdaptadorModelo(List<Modelo> listaModelo, Context context) {
        this.listaModelo = listaModelo;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaModelo.size();
    }

    @Override
    public Object getItem(int position) {
        return listaModelo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Se ejecuta tantas veces como número indique el método getCount()
    // El parámetro position toma valores de 0 - getCount() -1
    // La variable convertView es la vista (rellena) que va a representar
    // El parametro parent es el elemneto donde se va a representar la vista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Modelo modeloActual = listaModelo.get(position);

        // 1 -> Inflo vista
        convertView = LayoutInflater.from(context).inflate(R.layout.fila_listview_modelo,parent,false);

        // 2 -> Sacar elementos gráficos
        ImageView imagenMarca = convertView.findViewById(R.id.imagen_modelo_fila);
        TextView texotMarca = convertView.findViewById(R.id.texto_modelo_fila);

        // 3 -> Sacar elementos gráficos de la lista y los asocio en los elementos gráficos
        imagenMarca.setImageResource(modeloActual.getImagen());
        texotMarca.setText(modeloActual.getModelo());

        // 4 -> Retorno la vista
        return convertView;
    }
}

