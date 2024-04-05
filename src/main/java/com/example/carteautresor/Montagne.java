package com.example.carteautresor;

/**
 * Classe décrivant une montagne héritant de la classe Plaine
 */
public class Montagne extends Plaine {

    /**
     * Constructeur de la classe Montagne
     * @param posX
     * @param posY
     */
    public Montagne(int posX, int posY) {
        super(posX, posY, false);
    }

    @Override
    public String toString() {
        return "  M  ";
    }
}
