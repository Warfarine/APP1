package menufact.plats;

import ingredients.Ingredient;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
