package menufact.facture;

import menufact.Client;
import menufact.facture.exceptions.FactureException;
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
    public Facture( String description) {
        date = new Date();
        etat = FactureEtat.OUVERTE;
        this.description = description;
    }

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
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException
    {
        if (etat == FactureEtat.OUVERTE) {
            if (p.getEtat()) {
                platchoisi.add(p);
            }
            else
                throw new FactureException("Le plat choisi est invalide");
        }
        else
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
    }

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
     *
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    private double tps(){
        return TPS*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return TVQ*(TPS+1)*sousTotal();
    }

    public void payer()
    {
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
        if (etat == FactureEtat.PAYEE)
            throw new FactureException("La facture ne peut pas être reouverte.");
        else
            etat = FactureEtat.OUVERTE;
    }

    /**
     *
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
        for (int i = 0; i < platchoisi.size(); i++) {
            System.out.println(platchoisi.get(i).toString() + " Etat Facture: " + etat);
        }
    }

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture()
    {
        String lesPlats = new String();
        String factureGenere = new String();

        int i = 1;


        factureGenere =   "Facture generee.\n" +
                          "Date:" + date + "\n" +
                          "Description: " + description + "\n" +
                          "Client:" + client.getNom() + "\n" +
                          "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : platchoisi)
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + tps() + "\n";
        factureGenere += "          TVQ:               " + tvq() + "\n";
        factureGenere += "          Le total est de:   " + total() + "\n";

        return factureGenere;
    }
}