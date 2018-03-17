/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.util.HashMap;

/**
 *
 * @author romain
 */
public class Fournisseur extends Personne{

    
    public Fournisseur(String nomPersonne, int telPersonne, Adresse adresse){
        super(nomPersonne, telPersonne, adresse);
    }
    
    public Fournisseur(int idPersonne, String nomPersonne, int telPersonne){
        super(idPersonne, nomPersonne, telPersonne);
    }
          
    public void Livrer (HashMap <Ingredient,Integer> livraison){
        // Association ingrédient / Quantité
    }
    
    @Override
    public String getCreationQuery() {
        return "INSERT INTO FOURNISSEUR VALUES("+this.getId()+",'"+this.getNomPersonne()+"',"+this.getTelPersonne()+");";
    }
}

