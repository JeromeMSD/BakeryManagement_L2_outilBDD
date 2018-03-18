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
    

    Ingredient(int aInt, String string, int aInt0) {
        this.idIngredient = aInt;
        this.nomIngredient = string;
        this.qte = aInt0;
    }

    Ingredient(String text, int parseInt) {
        compteurIng++;
        this.idIngredient = compteurIng;
        this.nomIngredient = text;
        this.qte = parseInt;
    }

    public int getId(){
        return idIngredient;
    }
    
    @Override
    public String toString(){
        return this.getId()+": "+this.nomIngredient+"->"+this.qte;
    }
    
    String getCreationQuery() {
        return "INSERT INTO INGREDIENT VALUES("+this.getId()+",'"+this.nomIngredient+"',"+this.qte+");";
    }
}
