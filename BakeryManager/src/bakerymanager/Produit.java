package bakerymanager;

import java.util.HashMap;

/**
 *
 * @author Nicolas
 */
//Classe Produit, mais j'ai pas voulu modifié ton taff 
public class Produit {
    private int idProduit;
    public static int compteurProd = 0;
    private String nomProd;
    private float prix;
    private int qte;
    private HashMap<Ingredient,Integer> recette; // Comment créer le produit ? Ingredient + quantité
    
    public Produit (String nomProd, float prix, int qte){
        compteurProd ++;
        this.idProduit = compteurProd;
        this.nomProd = nomProd;
        this.prix=prix;
        this.qte=qte;
    }

    Produit(int aInt, String string, float aFloat, int aInt0) {
        this.idProduit = aInt;
        this.nomProd = string;
        this.prix = aFloat;
        this.qte = aInt0;
    }
    
    @Override
    public String toString () {
        return idProduit+": "+nomProd+"("+qte+") ->"+prix;
    }

    public String getCreationQuery() {
        return "INSERT INTO PRODUIT VALUES("+this.getId()+",'"+this.nomProd+"',"+this.prix+","+this.qte+");";
    }
    
    public int getId() {
        return this.idProduit;
    }

    int getQuantite() {
        return this.qte;
    }
}
