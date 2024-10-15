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
        Random alea = new Random();
        toxicite = alea.nextInt(9) +1;
    }

    /**
     * Constructeur de la classe NuageToxique
     *
     * @param nom Nom du danger
     * @param description Description du nuage
     * @param pos Position du nuage
     * @param toxicite Toxicité du nuage
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

        // Si la distance est suffisamment petite
        if (d == 0) {
            c.setPtVie(c.getPtVie() - toxicite);
            System.out.println(c.getClass().getSimpleName() + " respire le gaz et subit " + toxicite + " dégâts. Il lui reste " + c.getPtVie() + " points de vie.");
        }
    }

    @Override
    /**
     * Méthode permettant de déplacer un objet dans le monde de manière
     * aléatoire. Le déplacement s'effectue tant que la nouvelle position est
     * valide et non occupée.
     *
     * @param monde Le monde dans lequel l'objet se déplace
     */
    public void deplacer(World monde) {
        Random alea = new Random();
        Point2D nouvellePos = new Point2D(this.getPos()); // Copie de la position actuelle

        int r1 = 0, r2 = 0;
        do {
            // Génère un déplacement aléatoire entre -1 et 1 pour x et y
            r1 = alea.nextInt(3) - 1;
            r2 = alea.nextInt(3) - 1;

            // Applique temporairement la translation sur la nouvelle position
            nouvellePos.translate(r1, r2); // Applique la translation

            // Continue tant que le déplacement n'est pas nul (r1 == 0 et r2 == 0) ou que la position est invalide
        } while ((r1 == 0 && r2 == 0) || !nouvellePos.check_deplacement(monde));

        // Met à jour la position de l'objet en utilisant translate
        this.getPos().translate(r1, r2); // Applique la translation à la position actuelle
    }
}
