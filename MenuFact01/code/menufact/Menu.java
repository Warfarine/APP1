package menufact;

import ingredients.Ingredient;
import menufact.plats.*;
import java.util.ArrayList;

public class Menu {
    private String description;
    private ArrayList<PlatAuMenu> plats = new ArrayList<>();

    // Constructeur par paramètre
    public Menu(String description) {
        this.description = description;
    }

    // Builders
    public void buildPlatRegulier(Builder builder, int code, String description, double prix) {
        builder.setType(TypePlats.REGULIER);
        builder.setCode(code);
        builder.setDescription(description);
        builder.setPrix(prix);
    }

    public void buildPlatSante(Builder builder, int code, String description, double prix,
                               double kcal, double chol, double gras) {
        builder.setType(TypePlats.SANTE);
        builder.setCode(code);
        builder.setDescription(description);
        builder.setPrix(prix);
        builder.setKcal(kcal);
        builder.setChol(chol);
        builder.setGras(gras);
    }

    public void buildPlatEnfant(Builder builder, int code, String description, double prix, double proportion) {
        builder.setType(TypePlats.ENFANT);
        builder.setCode(code);
        builder.setDescription(description);
        builder.setPrix(prix);
        builder.setProportion(proportion);
    }

    // Méthodes d'access et de modification
    ArrayList<PlatAuMenu> getPlats() { return plats; }
    public PlatAuMenu getPlatSingulier(int code) {return plats.get(code); }
    public String getPlatInfo(int code) {
        if (code < 0 | code > plats.size()) {
            throw new ArrayIndexOutOfBoundsException("Le code entre est invalide");
        }
        else {
            return (plats.get(code)).toString();
        }
    }

    // Méthode de modification du menu - Ajoute les plats
    void ajoute(PlatAuMenu nouveauPlat)
    {
        plats.add(nouveauPlat);
    }

    // Affichage menu
    void afficherMenu() {
        for (int i = 0; i < plats.size(); i++) {
            System.out.println(getPlatInfo(i).toString());
        }
    }
}