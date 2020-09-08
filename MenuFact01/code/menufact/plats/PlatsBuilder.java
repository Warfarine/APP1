package menufact.plats;

import ingredients.Ingredient;
import java.util.ArrayList;

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

    @Override
    public void setType(TypePlats type) {
        this.type = type;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public void setIngredients(ArrayList<Ingredient> liste) {
        this.liste = liste;
    }

    @Override
    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    @Override
    public void setChol(double chol) {
        this.chol = chol;
    }

    @Override
    public void setGras(double gras) {
        this.gras = gras;
    }

    @Override
    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

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