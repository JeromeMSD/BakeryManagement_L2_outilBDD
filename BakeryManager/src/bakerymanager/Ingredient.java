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
public class Ingredient {
    private int idIngredient;
    public static int compteurIng = 0;
    private String nomIngredient;
    private int qte;
    

    public Ingredient(int idIngredient, String nomIngredient, int qteIngredient) {
        this.idIngredient = idIngredient;
        this.nomIngredient = nomIngredient;
        this.qte = qteIngredient;
    }

    public Ingredient(String nomIngredient, int qteIngredient) {
        compteurIng++;
        this.idIngredient = compteurIng;
        this.nomIngredient = nomIngredient;
        this.qte = qteIngredient;
    }

    public int getId(){
        return this.idIngredient;
    }
    
    @Override
    public String toString(){
        return this.getId()+": "+this.nomIngredient+"->"+this.qte;
    }
    
    public String getCreationQuery() {
        return "INSERT INTO INGREDIENT VALUES("+this.getId()+",'"+this.nomIngredient+"',"+this.qte+");";
    }
}
