package menufact.tests;

import menufact.Client;
import menufact.Menu;
import menufact.facture.Facture;
import menufact.facture.FactureEtat;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.TypePlats;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * L'ensemble des tests unitaires pour les méthodes qui touches la gestion de la facture
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class FactureTestsUnitaires {

    @Test
    public void Facture() {
        // Creation facture et d'un client
        Facture facture = new Facture("Facture test");
        Client client = new Client(1234, "Mr Client", "567890");

        // Association des informations du client a la facture
        facture.associerClient(client);

        assertEquals("Facture test", facture.getDescription());
        assertEquals(FactureEtat.OUVERTE, facture.getEtat());
        assertTrue(facture.getPlats().isEmpty());
        assertEquals(1234, facture.getClient().getIdClient());
        assertEquals("Mr Client", facture.getClient().getNom());
        assertEquals("567890", facture.getClient().getNumeroCarteCredit());
    }

    @Test(expected = FactureException.class)
    public void ajoutePlat() throws FactureException {
        // Creation menu avec un plat
        Menu mainMenu = new Menu("Menu principale");
        PlatAuMenu p1 = new PlatAuMenu(TypePlats.REGULIER, 2, "P1", 35);
        mainMenu.ajoute(p1);

        // Creation facture
        Facture facture = new Facture("Facture test");
        facture.fermer();
        facture.ajoutePlat(2, 1, mainMenu);
    }

    @Test
    public void retirerPlat() {
        // Creation menu avec deux plats
        Menu mainMenu = new Menu("Menu principale");
        PlatAuMenu p1 = new PlatAuMenu(TypePlats.REGULIER, 2, "P1", 35);
        PlatAuMenu p2 = new PlatAuMenu(TypePlats.REGULIER, 3, "P2", 25);
        mainMenu.ajoute(p1); mainMenu.ajoute(p2);

        // Creation facture
        Facture facture = new Facture("Facture test");

        //facture.ajoutePlat(3, 2, mainMenu);
        //assertEquals(2, facture.getPlats().size());
        //retirerPlat();
    }

    @Test
    public void payer() {
        // Creation facture
        Facture facture = new Facture("Facture test");

        try {
            facture.payer();
            fail("La facture doit etre a l'etat fermee");
        } catch(FactureException e) {}

        facture.fermer();
        try {
            facture.payer();
        } catch(FactureException e) {}
    }

    @Test
    public void fermer() {
        // Creation facture
        Facture facture = new Facture("Facture test");
        assertEquals(FactureEtat.OUVERTE, facture.getEtat());
        facture.fermer();
        assertEquals(FactureEtat.FERMEE, facture.getEtat());
    }

    @Test
    public void ouvrir() throws FactureException {
        // Creation facture
        Facture facture = new Facture("Facture test");
        assertEquals(FactureEtat.OUVERTE, facture.getEtat());
        facture.fermer();
        assertEquals(FactureEtat.FERMEE, facture.getEtat());
        facture.ouvrir();
        assertEquals(FactureEtat.OUVERTE, facture.getEtat());

        facture.fermer();
        facture.payer();
        try {
            facture.ouvrir();
            fail("La facture ne peut pas être reouverte.");
        } catch (FactureException e) {}
    }
}