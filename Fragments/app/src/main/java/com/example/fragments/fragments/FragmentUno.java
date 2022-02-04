package com.example.fragments.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments.R;

public class FragmentUno extends Fragment {

    protected View view;
    private EditText editFragment1;
    private Button buttonFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_uno_layout, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
    }

    private void instancias() {
        buttonFragment = view.findViewById(R.id.boton_fragment1);
        editFragment1 = view.findViewById(R.id.edit_fragment1);
    }
}
