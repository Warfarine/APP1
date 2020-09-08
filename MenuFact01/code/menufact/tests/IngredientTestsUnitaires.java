package menufact.tests;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTestsUnitaires {

    @Test()
    public void setQuantite() throws IngredientException {
        Ingredient i1 = new Ingredient("pomme", "rouge", 20, TypeIngredient.FRUIT, EtatIngredient.UNITES);
        Ingredient i2 = new Ingredient("carottes", "bio", 20, TypeIngredient.LEGUME, EtatIngredient.UNITES);

        // Modification de la quantite d'ingredient
        i2.setQuantite(100);
        assertEquals(100, i2.getQuantite(), 0);

        // Quantite negative
        try {
            i1.setQuantite(-1);
            fail("Il n'est pas possible d'avoir une quantite negative");
        } catch (IngredientException e) {}
    }

    @Test(expected = IngredientException.class)
    public void setTypeIngredient() throws IngredientException {
        Ingredient i1 = new Ingredient("pomme", "rouge", 20, TypeIngredient.FRUIT, EtatIngredient.UNITES);

        i1.setTypeIngredient(TypeIngredient.LAITIER);
    }
}