/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author romain
 */
public class Adherent extends Personne {
    private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
    private Date dateEntree;
    private Date dateSortie;
    private Boolean disponibilite;
    private Activité activité;
    
    public Adherent(String nom,String prenom, String adresse, Date dateEntree, Date dateSortie, SecteurGeographique s, Activité activité){
        super(nom, prenom, adresse, s);
        
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
        this.disponibilite = true;
        this.activité= activité;
    }
    
    @Override
    public Boolean estDisponnible(){
        return disponibilite;
    }
    
    
    @Override
    public String toSave(){
        return super.toSave()+";"+format.format(dateEntree) + ";" +format.format(dateSortie)+";"+getSecteurGeographique()+ ";" +activité + ";";
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }
}

