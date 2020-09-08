package menufact.iterateur;

import menufact.plats.PlatChoisi;
import java.util.ArrayList;

/**
 * Classe pour gérer la liste des plats choisis des factures
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class ListePlatsFacture implements CollectionPlatsFacture {
    private ArrayList<PlatChoisi> platsC;

    /**
     * Constructeur par paramètre
     * @param listePlats ArrayList contenant les plats choisis
     */
    public ListePlatsFacture(ArrayList<PlatChoisi> listePlats) {
        this.platsC = listePlats;
    }

    /**
     * Méthode pour créer un itérateur d'une facture
     * @return un object de type itérateur facture
     */
    @Override
    public IterateurF creerIterateurFacture() {
        return new IterateurFacture(platsC);
    }
}