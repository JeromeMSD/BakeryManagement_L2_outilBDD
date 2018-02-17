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
public class Fournisseur{
    private int idFournniseur;
    private String nomFournisseur;
    private int telFournisseur;
    
    public Fournisseur(String nomFournisseur, int telFournisseur){
        this.nomFournisseur =  nomFournisseur;
        this.telFournisseur = telFournisseur;
    }
}

