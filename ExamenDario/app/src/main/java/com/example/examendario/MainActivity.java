package com.example.examendario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.examendario.Utils.Vehiculo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewCoches,listViewMotos;
    private Spinner spinnerCochesMotos;
    private EditText editTextMarcas,editTextModelo,editTextCv,editTextPeso;
    private Button botonADD;
    private ArrayList<Vehiculo> arraylistVehiculo;
     String marcaString,modeloString;
    int cvInt,pesoInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        conversion();
        asociarAdaptador();
        Boton();
    }

    private void conversion() {
        marcaString = editTextMarcas.toString();
        modeloString = editTextModelo.toString();

        cvInt = Integer.parseInt(editTextCv.toString());
        pesoInt = Integer.parseInt(editTextPeso.toString());
    }

    private void Boton() {
        botonADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arraylistVehiculo.add(marcaString,modeloString,cvInt,pesoInt);
            }
        });
    }

    private void asociarAdaptador() {
    }

    private void instancias() {
        listViewCoches = findViewById(R.id.listViewCoches);
        listViewMotos = findViewById(R.id.listViewMotos);
        spinnerCochesMotos = (Spinner) findViewById(R.id.spinnerCochesMotos);
        editTextMarcas = findViewById(R.id.editTextMarcas);
        editTextModelo = findViewById(R.id.editTextModelo);
        editTextCv = findViewById(R.id.editTextCv);
        editTextPeso = findViewById(R.id.editTextPeso);
        botonADD = findViewById(R.id.botonADD);
    }
}