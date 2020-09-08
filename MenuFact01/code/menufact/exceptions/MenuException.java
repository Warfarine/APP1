package menufact.exceptions;

/**
 * Exception en lien avec la gestion du menu
 * @author J. LaFerrière, É. Marchal
 * @version 1.0
 */
public class MenuException extends Exception{
    public MenuException(String message){
        super("MenuException: " + message);
    }
}

