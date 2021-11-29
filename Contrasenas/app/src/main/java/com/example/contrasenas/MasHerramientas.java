package com.example.contrasenas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class MasHerramientas extends AppCompatActivity {
    private Button generador,paginaServidores;
    private TextView textgenerador;
    private KeyPairGenerator key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_herramientas);
        instancias();
        generadorCon();
        paginaServidor();

    }

    private void instancias() {
        generador = (Button) findViewById(R.id.generador);
        textgenerador = (TextView) findViewById(R.id.textGenerador);
        paginaServidores = (Button) findViewById(R.id.paginaServidores);

    }

    private void generadorCon() {
        try {
            key = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        generador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                key.initialize(2048);
                KeyPair keyP = key.generateKeyPair();
                String stringKey = keyP.toString();
                //Realizo un Split porque el Keypair me imprime la contraseña generada mas el codigo de Keypair.
                String[] splitKey = stringKey.split("@");
                String parte1 = splitKey[0];//Parte de antes del @ -> codigo del key pair usado
                String parte2 = splitKey[1];//Parte de despueé del @ -> al generador de contraseña
                textgenerador.setText(splitKey[1]);
            }
        });
    }
    private void paginaServidor(){
        paginaServidores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MasHerramientas.this,servidores.class));
            }
        });
    }

}