package com.example.aplicaciocartas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class juego extends AppCompatActivity implements View.OnClickListener {

    private ImageButton arriba,abajo;
    private ImageView carta;
    private int[] cartas;
    private int numeroActual, numeroFuturo, aciertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        instancias();
        acciones();
        abajo = (ImageButton) findViewById(R.id.abajo);
        arriba = (ImageButton) findViewById(R.id.arriba);
        carta = (ImageView) findViewById(R.id.carta);
    }

    private void acciones() {
        arriba.setOnClickListener(this);
        abajo.setOnClickListener(this);
    }

    private void instancias() {

        cartas = new int[]{R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
                R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
                R.drawable.c11, R.drawable.c12, R.drawable.c13};

        numeroActual = (int) (Math.random()*13);

        carta.setImageResource(cartas[numeroActual]);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.abajo:
                // pregunto si el número con el que juego es más pequeño que el que está puesto
                numeroFuturo = (int) (Math.random()*13);
                if (numeroActual>numeroFuturo){
                    aciertos++;
                    numeroActual=numeroFuturo;
                    carta.setImageResource(cartas[numeroActual]);

                } else {
                    Intent intent = new Intent();
                    intent.putExtra("record",aciertos);
                    setResult(0,intent);
                    finish();
                }

                break;
            case R.id.arriba:
                // pregunto si el número con el que juego es más grade que el que está puesto
                numeroFuturo = (int) (Math.random()*13);
                if (numeroActual<numeroFuturo){
                    aciertos++;
                    numeroActual=numeroFuturo;
                    carta.setImageResource(cartas[numeroActual]);

                }else {
                    Intent intent = new Intent();
                    intent.putExtra("record",aciertos);
                    setResult(0,intent);
                    finish();
                }


                break;
        }
    }
}