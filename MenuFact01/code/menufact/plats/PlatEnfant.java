package menufact.plats;

import ingredients.Ingredient;
import java.util.ArrayList;

/**
 * Classe des platsEnfant
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    /**
     * Constructeur par paramètre
     * @param type type du plats (Enfant)
     * @param code valeur entière indiquant le code du plat
     * @param description chaîne de caractère avec la description du plat
     * @param prix prix du plat
     * @param proportion valeur indiquant la proportion du plat par rapport au plat régulier
     */
    public PlatEnfant(TypePlats type, int code, String description, double prix, double proportion) {
        super(type, code, description, prix);
        this.proportion = proportion;
    }

    // Méthode d'accès et de modification de la proportion
    public double getProportion() {
        return proportion;
    }
    public void setProportion(double proportion) { this.proportion = proportion; }

    /**
     * @return le contenu du plat enfant en chaîne de caractères
     */
    @Override
    public String toString() {
        return super.toString() +
                "; Proportion: " + proportion + "\n";
    }
}
