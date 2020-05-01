package com.compan;

public class Jugador {

    private Ficha ficha;
    private String nombre;

    public Jugador(Ficha ficha, String nombre) {
        this.ficha = ficha;
        this.nombre = nombre;
    }

    public Ficha getFicha() {
        return ficha;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
