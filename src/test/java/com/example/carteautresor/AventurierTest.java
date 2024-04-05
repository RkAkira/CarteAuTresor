package com.example.carteautresor;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AventurierTest {

    @Test
    void bouger() {
        Montagne montagne = new Montagne(0,0);
        List<Montagne> montagneList = new ArrayList<>();
        montagneList.add(montagne);

        Tresor tresor = new Tresor(1,1,1);
        List<Tresor> tresorList = new ArrayList<>();
        tresorList.add(tresor);

        List<String> mouvements = new ArrayList<>();
        mouvements.add("A");

        List<Aventurier> aventurierList = new ArrayList<>();
        Aventurier aventurier = new Aventurier("test",1, 1, "O",mouvements);
        aventurierList.add(aventurier);


        Carte carte = new Carte();
        carte.setLongueur(2);
        carte.setLargeur(2);
        carte.setMontagnes(montagneList);
        carte.setTresors(tresorList);
        carte.setAventuriers(aventurierList);


        aventurier.bouger(carte);

        assertEquals(0, aventurier.getLongitude());
        assertEquals(1, aventurier.getLatitude());
    }

    @Test
    void verifOnTheMap() {
        Carte carte = new Carte();
        carte.setLongueur(2);
        carte.setLargeur(2);
        Aventurier aventurier = new Aventurier("test",1, 1, "O",new ArrayList<>());
        assertTrue(aventurier.verifOnTheMap(carte));
    }

    @Test
    void verifMontagne() {
        Montagne montagne = new Montagne(0,0);
        List<Montagne> montagneList = new ArrayList<>();
        montagneList.add(montagne);
        Aventurier aventurier = new Aventurier("test",1, 1, "O",new ArrayList<>());
        assertTrue(aventurier.verifMontagne(montagneList, aventurier.getOrientation()));

    }

    @Test
    void changeOrientationG() {
        Aventurier aventurier = new Aventurier("test",1, 1, "O",new ArrayList<>());
        aventurier.changeOrientationG();
        assertEquals("S", aventurier.getOrientation() );
    }

    @Test
    void changeOrientationD() {
        Aventurier aventurier = new Aventurier("test",1, 1, "O",new ArrayList<>());
        aventurier.changeOrientationD();
        assertEquals("N", aventurier.getOrientation() );
    }

    @Test
    void getTresor() {
        Tresor tresor = new Tresor(1,1,1);

        List<Tresor> tresorList = new ArrayList<>();
        tresorList.add(tresor);

        Aventurier aventurier = new Aventurier("test",1, 1, "O",new ArrayList<>());
        aventurier.getTresor(tresorList);

        assertEquals(1, aventurier.getSacoche());
        assertEquals(0, tresor.getNbTresor());
    }
}