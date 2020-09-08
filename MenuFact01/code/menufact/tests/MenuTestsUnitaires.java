package menufact.tests;

import ingredients.TypeIngredient;
import menufact.Menu;
import menufact.plats.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTestsUnitaires {

    @Test
    public void Menu() {
        Menu mainMenu = new Menu("Menu Principale");
        assertEquals("Menu Principale", mainMenu.getDescription());
    }

    @Test
    public void buildPlatRegulier() {
        // Creation menu
        Menu mainMenu = new Menu("Menu Principale");

        // Creation plat Regulier
        PlatsBuilder plat1 = new PlatsBuilder();
        mainMenu.buildPlatRegulier(plat1, 0, "P1", 20);
        PlatRegulier p1 = plat1.getResultatRegulier();

        assertEquals(0, p1.getCode());
        assertEquals("P1", p1.getDescription());
        assertEquals(20, p1.getPrix(), 0);
        assertEquals(TypePlats.REGULIER, p1.getType());
    }

    @Test
    public void buildPlatEnfant() {
        // Creation menu
        Menu mainMenu = new Menu("Menu Principale");

        // Creation plat Enfant
        PlatsBuilder plat2 = new PlatsBuilder();
        mainMenu.buildPlatEnfant(plat2, 1, "P2", 15, 25);
        PlatEnfant p2 = plat2.getResultatEnfant();

        assertEquals(1, p2.getCode());
        assertEquals("P2", p2.getDescription());
        assertEquals(15, p2.getPrix(), 0);
        assertEquals(25, p2.getProportion(), 0);
        assertEquals(TypePlats.ENFANT, p2.getType());
    }

    @Test
    public void buildPlatSante() {
        // Creation menu
        Menu mainMenu = new Menu("Menu Principale");

        // Creation plat Sante
        PlatsBuilder plat3 = new PlatsBuilder();
        mainMenu.buildPlatSante(plat3, 2, "P3", 20, 350, 2, 5);
        PlatSante p3 = plat3.getResultatSante();

        assertEquals(2, p3.getCode());
        assertEquals("P3", p3.getDescription());
        assertEquals(20, p3.getPrix(), 0);
        assertEquals(350, p3.getKcal(), 0);
        assertEquals(2, p3.getChol(), 0);
        assertEquals(5, p3.getGras(), 0);
        assertEquals(TypePlats.SANTE, p3.getType());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getPlatSingulier() {
        // Creation menu
        Menu mainMenu = new Menu("Menu Principale");
        // Creation des plats
        PlatsBuilder plat1 = new PlatsBuilder();
        mainMenu.buildPlatRegulier(plat1, 0, "P1", 20);

        PlatsBuilder plat2 = new PlatsBuilder();
        mainMenu.buildPlatEnfant(plat2, 1, "P2", 15, 25);

        PlatRegulier p1 = plat1.getResultatRegulier();
        PlatEnfant p2 = plat2.getResultatEnfant();

        // Ajout des plats au menu
        mainMenu.ajoute(p1); mainMenu.ajoute(p2);

        assertEquals(p2, mainMenu.getPlatSingulier(1));
        mainMenu.getPlatSingulier(5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getPlatInfo() {
        // Creation menu
        Menu mainMenu = new Menu("Menu Principale");
        // Creation des plats
        PlatsBuilder plat1 = new PlatsBuilder();
        mainMenu.buildPlatRegulier(plat1, 0, "P1", 20);
        PlatRegulier p1 = plat1.getResultatRegulier();

        // Ajout des plats au menu
        mainMenu.ajoute(p1);

        mainMenu.getPlatInfo(-2);
        mainMenu.getPlatInfo(10);
    }

    @Test
    public void ajoute() {
        // Creation menu
        Menu mainMenu = new Menu("Menu Principale");
        // Creation des plats
        PlatsBuilder plat1 = new PlatsBuilder();
        mainMenu.buildPlatRegulier(plat1, 0, "P1", 20);

        PlatsBuilder plat2 = new PlatsBuilder();
        mainMenu.buildPlatEnfant(plat2, 1, "P2", 15, 25);

        PlatRegulier p1 = plat1.getResultatRegulier();
        PlatEnfant p2 = plat2.getResultatEnfant();

        assertEquals(0, mainMenu.getPlats().size());
        mainMenu.ajoute(p1);
        assertEquals(1, mainMenu.getPlats().size());
        mainMenu.ajoute(p2);
        assertEquals(2, mainMenu.getPlats().size());
    }
}