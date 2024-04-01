package com.example.carteautresor;

public class Plaine {

    private int posX;

    private int posY;

    private boolean vide;

    public Plaine(int posX, int posY, boolean vide) {
        this.posX = posX;
        this.posY = posY;
        this.vide = vide;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isVide() {
        return vide;
    }

    public void setVide(boolean vide) {
        this.vide = vide;
    }

}
