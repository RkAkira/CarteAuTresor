package com.example.carteautresor;

import java.util.Iterator;
import java.util.List;

public class Carte {

    private int longueur;

    private int largeur;

    private List<Montagne> montagnes;

    private List<Tresor> tresors;


    public Carte(int longueur, int largeur, List<Montagne> montagnes, List<Tresor> tresors) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.montagnes = montagnes;
        this.tresors = tresors;
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
                        if (tresor.getPosX() == i && tresor.getPosY() == j) {
                            System.out.print(tresor); // Utiliser toString() ou l'objet lui-même
                            hasElement = true;
                            break;
                        }
                    }
                }
                // Si aucune montagne ni trésor n'est trouvé, afficher un point
                if (!hasElement) {
                    System.out.print(".");
                }
            }
            System.out.println(); // Aller à la ligne après chaque ligne de la carte
        }
    }

}
