/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

/**
 *
 * @author Nicolas
 */
public class Commande {
    public static int compteurCom = 0;
    private int idCommande;
    private int personne;
    private String date;
    private float prixTotal=0;

    public Commande(int aInt, String fromString, float aFloat) {
        this.idCommande = aInt;
        this.date = fromString;
        this.prixTotal = aFloat;
    }

    Commande(String fromString, int text) {
        compteurCom++;
        this.idCommande = compteurCom;
        this.date = fromString;
        this.personne = text;
    }
    
    public void setPrixTotal(float f){
        this.prixTotal = f;
    }
    
    @Override
    public String toString () {
        return idCommande+": "+date+"->"+prixTotal;
    }

    String getCreationQuery() {
        return "INSERT INTO COMMANDE VALUES("+this.idCommande+","+this.personne+",'"+this.date+"',"+this.prixTotal+");";
    }

    int getId() {
       return idCommande;
    }
    
}
