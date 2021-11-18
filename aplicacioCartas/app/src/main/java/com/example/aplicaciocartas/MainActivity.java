package com.example.aplicaciocartas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button inicio;
    private TextView textRecord;
    private CheckBox check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        inicio.setOnClickListener(this);
    }

    private void instancias() {
        inicio = findViewById(R.id.inicio);
        check = findViewById(R.id.check);
        textRecord = findViewById(R.id.textRecord);
    }

    @Override
    public void onClick(View v) {
        // empezar una pantalla, dependiendo de la practica

        Intent intent = new Intent(getApplicationContext(), juego.class);

        if (check.isChecked()){
            // si estoy practicado --> arranco practicado (REQUEST 0)
            startActivityForResult(intent,0);
        } else {
            // si estoy jugando --> arranco jugando (REQUEST 1)
            startActivityForResult(intent,1);
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // si el request es 1 --> jugando
        if (requestCode == 1){
            // recuepero el aciertos del DATA
            data.getExtras().getString("aciertos");
        }
    }
}