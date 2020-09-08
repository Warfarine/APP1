package ingredients;

import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

/**
 * L'inventaire du système MenuFact
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public final class SingletonInventaire {
    private static volatile SingletonInventaire instanceInventaire;
    public ArrayList<Ingredient> contenu = new ArrayList<>();

    /**
     * Constructeur par défaut
     */
    private SingletonInventaire() { }

    /**
     * Méthode pour accéder l'objet inventaire
     * @return l'objet de l'inventaire
     */
    public static SingletonInventaire getInstance() {
        SingletonInventaire resultat = instanceInventaire;
        // Vérifier si l'instance de l'inventaire existe
        if (instanceInventaire != null) {
            return resultat;
        }
        synchronized (SingletonInventaire.class) {
            if (instanceInventaire == null) {
                instanceInventaire = new SingletonInventaire();
            }
            return instanceInventaire;
        }
    }

    /**
     * Méthode pour rajouter un ingrédient à l'inventaire
     * @param ingredient un ingredient à rajouter à l'inventaire
     */
    public void ajoutIngredient(Ingredient ingredient) {
        contenu.add(ingredient);
    }

    /**
     * Méthode pour vérifier si un ingérdient spécifique est dans l'inventaire ou s'il est dans le bon format
     * @param nomIngredient nom de l'ingrédient à vérifier
     * @param etat état de l'ingrédient à vérifier
     * @ return int pour indiquer la position dans l'inventaire
     */
    public int estDansInventaire(String nomIngredient, EtatIngredient etat) {
        for (int i = 0; i < contenu.size(); i++) {
            // Vérifier si l'ingrédient est présent dans l'inventaire ou s'il est dans le bon format
            if ((contenu.get(i).getNom()).equals(nomIngredient) && contenu.get(i).getEtatIngredient().equals(etat)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Méthode pour vérifier si un ingérdient spécifique est dans l'inventaire ou s'il est dans le bon format
     * @param nomIngredient nom de l'ingrédient
     * @param qnt la quantité de l'ingrédient à retirer
     * @param etat l'état de l'ingrédient
     * @throws IngredientException si l'ingrédient n'est pas présent dans l'inventaire
     */
    public void modifierQnt(String nomIngredient, double qnt, EtatIngredient etat) throws IngredientException {
        int position = estDansInventaire(nomIngredient, etat);
        // Une position négative indique que l'ingrédient n'était pas dans l'inventaire
        if (position >= 0) {
                contenu.get(position).setQuantite(contenu.get(position).getQuantite() - qnt);
            }
            else throw new IngredientException("L'ingrédient ne se retrouve pas dans l'inventaire");
        }

    /**
     * Méthode pour vérifier la quantité d'un ingrédient dans l'inventaire
     * @param nomIngredient nom de l'ingrédient à vérifier
     * @param qnt la quantité à de l'ingrédient à vérifier
     * @param etat état de l'ingrédient à vérifier
     * @throws IngredientException s'il n'y a pas assez de d'ingrédients dans l'inventaire ou s'il n'est pas présent
     */
    public boolean verifierQnt(String nomIngredient, double qnt, EtatIngredient etat) throws IngredientException {
        int position = estDansInventaire(nomIngredient, etat);
        // Une position négative indique que l'ingrédient n'était pas dans l'inventaire
        if (position >= 0) {
           // Vérifier si la quantité est suffisante dans l'inventaire pour l'ingrédient donné
            if (contenu.get(position).getQuantite() - qnt >= 0) {
                return true;
            }
            else throw new IngredientException("Il n'y a pas assez d'ingrédient de disponible");
        }
        else {
            throw new IngredientException("L'ingrédient ne se retrouve pas dans l'inventaire");
        }
    }
}