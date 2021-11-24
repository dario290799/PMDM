package com.example.examendario.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.examendario.R;
import com.example.examendario.Utils.Vehiculo;

import java.util.List;

public class AdaptadorListaMotos extends BaseAdapter {
    List<Vehiculo> listaMoto;
    Context context;
    public AdaptadorListaMotos(List<Vehiculo> listaMoto, Context context) {
        this.listaMoto = listaMoto;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaMoto.size();
    }

    @Override
    public Object getItem(int position) {
        return listaMoto.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        Vehiculo vehiculo =listaMoto.get(position);
        convertview = LayoutInflater.from(context).inflate(R.layout.layoutlistamoto,parent,false);
        return null;
    }
}
