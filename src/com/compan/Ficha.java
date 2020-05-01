package com.compan;

public class Ficha {

    private TipoFicha tipoFicha;

    public Ficha(TipoFicha tipoFicha) {
        this.tipoFicha = tipoFicha;
    }

    @Override
    public String toString() {
        return String.valueOf(tipoFicha.getCaracterFicha());
    }

    public enum TipoFicha {
        BLANCA('☻'),
        NEGRA('☺');

        private final char caracterFicha;

        private TipoFicha(char caracterFicha) {
            this.caracterFicha = caracterFicha;
        }

        public char getCaracterFicha() {
            return caracterFicha;
        }
    }
}
