package menufact.EtatPlats;

/**
 * État du plat: Terminé
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class Termine extends EtatPlat{

    @Override
    public void action(Chef context)
    {
        System.out.println("Le plat est terminé");
    }
}
