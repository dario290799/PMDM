package com.example.elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    private ToggleButton toggle;
    private TextView textoToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }
    private void acciones(){
        toggle.setOnCheckedChangeListener( {


    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }
}