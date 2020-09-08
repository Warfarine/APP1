package menufact.plats;

import ingredients.Ingredient;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    public PlatSante(TypePlats type, int code, String description, double prix, double kcal, double chol, double gras) {
        super(type, code, description, prix);
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    @Override
    public String toString() {
        return super.toString() +
                "; kcal: " + kcal +
                "; chol: " + chol +
                "; gras: " + gras + "\n";
    }

    public double getKcal() {
        return kcal;
    }

    public double getChol() {
        return chol;
    }

    public double getGras() {
        return gras;
    }
}