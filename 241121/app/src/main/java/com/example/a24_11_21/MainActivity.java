package com.example.a24_11_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.a24_11_21.adaptadores.AdaptadorMarcas;
import com.example.a24_11_21.adaptadores.AdaptadorModelo;
import com.example.a24_11_21.utils.Marca;
import com.example.a24_11_21.utils.Modelo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinerMarcas;
    private ListView listViewModelos;
    private AdaptadorMarcas adaptadorMarcas;
    private ArrayList <Marca> listaMarcas;
    private ArrayList<Modelo> listaModelos;
    private AdaptadorModelo adaptadorModelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        inciarListas();
        asociarElementos();
    }

    private void asociarElementos() {
        spinerMarcas.setAdapter(adaptadorMarcas);
    }

    private void inciarListas() {
        listaMarcas.add(new Marca("BMW",R.drawable.bmw));
        listaMarcas.add(new Marca("AUDI",R.drawable.audi));
        listaMarcas.add(new Marca("VM",R.drawable.vw));
        listaMarcas.add(new Marca("MERCEDES",R.drawable.mercedes));


        listaModelos.add(new Modelo("i8",500,R.drawable.i8,new Marca("BMW")));
        listaModelos.add(new Modelo("Arteon",500,R.drawable.arteon,new Marca("VW")));
        listaModelos.add(new Modelo("A5",500,R.drawable.i8,new Marca("AUDI")));
        listaModelos.add(new Modelo("EQC",500,R.drawable.i8,new Marca("MERCEDES")));

    }

    private void instancias() {
        listaMarcas= new ArrayList<>();
        listaModelos= new ArrayList<>();
        spinerMarcas=findViewById(R.id.spiner_marcas);
        listViewModelos=findViewById(R.id.lista_modelos);
        adaptadorMarcas = new AdaptadorMarcas(listaMarcas,getApplicationContext());
        adaptadorModelo = new AdaptadorModelo(listaModelos,getApplicationContext());
    }
}