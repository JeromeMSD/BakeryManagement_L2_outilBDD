/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javafx.scene.control.DatePicker;
import javafx.util.converter.DateTimeStringConverter;

/**
 *
 * @author Nicolas
 */
public class Commande {
    public static int compteurCom = 0;
    private int idCommande;
    private int personne;
    private Date date;
    private float prixTotal=0;
    private DateTimeStringConverter format = new DateTimeStringConverter(Locale.FRANCE,"YYYY-MM-dd");
    private HashMap<Produit,Integer> commande;
    
    public Commande(Date d,HashMap<Produit, Integer> commande){
        compteurCom++;
        this.idCommande = compteurCom;
        this.date=d;
        this.commande=commande;
        /* Doit parcourir la commande(liste d'ingredient + prix) pour en calculer son prix total pour l'instancier */
    }

    public Commande(int aInt, Date fromString, float aFloat) {
        this.idCommande = aInt;
        this.date = fromString;
        this.prixTotal = aFloat;
    }

    Commande(Date fromString, int text) {
        compteurCom++;
        this.idCommande = compteurCom;
        this.date = fromString;
        this.personne = text;
    }
    
    
    
    @Override
    public String toString () {
        return idCommande+": "+date+"->"+prixTotal;
    }

    String getCreationQuery() {
        return "INSERT INTO COMMANDE VALUES("+this.idCommande+","+this.personne+",'"+format.toString(this.date)+"',"+this.prixTotal+");";
    }

    int getId() {
       return idCommande;
    }
    
}
