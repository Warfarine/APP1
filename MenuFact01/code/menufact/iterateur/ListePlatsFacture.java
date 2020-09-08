package menufact.iterateur;

import menufact.plats.PlatChoisi;
import java.util.ArrayList;

public class ListePlatsFacture implements CollectionPlatsFacture {
    private ArrayList<PlatChoisi> platsC;

    public ListePlatsFacture(ArrayList<PlatChoisi> listePlats) {
        this.platsC = listePlats;
    }

    @Override
    public IterateurF creerIterateurFacture() {
        return new IterateurFacture(platsC);
    }
}