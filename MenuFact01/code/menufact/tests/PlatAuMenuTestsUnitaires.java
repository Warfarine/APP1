package menufact.tests;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.SingletonInventaire;
import ingredients.TypeIngredient;
import menufact.plats.PlatAuMenu;
import menufact.plats.TypePlats;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlatAuMenuTestsUnitaires {

    @Test
    public void setListIngredients() {
        // Creation de l'inventaire des ingredient
        SingletonInventaire inventaire = SingletonInventaire.getInstance();
        Ingredient i1 = new Ingredient("pomme", "rouge", 20, TypeIngredient.FRUIT, EtatIngredient.UNITES);
        Ingredient i2 = new Ingredient("carotte", "petites", 30, TypeIngredient.LEGUME, EtatIngredient.UNITES);
        Ingredient i3 = new Ingredient("brocoli", "organique", 10, TypeIngredient.LEGUME, EtatIngredient.UNITES);
        Ingredient i4 = new Ingredient("lait", "de vache", 1000, TypeIngredient.LAITIER, EtatIngredient.millilitre);
        Ingredient i5 = new Ingredient("fromage", "vielli", 500, TypeIngredient.LAITIER, EtatIngredient.grammes);
        Ingredient i6 = new Ingredient("boeuf", "joocy", 700, TypeIngredient.VIANDE, EtatIngredient.grammes);
        Ingredient i7 = new Ingredient("porc", "oink", 600, TypeIngredient.VIANDE, EtatIngredient.grammes);
        Ingredient i8 = new Ingredient("poivre", "noir", 30, TypeIngredient.EPICE, EtatIngredient.millilitre);

        inventaire.contenu.add(i1);
        inventaire.contenu.add(i3);
        inventaire.contenu.add(i4);
        inventaire.contenu.add(i5);
        inventaire.contenu.add(i6);
        inventaire.contenu.add(i7);
        inventaire.contenu.add(i8);
        // Creation ingredients
    }

}