/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.centrale.objet.woe.projettp1;

/**
 * Sous-classe d'objet qui gére les norritures
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
     * @return Les points de vie gagné ou perdu grâce au consommable
    */
    public int getModifPtVie() {
        return modifPtVie;
    }

    /**
     * Getter de l'attribut modifDegAtt
     * @return Le bonus (ou malus) de dégats du consommable
    */
    public int getModifDegAtt() {
        return modifDegAtt;
    }

    /**
     * Setter de l'attribut modifDegAtt
     * @param modifDegAtt Le nouveau bonus (ou malus) de dégats du consommable
    */
    public void setModifDegAtt(int modifDegAtt) {
        this.modifDegAtt = modifDegAtt;
    }

    /**
     * Getter de l'attribut modifPageAtt
     * @return Le bonus (ou malus) au pourcentage d'attaque du consommable
    */
    public int getModifPageAtt() {
        return modifPageAtt;
    }

    /**
     * Setter de l'attribut modifPageAtt
     * @param modifPageAtt Le nouveau bonus (ou malus) au pourcentage d'attaque du consommable
    */
    public void setModifPageAtt(int modifPageAtt) {
        this.modifPageAtt = modifPageAtt;
    }

    /**
     * Getter de l'attribut modifPagePar
     * @return Le bonus (ou malus) au pourcentage de parade du consommable
    */
    public int getModifPagePar() {
        return modifPagePar;
    }

    /**
     * Setter de l'attribut modifPagePar
     * @param modifPagePar  Le nouveau bonus (ou malus) au pourcentage de parade du consommable
    */
    public void setModifPagePar(int modifPagePar) {
        this.modifPagePar = modifPagePar;
    }

    /**
     * Getter de l'attribut modifPtPar
     * @return Le bonus (ou malus) au points de parade du consommable
    */
    public int getModifPtPar() {
        return modifPtPar;
    }

    /**
     * Stter de l'attribut modifPtPar
     * @param modifPtPar Le nouveau bonus (ou malus) au points de parade du consommable
    */
    public void setModifPtPar(int modifPtPar) {
        this.modifPtPar = modifPtPar;
    }

    /**
     * Getter de l'attribut nbTourEffet
     * @return Le nombre de tours restant pour l'effet
    */
    public int getNbToursEffet() {
        return nbToursEffet;
    }

    /**
     * Setter de l'attribut nbToursEffet
     * @param nbToursEffet Le nouveau nombre de tours restants pour l'effet
    */
    public void setNbToursEffet(int nbToursEffet) {
        this.nbToursEffet = nbToursEffet;
    }

    /**
     * Setter de l'attribut modifPtVie
     * @param modifPtVie Le nouveau nombre de points de vie gagné (ou perdu) grâce à l'effet
    */
    public void setModifPtVie(int modifPtVie) {
        this.modifPtVie = modifPtVie;
    }
  
    // Poulet configuration
    public static final String POULET = "Poulet";
    public static final int POULET_MODIF_PTVIE = 0;
    public static final int POULET_MODIF_DEGATT = 2;
    public static final int POULET_MODIF_PAGEATT = 0;
    public static final int POULET_MODIF_PAGEPAR = 0;
    public static final int POULET_MODIF_PTPAR = 0;
    public static final int POULET_NBTOURS = 3;
    
    // Champignon configuration
    public static final String CHAMPIGNON_VENENEUX = "Champignon vénéneux";
    public static final int CHAMPIGNON_VENENEUX_PTVIE = 0;
    public static final int CHAMPIGNON_VENENEUX_DEGATT = 0;
    public static final int CHAMPIGNON_VENENEUX_PAGEATT = 0;
    public static final int CHAMPIGNON_VENENEUX_PAGEPAR = 0;
    public static final int CHAMPIGNON_VENENEUX_PTPAR = -2;
    public static final int CHAMPIGNON_VENENEUX_NBTOURS = 5;

    /**
     * Constructeur de Nourriture
     * @param modifPtVie Les points de vie gagné ou perdu grâce au consommabl
     * @param modifDegAtt Le bonus (ou malus) de dégats du consommable
     * @param modifPageAtt Le bonus (ou malus) au pourcentage d'attaque du consommable
     * @param modifPagePar Le bonus (ou malus) au pourcentage de parade du consommable
     * @param modifPtPar Le bonus (ou malus) au points de parade du consommable
     * @param nbToursEffet Le nombre de tours restant pour l'effet du consommable
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
        super("poulet","Poulet avec sauce Alfredo",new Point2D());
        this.modifPtVie = POULET_MODIF_PTVIE;
        this.modifDegAtt = POULET_MODIF_DEGATT;
        this.modifPageAtt = POULET_MODIF_PAGEATT;
        this.modifPagePar = POULET_MODIF_PAGEPAR;
        this.modifPtPar = POULET_MODIF_PTPAR;
        this.nbToursEffet = POULET_NBTOURS;
    }

    /**
     * Constructeur d'un consommable "Poulet"
     * @param pos Position du poulet
     * @return Le consommable
    */
    public Nourriture poulet(Point2D pos) {
        return new Nourriture(POULET_MODIF_PTVIE, POULET_MODIF_DEGATT, POULET_MODIF_PAGEATT, POULET_MODIF_PAGEPAR, POULET_MODIF_PTPAR, POULET_NBTOURS, "Poulet", "Miam", pos);
    };
    
    /**
     * Constructeur d'un consommable "Champignon Veneneux"
     * @param pos Position du champignon
     * @return Le consommable
    */
    public Nourriture champignonVeneneux(Point2D pos) {
        return new Nourriture(CHAMPIGNON_VENENEUX_PTVIE, CHAMPIGNON_VENENEUX_DEGATT, CHAMPIGNON_VENENEUX_PAGEATT, CHAMPIGNON_VENENEUX_PAGEPAR, CHAMPIGNON_VENENEUX_PTPAR, CHAMPIGNON_VENENEUX_NBTOURS,"Champignon vénéneux","Manger ceci était une mauvaise idée",pos);
    };
    
    /**
     *Méthode d'utilisation d'un consommable
     * @param p Personnage utilisant le consommable
    */
    
    
    /*
    @Override
    public void est_utilise(Personnage p){
        p.getEffets().put(this.getNom(),this);
    }*/
}

