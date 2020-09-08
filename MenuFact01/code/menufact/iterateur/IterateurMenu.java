package menufact.iterateur;

import menufact.plats.PlatAuMenu;
import java.util.ArrayList;

/**
 * Le menu du système MenuFact
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class IterateurMenu implements Iterateur {
    private int positionCourante;
    private ArrayList<PlatAuMenu> plats;

    /**
     * Constructeur par paramètre
     * @param listePlats ArrayList contenant les plats au menu
     */
    public IterateurMenu(ArrayList<PlatAuMenu> listePlats){
        this.plats = listePlats;
        positionCourante = 0;
    }

    /**
     * Méthode pour passer au plat suivant dans la liste des plats
     * @throws IndexOutOfBoundsException seulement si l'index sélection est en dehors de la liste
     * @return le platAuMenu pointé par l'itérateur
     */
    @Override
    public PlatAuMenu suivant() {
        if (positionCourante >= plats.size()) {
            throw new IndexOutOfBoundsException("Depasse le nombre maximal de plats");
        }
        else {
            return plats.get(++positionCourante);
        }
    }

    /**
     * Méthode pour passer au plat précédent dans la liste des plats
     * @throws IndexOutOfBoundsException seulement si l'index sélection est en dehors de la liste
     * @return le platAuMenu pointé par l'itérateur
     */
    @Override
    public PlatAuMenu precedent() {
        if (positionCourante <= 0) {
            throw new IndexOutOfBoundsException("Depasse le nombre minimal de plats");
        }
        else {
            return plats.get(--positionCourante);
        }
    }

    /**
     * Méthode pour retourner le plat pointé par l'itérateur
     * @return le platAuMenu pointé par l'itérateur
     */
    @Override
    public PlatAuMenu itemCourant() {
        return plats.get(positionCourante);
    }
}