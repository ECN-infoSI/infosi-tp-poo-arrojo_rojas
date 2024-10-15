/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.Arrays;

/**
 * Classe qui gére les objets
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
   	 this.nom = "Objet Random";
         this.description = "Ceci est un objet random, et par conséquent, possède une utilité nulle";
         this.pos = new Point2D(0,0);
    }

    /**
     * Constructeur
     * @param nom Nom de l'objet
     * @param description Description de l'objet
     * @param pos positiob
    */
    public Objet(String nom, String description, Point2D pos) {
    	this.nom = nom;
    	this.description = description;
        this.pos = new Point2D(pos);
    }
    
    /**
     * Constructeur de copie
     * @param o Objet à copier
    */
    public Objet(Objet o) {
    	this.nom = o.nom;
    	this.description = o.description;
        this.pos = new Point2D(o.pos);
    }
    
    /**
     * Méthode pour obtenir le nnom
     * @return nom
    */
    public String getNom() {
    	return nom;
    }

    /**
     * Méthode pour définir le nnom
     * @param nom nom
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
     * @param description description
    */
    public void setDescription(String description) {
    	this.description = description;
    }

    /**
     * Méthode pour obtenir la position
     * @return position
    */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Méthode pour définir la position
     * @param pos position
    */
    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }
     
    /**
     * Permet d'afficher les attributs correspondant d'objet
    */
    public void affiche() {
        Class nclasse = this.getClass();
        System.out.println("La classe est : "+ nclasse.getName());
        System.out.println("Nom : "+ nom);
        System.out.println("Description : "+ description);
        System.out.println("Position : " + Arrays.toString(pos.GetPosition()));
    }
}
