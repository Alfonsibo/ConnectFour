package com.compan;


import java.util.Scanner;

public class Juego {

    private final byte NUMERO_JUGADORES = 2;

    private final Tablero tablero;
    private final Jugador[] jugadores;

    private Jugador siguienteJugador;
    private Jugador jugadorGanador;
    private int turnos = 0;

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
            siguienteJugador = jugadores[turnos % 2];
            meterFicha();

            System.out.println(tablero);

            if (turnos > 5) {
                comprobarGanador();
            }
            turnos++;
        }
    }

    private void comprobarGanador() {
        tablero.comprobarFichasConectadas(siguienteJugador.getFicha());
    }

    private void crearJugadores() {
        for (int i = 0; i < NUMERO_JUGADORES; i++) {
            crearJugador(i);
        }
    }

    private void crearJugador(int numeroJugador) {
        String nombreJugador = obtenerNombreJugador(numeroJugador + 1);

        if (numeroJugador == 0) { //ES EL JUGADOR 1 Y VA CON NEGRAS
            jugadores[numeroJugador] = new Jugador(new Ficha(Ficha.TipoFicha.NEGRA), nombreJugador);
        } else { //ES EL JUGADOR 2 Y VA CON BLANCAS
            jugadores[numeroJugador] = new Jugador(new Ficha(Ficha.TipoFicha.BLANCA), nombreJugador);
        }
    }

    private String obtenerNombreJugador(int numeroJugador) {
        System.out.println("Jugador " + numeroJugador + " elige tu nombre: ");

        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.next();
        scanner.close();
        return nombre;
    }

    private void meterFicha() {
        tablero.insertarFichaEnTablero(siguienteJugador.getFicha(), obtenerColumnaFicha());
    }

    private byte obtenerColumnaFicha() {
        System.out.println("Introduzca la columna donde va a insertar ficha " + siguienteJugador);
        byte columna = leerColumna();
        while (columna < 1 || columna > Tablero.MAXIMO_NUMERO_COLUMNAS) {
            System.out.println("Numero de columna erroneo " + siguienteJugador
                    + ", introduzca un valor comprendido entre 1 y " + Tablero.MAXIMO_NUMERO_COLUMNAS);
            columna = leerColumna();
        }
        return columna;
    }

    private byte leerColumna() {
        Scanner scanner = new Scanner(System.in);
        byte b = scanner.nextByte();
        scanner.close();
        return b;
    }

}
