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
public class SecteurGeographique {
    private String nomVille;
    private int cdePostal;

    public SecteurGeographique(String s){
        String str[] = s.split("-");
        this.cdePostal = Integer.parseInt(str[0]);
        this.nomVille = str[1];
    }
    
    public SecteurGeographique(int cdePostal, String nomVille){
        this.nomVille = nomVille;
        this.cdePostal = cdePostal;
    }
    
    @Override
    public String toString(){
        return cdePostal+"-"+nomVille;
    }
}
