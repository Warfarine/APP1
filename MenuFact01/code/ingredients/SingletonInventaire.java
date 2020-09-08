package ingredients;

import ingredients.exceptions.IngredientException;

import java.util.ArrayList;

public final class SingletonInventaire {
    private static volatile SingletonInventaire instanceInventaire;
    public ArrayList<Ingredient> contenu = new ArrayList<>();

    private SingletonInventaire() {
    }
    public static SingletonInventaire getInstance() {
        SingletonInventaire resultat = instanceInventaire;
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

    public void ajoutIngredient(Ingredient ingredient) {
        contenu.add(ingredient);
    }

    public int estDansInventaire(String nomIngredient, EtatIngredient etat) {
        for (int i = 0; i < contenu.size(); i++) {
            if ((contenu.get(i).getNom()).equals(nomIngredient) && contenu.get(i).getEtatIngredient().equals(etat)) {
                return i;
            }
        }
        return -1;
    }

    public void modifierQnt(String nomIngredient, double qnt, EtatIngredient etat) throws IngredientException {
        int position = estDansInventaire(nomIngredient, etat);
        if (position >= 0) {
                contenu.get(position).setQuantite(contenu.get(position).getQuantite() - qnt);
            }
            else throw new IngredientException("L'ingredient ne se retrouve pas dans l'inventaire");
        }

    public boolean verifierQnt(String nomIngredient, double qnt, EtatIngredient etat) throws IngredientException {
        int position = estDansInventaire(nomIngredient, etat);
        if (position >= 0) {
            if (contenu.get(position).getQuantite() - qnt >= 0) {
                return true;
            }
            else throw new IngredientException("Il n'y a pas assez d'ingredient de disponible");
        }
        else {
            throw new IngredientException("L'ingredient ne se retrouve pas dans l'inventaire");
        }
    }
}

