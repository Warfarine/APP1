package menufact.EtatPlats;

/**
 * Classe qui fait la gestion du Chef (l'objet qui contrôle l'état des plats)
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class Chef {
    private EtatPlat etatPlat;

    // Méthodes de modification
    public void setEtat(EtatPlat newEtat)
    {
        this.etatPlat = newEtat;
    }
    public  void action() { etatPlat.action(this);
    }
}
