package menufact.iterateur;

import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;

public class IterateurFacture implements IterateurF {
    private int positionCourante;
    private ArrayList<PlatChoisi> plats;

    public IterateurFacture(ArrayList<PlatChoisi> listePlats){
        this.plats = listePlats;
        positionCourante = 0;
    }

    @Override
    public PlatChoisi suivant() {
        if (positionCourante >= plats.size()) {
            throw new IndexOutOfBoundsException("Depasse le nombre maximal de plats");
        }
        else {
            return plats.get(++positionCourante);
        }
    }

    @Override
    public PlatChoisi precedent() {
        if (positionCourante <= 0) {
            throw new IndexOutOfBoundsException("Depasse le nombre minimal de plats");
        }
        else {
            return plats.get(--positionCourante);
        }
    }

    @Override
    public PlatChoisi itemCourant() {
        return plats.get(positionCourante);
    }
}