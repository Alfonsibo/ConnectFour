package com.compan;

public class Ficha {

    private char ficha;

    public Ficha(char ficha) {
        this.ficha = ficha;
    }

    public char getFicha() {
        return ficha;
    }

    public void setFicha(char ficha) {
        this.ficha = ficha;
    }

    @Override
    public String toString() {
        return String.valueOf(ficha);
    }

}
