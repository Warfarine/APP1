package menufact.EtatPlats;

public class Chef {
    private EtatPlat etatPlat;

    public void setEtat(EtatPlat newEtat)
    {
        this.etatPlat = newEtat;
    }

    public  void action()
    {
        etatPlat.action(this);
    }
}
