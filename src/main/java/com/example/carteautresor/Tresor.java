package com.example.carteautresor;

public class Tresor extends Plaine {
    private int nbTresor;

    public Tresor(int posX, int posY, boolean vide, int nbTresor) {
        super(posX, posY, vide);
        this.nbTresor = nbTresor;
    }

    public int getNbTresor() {
        return nbTresor;
    }

    public void setNbTresor(int nbTresor) {
        this.nbTresor = nbTresor;
    }

    @Override
    public String toString() {
        return "T("+ nbTresor +")";
    }
}
