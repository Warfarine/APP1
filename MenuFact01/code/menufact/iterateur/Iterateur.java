package menufact.iterateur;
import menufact.plats.PlatAuMenu;

public interface Iterateur {
    PlatAuMenu suivant();
    PlatAuMenu precedent();
    PlatAuMenu itemCourant();
}
