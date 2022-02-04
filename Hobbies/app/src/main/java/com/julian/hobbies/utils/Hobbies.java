package com.julian.hobbies.utils;

public class Hobbies {
    private String nombre,detalle;
    private int imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Hobbies(String nombre, String detalle, int imagen) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.imagen = imagen;
    }

    public Hobbies(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }
}
