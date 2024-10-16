/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.Random;

/**
 * Sous-classe d'objet qui gére les norritures
 *
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class Nourriture extends Objet implements Utilisable {

    private int modifPtVie;
    private int modifDegAtt;
    private int modifPageAtt;
    private int modifPagePar;
    private int modifPtPar;
    private int nbToursEffet;

    /**
     * Getter de l'attribut modifPtVie
     *
     * @return Les points de vie gagné ou perdu grâce au consommable
     */
    public int getModifPtVie() {
        return modifPtVie;
    }

    /**
     * Getter de l'attribut modifDegAtt
     *
     * @return Le bonus (ou malus) de dégats du consommable
     */
    public int getModifDegAtt() {
        return modifDegAtt;
    }

    /**
     * Setter de l'attribut modifDegAtt
     *
     * @param modifDegAtt Le nouveau bonus (ou malus) de dégats du consommable
     */
    public void setModifDegAtt(int modifDegAtt) {
        this.modifDegAtt = modifDegAtt;
    }

    /**
     * Getter de l'attribut modifPageAtt
     *
     * @return Le bonus (ou malus) au pourcentage d'attaque du consommable
     */
    public int getModifPageAtt() {
        return modifPageAtt;
    }

    /**
     * Setter de l'attribut modifPageAtt
     *
     * @param modifPageAtt Le nouveau bonus (ou malus) au pourcentage d'attaque
     * du consommable
     */
    public void setModifPageAtt(int modifPageAtt) {
        this.modifPageAtt = modifPageAtt;
    }

    /**
     * Getter de l'attribut modifPagePar
     *
     * @return Le bonus (ou malus) au pourcentage de parade du consommable
     */
    public int getModifPagePar() {
        return modifPagePar;
    }

    /**
     * Setter de l'attribut modifPagePar
     *
     * @param modifPagePar Le nouveau bonus (ou malus) au pourcentage de parade
     * du consommable
     */
    public void setModifPagePar(int modifPagePar) {
        this.modifPagePar = modifPagePar;
    }

    /**
     * Getter de l'attribut modifPtPar
     *
     * @return Le bonus (ou malus) au points de parade du consommable
     */
    public int getModifPtPar() {
        return modifPtPar;
    }

    /**
     * Stter de l'attribut modifPtPar
     *
     * @param modifPtPar Le nouveau bonus (ou malus) au points de parade du
     * consommable
     */
    public void setModifPtPar(int modifPtPar) {
        this.modifPtPar = modifPtPar;
    }

    /**
     * Getter de l'attribut nbTourEffet
     *
     * @return Le nombre de tours restant pour l'effet
     */
    public int getNbToursEffet() {
        return nbToursEffet;
    }

    /**
     * Setter de l'attribut nbToursEffet
     *
     * @param nbToursEffet Le nouveau nombre de tours restants pour l'effet
     */
    public void setNbToursEffet(int nbToursEffet) {
        this.nbToursEffet = nbToursEffet;
    }

    /**
     * Setter de l'attribut modifPtVie
     *
     * @param modifPtVie Le nouveau nombre de points de vie gagné (ou perdu)
     * grâce à l'effet
     */
    public void setModifPtVie(int modifPtVie) {
        this.modifPtVie = modifPtVie;
    }

    // Baguette configuration
    public static final String BAGUETTE = "Baguette";
    public static final int BAGUETTE_MODIF_PTVIE = 5;
    public static final int BAGUETTE_MODIF_DEGATT = -8;
    public static final int BAGUETTE_MODIF_PAGEATT = 0;
    public static final int BAGUETTE_MODIF_PAGEPAR = 0;
    public static final int BAGUETTE_MODIF_PTPAR = 0;
    public static final int BAGUETTE_NBTOURS = 2;

    // Fromage configuration
    public static final String FROMAGE_VENENEUX = "Fromage magique";
    public static final int FROMAGE_PTVIE = 2;
    public static final int FROMAGE_DEGATT = 0;
    public static final int FROMAGE_PAGEATT = -5;
    public static final int FROMAGE_PAGEPAR = 0;
    public static final int FROMAGE_PTPAR = 0;
    public static final int FROMAGE_NBTOURS = 3;

    /**
     * Constructeur de Nourriture
     *
     * @param modifPtVie Les points de vie gagné ou perdu grâce au consommabl
     * @param modifDegAtt Le bonus (ou malus) de dégats du consommable
     * @param modifPageAtt Le bonus (ou malus) au pourcentage d'attaque du
     * consommable
     * @param modifPagePar Le bonus (ou malus) au pourcentage de parade du
     * consommable
     * @param modifPtPar Le bonus (ou malus) au points de parade du consommable
     * @param nbToursEffet Le nombre de tours restant pour l'effet du
     * consommable
     * @param nom Nom du consommable
     * @param description Description du consommable
     * @param pos Position du consommable sur la carte
     */
    public Nourriture(int modifPtVie, int modifDegAtt, int modifPageAtt, int modifPagePar, int modifPtPar, int nbToursEffet, String nom, String description, Point2D pos) {
        super(nom, description, pos);
        this.modifPtVie = modifPtVie;
        this.modifDegAtt = modifDegAtt;
        this.modifPageAtt = modifPageAtt;
        this.modifPagePar = modifPagePar;
        this.modifPtPar = modifPtPar;
        this.nbToursEffet = nbToursEffet;
    }

    /**
     * Constructeur par défaut de Nourriture
     */
    public Nourriture() {
        super("Baguette", "Baguette avec sauce Alfredo", new Point2D());
        this.modifPtVie = BAGUETTE_MODIF_PTVIE;
        this.modifDegAtt = BAGUETTE_MODIF_DEGATT;
        this.modifPageAtt = BAGUETTE_MODIF_PAGEATT;
        this.modifPagePar = BAGUETTE_MODIF_PAGEPAR;
        this.modifPtPar = BAGUETTE_MODIF_PTPAR;
        this.nbToursEffet = BAGUETTE_NBTOURS;
    }

    /**
     * Constructeur d'un consommable Nourriture basé sur le type (Baguette ou
     * Fromage)
     *
     * @param type Le type de nourriture (Baguette ou Fromage)
     * @return Le consommable (Baguette ou Fromage)
     */
    public static Nourriture creerNourriture(String type) {
        Point2D pos = new Point2D();
        if (type.equalsIgnoreCase("Fromage magique")) {
            return new Nourriture(FROMAGE_PTVIE, FROMAGE_DEGATT, FROMAGE_PAGEATT, FROMAGE_PAGEPAR, FROMAGE_PTPAR, FROMAGE_NBTOURS, "Fromage vénéneux", "Manger ceci était une mauvaise idée", pos);
        } else if (type.equalsIgnoreCase("Baguette")) {
            return new Nourriture(BAGUETTE_MODIF_PTVIE, BAGUETTE_MODIF_DEGATT, BAGUETTE_MODIF_PAGEATT, BAGUETTE_MODIF_PAGEPAR, BAGUETTE_MODIF_PTPAR, BAGUETTE_NBTOURS, "Baguette", "Super !", pos);
        } else {
            throw new IllegalArgumentException("Type de nourriture non reconnu: " + type);
        }
    }

    /**
     * Méthode d'utilisation d'un consommable
     *
     * @param personnage Personnage utilisant le consommable
     */
    public void est_utilise(Personnage personnage,int nbTour) {
        personnage.getEffets().put(this.getNom(), this); // Registra o efeito com a duração
        this.setNbToursEffet(nbTour * this.getNbToursEffet()); // Supondo que o efeito dure 3 turnos
    }
}
