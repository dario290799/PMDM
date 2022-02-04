package com.example.videosfragments.utils;

public class Usuario {

    // Atributos
    private String nombre, apellidos;

    // Constructor
    public Usuario(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }

    // Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
