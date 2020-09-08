package ingredients.exceptions;

/**
 * Exception en lien avec la gestion des ingrédients
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class IngredientException extends Exception{
    public IngredientException(String message){
        super("IngredientException: " + message);
    }
}
