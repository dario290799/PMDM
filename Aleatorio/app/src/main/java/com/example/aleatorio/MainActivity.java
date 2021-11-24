package com.example.aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton copaBoton,flechasBoton,dadosBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        copaBoton= (ImageButton) findViewById(R.id.copaBoton);
        flechasBoton= (ImageButton) findViewById(R.id.flechasBoton);
        dadosBoton= (ImageButton) findViewById(R.id.dadosBoton);
        Botones();
    }
    public void Botones(){
        copaBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,copa.class));
            }
        });
        flechasBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,flechas.class));
            }
        });
        dadosBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,dados.class));
            }
        });
    }
}