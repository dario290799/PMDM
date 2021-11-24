package com.example.examendario.Utils;

public class Vehiculo {

    private String marca,modelo;
    private int cv,peso;

    //constructor

    public Vehiculo(String marca, String modelo, int cv, int peso) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.peso = peso;
    }
    public Vehiculo(){}

    //Getter & Setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}
