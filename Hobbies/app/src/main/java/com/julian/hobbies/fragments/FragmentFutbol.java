package com.julian.hobbies.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.julian.hobbies.R;
import com.julian.hobbies.adaptadores.AdaptadorFutbol;
import com.julian.hobbies.utils.Hobbies;

import java.util.ArrayList;

public class FragmentFutbol extends Fragment{
    private View view;
    private RecyclerView recyclerView;
    private AdaptadorFutbol adaptadorFutbol;
    private ArrayList<Hobbies> listaFutbol;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_futbol,container,false);
        instancias();
        rellenarRecycler();
        acciones();
        return view;
    }

    private void acciones() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void rellenarRecycler() {
        recyclerView.setAdapter(adaptadorFutbol);
        listaFutbol.add(new Hobbies("FC BARCELONA",R.drawable.barsa));
        listaFutbol.add(new Hobbies("BRASIL",R.drawable.brasil));
        listaFutbol.add(new Hobbies("ESPAÑA",R.drawable.espania));
        listaFutbol.add(new Hobbies("REAL MADRID",R.drawable.madrid));
        listaFutbol.add(new Hobbies("AC MILAN",R.drawable.milan));
        adaptadorFutbol.notifyDataSetChanged();
    }

    private void instancias() {
        listaFutbol=new ArrayList<>();
        recyclerView=view.findViewById(R.id.recycler_futbol);
        adaptadorFutbol=new AdaptadorFutbol(getContext(),listaFutbol);

    }
}
