package com.example.nuevoproyecto.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoListas extends DialogFragment {
    private Context context;
    private String opcionSelecionada;

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Dialogo Listas");
        CharSequence[] opciones = new CharSequence[]{"Opcion1", "Opcion2", "Opcion3"};
        /*alertDialog.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, opciones[i], Toast.LENGTH_SHORT).show();
            }
        });
        return super.onCreateDialog(savedInstanceState);
         */
        alertDialog.setSingleChoiceItems(opciones, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                opcionSelecionada = (String) opciones[i];
                Toast.makeText(context, opciones[i], Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setPositiveButton("Seleccion", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, opcionSelecionada, Toast.LENGTH_SHORT).show();
            }
        });
        return alertDialog.create();
    }
}
