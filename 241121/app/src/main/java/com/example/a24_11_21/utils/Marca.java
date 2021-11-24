package com.example.a24_11_21.utils;

public class Marca {


    private String marca;

    private int imagen;

    public Marca(String marca, int imagen) {
        marca = marca;
        this.imagen = imagen;
    }
    public Marca(String marca){
        this.marca=marca;
    }
    public Marca(){}

    //getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


}
