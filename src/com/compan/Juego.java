package com.compan;


import java.util.Scanner;

public class Juego {

    private final byte NUMERO_JUGADORES = 2;

    private final Tablero tablero;
    private final Jugador[] jugadores;

    private Jugador jugadorActual;
    private Jugador jugadorGanador;
    private int turnos = 0;

    Scanner scanner = new Scanner(System.in);

    public Juego() {
        tablero = new Tablero();
        jugadores = new Jugador[NUMERO_JUGADORES];
    }

    public void iniciarJuego() {
        System.out.println(tablero);
        crearJugadores();
        jugar();
    }

    private void jugar() {
        while (turnos < Tablero.MAXIMO_NUMERO_COLUMNAS * Tablero.MAXIMO_NUMERO_FILAS && jugadorGanador == null) {
            jugadorActual = jugadores[turnos % 2];
            meterFicha();

            System.out.println(tablero);
            turnos++;
        }
        scanner.close();
        terminarJuego();
    }

    private void terminarJuego() {
        if (jugadorGanador != null) {
            System.out.println("Ha ganado " + jugadorGanador);
        } else {
            System.out.println("Los jugadores han quedado empate.");
        }
    }

    private void comprobarGanador() {
        if (turnos > 5 && tablero.comprobarFichasConectadas(jugadorActual.getFicha())) { //Movimientos minimos para ganar 5
            jugadorGanador = jugadorActual;
        }
    }

    private void crearJugadores() {
        for (int i = 0; i < NUMERO_JUGADORES; i++) {
            crearJugador(i);
        }
    }

    private void crearJugador(int numeroJugador) {
        String nombreJugador = obtenerNombreJugador(numeroJugador + 1);

        if (numeroJugador == 0) { //ES EL JUGADOR 1 Y VA CON NEGRAS
            jugadores[numeroJugador] = new Jugador(TipoFicha.NEGRA.getCaracterFicha(), nombreJugador);
        } else { //ES EL JUGADOR 2 Y VA CON BLANCAS
            jugadores[numeroJugador] = new Jugador(TipoFicha.BLANCA.getCaracterFicha(), nombreJugador);
        }
    }

    private String obtenerNombreJugador(int numeroJugador) {
        System.out.println("Jugador " + numeroJugador + " elige tu nombre: ");
        return scanner.nextLine();
    }

    private void meterFicha() {
        int columna = obtenerColumnaFicha();
        boolean fichaInsertada = tablero.insertarFichaEnTablero(jugadorActual.getFicha(), columna);
        while (!fichaInsertada) {
            System.out.print("La columna " + (columna + 1) + " ya esta llena. ");
            columna = obtenerColumnaFicha();
            fichaInsertada = tablero.insertarFichaEnTablero(jugadorActual.getFicha(), columna);
        }

        comprobarGanador();
    }

    private int obtenerColumnaFicha() {
        System.out.println("Introduzca la columna donde va a insertar ficha " + jugadorActual + ":");
        int columna = leerColumna();
        while (columna < 1 || columna > Tablero.MAXIMO_NUMERO_COLUMNAS) {
            System.out.println("Numero de columna erroneo " + jugadorActual
                    + ", introduzca un valor comprendido entre 1 y " + Tablero.MAXIMO_NUMERO_COLUMNAS + ": ");
            columna = leerColumna();
        }
        return columna - 1;
    }

    private int leerColumna() {
        return scanner.nextInt();
    }

}
