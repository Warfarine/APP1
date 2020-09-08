package menufact.EtatPlats;

public class Preparation extends EtatPlat{

    @Override
    public void action(Chef context)
    {
        System.out.println("Le plat est en préparation");
    }
}
