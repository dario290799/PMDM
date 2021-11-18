package com.example.contrasenas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;


public class Almacen_Contrasenas extends AppCompatActivity {
    private Button cerrarSesion;
    private Button mHerramientas;
    private TextView texto;
    private TextView contador;
    private FirebaseAuth mAuth;
    private ImageButton anadirCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacen_contrasenas);
        cerrarSesion = (Button) findViewById(R.id.cerrarSesion);
        mHerramientas = (Button) findViewById(R.id.mHerramientas);
        texto = (TextView) findViewById(R.id.texto);
        contador = (TextView) findViewById(R.id.contador);
        mAuth = FirebaseAuth.getInstance();
        anadirCon = (ImageButton) findViewById(R.id.anadirCon);
        CerrarSesion();
        Herramientas();
        ContadorUsuariosRegistrados();
        VentanaEmergente();
    }

    private void CerrarSesion() {
        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Almacen_Contrasenas.this, MainActivity.class));
            }
        });
    }

    public void Herramientas() {
        mHerramientas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Almacen_Contrasenas.this, MasHerramientas.class));
            }
        });
    }

    public void ContadorUsuariosRegistrados() {
    }
    public void VentanaEmergente(){
        anadirCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(Almacen_Contrasenas.this, AnadirContrasenas.class));
            }
        });
    }

}

