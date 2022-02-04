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
import com.julian.hobbies.adaptadores.AdaptadorVideojuegos;
import com.julian.hobbies.utils.Hobbies;

import java.util.ArrayList;

public class FragmentVideojuegos extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private AdaptadorVideojuegos adaptadorVideojuegos;
    private ArrayList<Hobbies> listaVideojuegos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_videojuegos,container,false);
        instancias();
        rellenarRecycler();
        acciones();
        return view;
    }

    private void acciones() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void rellenarRecycler() {
        recyclerView.setAdapter(adaptadorVideojuegos);
        listaVideojuegos.add(new Hobbies("GTA",R.drawable.gta));
        listaVideojuegos.add(new Hobbies("THE LAST OF AS",R.drawable.last));
        listaVideojuegos.add(new Hobbies("FIFA 19",R.drawable.fifa19));
        adaptadorVideojuegos.notifyDataSetChanged();
    }

    private void instancias() {
        listaVideojuegos=new ArrayList<>();
        recyclerView=view.findViewById(R.id.recycler_videojuegos);
        adaptadorVideojuegos=new AdaptadorVideojuegos(getContext(),listaVideojuegos);

    }
}
