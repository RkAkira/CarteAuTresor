package com.example.carteautresor;

import java.util.List;

public class Carte {

    private int longueur;

    private int largeur;

    private List<Montagne> montagnes;

    private List<Tresor> tresors;

    private List<Aventurier> aventuriers;

    //Ajouter une liste d'aventurier sur la map


    public Carte(int longueur, int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public Carte() {
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public List<Montagne> getMontagnes() {
        return montagnes;
    }

    public void setMontagnes(List<Montagne> montagnes) {
        this.montagnes = montagnes;
    }

    public List<Tresor> getTresors() {
        return tresors;
    }

    public void setTresors(List<Tresor> tresors) {
        this.tresors = tresors;
    }

    public List<Aventurier> getAventuriers() {
        return aventuriers;
    }

    public void setAventuriers(List<Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
    }

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
