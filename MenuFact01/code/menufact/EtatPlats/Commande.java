package menufact.EtatPlats;

public class Commande extends EtatPlat
{
    @Override
    public void action(Chef context)
    {
        System.out.println("Le plat est commandé");
    }
}
