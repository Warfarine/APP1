package menufact.iterateur;

import menufact.plats.PlatAuMenu;
import java.util.ArrayList;

public class IterateurMenu implements Iterateur {
    private int positionCourante;
    private ArrayList<PlatAuMenu> plats;

    public IterateurMenu(ArrayList<PlatAuMenu> listePlats){
        this.plats = listePlats;
        positionCourante = 0;
    }

    @Override
    public PlatAuMenu suivant() {
        if (positionCourante >= plats.size()) {
            throw new IndexOutOfBoundsException("Depasse le nombre maximal de plats");
        }
        else {
            return plats.get(++positionCourante);
        }
    }

    @Override
    public PlatAuMenu precedent() {
        if (positionCourante <= 0) {
            throw new IndexOutOfBoundsException("Depasse le nombre minimal de plats");
        }
        else {
            return plats.get(--positionCourante);
        }
    }

    @Override
    public PlatAuMenu itemCourant() {
        return plats.get(positionCourante);
    }
}