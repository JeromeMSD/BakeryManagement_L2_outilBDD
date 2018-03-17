package bakerymanager;

import java.util.HashMap;

/**
 *
 * @author Nicolas
 */
//Classe Produit, mais j'ai pas voulu modifié ton taff 
public class Produit {
    private int idProduit;
    private static int compteurProd = 0;
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
    
    @Override
    public String toString () {
        return idProduit+": "+nomProd+"->"+prix;
    }
}
