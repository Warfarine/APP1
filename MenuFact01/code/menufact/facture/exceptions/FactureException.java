package menufact.facture.exceptions;

/**
 * Exception en lien avec la gestion des factures
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class FactureException extends Exception{
    public FactureException(String message){
        super("FactureException: " + message);
   }
}
