package com.compan;

public enum TipoFicha {
    BLANCA('☻'),
    NEGRA('☺');

    private final char caracterFicha;

    TipoFicha(char caracterFicha) {
        this.caracterFicha = caracterFicha;
    }

    public char getCaracterFicha() {
        return caracterFicha;
    }
}
