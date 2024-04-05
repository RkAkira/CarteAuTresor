package com.example.carteautresor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectureEcritureFichier {

    public Carte initGame(String string){
        List<Montagne> montagnes = new ArrayList<>();
        List<Tresor> tresors = new ArrayList<>();
        List<Aventurier> aventuriers = new ArrayList<>();
        Carte carte = new Carte();
        try{
            FileInputStream file = new FileInputStream(string);
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String temp = scanner.nextLine();
                String[] parties = temp.split(" - ");
                switch (temp.charAt(0)){
                    case 'C':
                        carte.setLongueur(Integer.parseInt(parties[2]));
                        carte.setLargeur(Integer.parseInt(parties[1]));
                        break;
                    case 'M':
                        Montagne montagne = new Montagne(Integer.parseInt(parties[2]), Integer.parseInt(parties[1]));
                        montagnes.add(montagne);
                        break;
                    case 'T':
                        Tresor tresor = new Tresor(Integer.parseInt(parties[2]), Integer.parseInt(parties[1]), Integer.parseInt(parties[3]));
                        tresors.add(tresor);
                        break;
                    case 'A':
                        String[] moves =  parties[parties.length-1].split("");
                        Aventurier aventurier = new Aventurier(parties[1], Integer.parseInt(parties[3]), Integer.parseInt(parties[2]), parties[4], List.of(moves));
                        aventuriers.add(aventurier);
                        break;
                    case '#':
                        break;
                }
            }
            carte.setMontagnes(montagnes);
            carte.setTresors(tresors);
            carte.setAventuriers(aventuriers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return carte;
    }


    public void endGame(Carte carte){
        String file = "output.txt";
        List<String> contenuFichier = new ArrayList<>();
        String carteP = "C - "+ carte.getLargeur()+" - "+carte.getLongueur();
        contenuFichier.add(carteP);
        for (Montagne montagne: carte.getMontagnes()){
            String montagneP = "M - "+montagne.getPosY()+" - "+ montagne.getPosX();
            contenuFichier.add(montagneP);
        }
        for(Tresor tresor: carte.getTresors()){
            if (tresor.getNbTresor()!=0){
                String tresorP = "T - "+tresor.getPosY()+" - "+tresor.getPosX()+" - "+tresor.getNbTresor();
                contenuFichier.add(tresorP);
            }
        }
        for(Aventurier aventurier: carte.getAventuriers()){
            String aventurierP = "A - "+aventurier.getNom()+" - "+aventurier.getLongitude()+" - "+aventurier.getLatitude()+
                    " - "+aventurier.getOrientation()+" - "+aventurier.getSacoche();
            contenuFichier.add(aventurierP);
        }

        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (String write : contenuFichier) {
                printWriter.println(write);
            }
            System.out.println("Contenu écrit dans le fichier avec succès.");
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'écriture dans le fichier", e);
        }

    }

}
