package com.example.carteautresor;

import java.util.Iterator;
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

    public void bouger(Carte carte){
        Iterator<String> it = mouvements.iterator();
        outerLoop: while(it.hasNext()){
            String mvt = it.next();
            switch(mvt){
                case "A":
                    switch (orientation){
                        case "N":
                            posY+=1;
                            if(verifOnTheMap(carte)){
                                break outerLoop;
                            }
                            break;
                        case "S":
                            posY-=1;
                            if(verifOnTheMap(carte)){
                                break outerLoop;
                            }
                            break;
                        case "O":
                            posX-=1;
                            if(verifOnTheMap(carte)){
                                break outerLoop;
                            }
                            break;
                        case "E":
                            posX+=1;
                            if(verifOnTheMap(carte)){
                                break outerLoop;
                            }
                            break;
                    }
                    break;
                case "G":
                    changeOrientationG();
                    break;
                case "D":
                    changeOrientationD();
                    break;
                default:
                    System.out.println("Invalid movement command: " + mvt);
            }
        }
    }

    public boolean verifOnTheMap(Carte carte) {
        if (posX < 0 || posX >= carte.getLongueur() || posY < 0 || posY >= carte.getLargeur()) {
            System.out.println("Movement impossible: out of bounds");
            return false;
        } else {
            return true;
        }
    }

    public void changeOrientationG() {
        switch (orientation) {
            case "N":
                orientation = "O";
                break;
            case "O":
                orientation = "S";
                break;
            case "S":
                orientation = "E";
                break;
            case "E":
                orientation = "N";
                break;
            default:
                System.out.println("Invalid orientation: " + orientation);
        }
    }

    public void changeOrientationD() {
        switch (orientation) {
            case "N":
                orientation = "E";
                break;
            case "O":
                orientation = "N";
                break;
            case "S":
                orientation = "O";
                break;
            case "E":
                orientation = "S";
                break;
            default:
                System.out.println("Invalid orientation: " + orientation);
        }
    }
}
