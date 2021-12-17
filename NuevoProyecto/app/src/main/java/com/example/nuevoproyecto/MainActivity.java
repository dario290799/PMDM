package com.example.nuevoproyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.nuevoproyecto.Dialog.DialogoConfirmacion;
import com.example.nuevoproyecto.Dialog.DialogoInformacion;
import com.example.nuevoproyecto.Dialog.DialogoListas;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_op1:
                //Toast.makeText(getApplicationContext(),"Opcion1",Toast.LENGTH_SHORT);
                //Dialogo info

                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(getSupportFragmentManager(),"información");
                break;
            case R.id.menu_op2:
                //Toast.makeText(getApplicationContext(),"Opcion2",Toast.LENGTH_SHORT);
                DialogoListas dialogoListas = new DialogoListas();
                dialogoListas.show(getSupportFragmentManager(),"Listas");
                break;
            case R.id.menu_op3:
                Toast.makeText(getApplicationContext(),"Opcion3",Toast.LENGTH_SHORT);
                break;
            case R.id.menu_op4:
                //Toast.makeText(getApplicationContext(),"Opcion4",Toast.LENGTH_SHORT);
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show(getSupportFragmentManager(),"Confirmacíon");
                break;
        }
        return true;
    }
}