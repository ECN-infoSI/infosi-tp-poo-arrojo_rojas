/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
*/
package org.centrale.objet.woe.projettp1;
import static org.centrale.objet.woe.projettp1.World.TAILLE_WORLD;

/**
 * Classe qui gére les mouvements du jeu
 * @author Augusto ARROJO et Fernando ROJAS
*/
public interface Deplacable {
    
    /**
     * Méthode de déplacement
     * @param monde Le monde dans lequel l'entité se déplace
    */
    public abstract void deplacer(World monde);
    
}