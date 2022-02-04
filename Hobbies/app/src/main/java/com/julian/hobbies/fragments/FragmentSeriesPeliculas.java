package com.julian.hobbies.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.julian.hobbies.R;
import com.julian.hobbies.adaptadores.AdaptadorFutbol;
import com.julian.hobbies.adaptadores.AdaptadorSeriesPeliculas;
import com.julian.hobbies.utils.Hobbies;

import java.util.ArrayList;

public class FragmentSeriesPeliculas extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private AdaptadorSeriesPeliculas adaptadorSeriesPeliculas;
    private ArrayList<Hobbies> listaSeriesPeliculas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_series_peliculas,container,false);
        instancias();
        rellenarRecycler();
        acciones();
        return view;
    }

    private void acciones() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void rellenarRecycler() {
        recyclerView.setAdapter(adaptadorSeriesPeliculas);
        listaSeriesPeliculas.add(new Hobbies("PERDIDOS",R.drawable.lost));
        listaSeriesPeliculas.add(new Hobbies("THE BIG BANG THEORY",R.drawable.big));
        listaSeriesPeliculas.add(new Hobbies("STRANGER THINGS",R.drawable.stranger));
        listaSeriesPeliculas.add(new Hobbies("MALDITOS BASTARDOS",R.drawable.malditos));
        adaptadorSeriesPeliculas.notifyDataSetChanged();
    }

    private void instancias() {
        listaSeriesPeliculas=new ArrayList<>();
        recyclerView=view.findViewById(R.id.recycler_seriesPeliculas);
        adaptadorSeriesPeliculas=new AdaptadorSeriesPeliculas(getContext(),listaSeriesPeliculas);

    }
}
