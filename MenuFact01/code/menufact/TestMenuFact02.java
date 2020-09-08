package menufact;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.SingletonInventaire;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import menufact.EtatPlats.Chef;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.iterateur.Iterateur;
import menufact.iterateur.IterateurF;
import menufact.iterateur.ListePlatsFacture;
import menufact.iterateur.ListePlatsMenu;
import menufact.plats.*;

public class TestMenuFact02 {
    public static void main(String[] args) throws IngredientException, FactureException {
        boolean trace = true;
        TestMenuFact02 t = new TestMenuFact02();

        /////////////////////////////////////// CREATION DE L'INVENTAIRE D'INGREDIENTS ////////////////////////////////
        Ingredient i1 = new Ingredient("pomme", "rouge", 50, TypeIngredient.FRUIT, EtatIngredient.UNITES);
        Ingredient i2 = new Ingredient("brocoli", "bio", 10, TypeIngredient.LEGUME, EtatIngredient.UNITES);
        Ingredient i3 = new Ingredient("lait", "de vache", 1000, TypeIngredient.LAITIER, EtatIngredient.millilitre);
        Ingredient i4 = new Ingredient("fromage", "cheddar", 500, TypeIngredient.LAITIER, EtatIngredient.grammes);
        Ingredient i5 = new Ingredient("boeuf", "moo moo", 700, TypeIngredient.VIANDE, EtatIngredient.grammes);
        Ingredient i6 = new Ingredient("poivre", "noir", 30, TypeIngredient.EPICE, EtatIngredient.millilitre);

        // Creation inventaire et ajout des ingredients
        SingletonInventaire inventaire = SingletonInventaire.getInstance();
        inventaire.contenu.add(i1);
        inventaire.contenu.add(i2);
        inventaire.contenu.add(i3);
        inventaire.contenu.add(i4);
        inventaire.contenu.add(i5);
        inventaire.contenu.add(i6);

        t.test1_AffichageInventaire(trace, inventaire);

        // Ajout d'un autre ingredient
        inventaire.contenu.add(new Ingredient("poisson", "saumon", 500, TypeIngredient.VIANDE, EtatIngredient.grammes));
        t.test1_AffichageInventaire(trace, inventaire);

        // Retirer la quantite d'un ingredient
        try {
            inventaire.modifierQnt("pomme", 10, EtatIngredient.UNITES);
        } catch (IngredientException e)
        {System.out.println(e);}
        t.test1_AffichageInventaire(trace, inventaire);

        //////////////////////////////////////////// CREATION DU MENU //////////////////////////////////////////////////
        // Creation Menu
        Menu mainMenu = new Menu("Test menu");

        // Creation des plats
        // Plat regulier
        PlatsBuilder plat1 = new PlatsBuilder();
        mainMenu.buildPlatRegulier(plat1, 0, "P1", 20);

        // Plat Enfant
        PlatsBuilder plat2 = new PlatsBuilder();
        mainMenu.buildPlatEnfant(plat2, 1, "P2", 15, 25);

        // Plat Sante
        PlatsBuilder plat3 = new PlatsBuilder();
        mainMenu.buildPlatSante(plat3, 2, "P3", 20, 350, 2, 5);

        PlatRegulier p1 = plat1.getResultatRegulier();
        PlatEnfant p2 = plat2.getResultatEnfant();
        PlatSante p3 = plat3.getResultatSante();

        // Ajout des ingredients aux plats crees
        // Ajout d'un ingredient qui n'est pas dans le bon format
        try {
            p1.setListIngredients("pomme", "red", 10, TypeIngredient.FRUIT, EtatIngredient.millilitre, inventaire);
        } catch (IngredientException e) {
            System.out.println(e);
        }

        // Ajout d'un ingredient qui n'existe pas dans l'inventaire
        try {
            p1.setListIngredients("banane", "jaune", 10, TypeIngredient.FRUIT, EtatIngredient.UNITES, inventaire);
        } catch (IngredientException e) {
            System.out.println(e);
        }

        // Ajout d'un ingredient en quantite trop grande
        try {
            p1.setListIngredients("pomme", "rouge", 100, TypeIngredient.FRUIT, EtatIngredient.UNITES, inventaire);
        } catch (IngredientException e) {
            System.out.println(e);
        }

        // Ajout correct des ingredients
        // Plat 1
        p1.setListIngredients("brocoli", "bio", 1, TypeIngredient.LEGUME, EtatIngredient.UNITES, inventaire);
        p1.setListIngredients("boeuf", "moo moo", 100, TypeIngredient.VIANDE, EtatIngredient.grammes, inventaire);
        p1.setListIngredients("fromage", "cheddar", 20, TypeIngredient.LAITIER, EtatIngredient.grammes, inventaire);
        p1.setListIngredients("poivre", "noir", 2, TypeIngredient.EPICE, EtatIngredient.millilitre, inventaire);

        // Plat 2
        p2.setListIngredients("brocoli", "bio", 1, TypeIngredient.LEGUME, EtatIngredient.UNITES, inventaire);
        p2.setListIngredients("boeuf", "moo moo", 75, TypeIngredient.VIANDE, EtatIngredient.grammes, inventaire);
        p2.setListIngredients("fromage", "cheddar", 15, TypeIngredient.LAITIER, EtatIngredient.grammes, inventaire);
        p2.setListIngredients("lait", "moo moo", 150, TypeIngredient.LAITIER, EtatIngredient.millilitre, inventaire);

        // Plat 3
        p3.setListIngredients("pomme", "rouge", 2, TypeIngredient.FRUIT, EtatIngredient.UNITES, inventaire);
        p3.setListIngredients("brocoli", "bio", 1, TypeIngredient.LEGUME, EtatIngredient.UNITES, inventaire);

        // Ajout des plats au menu
        mainMenu.ajoute(p1);
        mainMenu.ajoute(p2);
        mainMenu.ajoute(p3);

        t.test2_AffichageMenu(trace, mainMenu);

        // Affichage d'un plat selon le code
        // Code errone
        try {
            t.test3_AffichagePlat(trace, mainMenu, 5);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // Code correct
        try {
            t.test3_AffichagePlat(trace, mainMenu, 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // Creation de l'iterateur pour les plats au menu
        ListePlatsMenu listMenu = new ListePlatsMenu(mainMenu.getPlats());
        Iterateur itr = listMenu.creerIterateurMenu();

        // Plat 0
        try {
            t.test4_TestIterateur(trace, itr.itemCourant());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // Plat 1
        try {
            t.test4_TestIterateur(trace, itr.suivant());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // Plat 0
        try {
            t.test4_TestIterateur(trace, itr.precedent());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // Plat 1
        System.out.println();
        try {
            t.test4_TestIterateur(trace, itr.suivant());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // Plat 2
        try {
            t.test4_TestIterateur(trace, itr.suivant());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        // Plat inexistant
        try {
            t.test4_TestIterateur(trace, itr.suivant());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        //////////////////////////////////////////// CREATION DE LA FACTURE /////////////////////////////////////////////
        // Selection des plats et ajout a la facture - p1 = plat regulier, p2 = plat enfant, p3 = plat sante
        PlatChoisi pc1 = new PlatChoisi(p1, 2, inventaire);
        PlatChoisi pc2 = new PlatChoisi(p2, 30, inventaire);
        PlatChoisi pc3 = new PlatChoisi(p3, 1, inventaire);

        // Verifier si les plats sont valides et si ils peuvent etre faits dans la quantite demandee
        // Essais si les ingredients ne sont pas suffisants
        try {
            t.test5_TestChoixPlats(trace, pc2);
        } catch (IngredientException | MenuException e) {
            System.out.println(e);
        }

        // Verification valide
        try {
            t.test5_TestChoixPlats(trace, pc1);
            t.test5_TestChoixPlats(trace, pc3);
        } catch (IngredientException | MenuException e) {
            System.out.println(e);
        }

        // Montrer l'etat de l'inventaire
        t.test1_AffichageInventaire(trace,inventaire);

        // Creation d'une facture
        Facture facture = new Facture("Ma Facture");

        // Ajout des plats choisi a la facture
        facture.ajoutePlat(0, 2, mainMenu);
        facture.ajoutePlat(2, 1, mainMenu);

        t.test_6AffichageFacture(trace,facture);

        // Creation de l'iterateur pour les plats de la facture
        ListePlatsFacture listFacture = new ListePlatsFacture(facture.getPlats());
        IterateurF itrf = listFacture.creerIterateurFacture();

        // Plat 0
        t.test7_TestIterateurFacture(trace, itrf.itemCourant());
        // Plat 1
        t.test7_TestIterateurFacture(trace, itrf.suivant());

        // Modification de la quantite d'un plat de la facture
        itrf.itemCourant().setQuantite(3);
        try {
            t.test5_TestChoixPlats(trace, pc3);
        } catch (IngredientException | MenuException e) {
            System.out.println(e);
        }
        t.test_6AffichageFacture(trace, facture);

        // Ajout et retrait d'un plat
        PlatChoisi pc = new PlatChoisi(p2, 1, inventaire);
        facture.ajoutePlat(1, 1, mainMenu);
        t.test_6AffichageFacture(trace, facture);
        facture.retirerPlat(itrf.suivant());
        t.test_6AffichageFacture(trace, facture);

        // Ajustement des etats de la facture
        facture.fermer();
        t.test_6AffichageFacture(trace, facture);

        facture.payer();
        System.out.println("\n" + facture.genererFacture());

        //////////////////////////////////////////// TESTS AVEC LE CHEF ////////////////////////////////////////////////
    }

    private void test1_AffichageInventaire(boolean trace, SingletonInventaire inventaire) {
        System.out.println("=== Test 1: Affichage Inventaire ===" + "\n");
        if (trace)
        {
            System.out.println(inventaire.contenu.toString() + "\n");
        }
    }

    private void test2_AffichageMenu(boolean trace, Menu menu) {
        System.out.println("\n" + "=== Test 2: Affichage Menu ===" + "\n");
        if (trace)
        {
           menu.afficherMenu();
        }
    }

    private void test3_AffichagePlat(boolean trace, Menu menu, int code) {
        System.out.println("\n" + "=== Test 3: Affichage Menu Plat Singulier ===" + "\n");
        if (trace)
        {
            System.out.println(menu.getPlatInfo(code));
        }

    }

    private void test4_TestIterateur(boolean trace, PlatAuMenu plat) {
        System.out.println("\n" + "=== Test 4: Test Iterateur ===" + "\n");
        if (trace)
        {
            if (trace)
            {
                System.out.println(plat);
            }
        }
    }

    private void test5_TestChoixPlats(boolean trace, PlatChoisi plat) throws IngredientException, MenuException {
        System.out.println("\n" + "=== Test 5: Test Ajout Plats Facture ===" + "\n");
        if (trace) {
            plat.confirmerPlat();
        }
    }

    private void test_6AffichageFacture(boolean trace, Facture facture) {
        System.out.println("\n" + "=== Test 6: Affichage Facture ===" + "\n");
        if (trace) {
            facture.afficherFacture();
        }
    }

    private void test7_TestIterateurFacture(boolean trace, PlatChoisi plat) {
        System.out.println("\n" + "=== Test 7: Test Iterateur Facture ===" + "\n");
        if (trace)
        {
            System.out.println(plat);
        }
    }
}
