package menufact.plats;

import ingredients.Ingredient;
import java.util.ArrayList;

/**
 * Classe des platRegulier
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class PlatRegulier extends PlatAuMenu {

    /**
     * Constructeur par paramètre
     * @param type type du plats (Regulier)
     * @param code valeur entière indiquant le code du plat
     * @param description chaîne de caractère avec la description du plat
     * @param prix prix du plat
     */
    public PlatRegulier(TypePlats type, int code, String description, double prix) {
        super(type, code, description, prix);
    }
}

