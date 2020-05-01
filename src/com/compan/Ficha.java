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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ficha ficha = (Ficha) o;
        return tipoFicha.getCaracterFicha() == ficha.tipoFicha.getCaracterFicha();
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
