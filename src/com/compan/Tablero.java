package com.compan;

public class Tablero {

    public static final byte MAXIMO_NUMERO_COLUMNAS = 8;
    public static final byte MAXIMO_NUMERO_FILAS = 6;

    private Ficha[][] matrizTablero;

    public Tablero() {
        matrizTablero = new Ficha[MAXIMO_NUMERO_FILAS][MAXIMO_NUMERO_COLUMNAS];
    }

    /**
     * Inserta la ficha pasada por parametros en la columna que también se paso como parametro.
     *
     * @param ficha   la ficha que se va a insertar dentro del tablero.
     * @param columna la columna donde se quiere insertar la ficha dentro del tablero.
     * @return boolean false en caso de que no haya espacio en la columna para insertar la ficha o true en caso contrario.
     */
    public boolean insertarFichaEnTablero(Ficha ficha, int columna) {
        if (matrizTablero[columna][MAXIMO_NUMERO_COLUMNAS - 1] == null) {
            insertarFichaEnColumna(ficha, columna);
            return true;
        } else {
            return false;
        }
    }

    private void insertarFichaEnColumna(Ficha ficha, int columna) {
        for (int i = 0; i < matrizTablero[columna].length; i++) {
            if (matrizTablero[columna][i] == null) {
                matrizTablero[columna][i] = ficha;
            }
        }
    }

    public boolean comprobarFichasConectadas(Ficha ficha, int columnaFichaInsertada) {
        if (columnaFichaInsertada > 3) {
            for (int filas = 0; filas < matrizTablero.length; filas++) {
                for (int columnas = 0; columnas < matrizTablero[filas].length; columnas++) {
                    Ficha tFicha = matrizTablero[filas][columnas];

                    if (columnas <= matrizTablero[filas].length - 4
                            && tFicha == matrizTablero[filas][columnas + 1]
                            && tFicha == matrizTablero[filas][columnas + 2]
                            && tFicha == matrizTablero[filas][columnas + 3]) {
                        return true;
                    }

                    if (filas <= matrizTablero.length - 4
                            && tFicha == matrizTablero[filas + 1][columnas]
                            && tFicha == matrizTablero[filas + 2][columnas]
                            && tFicha == matrizTablero[filas + 3][columnas]) {
                        return true;
                    }

                    if (filas <= matrizTablero.length - 4 && columnas <= matrizTablero[filas].length - 4) {
                        if (tFicha == matrizTablero[filas + 1][columnas + 1]
                                && tFicha == matrizTablero[filas + 2][columnas + 2]
                                && tFicha == matrizTablero[filas + 3][columnas + 3]) {
                            return true;
                        }
                    }

                    if (filas <= matrizTablero.length - 4 && columnas >= matrizTablero[filas].length - 4) {
                        // If the current element equals each element diagonally to the bottom left
                        if (tFicha == matrizTablero[filas + 1][columnas - 1]
                                && tFicha == matrizTablero[filas + 2][columnas - 2]
                                && tFicha == matrizTablero[filas + 3][columnas - 3]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }

    @Override
    public String toString() {
        String cadena = "_________________________________\n";
        for (int filas = 0; filas < matrizTablero.length; filas++) {
            for (int columnas = 0; columnas < matrizTablero[filas].length; columnas++) {
                if (matrizTablero[filas][columnas] == null) {
                    cadena += "|   ";
                } else {
                    cadena += "| " + matrizTablero[filas][columnas] + " ";
                }
            }
            cadena += "|\n_________________________________\n";
        }
        return cadena;
    }
}
