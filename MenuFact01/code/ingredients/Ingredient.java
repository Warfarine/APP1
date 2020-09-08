package ingredients;

import ingredients.exceptions.IngredientException;
import menufact.facture.exceptions.FactureException;

/**
 * La classe des ingrédients du système MenuFact
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class Ingredient {

    private String nom;
    private String description;
    private double quantite;
    private TypeIngredient typeIngredient;
    private EtatIngredient etatIngredient;

    // Constructeur par paramètre
    public Ingredient(String inNom, String inDescription, double qnt, TypeIngredient type, EtatIngredient etat)
    {this.nom = inNom; this.description = inDescription; this.quantite = qnt; this.typeIngredient = type;
     this.etatIngredient = etat;}

     // Méthodes d'accès et de modification du nom
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthodes d'accès et de modification de la description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // Méthodes d'accès et de modification du type d'ingrédients
    public TypeIngredient getTypeIngredient() { return typeIngredient; }
    public void setTypeIngredient(TypeIngredient type) { this.typeIngredient = type; }

    // Méthodes d'accès et de modification du type d'état
    public EtatIngredient getEtatIngredient() { return etatIngredient; }
    public void setEtatIngredient(EtatIngredient etat)  { this.etatIngredient = etat; }

    // Méthode d'accès de pour la quantité
    public double getQuantite() {
        return quantite;
    }

    /**
     * Méthode pour rajouter un plat choisi à la facture
     * @param qnt quantité à modifier
     * @throws IngredientException Seulement si la quantité passée en paramètre est négative
     */
    public void setQuantite(double qnt) throws IngredientException {
        // Vérifier si la quantité est négative
        if (qnt < 0) {
            throw new IngredientException("Il n'est pas possible d'avoir une quantité négative");
        }
        else {
            this.quantite = qnt;
        }
    }

    /**
     * @return les informations d'un ingrédient en chaîne de caractères
     */
    @Override
    public String toString() {
        return  "Type Ingredient : " + typeIngredient +
                " ; Nom : " + nom +
                " ; Description : " + description +
                " ; Quantité : " + quantite + " " + etatIngredient;
    }
}