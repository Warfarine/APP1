package menufact.EtatPlats;

/**
 * État du plat: Impossible à servir
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class ImpossibleDeServir extends EtatPlat{

    @Override
    public void action(Chef context)
    {
        System.out.println("Le plat ne peux pas être servi");
    }
}
