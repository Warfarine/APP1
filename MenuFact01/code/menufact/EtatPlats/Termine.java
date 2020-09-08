package menufact.EtatPlats;

public class Termine extends EtatPlat{

    @Override
    public void action(Chef context)
    {
        System.out.println("Le plat est terminé");
    }
}
