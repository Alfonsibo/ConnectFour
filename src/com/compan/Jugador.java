package com.compan;

public class Jugador {

    private char ficha;
    private String nombre;

    public Jugador(char ficha, String nombre) {
        this.ficha = ficha;
        this.nombre = nombre;
    }

    public char getFicha() {
        return ficha;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
