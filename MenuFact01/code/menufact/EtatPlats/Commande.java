package menufact.EtatPlats;

/**
 * État du plat: Commandé
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class Commande extends EtatPlat
{
    @Override
    public void action(Chef context)
    {
        System.out.println("Le plat est commandé");
        System.out.println("La commande a éte envoyé au Chef");
    }
}
