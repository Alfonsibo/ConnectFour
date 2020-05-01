package com.compan;

public class Tablero {

    public static final byte MAXIMO_NUMERO_COLUMNAS = 8;
    public static final byte MAXIMO_NUMERO_FILAS = 6;

    private Ficha[][] matrizTablero;

    public Tablero() {
        matrizTablero = new Ficha[MAXIMO_NUMERO_FILAS][MAXIMO_NUMERO_COLUMNAS];
    }
    /*
            _________________________________
          5 | o |   |   |   |   |   |   |   |
            _________________________________
          4 | x |   |   |   |   |   |   |   |
            _________________________________
          3 | o |   |   |   |   |   |   |   |
            _________________________________
          2 | x | x |   |   |   |   |   |   |
            _________________________________
          1 | o | o |   | o |   |   |   |   |
            _________________________________
          0 | o | x | x | o |   |   |   |   |
            ---------------------------------
              0   1   2   3   4   5   6   7
    */

    /**
     * Inserta la ficha pasada por parametros en la columna que también se paso como parametro.
     * @param ficha la ficha que se va a insertar dentro del tablero.
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

    public void comprobarFichasConectadas(Ficha ficha) {
        for (int i = 0; i < matrizTablero.length; i++) {
            for (int j = 0 ; j < matrizTablero[i].length ; j++) {

            }
        }
    }

    @Override
    public String toString() {
        String cadena = "_________________________________\n";
        for (int i = 0; i < matrizTablero.length; i++) {
            for (int j = 0 ; j < matrizTablero[i].length ; j++) {
                if (matrizTablero[i][j] == null) {
                    cadena += "|   ";
                } else {
                    cadena += "| " + matrizTablero[i][j] + " ";
                }
            }
            cadena += "|\n_________________________________\n";
        }
        return cadena;
    }
}
