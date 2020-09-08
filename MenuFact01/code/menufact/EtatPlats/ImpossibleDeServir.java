package menufact.EtatPlats;

public class ImpossibleDeServir extends EtatPlat{

    @Override
    public void action(Chef context)
    {
        System.out.println("Le plat ne peux pas être servi");
    }
}
