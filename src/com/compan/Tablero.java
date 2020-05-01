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
        if (matrizTablero[MAXIMO_NUMERO_FILAS - 1][columna] == null) {
            insertarFichaEnColumna(ficha, columna);
            return true;
        } else {
            return false;
        }
    }

    private void insertarFichaEnColumna(Ficha ficha, int columna) {
        for (int filas = 0; filas < matrizTablero.length; filas++) {
            if (matrizTablero[filas][columna] == null) {
                matrizTablero[filas][columna] = ficha;
                break;
            }
        }
    }

    public boolean comprobarFichasConectadas(int columnaFichaInsertada) {
        if (columnaFichaInsertada > 3) {
            for (int filas = 0; filas < matrizTablero.length; filas++) {
                for (int columnas = 0; columnas < matrizTablero[filas].length; columnas++) {
                    Ficha tFicha = matrizTablero[filas][columnas];

                    if (columnas <= matrizTablero[filas].length - 4
                            && tFicha.equals(matrizTablero[filas][columnas + 1])
                            && tFicha.equals(matrizTablero[filas][columnas + 2])
                            && tFicha.equals(matrizTablero[filas][columnas + 3])) {
                        return true;
                    }

                    if (filas <= matrizTablero.length - 4
                            && tFicha.equals(matrizTablero[filas + 1][columnas])
                            && tFicha.equals(matrizTablero[filas + 2][columnas])
                            && tFicha.equals(matrizTablero[filas + 3][columnas])) {
                        return true;
                    }

                    if (filas <= matrizTablero.length - 4 && columnas <= matrizTablero[filas].length - 4) {
                        if (tFicha.equals(matrizTablero[filas + 1][columnas + 1])
                                && tFicha.equals(matrizTablero[filas + 2][columnas + 2])
                                && tFicha.equals(matrizTablero[filas + 3][columnas + 3])) {
                            return true;
                        }
                    }

                    if (filas <= matrizTablero.length - 4 && columnas >= matrizTablero[filas].length - 4) {
                        if (tFicha.equals(matrizTablero[filas + 1][columnas - 1])
                                && tFicha.equals(matrizTablero[filas + 2][columnas - 2])
                                && tFicha.equals(matrizTablero[filas + 3][columnas - 3])) {
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
        String cadena = "_________________________________________\n";
        for (int filas = matrizTablero.length - 1; filas >= 0; filas--) {
            for (int columnas = 0; columnas < matrizTablero[filas].length; columnas++) {
                if (matrizTablero[filas][columnas] == null) {
                    cadena += "|    ";
                } else {
                    cadena += "| " + matrizTablero[filas][columnas] + " ";
                }
            }
            cadena += "|\n_________________________________________\n";
        }
        return cadena;
    }
}
