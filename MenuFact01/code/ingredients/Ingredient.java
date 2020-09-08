package ingredients;

import ingredients.exceptions.IngredientException;

public class Ingredient {

    private String nom;
    private String description;
    private double quantite;
    private TypeIngredient typeIngredient;
    private EtatIngredient etatIngredient;

    public Ingredient(String inNom, String inDescription, double qnt, TypeIngredient type, EtatIngredient etat)
    {this.nom = inNom; this.description = inDescription; this.quantite = qnt; this.typeIngredient = type;
     this.etatIngredient = etat;}

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double qnt) throws IngredientException {
        if (qnt < 0) {
            throw new IngredientException("Il n'est pas possible d'avoir une quantite negative");
        }
        else {
            this.quantite = qnt;
        }
    }

    public TypeIngredient getTypeIngredient() { return typeIngredient; }
    public void setTypeIngredient(TypeIngredient type) throws IngredientException {
        if (!typeIngredient.equals(type)) {
            throw new IngredientException("Type incompatible d'ingredients");
        } else {
            this.typeIngredient = type;
        }
    }

    public EtatIngredient getEtatIngredient() { return etatIngredient; }
    public void setEtatIngredient(EtatIngredient etat) throws IngredientException {
        if (!typeIngredient.equals(etat)) {
            throw new IngredientException("Type incompatible d'ingredients");
        } else {
            this.etatIngredient = etat;
        }
    }

    @Override
    public String toString() {
        return  "Type Ingredient : " + typeIngredient +
                " ; Nom : " + nom +
                " ; Description : " + description +
                " ; Quantite : " + quantite + " " + etatIngredient;
    }
}
