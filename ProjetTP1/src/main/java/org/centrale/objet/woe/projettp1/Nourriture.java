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
        super("Inconnu", "Inconnu", new Point2D());
        this.modifPtVie = 0;
        this.modifDegAtt = 0;
        this.modifPageAtt = 0;
        this.modifPagePar = 0;
        this.modifPtPar = 0;
        this.nbToursEffet = 0;
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
        // Baguette
        String baguette_nom = "Baguette";
        int baguette_modif_ptvie = 5;
        int baguette_modif_degatt = -8;
        int baguette_modif_pageatt = 0;
        int baguette_modif_pagepar = 0;
        int baguette_modif_ptpar = 0;
        int baguette_nbtours = 2;

        //Fromage
        String fromage_veneneux_nom = "Fromage magique";
        int fromage_ptvie = 2;
        int fromage_degatt = 0;
        int fromage_pageatt = -5;
        int fromage_pagepar = 0;
        int fromage_ptpar = 0;
        int fromage_nbtours = 3;

        if (type.equalsIgnoreCase(fromage_veneneux_nom)) {
            return new Nourriture(fromage_ptvie, fromage_degatt, fromage_pageatt, fromage_pagepar, fromage_ptpar, fromage_nbtours, fromage_veneneux_nom, fromage_veneneux_nom, pos);
        } else if (type.equalsIgnoreCase(baguette_nom)) {
            return new Nourriture(baguette_modif_ptvie, baguette_modif_degatt, baguette_modif_pageatt, baguette_modif_pagepar, baguette_modif_ptpar, baguette_nbtours, baguette_nom, baguette_nom, pos);
        } else {
            throw new IllegalArgumentException("Type de nourriture non reconnu: " + type);
        }
    }

    /**
     * Méthode d'utilisation d'un consommable
     *
     * @param personnage Personnage utilisant le consommable
     * @param nbTour Nombre de tours que le effet va durer
     */
    public void est_utilise(Personnage personnage, int nbTour) {
        personnage.getEffets().put(this.getNom(), this); // Registra o efeito com a duração
        this.setNbToursEffet(nbTour * this.getNbToursEffet()); // Supondo que o efeito dure 3 turnos
    }
}
