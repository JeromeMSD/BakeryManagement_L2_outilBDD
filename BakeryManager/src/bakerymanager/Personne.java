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
public class Personne{
    private int idPersonne; //On ne peux pas utiliser ca reviens à zero apres chaque redémarage de l'app
    public static int compteurPers = 0;
    private String nomPersonne;
    private int telPersonne;
    protected Adresse adresse;
    
    public Personne (String nomPersonne, int telPersonne, Adresse adresse){
        compteurPers ++; // Nb de personnes instanciées
        this.idPersonne = compteurPers; // Attribue un ID en fonction du nombre de personne instanciées au moment de l'initialisation;
        this.nomPersonne = nomPersonne;
        this.telPersonne = telPersonne;
        this.adresse = adresse;
    }

    public Personne(int id, String nom, int tel,Adresse adr) {
        this.idPersonne = id;
        this.nomPersonne = nom;
        this.telPersonne = tel;
        this.adresse = adr;
    }
    
    public String getNomPersonne(){
        return this.nomPersonne;
    }
    
    public int getTelPersonne(){
        return this.telPersonne;
    }
    
    public int getId(){
        return this.idPersonne;
    }
    
    @Override
    public String toString () {
        return this.idPersonne+": "+this.nomPersonne+"->"+this.telPersonne+" Adresse: "+this.adresse.toString();
    }
    
    public String getCreationQuery() {
        return "INSERT INTO PERSONNE VALUES("+this.getId()+",'"+this.getNomPersonne()+"',"+this.getTelPersonne()+","+this.adresse.getReferenceQuery()+");";
    }
}
