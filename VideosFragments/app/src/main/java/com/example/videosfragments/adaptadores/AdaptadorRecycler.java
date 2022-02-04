package com.example.videosfragments.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videosfragments.R;
import com.example.videosfragments.utils.Usuario;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MyHolder> {

    ArrayList<Usuario>listaElementos;
    Context context;

    public AdaptadorRecycler(ArrayList listaElementos, Context context) {
        this.listaElementos = listaElementos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_lista, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Usuario usuario = listaElementos.get(position);
        holder.nombre.setText(usuario.getNombre());
        holder.apellidos.setText(usuario.getApellidos());
    }

    @Override
    public int getItemCount() {
        return listaElementos.size();
    }

    public void addUser(Usuario usuario){
        listaElementos.add(usuario);
        this.notifyDataSetChanged();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView nombre, apellidos;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_Item);
            apellidos = itemView.findViewById(R.id.apellido_Item);
        }
    }
}
