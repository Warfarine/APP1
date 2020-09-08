package menufact;

import ingredients.Ingredient;
import menufact.plats.*;
import java.util.ArrayList;

/**
 * Classe qui fait la gestion du menu
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class Menu {
    private String description;
    private ArrayList<PlatAuMenu> plats = new ArrayList<>();

    /**
     * Constructeur par paramètre
     * @param description chaîne de caractère avec la description du menu
     */
    public Menu(String description) {
        this.description = description;
    }

    /**
     * Méthode pour construire un plat régulier
     * @param builder object qui vo construire le plat
     * @param code valeur entière désignant de code du plat
     * @param description chaîne de caractère avec la description du plat
     * @param prix valeur du plat
     */
    public void buildPlatRegulier(Builder builder, int code, String description, double prix) {
        builder.setType(TypePlats.REGULIER);
        builder.setCode(code);
        builder.setDescription(description);
        builder.setPrix(prix);
    }

    /**
     * Méthode pour construire un plat santé
     * @param builder object qui vo construire le plat
     * @param code valeur entière désignant de code du plat
     * @param description chaîne de caractère avec la description du plat
     * @param prix valeur du plat
     * @param kcal quantité de calories
     * @param chol quantité de cholestérol
     * @param gras quantité de gras
     */
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

    /**
     * Méthode pour construire un plat enfant
     * @param builder object qui vo construire le plat
     * @param code valeur entière désignant de code du plat
     * @param description chaîne de caractère avec la description du plat
     * @param prix valeur du plat
     * @param proportion proportion par rapport au plat régulier
     */
    public void buildPlatEnfant(Builder builder, int code, String description, double prix, double proportion) {
        builder.setType(TypePlats.ENFANT);
        builder.setCode(code);
        builder.setDescription(description);
        builder.setPrix(prix);
        builder.setProportion(proportion);
    }

    // Méthodes d'accès et de modification
    public ArrayList<PlatAuMenu> getPlats() { return plats; }
    public String getDescription() { return description; }

    /**
     * Méthode pour accéder un plat singulier selon son code
     * @param code valeur entière pour indiquer le code du plat
     * @return un plat au menu
     */
    public PlatAuMenu getPlatSingulier(int code) {return plats.get(code); }

    /**
     * Méthode pour accéder les informations complètes d'un plat
     * @param code valeur entière désignant de code du plat
     * @return la description des plats en chaîne de caractères
     * @throws ArrayIndexOutOfBoundsException seulement si le code entré n'est pas valide
     */
    public String getPlatInfo(int code) {
        if (code < 0 | code > plats.size()) {
            throw new ArrayIndexOutOfBoundsException("Le code entre est invalide");
        }
        else {
            return (plats.get(code)).toString();
        }
    }

    /**
     * Méthode pour ajouter un plat au menu
     * @param nouveauPlat un PlatAuMenu à rajouter
     */
    public void ajoute(PlatAuMenu nouveauPlat)
    {
        plats.add(nouveauPlat);
    }


    /**
     * Méthode d'affichage du menu
     */
    void afficherMenu() {
        for (int i = 0; i < plats.size(); i++) {
            System.out.println(getPlatInfo(i).toString());
        }
    }
}