package menufact;

import ingredients.EtatIngredient;
import ingredients.Ingredient;
import ingredients.SingletonInventaire;
import ingredients.TypeIngredient;
import ingredients.exceptions.IngredientException;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.iterateur.Iterateur;
import menufact.iterateur.IterateurF;
import menufact.iterateur.ListePlatsFacture;
import menufact.iterateur.ListePlatsMenu;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.TypePlats;

import java.util.Date;

public class TestFACTURE {
    public static void main(String[] args) throws IngredientException, MenuException, FactureException {

        // Creation de l'inventaire des ingredient
        SingletonInventaire inventaire = SingletonInventaire.getInstance();
        Ingredient i1 = new Ingredient("pomme", "red", 20, TypeIngredient.FRUIT, EtatIngredient.UNITES);
        Ingredient i2 = new Ingredient("carotte", "fresh", 30, TypeIngredient.LEGUME, EtatIngredient.UNITES);
        Ingredient i3 = new Ingredient("broco", "green", 10, TypeIngredient.LEGUME, EtatIngredient.UNITES);
        Ingredient i4 = new Ingredient("milk", "cows", 1000, TypeIngredient.LAITIER, EtatIngredient.millilitre);
        Ingredient i5 = new Ingredient("cheese", "old", 1000, TypeIngredient.LAITIER, EtatIngredient.grammes);
        Ingredient i6 = new Ingredient("beef", "joocy", 700, TypeIngredient.VIANDE, EtatIngredient.grammes);
        Ingredient i7 = new Ingredient("pepper", "black", 30, TypeIngredient.EPICE, EtatIngredient.millilitre);

        inventaire.contenu.add(i1);
        inventaire.contenu.add(i2);
        inventaire.contenu.add(i3);
        inventaire.contenu.add(i4);
        inventaire.contenu.add(i5);
        inventaire.contenu.add(i6);
        inventaire.contenu.add(i7);

        // creation Plats
        PlatAuMenu p1 = new PlatAuMenu(TypePlats.REGULIER, 0, "P1", 20);
        PlatAuMenu p2 = new PlatAuMenu(TypePlats.REGULIER, 2, "P3", 15);

        try {
            p1.setListIngredients("pomme", "red", 1, TypeIngredient.FRUIT, EtatIngredient.UNITES, inventaire);
            p1.setListIngredients("pepper", "black", 1, TypeIngredient.EPICE, EtatIngredient.millilitre, inventaire);
            p1.setListIngredients("beef", "joocy", 100, TypeIngredient.VIANDE, EtatIngredient.grammes, inventaire);

            p2.setListIngredients("beef", "joocy", 50, TypeIngredient.VIANDE, EtatIngredient.grammes, inventaire);
            p2.setListIngredients("cheese", "old", 240, TypeIngredient.LAITIER, EtatIngredient.grammes, inventaire);
        } catch (IngredientException e) {
            System.out.println(e);
        }

        PlatChoisi pc1 = new PlatChoisi(p1, 2, inventaire);
        PlatChoisi pc2 = new PlatChoisi(p2, 1, inventaire);

        // ajout ingredients au plats
        try {
            pc1.confirmerPlat();
            pc2.confirmerPlat();
        } catch (IngredientException | MenuException e) {
            System.out.println(e);
        }

        //System.out.println(inventaire.contenu);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Creation facture
        Facture facture = new Facture("Ma Facture");
        try {
            facture.ajoutePlat(pc1);
            facture.ajoutePlat(pc2);
        } catch (FactureException e) {
            System.out.println(e);
        }

        // Creation de l'iterateur pour les plats de la facture
        ListePlatsFacture listFacture = new ListePlatsFacture(facture.getPlats());
        IterateurF itr = listFacture.creerIterateurFacture();

        facture.afficherFacture();

    }
}
