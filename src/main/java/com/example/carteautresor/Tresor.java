package com.example.carteautresor;

/**
 * Classe décrivant un trésor et héritant de la classe Plaine
 */
public class Tresor extends Plaine {
    private int nbTresor;

    /**
     * Constructeur de la classe Tresor
     * @param posX
     * @param posY
     * @param nbTresor
     */
    public Tresor(int posX, int posY, int nbTresor) {
        super(posX, posY, false);
        this.nbTresor = nbTresor;
    }

    /**
     * Getter
     * @return nbTresor
     */
    public int getNbTresor() {
        return nbTresor;
    }

    /**
     * Setter
     * @param nbTresor
     */
    public void setNbTresor(int nbTresor) {
        this.nbTresor = nbTresor;
    }

    @Override
    public String toString() {
        return " T("+ nbTresor +") ";
    }
}
