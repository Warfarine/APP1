package menufact.tests;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.SingletonInventaire;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import menufact.plats.PlatAuMenu;
import menufact.plats.TypePlats;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * L'ensemble des tests unitaires pour les méthodes qui touches la gestion des PlatAuMenu
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class PlatAuMenuTestsUnitaires {

    @Test()
    public void PlatAuMenu() {
        PlatAuMenu plat = new PlatAuMenu(TypePlats.REGULIER, 0, "Plats test", 20);

        assertEquals(TypePlats.REGULIER, plat.getType());
        assertEquals(0, plat.getCode());
        assertEquals("Plats test", plat.getDescription());
        assertEquals(20, plat.getPrix(),0);
    }

    @Test()
    public void setListIngredients() {
        // Creation de l'inventaire des ingredient
        SingletonInventaire inventaire = SingletonInventaire.getInstance();
        Ingredient i1 = new Ingredient("pomme", "rouge", 20, TypeIngredient.FRUIT, EtatIngredient.UNITES);

        // Ajout des ingredients a l'inventaire
        inventaire.contenu.add(i1);

        // Creation ingredients
        PlatAuMenu p1 = new PlatAuMenu(TypePlats.REGULIER, 0, "P1", 20);

        try {
            // ingredient non existant dans l'inventaire
            p1.setListIngredients("banane", "jaune", 5, TypeIngredient.FRUIT, EtatIngredient.UNITES, inventaire);
            // ingredient sous le mauvait format
            p1.setListIngredients("pomme", "red", 5, TypeIngredient.FRUIT, EtatIngredient.millilitre, inventaire);
            fail("Cet ingredient n'est pas dans l'inventaire ou n'est pas dans le bon format");
        } catch (IngredientException e) {}


        try {
            // pas assez d'ingredient dans l'inventaire
            p1.setListIngredients("pomme", "wont work", 30, TypeIngredient.FRUIT, EtatIngredient.UNITES, inventaire);
            fail("Il n'y a pas une assez grande quantite dans l'inventaire pour inclure cet ingredient");
        } catch (IngredientException e) {};
    }
}