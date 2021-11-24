package com.example.a24_11_21.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a24_11_21.R;
import com.example.a24_11_21.utils.Marca;

import java.util.List;

public class AdaptadorMarcas extends BaseAdapter {

    private List <Marca>listMarcas;
    private Context context;

    public AdaptadorMarcas(List listMarcas, Context context) {
        this.listMarcas = listMarcas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listMarcas.size();
    }

    @Override
    public Object getItem(int position) {
        return listMarcas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        Marca marcaActual = listMarcas.get(position);

        convertview= LayoutInflater.from(context).inflate(R.layout.fila_spinner_marca,parent,false);
        TextView textoMarca = convertview.findViewById(R.id.texto_marca_fila);
        ImageView imagenMarca = convertview.findViewById(R.id.imagen_marca_fila);

        textoMarca.setText(marcaActual.getMarca());
        imagenMarca.setImageResource(marcaActual.getImagen());


        return convertview;
    }

}
