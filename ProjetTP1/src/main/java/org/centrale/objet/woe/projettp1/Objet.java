/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.Arrays;
/**
 * Classe qui gère les objets
 * @author Augusto ARROJO et Fernando ROJAS
 */
public abstract class Objet extends ElementDeJeu {
    private String nom;
    private String description;
    private Point2D pos;

    /**
     * Constructeur par défaut d'objet
     */
    public Objet() {
        super(new Point2D());
        this.nom = "Objet Random";
        this.description = "Ceci est un objet random, et par conséquent, possède une utilité nulle";
    }

    /**
     * Constructeur
     * @param nom Nom de l'objet
     * @param description Description de l'objet
     * @param pos Position de l'objet
     */
    public Objet(String nom, String description, Point2D pos) {
        super(pos);
        this.nom = nom;
        this.description = description;
    }

    /**
     * Constructeur de copie
     * @param o Objet à copier
     */
    public Objet(Objet o) {
        super(o.pos);
        this.nom = o.nom;
        this.description = o.description;
    }

    /**
     * Méthode pour obtenir le nom
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode pour définir le nom
     * @param nom Nom de l'objet
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode pour obtenir la description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Méthode pour définir la description
     * @param description Description de l'objet
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Permet d'afficher les attributs correspondant d'objet
     */
    public void affiche() {
        System.out.println("La classe est : " + this.getClass().getSimpleName());
        System.out.println("Nom : " + nom);
        System.out.println("Description : " + description);
        System.out.println("Position : " + Arrays.toString(pos.getPosition()));
    }
}
