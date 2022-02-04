package com.example.repasoexamen.Utils;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.repasoexamen.R;
import com.google.android.material.navigation.NavigationView;

public class Transicion extends AppCompatActivity {
    private Toolbar toolbarInicio;
    private Button botonToolbar;
    private NavigationView menuLateral;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transicion);
        instancias();
        acciones();
        menuLateral();
    }


    private void instancias() {
        toolbarInicio = (Toolbar) findViewById(R.id.toolbarInicio);
        botonToolbar = (Button) findViewById(R.id.botonToolbar);
        menuLateral = (NavigationView) findViewById(R.id.menuLateral);
    }
    private void acciones() {
        botonToolbar.setOnClickListener((View.OnClickListener) this);
    }
    private void menuLateral() {
        botonToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

}
