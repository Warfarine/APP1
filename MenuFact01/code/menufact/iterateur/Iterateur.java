package menufact.iterateur;
import menufact.plats.PlatAuMenu;

/**
 * Interface pour la gestion de l'itérateur du menu
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public interface Iterateur {
    PlatAuMenu suivant();
    PlatAuMenu precedent();
    PlatAuMenu itemCourant();
}
