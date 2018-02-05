/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.DateTimeStringConverter;

/**
 *
 * @author jmddu_000
 */
public class DAO {
    private final static String RESOURCES_PATH= "res/save/";                     // Emplacement initial des sauvegarde, à du être changer pour permettre la persistence fichier apres le deploiement sous la forme application
    private final static String SEPARATOR = ";";
    private final static String CLIENT_FILE_NAME = "clients.txt";
    private final static String ADHERENT_FILE_NAME = "adherents.txt";
    private final static String INTERVENTION_FILE_NAME = "interventions.txt";
    private final static String DEMANDE_FILE_NAME = "demandes.txt";
    private DateTimeStringConverter format = new DateTimeStringConverter(Locale.FRANCE,"dd/MM/YYYY");
    
    public void saveClients(Groupe<Client> gc){
        File file = new File(  CLIENT_FILE_NAME);
        ArrayList<String> gs = gc.save();
        FileWriter fw  = null;
        BufferedWriter bw = null;
 
        try {
            fw  = new FileWriter(file);
            bw = new BufferedWriter(fw);
            
            for(String s : gs){
                bw.write(s);
                bw.newLine();
            }

	} catch (IOException e) {
			e.printStackTrace();
	} finally {
		try {
                    if (bw != null)
                        bw.close();
                    if (fw != null)
                    	fw.close();
		} catch (IOException ex) {
				ex.printStackTrace();
		}
        }
    }

    public void saveAdherents(Groupe<Adherent> ga) {
        File file = new File(  ADHERENT_FILE_NAME);
        ArrayList<String> gs = ga.save();
        FileWriter fw  = null;
        BufferedWriter bw = null;
 
        try {
            fw  = new FileWriter(file);
            bw = new BufferedWriter(fw);
            
            for(String s : gs){
                bw.write(s);
                bw.newLine();
            }

	} catch (IOException e) {
			e.printStackTrace();
	} finally {
		try {
                    if (bw != null)
                        bw.close();
                    if (fw != null)
                    	fw.close();
		} catch (IOException ex) {
				ex.printStackTrace();
		}
        }
    }

    public void saveInterventions(Groupe<Intervention> gi) {
        File file = new File(  INTERVENTION_FILE_NAME);
        ArrayList<String> gs = gi.save();
        FileWriter fw  = null;
        BufferedWriter bw = null;
 
        try {
            fw  = new FileWriter(file);
            bw = new BufferedWriter(fw);
            
            for(String s : gs){
                bw.write(s);
                bw.newLine();
            }

	} catch (IOException e) {
			e.printStackTrace();
	} finally {
		try {
                    if (bw != null)
                        bw.close();
                    if (fw != null)
                    	fw.close();
		} catch (IOException ex) {
				ex.printStackTrace();
		}
        }
    }
    public void saveDemandes(Groupe<Demande> gd) {
        File file = new File(  DEMANDE_FILE_NAME);
        ArrayList<String> gs = gd.save();
        FileWriter fw  = null;
        BufferedWriter bw = null;
 
        try {
            fw  = new FileWriter(file);
            bw = new BufferedWriter(fw);
            
            for(String s : gs){
                bw.write(s);
                bw.newLine();
            }

	} catch (IOException e) {
			e.printStackTrace();
	} finally {
		try {
                    if (bw != null)
                        bw.close();
                    if (fw != null)
                    	fw.close();
		} catch (IOException ex) {
				ex.printStackTrace();
		}
        }
    }
    
    public void save(Groupe<Client> gc, Groupe<Adherent> ga, Groupe<Intervention> gi,Groupe<Demande> gd){
        saveClients(gc);
        saveAdherents(ga);
        saveDemandes(gd);
        saveInterventions(gi);
    }
    
    public ArrayList<Client> loadClients() {
        ArrayList<Client> l = new ArrayList<>();
        File file = new File(  CLIENT_FILE_NAME);
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String[] strSplit = null;
            String str = br.readLine();
            
            while(str != null){
                strSplit = str.split(SEPARATOR);
                l.add(new Client(strSplit[0], strSplit[1], strSplit[2], strSplit[3], new SecteurGeographique(strSplit[4])));
                str = br.readLine();
            }
            
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
     
        }   
        
        return l;
    }

    public ArrayList<Adherent> loadAdherents() {
        ArrayList<Adherent> l = new ArrayList<>();
        File file = new File(  ADHERENT_FILE_NAME);
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String[] strSplit = null;
            String str = br.readLine();
            
            while(str != null){
                strSplit = str.split(SEPARATOR);
                l.add(new Adherent(strSplit[0], strSplit[1], strSplit[2], format.fromString(strSplit[3]), format.fromString(strSplit[4]), new SecteurGeographique(strSplit[5]),Activité.get(strSplit[6])));
                str = br.readLine();
            }
            
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
     
        }   
        
        return l;
    }

    public ArrayList<Intervention> loadInterventions(Groupe<Client> gc, Groupe<Adherent> ga) {
        ArrayList<Intervention> l = new ArrayList<>();
        File file = new File(  INTERVENTION_FILE_NAME);
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String[] strSplit = null;
            String str = br.readLine();
            
            while(str != null){
                strSplit = str.split(SEPARATOR);
                l.add(new Intervention(gc.getPersonne(strSplit[0]), ga.getPersonne(strSplit[1]), format.fromString(strSplit[2]),format.fromString(strSplit[3]), new SecteurGeographique(strSplit[4]), Activité.valueOf(strSplit[5]), Integer.parseInt(strSplit[6]) ));
                str = br.readLine();
            }
            
        }catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
     
        }   
        
        return l;
    }
    public ArrayList<Demande> loadDemandes(Groupe<Client> gc) {
        ArrayList<Demande> l = new ArrayList<>();
        File file = new File(  DEMANDE_FILE_NAME);
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String[] strSplit = null;
            String str = br.readLine();
            
            while(str != null){
                strSplit = str.split(SEPARATOR);
                l.add(new Demande(gc.getPersonne(strSplit[0]), format.fromString(strSplit[1]) ,Integer.parseInt(strSplit[2]), Integer.parseInt(strSplit[3]), strSplit[4]));
                str = br.readLine();
            }
            
        }catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
     
        }   
        
        return l;
    }
    
}
