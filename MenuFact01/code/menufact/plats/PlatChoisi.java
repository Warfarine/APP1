package menufact.plats;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.SingletonInventaire;
import ingredients.exceptions.IngredientException;
import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;

import java.util.ArrayList;

/**
 * Classe des platsChoisi
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class PlatChoisi {
    private PlatAuMenu plat;
    private double quantitePlat;
    private boolean estOK;
    private SingletonInventaire inventaire;

    /**
     * Constructeur par paramètre
     * @param plat un PlatAuMenu à rajouter à la facture
     * @param quantitePlat quantité des plats à rajouter
     */
    public PlatChoisi(PlatAuMenu plat, double quantitePlat) {
        this.plat = plat;
        this.quantitePlat = quantitePlat;
    }

    /**
     * Constructeur par paramètre
     * @param plat un PlatAuMenu à rajouter à la facture
     * @param quantitePlat quantité des plats à rajouter
     * @param inventaire un inventaire de type SingletonInventaire
     */
    public PlatChoisi(PlatAuMenu plat, double quantitePlat, SingletonInventaire inventaire) {
        this.plat = plat;
        this.quantitePlat = quantitePlat;
        this.inventaire = inventaire;
        this.estOK = false;
    }

    /**
     * Méthode pour vérifier si c'est possible de faire un plat selon ce qui est disponible dans l'inventaire; si le plat
     * est validé, il pourra être commandé et inscrit sur la facture
     * @throws MenuException seulement s'il n'y as pas assez d'ingrédients pour faire le plat
     */
    public void confirmerPlat() throws IngredientException, MenuException {
        for (int i = 0; i < plat.getListIngredients().size(); i++) {
            // Accéder les informations nécessaires des ingrédients du plats
            String nomIngredient = (plat.getListIngredients()).get(i).getNom();
            Double quantiteRequise = (plat.getListIngredients()).get(i).getQuantite() * quantitePlat;
            EtatIngredient etat = plat.getListIngredients().get(i).getEtatIngredient();

            // Vérifier l'état de l'inventaire
            if (inventaire.verifierQnt(nomIngredient, quantiteRequise, etat))
            {
                inventaire.modifierQnt(nomIngredient, quantiteRequise,etat);
                estOK = true;
            }
            else
            {
                throw new MenuException("Il n'y a pas assez d'ingrédients pour faire cette quantité de plats");
            }
        }
    }

    /**
     * @return le contenu du plat choisi en chaîne de caractères
     */
    @Override
    public String toString() {
        return "PlatChoisi : " +
                "Code plat: " + plat.getCode() +
                "; Prix : " + plat.getPrix() +
                "; Quantite : " + quantitePlat + "; ";
    }

    // Méthodes d'accès et de modification de la quantité des plats commandée
    public double getQuantite() { return quantitePlat; }
    public void setQuantite(int quantite) { this.quantitePlat = quantite; }
    // Méthode pour vérifier l'état du plat (s'il est valide ou non)
    public boolean getEtat() { return estOK; }
    // Méthode d'accès du plat
    public PlatAuMenu getPlat() { return plat; }
}
