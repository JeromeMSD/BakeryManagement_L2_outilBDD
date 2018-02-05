/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.util.ArrayList;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * 
 * @author jmddu_000
 * @param <E> Classe
 */
public class Groupe <E extends ObjectE> {
    private String nom;
    private ArrayList<E> groupe = new ArrayList<>();
    
    public Groupe(String groupe_Client) {
       this.nom = groupe_Client;
    }
    
    public String getGroupeName(){
        return nom;
    }
    
    public void setGroupeName(String nom){
        this.nom = nom;
    }
    
    public ArrayList<String> getStringList(){
        ArrayList<String> l = new ArrayList<>();
        l.add("----------");
        for(E e : groupe)
            l.add(e.toString());
        
        return l;
    }
    
    ArrayList<E> getList() {
        return groupe;
    }
    
    public E getFirst(){
        return groupe.get(0);
    }
    
    public E getPersonne(String s) throws Exception{
        for(E e: groupe)
            if(s.equals(e.toString()))
                return e;
        
        throw new NotFound();
    }
    
    public void addToGroupe(E e){
        groupe.add(e);
    }
    
    public void removeFromGroupe(E e){
        groupe.remove(e);
    }

    public void addList(ArrayList<E> list) {
        groupe.addAll(list);
    }
    
    void rm(String s) {
        for (E e : groupe)
            if(e.toString().equals(s))
                groupe.remove(e);
    }
    
    public ArrayList<String> getDisponnible(){
        ArrayList<String> l = new ArrayList<>();
        l.add("----------");
        for(E e : groupe)
            if(e.estDisponnible())
                l.add(e.toString());
        
        return l;
    }
    
    public ArrayList<String> getSecteurs(){
        ArrayList<String> l = new ArrayList<>();
        String s = null;
        for(E e : groupe){
            s = e.getSecteurGeographique();
            if(!l.contains(s))
                l.add(e.getSecteurGeographique());
        }
        return l;
    }
    
    public ArrayList<String> save(){
        ArrayList<String> ls = new ArrayList<>();
        
        for (E e : groupe)
            ls.add(e.toSave());
        return ls;
    }


}
