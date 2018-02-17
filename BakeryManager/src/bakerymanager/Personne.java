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
public class Personne{
    private int idPersonne;
    private String nomPersonne;
    private int telPersonne;
    
    public Personne (String nomPersonne, int telPersonne){
        this.nomPersonne = nomPersonne;
        this.telPersonne = telPersonne;
    }
}
