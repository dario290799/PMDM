package com.example.calculadora.Utils;

public class Operacion {
    private double numeroUno, numeroDos;
    private String operacion;

    public Operacion(double numeroUno, double numeroDos, String operacion) {
        this.numeroUno = numeroUno;
        this.numeroDos = numeroDos;
        this.operacion = operacion;
    }

    public double getNumeroUno() {
        return numeroUno;
    }

    public void setNumeroUno(double numeroUno) {
        this.numeroUno = numeroUno;
    }

    public double getNumeroDos() {
        return numeroDos;
    }

    public void setNumeroDos(double numeroDos) {
        this.numeroDos = numeroDos;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
}
