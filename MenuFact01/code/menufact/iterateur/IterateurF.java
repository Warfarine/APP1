package menufact.iterateur;
import menufact.plats.PlatChoisi;

/**
 * Interface pour la gestion de l'itérateur de la facture
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public interface IterateurF {
    PlatChoisi suivant();
    PlatChoisi precedent();
    PlatChoisi itemCourant();
}
