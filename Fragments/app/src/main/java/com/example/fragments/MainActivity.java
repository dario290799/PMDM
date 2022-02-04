package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fragments.fragments.FragmentDos;
import com.example.fragments.fragments.FragmentUno;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonF1, botonF2, botonComprobar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        initFragments();
        acciones();
    }

    private void initFragments() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        // Que empiece por el Fragments Uno
        fragmentTransaction.replace(R.id.sitio_fragments, new FragmentUno());
        fragmentTransaction.addToBackStack("f1");
        fragmentTransaction.commit();
    }

    private void acciones() {
        botonF1.setOnClickListener(this);
        botonF2.setOnClickListener(this);
        botonComprobar.setOnClickListener(this);
    }

    private void instancias() {
        botonF1 = findViewById(R.id.boton_fragment1);
        botonF2 = findViewById(R.id.boton_fragment2);
        botonComprobar = findViewById(R.id.boton_comprobar);
    }

    @Override
    public void onClick(View view) {

        fragmentManager = getSupportFragmentManager();

        // Al fragmentTransaction se accede desde fragmentManager
        fragmentTransaction = fragmentManager.beginTransaction();

        Log.v("fragments", String.valueOf(fragmentManager.getBackStackEntryCount()));

        switch (view.getId()){
            case R.id.boton_fragment1:
                FragmentUno fragmentUno = (FragmentUno) fragmentManager.findFragmentByTag("F1");
                fragmentTransaction.replace(R.id.sitio_fragments, new FragmentUno(), "F1");
                if (fragmentUno != null){
                    fragmentTransaction.addToBackStack("F1");
                }
                // Lo añades a la pila
                fragmentTransaction.addToBackStack("F1");
                break;
            case R.id.boton_fragment2:
                FragmentDos fragmentDos = (FragmentDos) fragmentManager.findFragmentByTag("F2");
                fragmentTransaction.replace(R.id.sitio_fragments, new FragmentDos(), "F2");
                if (fragmentDos != null){
                    fragmentTransaction.addToBackStack("F2");
                }
                // Lo añades a la pila
                fragmentTransaction.addToBackStack("F2");
                break;
            case R.id.boton_comprobar:
                FragmentUno fragmentUno1 = (FragmentUno) fragmentManager.findFragmentByTag("F1");
                if (fragmentUno1 != null){
                    Log.v("Fragments", "El F1 en la pila");
                }
                break;
        }
        // Gararntizo la transición
        fragmentTransaction.commit();
    }

    // Gestionar el ir hacia atras
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0){
            finish();
        }
        // Log.v("fragments", String.valueOf(getSupportFragmentManager().getBackStackEntryCount()));
        // Log.v("fragments", "Pulsado ir hacia atras");
    }
}