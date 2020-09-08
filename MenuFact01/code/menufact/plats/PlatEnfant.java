package menufact.plats;

import ingredients.Ingredient;
import java.util.ArrayList;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant(TypePlats type, int code, String description, double prix, double proportion) {
        super(type, code, description, prix);
        this.proportion = proportion;
    }

    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return super.toString() +
                "; Proportion: " + proportion;
    }
}
