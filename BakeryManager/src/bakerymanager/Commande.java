/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Nicolas
 */
public class Commande {
    private static int compteurCom = 0;
    private int idCommande;
    private Date date;
    private float prixTotal=0;
    private HashMap<Resultat,Integer> commande;
    
    public Commande(Date d,HashMap<Resultat, Integer> commande){
        compteurCom ++;
        this.idCommande = compteurCom;
        this.date=d;
        this.commande=commande;
        /* Doit parcourir la commande(liste d'ingredient + prix) pour en calculer son prix total pour l'instancier */
        
    }
    
}
