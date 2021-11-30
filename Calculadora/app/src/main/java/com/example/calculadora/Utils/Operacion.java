package com.example.calculadora.Utils;

public class Operacion {
    // Atributos
    private double numero1, numero2;
    private String operacion;


    public Operacion(double numero1, double numero2, String operacion) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacion = operacion;
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}
