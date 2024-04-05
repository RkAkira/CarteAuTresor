package com.example.carteautresor;

import java.util.List;

/**
 * Classe décrivant la carte
 */
public class Carte {

    private int longueur;

    private int largeur;

    private List<Montagne> montagnes;

    private List<Tresor> tresors;

    private List<Aventurier> aventuriers;

    //Ajouter une liste d'aventurier sur la map

    /**
     * Constructeur de la classe
     * @param longueur
     * @param largeur
     */
    public Carte(int longueur, int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public Carte() {
    }

    /**
     * Getter
     * @return longueur
     */
    public int getLongueur() {
        return longueur;
    }

    /**
     * Setter
     * @param longueur
     */
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    /**
     * Getter
     * @return largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Setter
     * @param largeur
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**
     * Getter
     * @return montagnes
     */
    public List<Montagne> getMontagnes() {
        return montagnes;
    }

    /**
     * Setter
     * @param montagnes
     */
    public void setMontagnes(List<Montagne> montagnes) {
        this.montagnes = montagnes;
    }

    /**
     * Getter
     * @return tresors
     */
    public List<Tresor> getTresors() {
        return tresors;
    }

    /**
     * Setter
     * @param tresors
     */
    public void setTresors(List<Tresor> tresors) {
        this.tresors = tresors;
    }

    /**
     * Getter
     * @return aventuriers
     */
    public List<Aventurier> getAventuriers() {
        return aventuriers;
    }

    /**
     * Setter
     * @param aventuriers
     */
    public void setAventuriers(List<Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
    }

    /**
     * Methode permettant d'afficher la carte ainsi que les differents objets qu'il comporte
     */
    public void displayCarte() {
        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                boolean hasElement = false;
                // Vérifier s'il y a une montagne à cette position
                for (Montagne montagne : montagnes) {
                    if (montagne.getPosX() == i && montagne.getPosY() == j) {
                        System.out.print(montagne); // Utiliser toString() ou l'objet lui-même
                        hasElement = true;
                        break;
                    }
                }
                // Si aucune montagne n'est trouvée, vérifier s'il y a un trésor
                if (!hasElement) {
                    for (Tresor tresor : tresors) {
                        if (tresor.getPosX() == i && tresor.getPosY() == j && tresor.getNbTresor()!=0) {
                            System.out.print(tresor); // Utiliser toString() ou l'objet lui-même
                            hasElement = true;
                            break;
                        }
                    }
                }
                if (!hasElement) {
                    //modification si élément est Trésor
                    for (Aventurier aventurier : aventuriers) {
                        if (aventurier.getLatitude() == i && aventurier.getLongitude() == j) {
                            System.out.print(aventurier); // Utiliser toString() ou l'objet lui-même
                            hasElement = true;
                            break;
                        }
                    }
                }
                // Si aucune montagne ni trésor n'est trouvé, afficher un point
                if (!hasElement) {
                    System.out.print("   .   ");
                }
            }
            System.out.println(); // Aller à la ligne après chaque ligne de la carte
        }
    }


    @Override
    public String toString() {
        return "Carte{" +
                "longueur=" + longueur +
                ", largeur=" + largeur +
                ", montagnes=" + montagnes +
                ", tresors=" + tresors +
                ", aventuriers=" + aventuriers +
                '}';
    }
}
