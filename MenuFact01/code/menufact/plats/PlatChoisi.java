package menufact.plats;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.SingletonInventaire;
import ingredients.exceptions.IngredientException;
import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;

import java.util.ArrayList;

public class PlatChoisi {
    private PlatAuMenu plat;
    private double quantitePlat;
    private boolean estOK;
    private SingletonInventaire inventaire;

    public PlatChoisi(PlatAuMenu plat, double quantitePlat) {
        this.plat = plat;
        this.quantitePlat = quantitePlat;
    }
    public PlatChoisi(PlatAuMenu plat, double quantitePlat, SingletonInventaire inventaire) {
        this.plat = plat;
        this.quantitePlat = quantitePlat;
        this.inventaire = inventaire;
        this.estOK = false;
    }

    public void confirmerPlat() throws IngredientException, MenuException {
        for (int i = 0; i < plat.getListIngredients().size(); i++) {
            String nomIngredient = (plat.getListIngredients()).get(i).getNom();
            Double quantiteRequise = (plat.getListIngredients()).get(i).getQuantite() * quantitePlat;
            EtatIngredient etat = plat.getListIngredients().get(i).getEtatIngredient();

            if (inventaire.verifierQnt(nomIngredient, quantiteRequise, etat))
            {
                inventaire.modifierQnt(nomIngredient, quantiteRequise,etat);
                estOK = true;
            }
            else
            {
                throw new MenuException("Il n'y a pas assez d'ingredients pour faire cette quantite de plats");
            }
        }
    }

    @Override
    public String toString() {
        return "PlatChoisi : " +
                "Code plat: " + plat.getCode() +
                "; Prix : " + plat.getPrix() +
                "; Quantite : " + quantitePlat + "; ";
    }

    public double getQuantite() { return quantitePlat; }
    public void setQuantite(int quantite) { this.quantitePlat = quantite; }
    public boolean getEtat() { return estOK; }
    public PlatAuMenu getPlat() { return plat; }
}
