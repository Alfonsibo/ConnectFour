package com.compan;

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
