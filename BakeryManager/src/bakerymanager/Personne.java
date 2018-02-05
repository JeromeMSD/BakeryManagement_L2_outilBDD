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
public class Personne extends ObjectE{
    private static int genID = 0;
    private int numPers = 0;
    private String nom;
    private String prenom;
    private String libRue;
    private SecteurGeographique secteur;
    
    public int getNumPers(){
        return numPers;
    }
    
    public String getNom(){
        return nom;
    }
    
    public String getPrenom(){
        return prenom;
    }
    
    public String getLibRue(){
        return libRue;
    }
    
    @Override
    public String getSecteurGeographique(){
        return secteur.toString();
    }
        
    public Personne (String nom, String prenom, String libRue, SecteurGeographique secteur){
        this.nom = nom;
        this.prenom = prenom;
        this.libRue = libRue;
        this.secteur = secteur;
        genID=genID+1;
        this.numPers=genID;    
    }
    
    @Override
    public String toSave(){
        return this.getNom()+";"+this.getPrenom()+";"+this.getLibRue();
    }
    
    @Override
    public String toString(){
        return this.getNom()+"_"+this.getPrenom()+"_"+this.getNumPers();
    }
}
