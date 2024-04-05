package com.example.carteautresor;

public class Montagne extends Plaine {


    public Montagne(int posX, int posY) {
        super(posX, posY, false);
    }

    @Override
    public String toString() {
        return "  M  ";
    }
}
