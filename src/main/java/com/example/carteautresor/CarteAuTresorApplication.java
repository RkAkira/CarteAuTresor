package com.example.carteautresor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CarteAuTresorApplication {

    public static void main(String[] args) {
        LectureFichier jeu = new LectureFichier();
        Carte carte = jeu.initGame("");
        for(Aventurier aventurier: carte.getAventuriers()){
            aventurier.bouger(carte);
        }
        carte.displayCarte();
        SpringApplication.run(CarteAuTresorApplication.class, args);
    }

}
