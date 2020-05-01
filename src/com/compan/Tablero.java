package com.compan;

public class Tablero {

    public static final byte MAXIMO_NUMERO_COLUMNAS = 8;
    public static final byte MAXIMO_NUMERO_FILAS = 6;

    private final char[][] matrizTablero;

    public Tablero() {
        matrizTablero = new char[MAXIMO_NUMERO_FILAS][MAXIMO_NUMERO_COLUMNAS];
    }

    /**
     * Inserta la ficha pasada por parametros en la columna que también se paso como parametro.
     *
     * @param ficha   la ficha que se va a insertar dentro del tablero.
     * @param columna la columna donde se quiere insertar la ficha dentro del tablero.
     * @return boolean false en caso de que no haya espacio en la columna para insertar la ficha o true en caso contrario.
     */
    public boolean insertarFichaEnTablero(char ficha, int columna) {
        if (matrizTablero[MAXIMO_NUMERO_FILAS - 1][columna] == '\u0000') {
            insertarFichaEnColumna(ficha, columna);
            return true;
        } else {
            return false;
        }
    }

    private void insertarFichaEnColumna(char ficha, int columna) {
        for (int filas = 0; filas < matrizTablero.length; filas++) {
            if (matrizTablero[filas][columna] == '\u0000') {
                matrizTablero[filas][columna] = ficha;
                break;
            }
        }
    }

    public boolean comprobarFichasConectadas(char ficha) {
        for (int filas = 0; filas < matrizTablero.length; filas++) {
            for (int columnas = 0; columnas < matrizTablero[filas].length; columnas++) {

                // This is the current element in our matrix
                char tFicha = matrizTablero[filas][columnas];
                if (tFicha == ficha) {

                    if (columnas <= matrizTablero[filas].length - 4
                            && ficha == matrizTablero[filas][columnas + 1]
                            && ficha == matrizTablero[filas][columnas + 2]
                            && ficha == matrizTablero[filas][columnas + 3])
                        return true;

                    if (filas <= matrizTablero.length - 4
                            && ficha == matrizTablero[filas + 1][columnas]
                            && ficha == matrizTablero[filas + 2][columnas]
                            && ficha == matrizTablero[filas + 3][columnas]) {
                        return true;
                    }

                    if (filas <= matrizTablero.length - 4 && columnas <= matrizTablero[filas].length - 4) {
                        if (ficha == matrizTablero[filas + 1][columnas + 1]
                                && ficha == matrizTablero[filas + 2][columnas + 2]
                                && ficha == matrizTablero[filas + 3][columnas + 3])
                            return true;
                    }

                    if (filas <= matrizTablero.length - 4 && columnas >= matrizTablero[filas].length - 4) {
                        if (ficha == matrizTablero[filas + 1][columnas - 1]
                                && ficha == matrizTablero[filas + 2][columnas - 2]
                                && ficha == matrizTablero[filas + 3][columnas - 3])
                            return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder("_________________________\n");
        for (int filas = matrizTablero.length - 1; filas >= 0; filas--) {
            for (int columnas = 0; columnas < matrizTablero[filas].length; columnas++) {
                if (matrizTablero[filas][columnas] == '\u0000') {
                    cadena.append("|  ");
                } else {
                    cadena.append("|").append(matrizTablero[filas][columnas]);
                }
            }
            cadena.append("|\n_________________________\n");
        }
        return cadena.toString();
    }
}
