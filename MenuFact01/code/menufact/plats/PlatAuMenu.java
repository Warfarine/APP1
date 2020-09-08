package menufact.plats;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.SingletonInventaire;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import menufact.facture.exceptions.FactureException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe qui fait la gestion des plats au menu
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class PlatAuMenu {
    private TypePlats type;
    private int code;
    private String description;
    private double prix;
    private ArrayList<Ingredient> listeIngredients = new ArrayList<>();

    /**
     * Constructeur par paramètre
     * @param type le type du plats à construire
     * @param code valeur entière pour désigner le code du plat à construire
     * @param description chaine de caractère avec la description du plat
     * @param prix valeur du plat
     */
    public PlatAuMenu(TypePlats type, int code, String description, double prix) {
        this.type = type;
        this.code = code;
        this.description = description;
        this.prix = prix;
    }

    // Méthodes d'accès et de modification du type du plat
    public TypePlats getType() {
        return type;
    }
    public void setType(TypePlats type) {
        this.type = type;
    }

    // Méthodes d'accès et de modification du code du plat
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    // Méthodes d'accès et de modification de la description du plat
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // Méthodes d'accès et de modification du prix du plat
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Méthode d'accès de la liste des ingrédients du plats
    public ArrayList<Ingredient> getListIngredients() { return listeIngredients; }

    /**
     * Méthode pour entrer les ingrédients dans la liste d'ingrédients d'un plat
     * @param nomIngredient nom de l'ingrédient à rajouter
     * @param description chaîne contenant une description de l'ingrédient
     * @param quantite quantité de l'ingrédient
     * @param type Type de l'ingrédient à rajouter (plat régulier, santé, enfant)
     * @param etat État de l'ingérdient (unité, en mL ou en g)
     * @throws IngredientException seulement s'il n'y a pas assez d'ingrédients dans l'inventaire pour accomoder le plat
     * @throws IngredientException seulement si l'ingrédient n'est pas présent dans l'inventaire ou s'il n'est pas dans le bon format
     */
    public void setListIngredients(String nomIngredient, String description, double quantite, TypeIngredient type, EtatIngredient etat, SingletonInventaire inventaire) throws IngredientException {
        // vérifier si l'ingrédient est dans l'inventaire ou du mauvais format
        if (inventaire.estDansInventaire(nomIngredient, etat) >= 0) {
                // vérifier s'il est en quantité suffisante
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

    /**
     * @return le contenu du menu en chaîne de caracteres
     */
    @Override
    public String toString() {
        return  "Type plat: " + type +
                ", Code: " + code +
                ", Description: " + description +
                ", Prix: " + prix +
                ", Ingredient: " + listeIngredients + '\n';
    }
}