package menufact.tests;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.SingletonInventaire;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import menufact.Menu;
import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.TypePlats;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * L'ensemble des tests unitaires pour les méthodes qui touches la gestion des PlatChoisi
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class PlatChoisiTestsUnitaires {

    @Test
    public void PlatChoisi()
    {
        PlatAuMenu p1 = new PlatAuMenu(TypePlats.REGULIER, 20, "P1", 12);
        PlatChoisi pc = new PlatChoisi(p1,4);

        assertEquals(4, pc.getQuantite(),0);
        assertEquals(20, pc.getPlat().getCode());
    }

    @Test
    public void confirmerPlat() {
        // Creation de l'inventaire des ingredient
        SingletonInventaire inventaire = SingletonInventaire.getInstance();
        Ingredient i1 = new Ingredient("pomme", "red", 20, TypeIngredient.FRUIT, EtatIngredient.UNITES);
        inventaire.contenu.add(i1);

        // Creation Plats
        PlatAuMenu p1 = new PlatAuMenu(TypePlats.REGULIER, 0, "P1", 20);

        // Creation menu
        Menu menu = new Menu("Test Menu");
        menu.ajoute(p1);

        try {
            p1.setListIngredients("pomme", "red", 1, TypeIngredient.FRUIT, EtatIngredient.UNITES, inventaire);
        } catch (IngredientException e) {
            System.out.println(e);
        }

        PlatChoisi pc1 = new PlatChoisi(p1, 200, inventaire);
        // Trop d'ingredient
        try {
            pc1.confirmerPlat();
            fail("Il n'y a pas assez d'ingredients pour faire cette quantite de plats");
        } catch (IngredientException | MenuException e) {
            System.out.println(e);
        }
    }
}