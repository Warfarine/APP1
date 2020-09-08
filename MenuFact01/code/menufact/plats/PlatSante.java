package menufact.plats;

import ingredients.Ingredient;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Classe des platSante
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    /**
     * Constructeur par paramètre
     * @param type type du plats (Sante)
     * @param code valeur entière indiquant le code du plat
     * @param description chaîne de caractère avec la description du plat
     * @param prix prix du plat
     * @param kcal quantité de calories
     * @param chol quantité de cholestérol
     * @param gras quantité de gras
     */
    public PlatSante(TypePlats type, int code, String description, double prix, double kcal, double chol, double gras) {
        super(type, code, description, prix);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    /**
     * @return le contenu du plat santé en chaîne de caractères
     */
    @Override
    public String toString() {
        return super.toString() +
                "; kcal: " + kcal +
                "; chol: " + chol +
                "; gras: " + gras + "\n";
    }

    // Méthodes d'accès et de modification des calories
    public double getKcal() {
        return kcal;
    }
    public void setKcal(double kcal) { this.kcal = kcal; }
    // Méthodes d'accès et de modification de la quantité de cholestérol
    public double getChol() {
        return chol;
    }
    public void setChol(double chol) { this.chol = chol; }
    // Méthodes d'accès et de modification de la quantité de gras
    public double getGras() {
        return gras;
    }
    public void setGras(double gras) { this.gras = gras; }
}