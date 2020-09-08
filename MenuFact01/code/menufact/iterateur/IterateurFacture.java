package menufact.iterateur;

import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

/**
 * Intérateur pour la facteur
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class IterateurFacture implements IterateurF {
    private int positionCourante;
    private ArrayList<PlatChoisi> plats;

    /**
     * Constructeur par paramètre
     * @param listePlats ArrayList contenant les plats choisis
     */
    public IterateurFacture(ArrayList<PlatChoisi> listePlats){
        this.plats = listePlats;
        positionCourante = 0;
    }

    /**
     * Méthode pour passer au plat suivant dans la liste des plats
     * @throws IndexOutOfBoundsException seulement si l'index sélection est en dehors de la liste
     * @return le platChoisi pointé par l'itérateur
     */
    @Override
    public PlatChoisi suivant() {
        if (positionCourante >= plats.size()) {
            throw new IndexOutOfBoundsException("Dépasse le nombre maximal de plats");
        }
        else {
            return plats.get(++positionCourante);
        }
    }

    /**
     * Méthode pour passer au plat précédent dans la liste des plats
     * @throws IndexOutOfBoundsException seulement si l'index sélection est en dehors de la liste
     * @return le platChoisi pointé par l'itérateur
     */
    @Override
    public PlatChoisi precedent() {
        if (positionCourante <= 0) {
            throw new IndexOutOfBoundsException("Dépasse le nombre minimal de plats");
        }
        else {
            return plats.get(--positionCourante);
        }
    }

    /**
     * Méthode pour retourner le plat pointé par l'itérateur
     * @return le platChoisi pointé par l'itérateur
     */
    @Override
    public PlatChoisi itemCourant() {
        return plats.get(positionCourante);
    }
}