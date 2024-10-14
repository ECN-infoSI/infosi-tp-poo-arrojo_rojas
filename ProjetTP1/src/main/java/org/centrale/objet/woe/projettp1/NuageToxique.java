/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.Random;
import static org.centrale.objet.woe.projettp1.World.TAILLE_WORLD;

/**
 * Sous-classe d'objet gérant les nuages toxiques
 *
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class NuageToxique extends Objet implements Deplacable, Combattant {

    private int toxicite;

    /**
     * Constructeur par défaut de la classe NuageToxique
     */
    public NuageToxique() {
        super();
        toxicite = 1;
    }

    /**
     * Constructeur de la classe NuageToxique
     *
     * @param nom Nom du danger
     * @param description Description du danger
     * @param pos Position du danger
     * @param toxicite Toxicité du danger
     */
    public NuageToxique(String nom, String description, Point2D pos, int toxicite) {
        super(nom, description, pos);
        this.toxicite = toxicite;
    }

    /**
     * Constructeur de recopie de la classe NuageToxique
     *
     * @param nt Nuage Toxique à recopier
     */
    public NuageToxique(NuageToxique nt) {
        super(nt);
        this.toxicite = nt.toxicite;
    }

    /**
     * Getter de l'attribut toxicite
     *
     * @return La toxicité du NuageToxique
     */
    public int getToxicite() {
        return toxicite;
    }

    /**
     * Setter de l'attribut toxicite
     *
     * @param toxicite La nouvelle toxicité du Nuage toxique
     */
    public void setToxicite(int toxicite) {
        this.toxicite = toxicite;
    }

    /**
     * Méthode de combat du nuage toxique
     *
     * @param c Créature affectée par le nuage toxique
     */
    @Override
    public void combattre(Creature c) {
        double d = this.getPos().distance(c.getPos());
        if (d > 0) {
            System.out.println("La créature n''est pas dans le nuage toxique et ne subit par conséquent aucun dégât");
        } else {
            c.setPtVie(c.getPtVie() - toxicite);
            System.out.println(c.getClass() + " respire le gaz et subit " + toxicite + " dégâts. Il lui reste " + c.getPtVie() + " points de vie");
        }
    }

    /**
     * Méthode de déplacement du nuage toxique
     *
     * @param monde Monde dans lequel évolue le nuage toxique
     * @return true si le nuage peut se déplacer | false sinon
     */
    @Override
    public boolean deplace(World monde) {
        Random Alea = new Random();
        Point2D testPosition = new Point2D(this.getPos());
        int r1 = Alea.nextInt(3) - 1;
        int r2 = Alea.nextInt(3) - 1;
        while ((r1 == 0) && (r2 == 0)) {
            r1 = Alea.nextInt(3) - 1;
            r2 = Alea.nextInt(3) - 1;
        }
        testPosition.translate(r1, r2);
        for (Creature c : monde.getCrea()) {
            if (c.getPos().equals(testPosition) || Math.abs(testPosition.getX()) > TAILLE_WORLD || Math.abs(testPosition.getY()) > TAILLE_WORLD) {
                return false;
            } else {
                this.getPos().translate(r1, r2);
                return true;
            }

        }
        return false;
    }
}
