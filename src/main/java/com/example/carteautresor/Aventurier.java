package com.example.carteautresor;

import java.util.List;

public class Aventurier {

    private String nom;

    private int posX;

    private int posY;

    private String orientation;

    private List<String> mouvements;

    private int sacoche;

    public Aventurier(String nom, int posX, int posY, String orientation, List<String> mouvements) {
        this.nom = nom;
        this.posX = posX;
        this.posY = posY;
        this.orientation = orientation;
        this.mouvements = mouvements;
        this.sacoche = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public List<String> getMouvements() {
        return mouvements;
    }

    public void setMouvements(List<String> mouvements) {
        this.mouvements = mouvements;
    }

    public int getSacoche() {
        return sacoche;
    }

    public void setSacoche(int sacoche) {
        this.sacoche = sacoche;
    }

    @Override
    public String toString() {
        return "A("+ nom +")";
    }
}
