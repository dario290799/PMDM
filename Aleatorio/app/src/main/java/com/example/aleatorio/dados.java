package com.example.aleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class dados extends AppCompatActivity {
    private Button tirarDados;
    private ImageView imageDado;
    private int dadoActual;
    int[] dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        tirarDados=(Button) findViewById(R.id.tirarDados);
        imageDado=(ImageView) findViewById(R.id.imageDado);
        dados = new int[]{R.drawable.dado_uno, R.drawable.dado_dos, R.drawable.dado_tres,
                R.drawable.dado_cuatro, R.drawable.dado_cinco, R.drawable.dado_seis};
    }
    public void dadoRamdom(){
        tirarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dadoActual = (int) (Math.random()*6);
                imageDado.setImageResource(dados[dadoActual]);
            }
        });
    }
}