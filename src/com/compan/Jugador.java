package com.compan;

public class Jugador {

    private final char ficha;
    private final String nombre;

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
