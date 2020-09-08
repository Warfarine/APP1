package menufact.facture;

import menufact.Client;
import menufact.Menu;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact
 * @author Domingo Palao Munoz
 * @version 1.0
 */
public class Facture {
    private Date date;
    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private Client client;

    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;
    /*********************************************/

    /**
     * Constructeur par paramètre
     * @param description la description de la facture
     */
    public Facture(String description) {
        date = new Date();
        etat = FactureEtat.OUVERTE;
        this.description = description;
    }

    /**
     * Méthode pour accéder la description de la facture
     * @return la description de la facture
     */
    public String getDescription() {
        return description;
    }

    /**
     * Méthode pour accéder les information du client de la facture
     * @return le client associe a la facture
     */
    public Client getClient() { return client; }

    /**
     * Méthode pour accéder l'état de la facture
     * @return l'état courant de la facture
     */
    public FactureEtat getEtat() {
        return etat;
    }

    /**
     * Méthode pour accéder la liste des plats choisi de la facture
     * @return les plats choisis
     */
    public ArrayList<PlatChoisi> getPlats() {
        return platchoisi;
    }

    /**
     * Méthode pour rajouter un plat choisi à la facture
     * @param code le code du plat au menu
     * @param quantite la quantite de plats commandés
     * @param menu le menu d'ou provient les plats
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(int code, double quantite, Menu menu) throws FactureException
    {
        // Vérifier l'état de la facture
        if (etat == FactureEtat.OUVERTE) {
            PlatAuMenu plat = menu.getPlatSingulier(code);
            PlatChoisi pc = new PlatChoisi(plat, quantite);
            platchoisi.add(pc);
            }
        else
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

    /**
     * Méthode pour retirer un plat choisi à la facture
     * @param plat le plat choisi a retirer de la facture
     */
    public void retirerPlat(PlatChoisi plat) {
        platchoisi.remove(plat);
    };

    /**
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        this.client = client;
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        double soustotal=0;
         for (PlatChoisi p : platchoisi)
             soustotal += p.getQuantite() * p.getPlat().getPrix();
        return soustotal;
    }

    /**
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     * @return la valeur de la TPS
     */
    private double tps(){
        return TPS*sousTotal();
    }

    /**
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return TVQ*(TPS+1)*sousTotal();
    }

    public void payer() throws FactureException {
        // Vérifier l'état de la facture
        if (etat == FactureEtat.OUVERTE)
        {
            throw new FactureException("La facture doit etre a l'etat fermee");
        }
        else
            etat = FactureEtat.PAYEE;
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer()
    {
        etat = FactureEtat.FERMEE;
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException
    {
        // Vérifier l'état de la facture
        if (etat == FactureEtat.PAYEE)
            throw new FactureException("La facture ne peut pas être reouverte.");
        else
            etat = FactureEtat.OUVERTE;
    }

    /**
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        return "Facture : " +
                "Date : "  + date +
                ", Description: '" + description + '\'' +
                ", Etat : "  + etat +
                ", Platchoisi :"  + platchoisi +
                ", Client "  + client +
                ", TPS : "  + TPS +
                ", TVQ : " + TVQ +
                '}';
    }

    /**
     * Méthode pour afficher la facture
     */
    public void afficherFacture() {

        // État ouverte
        if (etat == FactureEtat.OUVERTE)
        {
            for (int i = 0; i < platchoisi.size(); i++) {
                System.out.println(platchoisi.get(i).toString());
            }
        }

        // État fermée
        else if (etat == FactureEtat.FERMEE) {
            for (int i = 0; i < platchoisi.size(); i++) {
                System.out.println(platchoisi.get(i).toString());
            }
        }
        // État payée
        System.out.println("Sous-totale : " + sousTotal() + " $" +
                           ", Total: " + total() + " $" +
                           "\nEtat Facture: " + etat);
    }

    /**
     * Méthode pour générer et imprimer une facture
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture()
    {
        String lesPlats = new String();
        String factureGenere = new String();

        int i = 1;
        factureGenere =   "Facture generee \n" +
                          "Date:" + date + "\n" +
                          "Description: " + description + "\n" +
                          //"Client:" + client.getNom() + "\n" +
                          "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : platchoisi)
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "           " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }
        factureGenere += "\n" + "          Le sous-total est de: " + sousTotal() + "\n";
        factureGenere += "          TPS:               " + tps() + "\n";
        factureGenere += "          TVQ:               " + tvq() + "\n";
        factureGenere += "          Le total est de:   " + total() + "\n";

        return factureGenere;
    }
}