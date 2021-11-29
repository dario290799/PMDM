package com.example.contrasenas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class servidores extends AppCompatActivity {
    private EditText puertoText, ipText;
    private Button tcpBoton;
    private TextView estadoTcp;
    private String numeroIp;
    private int numeroPuerto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servidores);
        puertoText = findViewById(R.id.puertoText);
        ipText = findViewById(R.id.ipText);
        tcpBoton = findViewById(R.id.tcpBoton);
        estadoTcp =  findViewById(R.id.estadoTcp);
        ComprobarTcp();
    }
    private void ComprobarTcp() {
        tcpBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroIp=ipText.getText().toString();
                String valor = puertoText.getText().toString();
                numeroPuerto = Integer.parseInt(valor);
                try {
                    Socket clienteSocket = new Socket(numeroIp, numeroPuerto);
                    PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
                    estadoTcp.setText("Puerto TCP " + numeroPuerto + " abierto");
                    out.close();
                    clienteSocket.close();
                } catch (IOException e) {
                    estadoTcp.setText("Puerto TCP " + numeroPuerto + " cerrado");
                }
            }
        });

    }

}