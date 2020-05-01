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

    echo "# ConnectFour" >> README.md
    git init
    git add README.md
    git commit -m "first commit"
    git remote add origin https://github.com/Alfonsibo/ConnectFour.git
    git push -u origin master
}
