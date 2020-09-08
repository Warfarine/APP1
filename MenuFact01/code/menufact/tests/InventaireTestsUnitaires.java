package menufact.tests;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.SingletonInventaire;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * L'ensemble des tests unitaires pour les méthodes qui touches la gestion de l'inventaire
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class InventaireTestsUnitaires {

    @Test
    public void getInstance() {
        SingletonInventaire inventaire = SingletonInventaire.getInstance();
        assertTrue(inventaire.contenu.isEmpty());
    }

    @Test
    public void estDansInventaire() {
        // Creation de l'inventaire des ingredient
        SingletonInventaire inventaire = SingletonInventaire.getInstance();
        Ingredient i1 = new Ingredient("pomme", "rouge", 20, TypeIngredient.FRUIT, EtatIngredient.UNITES);

        // Ajout des ingredient dans l'inventaire
        inventaire.contenu.add(i1);

        // Verification presence dans  inventaire
        assertTrue(inventaire.estDansInventaire("pomme", EtatIngredient.UNITES) >= 0);
        // Ingredient dans le mauvais etat
        assertFalse(inventaire.estDansInventaire("pomme", EtatIngredient.grammes) >= 0);
        // Ingredient pas present dans l'inventaire
        assertFalse(inventaire.estDansInventaire("banane", EtatIngredient.UNITES) >=0);
    }

    @Test()
    public void modifierQnt() throws IngredientException {
        // Creation de l'inventaire des ingredient
        SingletonInventaire inventaire = SingletonInventaire.getInstance();
        Ingredient i1 = new Ingredient("pomme", "rouge", 20, TypeIngredient.FRUIT, EtatIngredient.UNITES);

        // Ajout des ingredient dans l'inventaire
        inventaire.contenu.add(i1);

        // Verification de l'ajout de l'ingredient dans l'inventaire
        assertEquals("pomme", inventaire.contenu.get(0).getNom());
        assertEquals("rouge", inventaire.contenu.get(0).getDescription());
        assertEquals(20, inventaire.contenu.get(0).getQuantite(), 0);
        assertEquals(TypeIngredient.FRUIT, inventaire.contenu.get(0).getTypeIngredient());
        assertEquals(EtatIngredient.UNITES, inventaire.contenu.get(0).getEtatIngredient());

        try {
            // Ingredient non existant
            inventaire.modifierQnt("banane", 10, EtatIngredient.UNITES);
            fail("L'ingredient ne se retrouve pas dans l'inventaire");
        } catch (IngredientException e) {}

        try {
            // Ingredient non existant
            inventaire.modifierQnt("pomme", 10, EtatIngredient.grammes);
            fail("L'ingredient ne se retrouve pas dans l'inventaire");
        } catch (IngredientException e) {}

    }

    @Test(expected = IngredientException.class)
    public void verifierQnt() throws IngredientException {
        // Creation de l'inventaire des ingredient
        SingletonInventaire inventaire = SingletonInventaire.getInstance();
        Ingredient i1 = new Ingredient("pomme", "rouge", 20, TypeIngredient.FRUIT, EtatIngredient.UNITES);

        // Ajout des ingredient dans l'inventaire
        inventaire.contenu.add(i1);

        // Ingredient non existant
        inventaire.verifierQnt("banane", 10, EtatIngredient.UNITES);
        // Quantite insuffisante
        inventaire.verifierQnt("pomme", 40, EtatIngredient.UNITES);
    }
}