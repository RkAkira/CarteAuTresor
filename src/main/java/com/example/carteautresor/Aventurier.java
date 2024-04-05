package com.example.carteautresor;

import java.util.Iterator;
import java.util.List;

/**
 * Classe répresentant un aventurier
 */
public class Aventurier {

    private String nom;

    private int latitude;

    private int longitude;

    private String orientation;

    private List<String> mouvements;

    private int sacoche;

    /**
     * Constructeur de la classe
     * @param nom
     * @param latitude
     * @param longitude
     * @param orientation
     * @param mouvements
     */
    public Aventurier(String nom, int latitude, int longitude, String orientation, List<String> mouvements) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.orientation = orientation;
        this.mouvements = mouvements;
        this.sacoche = 0;
    }

    /**
     * Getter
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter
     * @return latitude
     */
    public int getLatitude() {
        return latitude;
    }

    /**
     * Setter
     * @param latitude
     */
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    /**
     * Getter
     * @return
     */
    public int getLongitude() {
        return longitude;
    }

    /**
     * Setter
     * @param longitude
     */
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    /**
     * Getter
     * @return
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * Setter
     * @param orientation
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    /**
     * Getter
     * @return
     */
    public List<String> getMouvements() {
        return mouvements;
    }

    /**
     * Setter
     * @param mouvements
     */
    public void setMouvements(List<String> mouvements) {
        this.mouvements = mouvements;
    }

    /**
     * Getter
     * @return
     */
    public int getSacoche() {
        return sacoche;
    }

    /**
     * Setter
     * @param sacoche
     */
    public void setSacoche(int sacoche) {
        this.sacoche = sacoche;
    }


    @Override
    public String toString() {
        return " ("+ nom +") ";
    }

    /**
     * Fonction permettant de simuler le mouvement d'un aventurier
     * @param carte
     */
    public void bouger(Carte carte){
        carte.displayCarte();
        System.out.println();
        Iterator<String> it = mouvements.iterator();
        outerLoop: while(it.hasNext()){
            String mvt = it.next();
            switch(mvt){
                case "A":
                    switch (orientation) {
                        case "N":
                            latitude -= (verifMontagne(carte.getMontagnes(), orientation)) ? 1 : 0;
                            break;
                        case "S":
                            latitude += (verifMontagne(carte.getMontagnes(), orientation)) ? 1 : 0;
                            break;
                        case "O":
                            longitude -= (verifMontagne(carte.getMontagnes(), orientation)) ? 1 : 0;
                            break;
                        case "E":
                            longitude += (verifMontagne(carte.getMontagnes(), orientation)) ? 1 : 0;
                            break;
                    }
                    getTresor(carte.getTresors());
                    if (!verifOnTheMap(carte)) {
                        break outerLoop;
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

    /**
     * Verifie la présence de l'aventurier sur la map
     * @param carte
     * @return
     */
    public boolean verifOnTheMap(Carte carte) {
        if (latitude < 0 || latitude >= carte.getLongueur() || longitude < 0 || longitude >= carte.getLargeur()) {
            System.out.println("Movement impossible: out of bounds");
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Verifie la présence d'une montagne en face de l'aventurier
     * @param montagnes
     * @param orientation
     * @return
     */
    public boolean verifMontagne(List<Montagne> montagnes, String orientation){
        for(Montagne montagne: montagnes){
            switch (orientation){
                case "N":
                    if (latitude -1 == montagne.getPosX() && longitude == montagne.getPosY()){
                        System.out.println("Movement impossible: vous rencontrez une montagne");
                        return false;
                    }
                    break;
                case "S":
                    if (latitude +1 == montagne.getPosX() && longitude == montagne.getPosY()){
                        System.out.println("Movement impossible: vous rencontrez une montagne");
                        return false;
                    }
                    break;
                case "O":
                    if (latitude == montagne.getPosX() && longitude -1 == montagne.getPosY()){
                        System.out.println("Movement impossible: vous rencontrez une montagne");
                        return false;
                    }
                    break;
                case "E":
                    if (latitude == montagne.getPosX() && longitude +1 == montagne.getPosY()){
                        System.out.println("Movement impossible: vous rencontrez une montagne");
                        return false;
                    }
                    break;
                default:
                    System.out.println("Invalid movement command: " + orientation);
            }
        }
        return true;
    }

    /**
     * Change l'orientation de l'aventurier vers la Gauche
     */
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

    /**
     * Change l'orientation de l'aventurier vers la Droite
     */
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

    /**
     * Recupère 1 trésor sur la case où l'aventurier est présent
     * @param tresors
     */
    public void getTresor(List<Tresor> tresors){
        for(Tresor tresor: tresors){
            int temp = tresor.getNbTresor();
            if(latitude == tresor.getPosX() && longitude ==  tresor.getPosY()){
                if(temp!=0){
                    sacoche+=1;
                    tresor.setNbTresor(temp-1);
                }
            }
        }
    }
}
