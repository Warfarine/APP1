package menufact.plats;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.SingletonInventaire;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlatAuMenu {
    private TypePlats type;
    private int code;
    private String description;
    private double prix;
    private ArrayList<Ingredient> listeIngredients = new ArrayList<>();

    public PlatAuMenu(TypePlats type, int code, String description, double prix) {
        this.type = type;
        this.code = code;
        this.description = description;
        this.prix = prix;
    }

    public TypePlats getType() {
        return type;
    }

    public void setType(TypePlats type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public ArrayList<Ingredient> getListIngredients() { return listeIngredients; }

    public void setListIngredients(String nomIngredient, String description, double quantite, TypeIngredient type, EtatIngredient etat, SingletonInventaire inventaire) throws IngredientException {
        if (inventaire.estDansInventaire(nomIngredient, etat) >= 0) {
                if (inventaire.verifierQnt(nomIngredient, quantite, etat)) {
                    listeIngredients.add(new Ingredient(nomIngredient,description,quantite,type,etat));
                } else {
                    throw new IngredientException("Il n'y a pas une assez grande quantite dans l'inventaire pour inclure cet ingredient");
                }
        }
        else {
            throw new IngredientException("Cet ingredient n'est pas dans l'inventaire ou n'est pas dans le bon format");
        }
    }

    @Override
    public String toString() {
        return  "Type plat: " + type +
                ", Code: " + code +
                ", Description: " + description +
                ", Prix: " + prix +
                ", Ingredient: " + listeIngredients + '\n';
    }
}