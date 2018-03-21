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

    public Commande(int idCommande, String date, float prixTotal) {
        this.idCommande = idCommande;
        this.date = date;
        this.prixTotal = prixTotal;
    }

    public Commande(String date, int idPersonne) {
        compteurCom++;
        this.idCommande = compteurCom;
        this.date = date;
        this.personne = idPersonne;
    }
    
    public void setPrixTotal(float newTotal){
        this.prixTotal = newTotal;
    }
    
    @Override
    public String toString () {
        return this.idCommande+": "+this.date+"->"+this.prixTotal;
    }

    public String getCreationQuery() {
        return "INSERT INTO COMMANDE VALUES("+this.idCommande+","+this.personne+",'"+this.date+"',"+this.prixTotal+");";
    }

    int getId() {
       return this.idCommande;
    }
    
}
