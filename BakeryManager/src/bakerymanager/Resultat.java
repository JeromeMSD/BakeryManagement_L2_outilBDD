/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bakerymanager;

import java.util.HashMap;

/**
 *
 * @author Nicolas
 */
//Classe Produit, mais j'ai pas voulu modifié ton taff 
public class Resultat {
    private int idProduit;
    private static int compteurProd = 0;
    private String nomProd;
    private float prix;
    private int qte;
    private HashMap<Ingredient,Integer> recette; // Comment créer le produit ? Ingredient + quantité
    
    public Resultat (String nomProd, float prix, int qte){
        compteurProd ++;
        this.idProduit = compteurProd;
        this.nomProd = nomProd;
        this.prix=prix;
        this.qte=qte;
    }
}
