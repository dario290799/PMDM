package com.example.contrasenas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.params.HttpConnectionParams;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class MasHerramientas extends AppCompatActivity {
    private Button generador;
    private TextView textgenerador;
    private KeyPairGenerator key;
    private EditText servidorText;
    private Button ping;
    private TextView estadoServidor;
    private URL urlServidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_herramientas);
        generador = (Button) findViewById(R.id.generador);
        textgenerador = (TextView) findViewById(R.id.textGenerador);
        servidorText = (EditText) findViewById(R.id.servidorText);
        ping = (Button) findViewById(R.id.ping);
        estadoServidor = (TextView) findViewById(R.id.estadoServidor);
        generadorCon();
        PingServidor();
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

    private void PingServidor() {
        ping.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                HttpURLConnection connection = null;
                String urlString = servidorText.toString();
                try {
                    urlServidor = new URL(urlString);
                    connection = (HttpURLConnection) urlServidor.openConnection();
                    connection.setRequestMethod("HEAD");
                    int code = connection.getResponseCode();
                    estadoServidor.setText(" "+code);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally { if (connection != null) {

                        connection.disconnect();
                    }
                }
            }
        });
    }
}