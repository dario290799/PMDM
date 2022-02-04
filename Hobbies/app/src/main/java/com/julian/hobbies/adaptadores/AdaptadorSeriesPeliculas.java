package com.julian.hobbies.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.julian.hobbies.R;
import com.julian.hobbies.utils.Hobbies;

import java.util.ArrayList;

public class AdaptadorSeriesPeliculas extends RecyclerView.Adapter<AdaptadorSeriesPeliculas.MyHolder> {

    private ArrayList<Hobbies> listaHobbies;
    private Context context;
    private View view;

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.fila_recycler_series,
                parent, false);
        MyHolder miHolder = new MyHolder(view);
        return miHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        final Hobbies hobbieActual=listaHobbies.get(position);
        holder.getTexto().setText(hobbieActual.getNombre());
        holder.getImagen().setImageResource(hobbieActual.getImagen());




    }

    @Override
    public int getItemCount() {
        return listaHobbies.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView texto;
        private ImageView imagen;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            texto=itemView.findViewById(R.id.texto_fila_recycler_series);
            imagen=itemView.findViewById(R.id.img_fila_recycler_series);
        }
        public TextView getTexto() {
            return texto;
        }

        public void setTexto(TextView texto) {
            this.texto = texto;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public void setImagen(ImageView imagen) {
            this.imagen = imagen;
        }
    }
    public AdaptadorSeriesPeliculas( Context context,ArrayList<Hobbies> listaHobbies) {
        this.context = context;
        this.listaHobbies = listaHobbies;
    }


}
