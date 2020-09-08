package menufact.iterateur;

import menufact.plats.PlatAuMenu;
import java.util.ArrayList;

/**
 * Classe pour gérer la liste des plats au menu
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class ListePlatsMenu implements CollectionPlatsMenu {
    private ArrayList<PlatAuMenu> plats;

    /**
     * Constructeur par paramètre
     * @param listePlats ArrayList contenant les plats au menu
     */
    public ListePlatsMenu(ArrayList<PlatAuMenu> listePlats) {
        this.plats = listePlats;
    }

    /**
     * Méthode pour créer un itérateur d'un menu
     * @return un object de type itérateur menu
     */
    @Override
    public Iterateur creerIterateurMenu() {
        return new IterateurMenu(plats);
    }
}