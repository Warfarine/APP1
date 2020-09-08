package menufact.plats;

import ingredients.Ingredient;
import java.util.ArrayList;

/**
 * Interface pour construire les plats
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class PlatsBuilder implements Builder {
    private TypePlats type;
    private int code;
    private String description;
    private double prix;
    private ArrayList<Ingredient> liste;
    private double kcal;
    private double chol;
    private double gras;
    private double proportion;

    /**
     * @param type type du plat
     */
    @Override
    public void setType(TypePlats type) {
        this.type = type;
    }

    /**
     * @param code valeur entière qui désigne le code du plat
     */
    @Override
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @param description chaîne de caratère avec la description du plat
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param prix prix du plat
     */
    @Override
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * @param liste ArrayList contenant une liste d'ingrédients
     */
    @Override
    public void setIngredients(ArrayList<Ingredient> liste) {
        this.liste = liste;
    }

    /**
     * @param kcal valeur de la quantité de calories
     */
    @Override
    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    /**
     * @param chol valeur de la quantité de cholestérol
     */
    @Override
    public void setChol(double chol) {
        this.chol = chol;
    }

    /**
     * @param gras valeur de la quantité de gras
     */
    @Override
    public void setGras(double gras) {
        this.gras = gras;
    }

    /**
     * @param proportion valeur indiquant la proportion du plat par rapport au plat régulier
     */
    @Override
    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

    // Méthodes pour instancier un plat régulier, un plat enfant et un plat santé
    public PlatRegulier getResultatRegulier() {
        return new PlatRegulier(type, code, description, prix);
    }
    public PlatEnfant getResultatEnfant() {
        return new PlatEnfant(type, code, description, prix, proportion);
    }
    public PlatSante getResultatSante() {
        return new PlatSante(type, code, description, prix, kcal, chol, gras);
    }
}