package menufact.EtatPlats;

public class Servi extends EtatPlat{

    @Override
    public void action(Chef context)
    {
        System.out.println("Le plat est servi");
    }
}
