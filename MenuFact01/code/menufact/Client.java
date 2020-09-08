package menufact;

/**
 * Classe qui fait la gestion du client
 * @author J. LaFerrière, É. Marchal
 * @version 2.0
 */

public class Client {
    private int idClient;
    private String nom;
    private String numeroCarteCredit;

    /**
     * Constructeur par paramètre
     * @param idClient valeur entière indiquant l'ID du client
     * @param nom chaîne de caractère avec le nom du client
     * @param numeroCarteCredit chaîne de caractère avec le numéro de la carte de crédit
     */
    public Client(int idClient, String nom, String numeroCarteCredit) {
        this.idClient = idClient;
        this.nom = nom;
        this.numeroCarteCredit = numeroCarteCredit;
    }

    // Méthode d'accès et de modification de l'ID du client
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    // Méthode d'accès et de modification du nom
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode d'accès et de modification du numéro de la carte de crédit
    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }
    public void setNumeroCarteCredit(String numeroCarteCredit) {
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * @return les information du client en chaîne de caractère
     */
    @Override
    public String toString() {
        return "menufact.Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", numeroCarteCredit='" + numeroCarteCredit + '\'' +
                '}';
    }
}
/*
@startuml
class menufact.Client{}
* */