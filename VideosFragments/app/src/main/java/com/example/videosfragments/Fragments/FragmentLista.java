package com.example.videosfragments.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.videosfragments.R;
import com.example.videosfragments.adaptadores.AdaptadorRecycler;
import com.example.videosfragments.utils.Usuario;
import com.google.androidgamesdk.gametextinput.Listener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentLista extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private AdaptadorRecycler adaptadorRecycler;
    private ArrayList<Usuario> listaUsuarios;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.from(getContext()).inflate(R.layout.fragment_lista, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        listaUsuarios = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler);
        adaptadorRecycler = new AdaptadorRecycler(listaUsuarios, getContext());

        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rellenarDatos();
    }

    private void rellenarDatos() {
        /*
        listaUsuarios.add(new Usuario("Aitor", "Tercero"));
        listaUsuarios.add(new Usuario("Juan", "Puerto"));
        listaUsuarios.add(new Usuario("Ana", "Valero"));
        listaUsuarios.add(new Usuario("Laura", "Paniagua"));
         */

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, "https://randomuser.me/api/?results=200", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                procesarPeticion(response);
                
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                
            }
        });

        Volley.newRequestQueue(getContext()).add(jsonObjectRequest);
    }

    private void procesarPeticion(JSONObject response) {

        try {
            JSONArray resultados = response.getJSONArray("results");
            for (int i = 0; i < resultados.length(); i++) {
                JSONObject user = resultados.getJSONObject(i);
                String nombre = user.getJSONObject("name").getString("first");
                String apellidos = user.getJSONObject("name").getString("last");
                Usuario usuario = new Usuario(nombre, apellidos);
                // listaUsuarios.add(usuario);
                adaptadorRecycler.addUser(usuario);
                // adaptadorRecycler.notifyDataSetChanged();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
