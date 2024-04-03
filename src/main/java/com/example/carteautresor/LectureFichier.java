package com.example.carteautresor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectureFichier {

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
                        carte.setLongueur(Integer.parseInt(parties[1]));
                        carte.setLargeur(Integer.parseInt(parties[2]));
                        break;
                    case 'M':
                        Montagne montagne = new Montagne(Integer.parseInt(parties[1]), Integer.parseInt(parties[2]));
                        montagnes.add(montagne);
                        break;
                    case 'T':
                        Tresor tresor = new Tresor(Integer.parseInt(parties[1]), Integer.parseInt(parties[2]), Integer.parseInt(parties[3]));
                        tresors.add(tresor);
                        break;
                    case 'A':
                        String[] moves =  parties[parties.length-1].split("");
                        Aventurier aventurier = new Aventurier(parties[1], Integer.parseInt(parties[2]), Integer.parseInt(parties[3]), parties[4], List.of(moves));
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


}
