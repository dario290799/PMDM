package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.calculadora.Utils.Operacion;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Variables

    // Vertical
    private Button cero,uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,borrar,igual,decimal,sumar,restar,multiplicar,dividir,X2,X3;
    // Horizontal
    private Button sin,cos,tan,sqrt,log;
    private String numeroUno = "";
    private String numeroDos = "";
    private Operacion operacion;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();

        // Cambiar la orientación de la pantalla
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            horizontal();
        }

        // Constructor de la clase operación
        operacion = new Operacion(0, 0, null);
    }

    private void horizontal() {
        sin.setOnClickListener(this::onClick);
        cos.setOnClickListener(this::onClick);
        tan.setOnClickListener(this::onClick);
        sqrt.setOnClickListener(this::onClick);
        log.setOnClickListener(this::onClick);
    }

    private void acciones() {
        cero.setOnClickListener(this::onClick);
        uno.setOnClickListener(this::onClick);
        dos.setOnClickListener(this::onClick);
        tres.setOnClickListener(this::onClick);
        cuatro.setOnClickListener(this::onClick);
        cinco.setOnClickListener(this::onClick);
        seis.setOnClickListener(this::onClick);
        siete.setOnClickListener(this::onClick);
        ocho.setOnClickListener(this::onClick);
        nueve.setOnClickListener(this::onClick);
        borrar.setOnClickListener(this::onClick);
        dividir.setOnClickListener(this::onClick);
        multiplicar.setOnClickListener(this::onClick);
        restar.setOnClickListener(this::onClick);
        sumar.setOnClickListener(this::onClick);
        igual.setOnClickListener(this::onClick);
        X2.setOnClickListener(this::onClick);
        X3.setOnClickListener(this::onClick);
    }

    private void instancias() {
        cero = findViewById(R.id.cero);
        uno = findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        tres = findViewById(R.id.tres);
        cuatro = findViewById(R.id.cuatro);
        cinco = findViewById(R.id.cinco);
        seis = findViewById(R.id.seis);
        siete = findViewById(R.id.siete);
        ocho = findViewById(R.id.ocho);
        nueve = findViewById(R.id.nueve);
        borrar = findViewById(R.id.borrar);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        sqrt = findViewById(R.id.btn_sqrt);
        tan = findViewById(R.id.tan);
        log = findViewById(R.id.btn_log);
        dividir = findViewById(R.id.dividir);
        multiplicar = findViewById(R.id.multiplicar);
        sumar = findViewById(R.id.sumar);
        restar = findViewById(R.id.restar);
        igual = findViewById(R.id.igual);
        textResultado = findViewById(R.id.textResultado);
        X2 = findViewById(R.id.bX2);
        X3 = findViewById(R.id.X3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Numeros
            case R.id.cero:
                textResultado.append(cero.getText());
                break;
            case R.id.uno:
                textResultado.append(uno.getText());
                break;
            case R.id.dos:
                textResultado.append(dos.getText());
                break;
            case R.id.tres:
                textResultado.append(tres.getText());
                break;
            case R.id.cuatro:
                textResultado.append(cuatro.getText());
                break;
            case R.id.cinco:
                textResultado.append(cinco.getText());
                break;
            case R.id.seis:
                textResultado.append(seis.getText());
                break;
            case R.id.siete:
                textResultado.append(siete.getText());
                break;
            case R.id.ocho:
                textResultado.append(ocho.getText());
                break;
            case R.id.nueve:
                textResultado.append(nueve.getText());
                break;

            // Operaciones
            case R.id.sumar:
                operacion.setOperacion("+");
                añadirNumero();
                break;
            case R.id.restar:
                operacion.setOperacion("-");
                añadirNumero();
                break;
            case R.id.multiplicar:
                operacion.setOperacion("*");
                añadirNumero();
                break;
            case R.id.dividir:
                operacion.setOperacion("/");
                añadirNumero();
                break;
            case R.id.bX2:
                operacion.setOperacion("X2");
                añadirNumero();
                hacerCalculo();
                break;
            case R.id.X3:
                operacion.setOperacion("X3");
                añadirNumero();
                hacerCalculo();
                break;
            case R.id.btn_log:
                operacion.setOperacion("log");
                añadirNumero();
                hacerCalculo();
                break;
            case R.id.btn_sqrt:
                operacion.setOperacion("sqrt");
                añadirNumero();
                hacerCalculo();
                break;
            case R.id.cos:
                operacion.setOperacion("cos");
                añadirNumero();
                hacerCalculo();
                break;
            case R.id.sin:
                operacion.setOperacion("sin");
                añadirNumero();
                hacerCalculo();
                break;
            case R.id.tan:
                operacion.setOperacion("tan");
                añadirNumero();
                hacerCalculo();
                break;

            // Igual
            case R.id.igual:
                añadirNumero();
                hacerCalculo();
                operacion.setOperacion(null);
                break;

            // Borrar
            case R.id.borrar:
                operacion.setOperacion(null);
                numeroUno = "";
                numeroDos = "";
                operacion.setNumero1(0);
                operacion.setNumero2(0);
                textResultado.setText("");
                break;

        }
    }

    private void hacerCalculo() {

        double resultado = 0;
        operacion.setNumero1(Integer.parseInt(numeroUno));
        if (numeroDos.length() > 0) {
            operacion.setNumero2(Integer.parseInt(numeroDos));
        }
        switch (operacion.getOperacion()) {
            case "+":
                resultado = (operacion.getNumero1() + operacion.getNumero2());
                textResultado.setText(String.valueOf(resultado));
                break;
            case "-":
                resultado = (operacion.getNumero1() - operacion.getNumero2());
                textResultado.setText(String.valueOf(resultado));
                break;
            case "*":
                resultado = (operacion.getNumero1() * operacion.getNumero2());
                textResultado.setText(String.valueOf(resultado));
                break;
            case "/":
                resultado = (operacion.getNumero1() / operacion.getNumero2());
                textResultado.setText(String.valueOf(resultado));
                break;
            case "X2":
                resultado = (operacion.getNumero1() * operacion.getNumero1());
                textResultado.setText(String.valueOf(resultado));
                break;
            case "X3":
                resultado = Math.pow(operacion.getNumero1(), 3);
                textResultado.setText(String.valueOf(resultado));
                break;
            case "sin":
                resultado = Math.sin(operacion.getNumero1());
                textResultado.setText(String.valueOf(resultado));
                break;
            case "cos":
                resultado = Math.cos(operacion.getNumero1());
                textResultado.setText(String.valueOf(resultado));
                break;
            case "log":
                resultado = Math.log10(operacion.getNumero1());
                textResultado.setText(String.valueOf(resultado));
                break;
            case "sqrt":
                resultado = Math.sqrt(operacion.getNumero1());
                textResultado.setText(String.valueOf(resultado));
                break;
            case "tan":
                resultado = Math.tan(operacion.getNumero1());
                textResultado.setText(String.valueOf(resultado));
                break;
        }
        Log.v("text", String.valueOf(numeroUno));
        Log.v("text", String.valueOf(numeroDos));
    }

    private void añadirNumero() {

        if (numeroUno.length() == 0) {

            numeroUno = textResultado.getText().toString();
            Log.v("text", String.valueOf(numeroUno));
            Log.v("text", String.valueOf(numeroUno.length()));
        } else if (numeroUno.length() > 0 && numeroDos.length() == 0) {
            numeroDos = textResultado.getText().toString();
            Log.v("text", String.valueOf(numeroDos));

        } else if (numeroUno.length() > 0 && numeroDos.length() > 0) {
            numeroUno = String.valueOf(textResultado.getText());
            numeroDos = "";
        }
        textResultado.setText("");
    }
}