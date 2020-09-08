package menufact.EtatPlats;

public class TestChef {

    public TestChef()
    {
        Chef ch = new Chef();
        ChangeEtatTermine(ch);
    }

    private void ChangeEtatImpossible(Chef ch)
    {
        ch.setEtat(new ImpossibleDeServir());
        ch.action();
    }

    private void ChangeEtatCommande(Chef ch)
    {
        ch.setEtat(new Commande());
        ch.action();
    }

    private void ChangeEtatPreparation(Chef ch)
    {
        ch.setEtat(new Preparation());
        ch.action();
    }

    private void ChangeEtatServi(Chef ch)
    {
        ch.setEtat(new Servi());
        ch.action();
    }

    private void ChangeEtatTermine(Chef ch)
    {
        ch.setEtat(new Termine());
        ch.action();
    }
}
