package com.example.aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class copa extends AppCompatActivity {
    private EditText nombre;
    private Button ganador, concursante;
    private final ArrayList<String> nombreCandidatos = new ArrayList<>();
    private String nombreString;
    private TextView nombreGanador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copa);
        instancias();
        agregarNombre();
        generarGanador();
    }

    private void instancias() {
        nombre=(EditText) findViewById(R.id.nombre);
        ganador=(Button) findViewById(R.id.ganador);
        concursante=(Button) findViewById(R.id.concursante);
        nombreGanador=(TextView)findViewById(R.id.nombreGanador);

    }

    public void agregarNombre(){
        concursante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombreCandidatos.add(String.valueOf(nombre.getText()));
                nombre.setText(null);
            }
        });
    }
    public void generarGanador(){
        ganador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random aleatorio = new Random();
                String campeonString = nombreCandidatos.get(aleatorio.nextInt(nombreCandidatos.size()));
                nombreGanador.setText(campeonString);
            }
        });
    }
}