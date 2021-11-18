package com.example.contrasenas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registrarse extends AppCompatActivity {
    private static final String TAG = "RegistrarUsuario";
    private Button registroUsuario;
    private EditText emailregistro;
    private EditText contrasenaRegistro;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        //Firebase
        mAuth = FirebaseAuth.getInstance();
        //EditText
        emailregistro = (EditText)findViewById(R.id.emailRegistro);
        contrasenaRegistro = (EditText)findViewById(R.id.contrasenaRegistro);
        //Botones
        registroUsuario = (Button) findViewById(R.id.registroUsuario);
        //Registro Usuario
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {

                    startActivity(new Intent(registrarse.this, MainActivity.class));

                } else {
                    // Toast.makeText(MainActivity.this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();

                }
            }
        };
        registroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void registrarUsuario() {


        String emailR = emailregistro.getText().toString();
        String passwordR = contrasenaRegistro.getText().toString();

        mAuth.createUserWithEmailAndPassword(emailR, passwordR)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail", task.getException());
                            Toast.makeText(registrarse.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}