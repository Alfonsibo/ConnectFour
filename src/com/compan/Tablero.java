package com.compan;

import java.util.Arrays;

public class Tablero {

    private Ficha[][] matrizTablero;

    public Tablero() {
        matrizTablero = new Ficha[6][8];
    }

    public Tablero(char[][] matrizTablero) {
        this.matrizTablero = matrizTablero;
    }

    public char[][] getMatrizTablero() {
        return matrizTablero;
    }

    public void setMatrizTablero(char[][] matrizTablero) {
        this.matrizTablero = matrizTablero;
    }

    public boolean insertarFichaEnFila(char ficha, int columna) {
        matrizTablero[columna][7] == '';
    }

    @Override
    public String toString() {
        //TODO PINTAR ESTO POR PANTALLA COMO SE VE EN LA IMAGEN DEL EJERCICIO
        return "Tablero{" +
                "matrizTablero=" + Arrays.toString(matrizTablero) +
                '}';
    }
}
