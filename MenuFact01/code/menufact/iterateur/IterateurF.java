package menufact.iterateur;
import menufact.plats.PlatChoisi;

public interface IterateurF {
    PlatChoisi suivant();
    PlatChoisi precedent();
    PlatChoisi itemCourant();
}
