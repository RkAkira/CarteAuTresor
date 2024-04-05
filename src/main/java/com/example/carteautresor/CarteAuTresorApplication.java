package com.example.carteautresor;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarteAuTresorApplication {

    public static void main(String[] args) {
        LectureEcritureFichier jeu = new LectureEcritureFichier();
        Carte carte = jeu.initGame("test.txt");
        for(Aventurier aventurier: carte.getAventuriers()){
            aventurier.bouger(carte);
        }
        carte.displayCarte();
        jeu.endGame(carte);
        //SpringApplication.run(CarteAuTresorApplication.class, args);
    }

}
