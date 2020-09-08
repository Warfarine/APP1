package menufact.iterateur;

import menufact.plats.PlatAuMenu;
import java.util.ArrayList;

public class ListePlatsMenu implements CollectionPlatsMenu {
    private ArrayList<PlatAuMenu> plats;

    public ListePlatsMenu(ArrayList<PlatAuMenu> listePlats) {
        this.plats = listePlats;
    }

    @Override
    public Iterateur creerIterateurMenu() {
        return new IterateurMenu(plats);
    }
}