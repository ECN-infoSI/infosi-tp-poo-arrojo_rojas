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
public class Objet {
    private String nom;
    private int prix_achat;
    private int prix_vente;
    private String description;
    private Point2D pos;

    /**
     * Constructeur d'objet
     * @return
     */
    public int getPrix_achat() {
    	return prix_achat;
	}

    /**
     *
     * @return
     */
    public String getNom() {
    	return nom;
	}

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
    	this.nom = nom;
	}

    /**
     *
     * @param prix_achat
     */
    public void setPrix_achat(int prix_achat) {
    	this.prix_achat = prix_achat;
	}

    /**
     *
     * @return
     */
    public int getPrix_vente() {
    	return prix_vente;
	}

    /**
     *
     * @param prix_vente
     */
    public void setPrix_vente(int prix_vente) {
    	this.prix_vente = prix_vente;
	}

    /**
     *
     * @return
     */
    public String getDescription() {
    	return description;
	}

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
    	this.description = description;
	}

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }
    
    

    /**
     * Constructeur par défaut d'objet
    */
    public Objet() {
   	 this.nom = "Objet Random";
         this.prix_achat = 0;
         this.prix_vente = 0;
         this.description = "Ceci est un objet random, et par conséquent, possède une utilité nulle";
         this.pos = new Point2D(0,0);
	}

    /**
     * Constructeur
     * @param nom Nom de l'objet
     * @param prix_achat Prix à l'achat de l'objet
     * @param prix_vente Prix à la vente de l'objet
     * @param description Description de l'objet
     * @param pos
     */
    public Objet(String nom,int prix_achat, int prix_vente, String description, Point2D pos) {
    	this.nom = nom;
    	this.prix_achat = prix_achat;
    	this.prix_vente = prix_vente;
    	this.description = description;
        this.pos = new Point2D(pos);
	}
    
    /**
     *Constructeur de copie
     * @param o Objet à copier
     */
    public Objet(Objet o) {
    	this.nom = o.nom;
    	this.prix_achat = o.prix_achat;
    	this.prix_vente = o.prix_vente;
    	this.description = o.description;
        this.pos = new Point2D(o.pos);
	}
    
    
    /**
     * Permet d'afficher les attributs correspondant d'objet
    */
    public void affiche() {
        Class nclasse = this.getClass();
        System.out.println("La classe est : "+ nclasse.getName());
        System.out.println("Nom "+ nom);
        System.out.println("Prix d'Achat "+ prix_achat);
        System.out.println("Prix_vente "+ prix_vente);
        System.out.println("Description "+ description);
        System.out.println("Position " + Arrays.toString(pos.GetPosition()));
    }
}
