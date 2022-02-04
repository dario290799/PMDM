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
import com.julian.hobbies.adaptadores.AdaptadorTodos;
import com.julian.hobbies.utils.Hobbies;

import java.util.ArrayList;

public class FragmentTodos extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private AdaptadorTodos adaptadorTodos;
    private ArrayList<Hobbies> listaTodos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_todos,container,false);
        instancias();
        rellenarRecycler();
        acciones();
        return view;
    }

    private void acciones() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void rellenarRecycler() {
        recyclerView.setAdapter(adaptadorTodos);
        listaTodos.add(new Hobbies("FC BARCELONA",R.drawable.barsa));
        listaTodos.add(new Hobbies("BRASIL",R.drawable.brasil));
        listaTodos.add(new Hobbies("ESPAÑA",R.drawable.espania));
        listaTodos.add(new Hobbies("REAL MADRID",R.drawable.madrid));
        listaTodos.add(new Hobbies("AC MILAN",R.drawable.milan));
        listaTodos.add(new Hobbies("PERDIDOS",R.drawable.lost));
        listaTodos.add(new Hobbies("THE BIG BANG THEORY",R.drawable.big));
        listaTodos.add(new Hobbies("STRANGER THINGS",R.drawable.stranger));
        listaTodos.add(new Hobbies("MALDITOS BASTARDOS",R.drawable.malditos));
        listaTodos.add(new Hobbies("GTA",R.drawable.gta));
        listaTodos.add(new Hobbies("THE LAST OF AS",R.drawable.last));
        listaTodos.add(new Hobbies("FIFA 19",R.drawable.fifa19));
        adaptadorTodos.notifyDataSetChanged();
    }

    private void instancias() {
        listaTodos=new ArrayList<>();
        recyclerView=view.findViewById(R.id.recycler_todos);
        adaptadorTodos=new AdaptadorTodos(getContext(),listaTodos);

    }
}
