package com.example.contrasenas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AnadirContrasenas extends AppCompatActivity {
    private Button anadirContrasena, volverAlmacen;
    private EditText nombreCuenta, emailCuenta, contrasenaCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_contrasenas);
        anadirContrasena = (Button) findViewById(R.id.anadirContrasena);
        volverAlmacen = (Button) findViewById(R.id.volverAlmacen);
        nombreCuenta = (EditText) findViewById(R.id.nombreCuenta);
        emailCuenta = (EditText) findViewById(R.id.emailCuenta);
        contrasenaCuenta = (EditText) findViewById(R.id.contrasenaCuenta);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Cuenta");
        DatabaseReference myRef1 = database.getReference("Email");
        DatabaseReference myRef2 = database.getReference("Contraseña");
        anadirDatos(myRef, myRef1, myRef2);
        Volver();
    }

    private void Volver() {
        volverAlmacen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnadirContrasenas.this,Almacen_Contrasenas.class));
            }
        });
    }

    private void anadirDatos(DatabaseReference myRef, DatabaseReference myRef1, DatabaseReference myRef2) {
        anadirContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.setValue(nombreCuenta.toString());
                myRef1.setValue(emailCuenta.toString());
                myRef2.setValue(contrasenaCuenta.toString());
            }
        });
    }
}