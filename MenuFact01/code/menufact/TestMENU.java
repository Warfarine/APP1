package menufact;

        import ingredients.Ingredient;
        import ingredients.TypeIngredient;
        import menufact.iterateur.Iterateur;
        import menufact.iterateur.ListePlatsMenu;
        import menufact.plats.*;
        import java.util.ArrayList;

public class TestMENU {
    public static void main(String[] args) {
        // Creation Menu
        Menu mainMenu = new Menu("Test menu");

        // Creation des plats
        PlatsBuilder plat1 = new PlatsBuilder();
        mainMenu.buildPlatRegulier(plat1, 0, "P1", 20);

        PlatsBuilder plat2 = new PlatsBuilder();
        mainMenu.buildPlatEnfant(plat2, 1, "P2", 15, 25);

        PlatsBuilder plat3 = new PlatsBuilder();
        mainMenu.buildPlatSante(plat3, 2, "P3", 20, 200, 10, 5);

        PlatRegulier p1 = plat1.getResultatRegulier();
        PlatEnfant p2 = plat2.getResultatEnfant();
        PlatSante p3 = plat3.getResultatSante();

        // Ajout des plats au menu
        mainMenu.ajoute(p1); mainMenu.ajoute(p2); mainMenu.ajoute(p3);

        // Creation de l'iterateur pour les plats au menu
        ListePlatsMenu listMenu = new ListePlatsMenu(mainMenu.getPlats());
        Iterateur itr = listMenu.creerIterateurMenu();

        // Test 1
        System.out.println("\nTEST AFFICHAGE MENU\n");
        mainMenu.afficherMenu();

        // Test 2
        System.out.println("\nTEST AFFICHAGE PLAT INDIVIDUEL\n");
        try {
            System.out.println(mainMenu.getPlatInfo(0));
            System.out.println(mainMenu.getPlatInfo(5));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // Test 3
        System.out.println("\nTEST ITERATION DES PLATS DANS LE MENU\n");
        try {
            System.out.println(itr.itemCourant());
            System.out.println(itr.suivant());
            System.out.println(itr.precedent());
            System.out.println(itr.suivant());
            System.out.println(itr.suivant());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}