package menufact;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.SingletonInventaire;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import menufact.plats.PlatAuMenu;
import menufact.plats.TypePlats;

public class TestINGREDIENTS {
    public static void main(String[] args) throws IngredientException {

        // Creation de l'inventaire des ingredient
        SingletonInventaire inventaire = SingletonInventaire.getInstance();
        Ingredient i1 = new Ingredient("pomme", "red", 20, TypeIngredient.FRUIT, EtatIngredient.UNITES);
        Ingredient i2 = new Ingredient("banane", "long and firm", 50, TypeIngredient.FRUIT, EtatIngredient.UNITES);
        Ingredient i3 = new Ingredient("carotte", "fresh", 30, TypeIngredient.LEGUME, EtatIngredient.UNITES);
        Ingredient i4 = new Ingredient("broco", "green", 10, TypeIngredient.LEGUME, EtatIngredient.UNITES);
        Ingredient i5 = new Ingredient("milk", "cows", 1000, TypeIngredient.LAITIER, EtatIngredient.millilitre);
        Ingredient i6 = new Ingredient("cheese", "old", 500, TypeIngredient.LAITIER, EtatIngredient.grammes);
        Ingredient i7 = new Ingredient("beef", "joocy", 700, TypeIngredient.VIANDE, EtatIngredient.grammes);
        Ingredient i8 = new Ingredient("piggy", "oink", 600, TypeIngredient.VIANDE, EtatIngredient.grammes);
        Ingredient i9 = new Ingredient("pepper", "black", 30, TypeIngredient.EPICE, EtatIngredient.millilitre);

        inventaire.contenu.add(i1);
        inventaire.contenu.add(i3);
        inventaire.contenu.add(i4);
        inventaire.contenu.add(i5);
        inventaire.contenu.add(i6);
        inventaire.contenu.add(i7);
        inventaire.contenu.add(i9);


        // creation Plats
        PlatAuMenu p1 = new PlatAuMenu(TypePlats.REGULIER, 0, "P1", 20);
        PlatAuMenu p2 = new PlatAuMenu(TypePlats.SANTE, 1, "P2", 25);
        PlatAuMenu p3 = new PlatAuMenu(TypePlats.REGULIER, 2, "P3", 15);

        try {
            //p1.setListIngredients("pomme", "red", 10, TypeIngredient.FRUIT, EtatIngredient.grammes, inventaire);
            //p1.setListIngredients("shit", "wont work", 20, TypeIngredient.VIANDE, EtatIngredient.UNITES, inventaire);
            // p1.setListIngredients("pomme", "wont work", 21, TypeIngredient.FRUIT, EtatIngredient.UNITES, inventaire);
            p1.setListIngredients("pomme", "red", 1, TypeIngredient.FRUIT, EtatIngredient.UNITES, inventaire);

        } catch (IngredientException e) {
            System.out.println(e);
        }
    }
}