package menufact.EtatPlats;

/**
 * État du plat: Préparation
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class Preparation extends EtatPlat{

    @Override
    public void action(Chef context)
    {
        System.out.println("Le plat est en préparation");
    }
}
