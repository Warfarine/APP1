package menufact.EtatPlats;

/**
 * État du plat: Servi
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class Servi extends EtatPlat{

    @Override
    public void action(Chef context)
    {
        System.out.println("Le plat est servi");
    }
}
