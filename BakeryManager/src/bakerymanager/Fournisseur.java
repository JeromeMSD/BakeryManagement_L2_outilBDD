/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

/**
 *
 * @author romain
 */
public class Fournisseur extends Personne{

    
    public Fournisseur(String nomPersonne, int telPersonne, Adresse adresse){
        super(nomPersonne, telPersonne, adresse);
    }
    
    public Fournisseur(int idPersonne, String nomPersonne, int telPersonne,Adresse adr){
        super(idPersonne, nomPersonne, telPersonne, adr);
    }

    @Override
    public String getCreationQuery() {
        return "INSERT INTO FOURNISSEUR VALUES("+this.getId()+",'"+this.getNomPersonne()+"',"+this.getTelPersonne()+","+this.adresse.getReferenceQuery()+");";
    }
}

