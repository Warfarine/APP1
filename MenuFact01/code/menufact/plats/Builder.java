package menufact.plats;

import ingredients.Ingredient;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Interface pour gérer l'interface Builder pour les différents types de plats
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public interface Builder {
    void setType(TypePlats type);
    void setCode(int code);
    void setDescription(String description);
    void setPrix(double prix);
    void setIngredients(ArrayList<Ingredient> liste);
    void setKcal(double kcal);
    void setChol(double chol);
    void setGras(double gras);
    void setProportion(double proportion);
}
