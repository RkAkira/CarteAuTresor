package com.example.carteautresor;

/**
 * Classe décrivant une plaine
 */
public class Plaine {

    private int posX;

    private int posY;

    private boolean vide;

    /**
     * Constructeur de la classe Plaine
     * @param posX
     * @param posY
     * @param vide
     */
    public Plaine(int posX, int posY, boolean vide) {
        this.posX = posX;
        this.posY = posY;
        this.vide = vide;
    }

    /**
     * Getter
     * @return posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Setter
     * @param posX
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Getter
     * @return posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Setter
     * @param posY
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Getter
     * @return vide
     */
    public boolean isVide() {
        return vide;
    }

    /**
     * Setter
     * @param vide
     */
    public void setVide(boolean vide) {
        this.vide = vide;
    }

}
