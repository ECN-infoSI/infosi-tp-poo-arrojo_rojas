/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

/**
 * Interface d'objet qui gére les objets utilisables
 * @author Augusto ARROJO et Fernando ROJAS
*/

public interface Utilisable {
    /**
     * Méthode pour indiquer qu'un effet a été crée
     * @param p personnage
     * @param nbTour nombre de tours qui il va durer
     */
    public void est_utilise(Personnage p, int nbTour);
}
